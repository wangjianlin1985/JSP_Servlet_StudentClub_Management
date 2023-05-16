// 
// 
// 

package wzy.com;

import entity.Img;
import java.util.Iterator;
import java.util.List;
import wzy.CommunitySquare.CommSquare;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FileLoad
{
    private static final String UPLOAD_DIRECTORY_IMG = "uploadImg";
    private static final String UPLOAD_DIRECTORY_VIDEO = "uploadVideo";
    private static final int MEMORY_THRESHOLD = 3145728;
    private static final int MAX_FILE_SIZE = 41943040;
    private static final int MAX_REQUEST_SIZE = 52428800;
    
    private static String setFileName(final String filename, final int org_id) {
        return String.valueOf(org_id) + "^" + filename;
    }
    
    private static String setFileName(final String filename, final String uid) {
        return String.valueOf(uid) + "^" + filename;
    }
    
    public static String upLoad(final HttpServletRequest request, final HttpServletResponse response, final boolean isVideo, final boolean isComm) {
        final DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(3145728);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        final ServletFileUpload upload = new ServletFileUpload((FileItemFactory)factory);
        upload.setFileSizeMax(41943040L);
        upload.setSizeMax(52428800L);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath;
        if (!isVideo) {
            uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadImg";
        }
        else {
            uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadVideo";
        }
        final File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            final List<FileItem> formItems = (List<FileItem>)upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (final FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = null;
                        int result = -1;
                        if (isVideo) {
                            if (!isComm) {
                                throw new Exception("\u6dfb\u52a0\u89c6\u9891\u4e0d\u80fd\u7528uid\u53c2\u6570");
                            }
                            final int org_id = Integer.parseInt((String)request.getAttribute("org_id"));
                            fileName = setFileName(item.getName(), org_id);
                            result = CommSquare.setVideo(org_id, fileName);
                        }
                        else if (isComm) {
                            final int org_id = Integer.parseInt((String)request.getAttribute("org_id"));
                            fileName = setFileName(item.getName(), org_id);
                            result = CommSquare.setCommImg(org_id, fileName);
                        }
                        else {
                            final String uid = (String)request.getSession().getAttribute("uid");
                            fileName = setFileName(item.getName(), uid);
                            FileDel.DelUserImg(uid, uploadPath);
                            result = CommSquare.setUserImg(uid, fileName);
                        }
                        if (result < 1) {
                            throw new Exception(String.valueOf(fileName) + "\u6570\u636e\u5e93\u63d2\u5165\u5931\u8d25");
                        }
                        final String filePath = String.valueOf(uploadPath) + File.separator + fileName;
                        final File storeFile = new File(filePath);
                        item.write(storeFile);
                        System.out.println(String.valueOf(fileName) + " \u4e0a\u4f20\u6210\u529f");
                        if (!isVideo && !isComm) {
                            break;
                        }
                        continue;
                    }
                }
            }
            return "success";
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }
    }
    
    public static String upload(final HttpServletRequest request, final HttpServletResponse response) {
        final DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(3145728);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        final ServletFileUpload upload = new ServletFileUpload((FileItemFactory)factory);
        upload.setFileSizeMax(41943040L);
        upload.setSizeMax(52428800L);
        upload.setHeaderEncoding("UTF-8");
        final String uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadImg";
        final File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            final List<FileItem> formItems = (List<FileItem>)upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (final FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = null;
                        final Img PreviousImg = null;
                        int result = -1;
                        final int org_id = Integer.parseInt((String)request.getAttribute("org_id"));
                        fileName = setFileName(item.getName(), org_id);
                        FileDel.DelCommPortrait(org_id, uploadPath);
                        result = CommSquare.setCommImg(org_id, fileName);
                        System.out.println(result);
                        if (result < 1) {
                            throw new Exception(String.valueOf(fileName) + "\u6570\u636e\u5e93\u63d2\u5165\u5931\u8d25");
                        }
                        CommSquare.setCommPortrait(org_id, result);
                        final String filePath = String.valueOf(uploadPath) + File.separator + fileName;
                        final File storeFile = new File(filePath);
                        item.write(storeFile);
                        System.out.println(String.valueOf(fileName) + " \u4e0a\u4f20\u6210\u529f");
                        break;
                    }
                }
            }
            return "success";
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }
    }
}
