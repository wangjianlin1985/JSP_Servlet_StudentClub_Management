// 
// 
// 

package wzy.com;

import java.io.PrintWriter;
import wzy.CommunitySquare.CommSquare;
import java.io.File;
import net.sf.json.JSONArray;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class DelCommImgServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final JSONArray jsonArray = JSONArray.fromObject((Object)request.getParameter("img_id_array"));
        int img_id = 0;
        final String uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadImg";
        final PrintWriter out = response.getWriter();
        for (int i = 0; i < jsonArray.size(); ++i) {
            img_id = Integer.parseInt(jsonArray.get(i).toString());
            System.out.println("=============@DelCommImgServlet img_id= " + img_id);
            if (!FileDel.DelCommImg(img_id, uploadPath).equals("success")) {
                out.write(CommSquare.getImgById(img_id) + " fail");
            }
            else {
                out.write(CommSquare.getImgById(img_id) + " success");
                System.out.println("\u5220\u9664\u6210\u529f");
            }
        }
        out.close();
    }
}
