// 
// 
// 

package wzy.com;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ForumPostServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            final PrintWriter writer = response.getWriter();
            writer.println("Error: \u8868\u5355\u5fc5\u987b\u5305\u542b enctype=multipart/form-data");
            writer.flush();
            return;
        }
        final String[] relist = LayerImgLoad.upLoad(request, response, true);
        request.setAttribute("message", (Object)relist[2]);
        request.setAttribute("post_id", (Object)relist[0]);
        this.getServletContext().getRequestDispatcher("transferAddPost.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
}
