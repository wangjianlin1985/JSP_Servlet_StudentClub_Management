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

public class VideoLoadServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            final PrintWriter writer = response.getWriter();
            writer.println("Error: \u8868\u5355\u5fc5\u987b\u5305\u542b enctype=multipart/form-data");
            writer.flush();
            return;
        }
        final String org_id = request.getParameter("org_id");
        request.setAttribute("org_id", (Object)org_id);
        final String message = FileLoad.upLoad(request, response, true, true);
        request.setAttribute("message", (Object)message);
        response.sendRedirect("../releasingNotices.jsp?org_id=" + org_id);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
}
