// 
// 
// 

package action;

import entity.User;
import dao.UserDao;
import javax.servlet.http.HttpSession;
import daoImpl.UserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ModiPersonServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\u4fee\u6539servlet--ModiPersonServlet");
        final HttpSession session = request.getSession();
        final String uid = (String)session.getAttribute("uid");
        final UserDao userdao = new UserDaoImpl();
        final User user = userdao.queryUserByUid(uid);
        final String name = request.getParameter("name");
        System.out.println(name);
        final String paswd = request.getParameter("paswd");
        System.out.println(paswd);
        final String sex = request.getParameter("sex");
        System.out.println(sex);
        final String birth = request.getParameter("birth");
        System.out.println(birth);
        if (name != null && name != "") {
            user.setUname(name);
        }
        if (paswd != null && paswd != "") {
            user.setUpwd(paswd);
        }
        if (sex != null && sex != "") {
            user.setSex(sex);
        }
        if (birth != null && birth != "") {
            user.setBirth(birth);
        }
        userdao.update(user);
        response.sendRedirect("personal-info.jsp");
    }
}
