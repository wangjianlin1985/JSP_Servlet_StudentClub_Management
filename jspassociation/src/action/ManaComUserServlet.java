// 
// 
// 

package action;

import javax.servlet.http.HttpSession;
import dao.UserDao;
import java.io.PrintWriter;
import dao.ComUserDao;
import daoImpl.UserDaoImpl;
import daoImpl.ComUserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ManaComUserServlet")
public class ManaComUserServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String type = request.getParameter("type");
        final String id = request.getParameter("id");
        final String org_id = request.getParameter("org_id");
        final String position = request.getParameter("position");
        final ComUserDao comuserdao = new ComUserDaoImpl();
        final PrintWriter out = response.getWriter();
        if (type.equals("add")) {
            if (comuserdao.queryUserByOrgUid(Integer.parseInt(org_id), id).size() != 0) {
                out.print("duplicated");
            }
            else {
                final UserDao userdao = new UserDaoImpl();
                if (userdao.queryExist(id).size() == 0) {
                    System.out.println("nexist");
                    out.print("nexist");
                }
                else if (comuserdao.addComUser(Integer.parseInt(org_id), id) == 1) {
                    out.print("success");
                }
            }
        }
        else if (type.equals("delete")) {
            final String[] uids = id.split(",");
            for (int i = 0; i < uids.length; ++i) {
                final String cur_uid = uids[i];
                if (comuserdao.queryUserByOrgUid(Integer.parseInt(org_id), cur_uid).size() != 0) {
                    System.out.println("=====delete=======");
                    System.out.println("type:" + type);
                    System.out.println("uid:" + cur_uid);
                    System.out.println("org_id:" + org_id);
                    comuserdao.deleteComUser(Integer.parseInt(org_id), cur_uid);
                    out.print("success");
                }
                else {
                    out.print("duplicated");
                }
            }
        }
        else if (type.equals("update")) {
            comuserdao.updatePosition(Integer.parseInt(org_id), id, position);
            if (request.getParameter("leader").equals("1")) {
                comuserdao.updatePosition(Integer.parseInt(org_id), id, "\u793e\u957f");
                comuserdao.updateManaPri(Integer.parseInt(org_id), id, 1);
                comuserdao.updateNotiPri(Integer.parseInt(org_id), id, 1);
                comuserdao.updateActiaPri(Integer.parseInt(org_id), id, 1);
                final HttpSession session = request.getSession();
                final String uid = (String)session.getAttribute("uid");
                comuserdao.updatePosition(Integer.parseInt(org_id), uid, "\u666e\u901a");
                comuserdao.updateManaPri(Integer.parseInt(org_id), uid, 0);
                comuserdao.updateNotiPri(Integer.parseInt(org_id), uid, 0);
                comuserdao.updateActiaPri(Integer.parseInt(org_id), uid, 0);
            }
            else {
                final String priMana = request.getParameter("priManaUser");
                comuserdao.updateManaPri(Integer.parseInt(org_id), id, Integer.parseInt(priMana));
                final String priNoNews = request.getParameter("priNoNews");
                comuserdao.updateNotiPri(Integer.parseInt(org_id), id, Integer.parseInt(priNoNews));
                final String priActi = request.getParameter("priActi");
                comuserdao.updateActiaPri(Integer.parseInt(org_id), id, Integer.parseInt(priActi));
            }
            out.print("success");
        }
    }
}
