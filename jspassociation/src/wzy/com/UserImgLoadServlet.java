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

public class UserImgLoadServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=========UserImgLoadServlet======");
        if (!ServletFileUpload.isMultipartContent(request)) {
            final PrintWriter writer = response.getWriter();
            writer.println("Error: \u8868\u5355\u5fc5\u987b\u5305\u542b enctype=multipart/form-data");
            writer.flush();
            System.out.println("\u4e0d\u662f\u591a\u5a92\u4f53");
            return;
        }
        FileLoad.upLoad(request, response, false, false);
        response.sendRedirect("../personal-info.jsp");
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
