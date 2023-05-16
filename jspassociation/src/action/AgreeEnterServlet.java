// 
// 
// 

package action;

import javax.servlet.http.HttpSession;
import dao.MesDao;
import dao.CommuDao;
import java.io.PrintWriter;
import dao.ComUserDao;
import dao.EnterDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;
import entity.User_Message;
import daoImpl.MesDaoImpl;
import daoImpl.CommuDaoImpl;
import daoImpl.ComUserDaoImpl;
import daoImpl.EnterDapImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "AgreeEnterServlet")
public class AgreeEnterServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\u5ba1\u6838servlet");
        response.setContentType("text/html;charset=utf-8");
        final String org_id = request.getParameter("org_id");
        final String rec_id = request.getParameter("rec_id");
        final String[] uid = request.getParameterValues("uid");
        final EnterDao enterdao = new EnterDapImpl();
        final ComUserDao comuserdao = new ComUserDaoImpl();
        final PrintWriter out = response.getWriter();
        System.out.println(uid[0]);
        final CommuDao commudao = new CommuDaoImpl();
        final MesDao mesdao = new MesDaoImpl();
        final HttpSession session = request.getSession();
        for (int i = 0; i < uid.length; ++i) {
            final User_Message user_mes = new User_Message();
            user_mes.setFrom_uid((String)session.getAttribute("uid"));
            user_mes.setTo_uid(uid[i]);
            user_mes.setMes_title("\u7533\u8bf7\u52a0\u5165\u793e\u56e2\u6210\u529f");
            final String mes_content = "\u60a8\u63d0\u4ea4\u7533\u8bf7\u7684\u52a0\u5165" + commudao.queryCommuByOrg(Integer.parseInt(org_id)).getOrg_name() + "\u793e\u56e2\u7533\u8bf7\u6210\u529f";
            user_mes.setMes_content(mes_content);
            final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date date1 = new Date();
            final String now1 = sdf1.format(date1);
            user_mes.setMes_date(now1);
            user_mes.setStat(2);
            user_mes.setType(1);
            mesdao.addMes(user_mes);
            enterdao.deleteEnterAgree(Integer.parseInt(rec_id), uid[i]);
            if (comuserdao.queryUserByOrgUid(Integer.parseInt(org_id), uid[i]).size() == 0) {
                comuserdao.addComUser(Integer.parseInt(org_id), uid[i]);
            }
        }
        request.getRequestDispatcher("recurit-sys.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
}
