// 
// 
// 

package action;

import entity.User;
import java.io.PrintWriter;
import dao.UserDao;
import daoImpl.UserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "RegisterAction")
public class RegisterAction extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String uid = request.getParameter("uid");
        final UserDao udao = new UserDaoImpl();
        final PrintWriter out = response.getWriter();
        final User u = udao.queryUserByUid(uid);
        if (u != null) {
            out.print("duplicated");
        }
        else {
            out.println("success");
        }
    }
}
