// 
// 
// 

package action;

import dao.ComUserDao;
import entity.Community;
import javax.servlet.http.HttpSession;
import dao.MesDao;
import dao.CommuDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import daoImpl.ComUserDaoImpl;
import java.util.Date;
import java.text.SimpleDateFormat;
import entity.User_Message;
import daoImpl.MesDaoImpl;
import daoImpl.CommuDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ManaOrgServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String[] org_id = request.getParameterValues("examination");
        final String type = request.getParameter("type");
        final CommuDao commudao = new CommuDaoImpl();
        final MesDao mesdao = new MesDaoImpl();
        final HttpSession session = request.getSession();
        final String uid = (String)session.getAttribute("uid");
        System.out.println("\u8fdb\u5165manaorgservlet");
        System.out.println("===========");
        final User_Message user_mes = new User_Message();
        if (type.equals("agree")) {
            for (int i = 0; i < org_id.length; ++i) {
                final int norg_id = Integer.parseInt(org_id[i]);
                commudao.updateStat(norg_id, 1);
                final Community comm = commudao.queryCommuByOrg(norg_id);
                user_mes.setFrom_uid(uid);
                user_mes.setTo_uid(comm.getUid());
                user_mes.setMes_title("\u793e\u56e2\u7533\u8bf7\u6210\u529f");
                final String mes_content = "\u60a8\u63d0\u4ea4\u7533\u8bf7\u7684" + comm.getOrg_name() + "\u793e\u56e2\u7533\u8bf7\u6210\u529f";
                user_mes.setMes_content(mes_content);
                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final Date date = new Date();
                final String now = sdf.format(date);
                user_mes.setMes_date(now);
                user_mes.setStat(2);
                user_mes.setType(1);
                mesdao.addMes(user_mes);
                final ComUserDao comuserdao = new ComUserDaoImpl();
                comuserdao.addComLeader(norg_id, comm.getUid());
            }
        }
        else if (type.equals("delete")) {
            for (int i = 0; i < org_id.length; ++i) {
                final int norg_id = Integer.parseInt(org_id[i]);
                final Community comm = commudao.queryCommuByOrg(norg_id);
                user_mes.setFrom_uid(uid);
                user_mes.setTo_uid(comm.getUid());
                user_mes.setMes_title("\u793e\u56e2\u7533\u8bf7\u5931\u8d25");
                final String mes_content = "\u60a8\u63d0\u4ea4\u7533\u8bf7\u7684" + comm.getOrg_name() + "\u793e\u56e2\u7533\u8bf7\u5931\u8d25";
                user_mes.setMes_content(mes_content);
                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final Date date = new Date();
                final String now = sdf.format(date);
                user_mes.setMes_date(now);
                user_mes.setStat(2);
                user_mes.setType(1);
                mesdao.addMes(user_mes);
                commudao.deleteCommu(norg_id);
            }
        }
        request.getRequestDispatcher("admin.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
}
