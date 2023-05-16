// 
// 
// 

package wzy.com;

import java.util.Iterator;
import java.util.List;
import wzy.CommunitySquare.Forum_Ctr;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LayerImgLoad
{
    private static final String UPLOAD_DIRECTORY_ForumIMG = "uploadForumImg";
    private static final int MEMORY_THRESHOLD = 3145728;
    private static final int MAX_FILE_SIZE = 41943040;
    private static final int MAX_REQUEST_SIZE = 52428800;
    
    private static String setFileName(final String filename, final int post_id, final int layer_id) {
        final String prefix = filename.substring(filename.lastIndexOf(".") + 1);
        return String.valueOf(post_id) + "^" + layer_id + "." + prefix;
    }
    
    public static String[] upLoad(final HttpServletRequest request, final HttpServletResponse response, final boolean creatpost) {
        final String[] resultlist = new String[3];
        final DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(3145728);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        final ServletFileUpload upload = new ServletFileUpload((FileItemFactory)factory);
        upload.setFileSizeMax(41943040L);
        upload.setSizeMax(52428800L);
        upload.setHeaderEncoding("UTF-8");
        final String uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadForumImg";
        final File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            final List<FileItem> formItems = (List<FileItem>)upload.parseRequest(request);
            String title = null;
            final String uid = (String)request.getSession().getAttribute("uid");
            String content;
            int post_id;
            if (!creatpost) {
                content = new String(formItems.get(0).getString());
                post_id = Integer.parseInt((String)request.getSession().getAttribute("post_id"));
            }
            else {
                title = new String(formItems.get(0).getString());
                content = new String(formItems.get(1).getString());
                int creatresult = -1;
                creatresult = Forum_Ctr.creatPost(uid, title, content);
                if (creatresult < 1) {
                    throw new Exception("\u63d2\u5165forum_post\u8868\u5931\u8d25,\u521b\u5efa\u5e16\u5b50\u5931\u8d25");
                }
                post_id = creatresult;
            }
            int result = -1;
            result = Forum_Ctr.addLayer(post_id, uid, content);
            resultlist[0] = String.valueOf(post_id);
            resultlist[1] = String.valueOf(result);
            if (result < 1) {
                throw new Exception("\u63d2\u5165layer\u8868\u5931\u8d25");
            }
            if (formItems != null && formItems.size() > 0) {
                for (final FileItem item : formItems) {
                    if (!item.isFormField()) {
                        final String fileName = setFileName(item.getName(), post_id, result);
                        result = Forum_Ctr.updateImgName(fileName, post_id, result);
                        if (result < 1) {
                            throw new Exception(String.valueOf(fileName) + "\u66f4\u65b0\u5230layer\u8868\u5931\u8d25");
                        }
                        final String filePath = String.valueOf(uploadPath) + File.separator + fileName;
                        final File storeFile = new File(filePath);
                        item.write(storeFile);
                        System.out.println("\u53d1\u5e03\u6210\u529f");
                        break;
                    }
                }
            }
            resultlist[2] = "\u53d1\u5e03\u6210\u529f";
            return resultlist;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultlist[2] = ex.getMessage();
            return resultlist;
        }
    }
}
