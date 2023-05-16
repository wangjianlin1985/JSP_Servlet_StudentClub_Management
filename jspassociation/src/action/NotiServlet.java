// 
// 
// 

package action;

import dao.NotiDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import entity.Notice;
import daoImpl.NotiDaoImpl;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "NotiServlet")
public class NotiServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String op = request.getParameter("op");
        final String org_id = request.getParameter("org_id");
        System.out.println(op);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = new Date();
        final String now = sdf.format(date);
        System.out.print(now);
        final NotiDao notidao = new NotiDaoImpl();
        final Notice noti = new Notice();
        if (op.equals("add")) {
            final String noti_title = request.getParameter("noti_title");
            final String noti_content = request.getParameter("noti_content");
            noti.setOrg_id(Integer.parseInt(org_id));
            noti.setNoti_date(now);
            noti.setNoti_content(noti_content);
            noti.setNoti_title(noti_title);
            notidao.addNoti(noti);
        }
        else if (op.equals("delete")) {
            final String noti_id = request.getParameter("noti_id");
            System.out.println(noti_id);
            notidao.deleteNoti(Integer.parseInt(noti_id));
        }
        request.getRequestDispatcher("message.jsp?org_id=" + Integer.parseInt(org_id)).forward((ServletRequest)request, (ServletResponse)response);
    }
}
