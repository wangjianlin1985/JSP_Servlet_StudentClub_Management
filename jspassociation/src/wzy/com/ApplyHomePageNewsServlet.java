// 
// 
// 

package wzy.com;

import java.io.PrintWriter;
import wzy.CommunitySquare.CommSquare;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ApplyHomePageNewsServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final int org_id = Integer.parseInt(request.getParameter("org_id"));
        final String title = request.getParameter("title");
        final String content = request.getParameter("content");
        final int news_id = CommSquare.setCommNews(org_id, title, content);
        final int appy_id = CommSquare.ApplyHomepageNews(news_id, String.valueOf(org_id));
        final PrintWriter out = response.getWriter();
        out.write("success");
    }
}
