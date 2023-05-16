// 
// 
// 

package action;

import dao.RecDao;
import java.io.PrintWriter;
import daoImpl.RecDaoImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CreateEnterServlet")
public class CreateEnterServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String[] need = request.getParameterValues("need");
        for (int i = 0; i < need.length; ++i) {
            System.out.println(need[i]);
        }
        final String org_id = request.getParameter("org_id");
        final String rec_id = request.getParameter("rec_id");
        System.out.println("\u4eca\u65e5\u62db\u65b0" + rec_id + org_id);
        final int[] rec_need = new int[6];
        final PrintWriter out = response.getWriter();
        for (int j = 0; j < need.length; ++j) {
            rec_need[Integer.parseInt(need[j])] = 1;
        }
        String Rec_need = String.valueOf(rec_need[0]);
        Rec_need = String.valueOf(Rec_need) + ",";
        for (int k = 1; k < rec_need.length - 1; ++k) {
            System.out.println(rec_need[k]);
            Rec_need = String.valueOf(Rec_need) + String.valueOf(rec_need[k]);
            Rec_need = String.valueOf(Rec_need) + ",";
        }
        Rec_need = String.valueOf(Rec_need) + String.valueOf(rec_need[5]);
        System.out.println(Rec_need);
        final RecDao recdao = new RecDaoImp();
        recdao.updateRecNeed(Integer.parseInt(rec_id), Rec_need);
        out.println("success");
    }
}
