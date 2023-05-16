// 
// 
// 

package action;

import dao.EnterDao;
import dao.RecDao;
import java.io.PrintWriter;
import daoImpl.EnterDapImpl;
import entity.Recruitment;
import daoImpl.RecDaoImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class RecServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String type = request.getParameter("type");
        final String rec_content = request.getParameter("rec_content");
        final String rec_title = request.getParameter("rec_title");
        final String rec_id = request.getParameter("rec_id");
        final String org_id = request.getParameter("org_id");
        System.out.println(rec_id);
        System.out.println(type);
        final int norg_id = Integer.parseInt(org_id);
        final int Rec_id = Integer.parseInt(rec_id);
        final PrintWriter out = response.getWriter();
        final RecDao recdao = new RecDaoImp();
        if (type.equals("delete")) {
            System.out.println("\u7b2c\u4e00\u5c42");
            if (recdao.queryAllByOrg(norg_id).get(0).getStatus() == 0) {
                System.out.println("\u7b2c2\u5c42");
                if (recdao.deleteRec(Rec_id) == 1) {
                    System.out.println("\u7b2c3\u5c42");
                    final EnterDao enterDao = new EnterDapImpl();
                    enterDao.deleteEnter(Rec_id);
                    out.print("success");
                    System.out.println("\u7b2c4\u5c42");
                }
            }
            else if (recdao.queryAllByOrg(norg_id).get(0).getStatus() == 1) {
                System.out.println("\u7b2c5\u5c42");
                out.print("fail");
                System.out.println("\u7b2c6\u5c42");
            }
        }
        else if (type.equals("stop")) {
            System.out.println("\u7b2c\u4e00\u5c42");
            if (recdao.queryAllByOrg(norg_id).get(0).getStatus() == 0) {
                System.out.println("\u7b2c2\u5c42");
                out.print("stopped");
            }
            else {
                System.out.println("\u7b2c3\u5c42");
                if (recdao.StopRec(Rec_id) == 1) {
                    out.print("success");
                    System.out.println("\u6210\u529f\u505c\u6b62");
                }
                System.out.println("\u7b2c4\u5c42");
            }
        }
    }
}
