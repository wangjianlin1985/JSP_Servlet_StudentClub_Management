// 
// 
// 

package action;

import dao.ActiDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;
import entity.Activity;
import daoImpl.ActiDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ActiServlet")
public class ActiServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String act_id = request.getParameter("id");
        final String op = request.getParameter("op");
        final String org_id = request.getParameter("org_id");
        System.out.print(act_id);
        System.out.print(op);
        final ActiDao actdao = new ActiDaoImpl();
        if (op.equals("delete")) {
            final int nAct_id = Integer.parseInt(act_id);
            actdao.deleteActi(nAct_id);
            System.out.print("delete success");
        }
        else if (op.equals("update")) {
            final String acti_title = request.getParameter("act_title");
            final String acti_content = request.getParameter("act_content");
            final Activity acti = new Activity();
            final int nAct_id2 = Integer.parseInt(act_id);
            acti.setAct_id(nAct_id2);
            acti.setOrg_id(Integer.parseInt(org_id));
            acti.setAct_content(acti_content);
            acti.setAct_title(acti_title);
            actdao.update(acti);
            System.out.print("update success");
        }
        else if (op.equals("add")) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date date = new Date();
            final String now = sdf.format(date);
            final String acti_title2 = request.getParameter("act_title");
            final String acti_content2 = request.getParameter("act_content");
            final Activity acti2 = new Activity();
            acti2.setOrg_id(Integer.parseInt(org_id));
            acti2.setAct_date(now);
            acti2.setAct_content(acti_content2);
            acti2.setAct_title(acti_title2);
            actdao.addActi(acti2);
            System.out.print("add success");
        }
        request.getRequestDispatcher("activity.jsp?org_id=" + Integer.parseInt(org_id)).forward((ServletRequest)request, (ServletResponse)response);
    }
}
