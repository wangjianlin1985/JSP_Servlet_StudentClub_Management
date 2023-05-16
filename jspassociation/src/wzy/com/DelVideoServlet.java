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

public class DelVideoServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final JSONArray jsonArray = JSONArray.fromObject((Object)request.getParameter("video_id_array"));
        final String uploadPath = String.valueOf(request.getServletContext().getRealPath("./")) + File.separator + "uploadVideo";
        final PrintWriter out = response.getWriter();
        for (int i = 0; i < jsonArray.size(); ++i) {
            final int video_id = Integer.parseInt(jsonArray.get(i).toString());
            System.out.println("@DelVideoServlet video_id= " + video_id);
            if (!FileDel.DelVideo(video_id, uploadPath).equals("success")) {
                out.write(CommSquare.getVideoById(video_id) + " fail");
            }
            else {
                out.write(CommSquare.getVideoById(video_id) + " success");
                System.out.println("\u5220\u9664\u6210\u529f");
            }
        }
    }
}
