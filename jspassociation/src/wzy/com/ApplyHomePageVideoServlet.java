// 
// 
// 

package wzy.com;

import entity.Video;
import java.io.PrintWriter;
import wzy.CommunitySquare.CommSquare;
import net.sf.json.JSONArray;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ApplyHomePageVideoServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("video_id_array"));
        final JSONArray jsonArray = JSONArray.fromObject((Object)request.getParameter("video_id_array"));
        final PrintWriter out = response.getWriter();
        for (int i = 0; i < jsonArray.size(); ++i) {
            final Video temp_video = CommSquare.getVideoById(Integer.parseInt(jsonArray.get(i).toString()));
            System.out.println("==" + temp_video.getVideo_name() + "======");
            if (CommSquare.ApplyHomepageVideo(temp_video.getVideo_name()) < 0) {
                out.write("fail");
            }
        }
        out.write("success");
        response.setContentType("text/plain");
    }
}
