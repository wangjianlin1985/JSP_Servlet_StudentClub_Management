// 
// 
// 

package wzy.com;

import java.io.PrintWriter;
import java.util.List;
import wzy.CommunitySquare.CommSquare;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ImgExaServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String[] ids = request.getParameterValues("examination_img");
        final List<Integer> idlist = new ArrayList<Integer>();
        String[] array;
        for (int length = (array = ids).length, i = 0; i < length; ++i) {
            final String id = array[i];
            idlist.add(Integer.parseInt(id));
        }
        String result = null;
        result = CommSquare.setHomepageImg(idlist);
        CommSquare.delOverdueApplyImg();
        if (result.equals("0")) {
            response.sendRedirect("admin.jsp");
        }
        else {
            final PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println(" <HEAD><TITLE>\u8bbe\u7f6e\u51fa\u9519</TITLE></HEAD>");
            out.println(" <BODY>");
            out.print("<p>");
            out.print(result);
            out.print("</p>");
            out.println(" </BODY>");
            out.println("</HTML>");
            out.close();
        }
    }
}
