// 
// 
// 

package action;

import dao.ComUserDao;
import javax.servlet.http.HttpSession;
import dao.MesDao;
import dao.NotiDao;
import daoImpl.ComUserDaoImpl;
import daoImpl.MesDaoImpl;
import entity.User_Message;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import daoImpl.NotiDaoImpl;
import entity.Notice;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ApplyNoticeServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String noti_title = request.getParameter("title");
        final String noti_content = request.getParameter("content");
        final String type = request.getParameter("type");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = new Date();
        final String now = sdf.format(date);
        final Notice noti = new Notice();
        final NotiDao notidao = new NotiDaoImpl();
        if (type.equals("add")) {
            final int org_id = Integer.parseInt(request.getParameter("org_id"));
            noti.setOrg_id(org_id);
            noti.setNoti_date(now);
            noti.setNoti_content(noti_content);
            noti.setNoti_title(noti_title);
            notidao.addApplyNoti(noti);
            request.getRequestDispatcher("releasingNotices.jsp?org_id=" + org_id).forward((ServletRequest)request, (ServletResponse)response);
        }
        else if (type.equals("agree")) {
            final String[] noti_id = request.getParameterValues("noti_id");
            final User_Message user_mes = new User_Message();
            final MesDao mesdao = new MesDaoImpl();
            final int[] Nnoti_id = new int[noti_id.length];
            for (int i = 0; i < noti_id.length; ++i) {
                Nnoti_id[i] = Integer.parseInt(noti_id[i]);
                System.out.println("ssssssss" + Nnoti_id[i] + "sssss");
                final HttpSession session = request.getSession();
                final String uid = (String)session.getAttribute("uid");
                final String mid = (String)session.getAttribute("mid");
                if (uid == null && mid == null) {
                    response.sendRedirect("manager.jsp");
                    return;
                }
                final ComUserDao comuserdao = new ComUserDaoImpl();
                final String touid = comuserdao.queryLeader(notidao.queryNotiByNoti(Nnoti_id[i]).getOrg_id());
                user_mes.setFrom_uid((uid == null) ? mid : uid);
                user_mes.setTo_uid(touid);
                user_mes.setMes_title("\u516c\u544a\u4e0a\u9996\u9875\u7533\u8bf7\u6210\u529f");
                final String mes_content = "\u60a8\u63d0\u4ea4\u7533\u8bf7\u7684" + notidao.queryNotiByNoti(Nnoti_id[i]).getNoti_title() + "\u516c\u544a\u4e0a\u9996\u9875\u7533\u8bf7\u6210\u529f";
                user_mes.setMes_content(mes_content);
                final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final Date date2 = new Date();
                final String now2 = sdf2.format(date2);
                user_mes.setMes_date(now2);
                user_mes.setStat(2);
                user_mes.setType(1);
                mesdao.addMes(user_mes);
            }
            notidao.AgreeApply(Nnoti_id);
            request.getRequestDispatcher("../admin.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
        else if (type.equals("delete")) {
            final String[] noti_id = request.getParameterValues("noti_id");
            final User_Message user_mes = new User_Message();
            final int[] Nnoti_id2 = new int[noti_id.length];
            final MesDao mesdao2 = new MesDaoImpl();
            for (int i = 0; i < noti_id.length; ++i) {
                Nnoti_id2[i] = Integer.parseInt(noti_id[i]);
                final HttpSession session = request.getSession();
                final String uid = (String)session.getAttribute("uid");
                final ComUserDao comuserdao2 = new ComUserDaoImpl();
                final String touid2 = comuserdao2.queryLeader(notidao.queryNotiByNoti(Nnoti_id2[i]).getOrg_id());
                user_mes.setFrom_uid(uid);
                user_mes.setTo_uid(touid2);
                user_mes.setMes_title("\u516c\u544a\u4e0a\u9996\u9875\u7533\u8bf7\u5931\u8d25");
                final String mes_content2 = "\u60a8\u63d0\u4ea4\u7533\u8bf7\u7684" + notidao.queryNotiByNoti(Nnoti_id2[i]).getNoti_title() + "\u516c\u544a\u4e0a\u9996\u9875\u7533\u8bf7\u5931\u8d25";
                user_mes.setMes_content(mes_content2);
                final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final Date date3 = new Date();
                final String now3 = sdf3.format(date3);
                user_mes.setMes_date(now3);
                user_mes.setStat(2);
                user_mes.setType(1);
                mesdao2.addMes(user_mes);
            }
            notidao.deleteApplyNoti(Nnoti_id2);
            request.getRequestDispatcher("admin.jsp?org_id=").forward((ServletRequest)request, (ServletResponse)response);
        }
    }
}
