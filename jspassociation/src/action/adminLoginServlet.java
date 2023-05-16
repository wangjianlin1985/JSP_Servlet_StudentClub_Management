// 
// 
// 

package action;

import dao.ManagerDao;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import daoImpl.ManagerDaoImpl;
import entity.Manager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "adminLoginServlet", value = { "/adminLoginServlet" })
public class adminLoginServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("user-name");
        final String pswd = request.getParameter("user-pwd");
        final PrintWriter out = response.getWriter();
        final HttpSession session = request.getSession();
        final Manager mana = new Manager();
        mana.setMid(name);
        mana.setPassword(pswd);
        System.out.println(mana.getMid());
        System.out.println(mana.getPassword());
        final ManagerDao manadao = new ManagerDaoImpl();
        final Manager m = manadao.login(mana);
        if (m != null) {
            session.setAttribute("mid", (Object)name);
            out.write("success");
        }
        else {
            out.write("fail");
        }
        System.out.println(name);
    }
}
