// 
// 
// 

package action;

import dao.EnterDao;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import daoImpl.EnterDapImpl;
import entity.Enter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "EnterServlet")
public class EnterServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Enter enter = new Enter();
        final HttpSession session = request.getSession();
        System.out.println("tiaozhuan");
        final String org_id = request.getParameter("org-id");
        final String rec_id = request.getParameter("rec-id");
        System.out.println(org_id);
        System.out.println(rec_id);
        System.out.println("tiaozhuan1");
        final int norg_id = Integer.parseInt(org_id);
        final int nrec_id = Integer.parseInt(rec_id);
        enter.setOrg_id(norg_id);
        enter.setRec_id(nrec_id);
        enter.setUid((String)session.getAttribute("uid"));
        enter.setName(request.getParameter("user-name"));
        final String sex = request.getParameter("user-sex");
        enter.setSex((sex == null) ? "\u7537" : sex);
        enter.setGrade(request.getParameter("user-grade"));
        enter.setQq(request.getParameter("user-QQ"));
        enter.setTel(request.getParameter("user-tele"));
        enter.setMail(request.getParameter("user-mail"));
        System.out.println("email" + enter.getMail());
        System.out.println("QQ " + enter.getQq());
        final PrintWriter out = response.getWriter();
        final EnterDao enterdao = new EnterDapImpl();
        if (enterdao.queryExist(norg_id, enter.getUid()).size() != 0) {
            out.print("duplicated");
            System.out.println("cunzai");
        }
        else {
            System.out.println("bucunzai");
            final int change = enterdao.addEnter(enter);
            if (change == 1) {
                System.out.println("success");
                out.print("success");
            }
            else {
                out.print("fail");
            }
        }
    }
}
