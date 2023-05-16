// 
// 
// 

package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "testServlet")
public class testServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String script = "<script>alert('\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u767b\u9646');location.href='../web/activity.jsp'</script>";
        response.getWriter().println(script);
    }
}
