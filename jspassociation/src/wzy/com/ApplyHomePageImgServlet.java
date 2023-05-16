// 
// 
// 

package wzy.com;

import entity.Img;
import java.io.PrintWriter;
import wzy.CommunitySquare.CommSquare;
import net.sf.json.JSONArray;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ApplyHomePageImgServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("img_id_array"));
        final JSONArray jsonArray = JSONArray.fromObject((Object)request.getParameter("img_id_array"));
        final PrintWriter out = response.getWriter();
        for (int i = 0; i < jsonArray.size(); ++i) {
            final Img temp_img = CommSquare.getImgById(Integer.parseInt(jsonArray.get(i).toString()));
            System.out.println("==" + temp_img.getImg_name() + "======");
            if (CommSquare.ApplyHomepageImg(temp_img.getImg_name()) < 0) {
                out.write("fail");
            }
        }
        out.write("success");
    }
}
