// 
// 
// 

package action;

import dao.UserDao;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import daoImpl.UserDaoImpl;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "userLoginServlet")
public class userLoginServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("user-name");
        final String pswd = request.getParameter("user-pwd");
        System.out.println(name);
        final String type = request.getParameter("type");
        final PrintWriter out = response.getWriter();
        final HttpSession session = request.getSession();
        final User user = new User();
        user.setUid(name);
        user.setUpwd(pswd);
        final UserDao dao = new UserDaoImpl();
        final User u = dao.login(user);
        if (u != null) {
            System.out.println(u.getUid());
            System.out.println(u.getUname());
            session.setAttribute("uid", (Object)name);
            out.write("success");
        }
        else {
            out.write("fail");
        }
        System.out.println(name);
    }
}
