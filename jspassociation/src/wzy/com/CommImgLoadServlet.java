// 
// 
// 

package wzy.com;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class CommImgLoadServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=====in post======");
        if (!ServletFileUpload.isMultipartContent(request)) {
            System.out.println("=====\u4e0d\u662f\u591a\u5a92\u4f53======");
            final PrintWriter writer = response.getWriter();
            writer.println("Error: \u8868\u5355\u5fc5\u987b\u5305\u542b enctype=multipart/form-data");
            writer.flush();
            return;
        }
        final String org_id = request.getParameter("org_id");
        request.setAttribute("org_id", (Object)org_id);
        final int isportrait = Integer.parseInt(request.getParameter("is_portrait"));
        String message = null;
        if (isportrait > 0) {
            message = FileLoad.upload(request, response);
            System.out.println("====is portrait======");
        }
        else {
            message = FileLoad.upLoad(request, response, false, true);
        }
        request.setAttribute("message", (Object)message);
        System.out.println("\u8df3\u8f6c");
        response.sendRedirect("../releasingNotices.jsp?org_id=" + org_id);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
}
