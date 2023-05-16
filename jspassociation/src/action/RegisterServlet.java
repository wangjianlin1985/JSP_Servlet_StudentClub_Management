// 
// 
// 

package action;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import dao.UserDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import entity.User;
import java.util.Date;
import daoImpl.UserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final UserDao udao = new UserDaoImpl();
        final String uid = request.getParameter("uid");
        final String name = request.getParameter("name");
        final String pwd = request.getParameter("password");
        final String sex = request.getParameter("sex");
        final String birth = request.getParameter("birth");
        final String code = request.getParameter("validateCode");
        final PrintWriter out = response.getWriter();
        final HttpSession session = request.getSession();
        final String validateCode = (String)session.getAttribute("validateCode");
        final Date date = (Date)session.getAttribute("validateTime");
        if (date == null) {
            System.out.println("\u7528\u6237" + uid + "," + name + ",\u6027\u522b" + sex + "  \u8ba4\u8bc1\u5931\u8d25");
            final String script = "<script>alert('\u6ce8\u518c\u5931\u8d25\u8bf7\u91cd\u65b0\u6ce8\u518c');location.href='register.jsp'</script>";
            response.setContentType("text/html;charset=utf-8");
            out.println(script);
            return;
        }
        final Date now = new Date();
        final long interval = now.getTime() - date.getTime();
        if (interval > 300000L) {
            System.out.println("\u7528\u6237" + uid + "," + name + ",\u6027\u522b" + sex + "  \u8ba4\u8bc1\u5931\u8d25");
            final String script2 = "<script>alert('\u6ce8\u518c\u5931\u8d25\u8bf7\u91cd\u65b0\u6ce8\u518c');location.href='register.jsp'</script>";
            response.setContentType("text/html;charset=utf-8");
            out.println(script2);
            return;
        }
        if (!code.trim().equals(validateCode)) {
            System.out.println("\u7528\u6237" + uid + "," + name + ",\u6027\u522b" + sex + "  \u8ba4\u8bc1\u5931\u8d25");
            final String script2 = "<script>alert('\u6ce8\u518c\u5931\u8d25\u8bf7\u91cd\u65b0\u6ce8\u518c');location.href='register.jsp'</script>";
            response.setContentType("text/html;charset=utf-8");
            out.println(script2);
            return;
        }
        System.out.println("\u7528\u6237" + uid + "," + name + ",\u6027\u522b" + sex + "  \u8ba4\u8bc1\u6210\u529f");
        final User user = new User();
        user.setUid(uid);
        user.setUname(name);
        user.setUpwd(pwd);
        user.setSex(sex);
        user.setBirth(birth);
        final int row = udao.addUser(user);
        if (row == 1) {
            session.setAttribute("uid", (Object)uid);
            request.getRequestDispatcher("club-square.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
        else {
            final String script3 = "<script>alert('\u6ce8\u518c\u5931\u8d25\u8bf7\u91cd\u65b0\u6ce8\u518c');location.href='register.jsp'</script>";
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(script3);
        }
    }
}
