// 
// 
// 

package action;

import java.io.PrintWriter;
import dao.MesDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;
import entity.User_Message;
import daoImpl.MesDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "UsermesServlet")
public class UsermesServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        final String type = request.getParameter("type");
        System.out.println(type);
        final MesDao mesdao = new MesDaoImpl();
        final User_Message user_mes = new User_Message();
        final PrintWriter out = response.getWriter();
        if (type.equals("send")) {
            final String from_uid = request.getParameter("from_id");
            final String to_uid = request.getParameter("to_id");
            final String mes_title = request.getParameter("mes_title");
            final String mes_content = request.getParameter("mes_content");
            System.out.println(from_uid);
            System.out.println(to_uid);
            System.out.println(mes_title);
            System.out.println(mes_content);
            user_mes.setFrom_uid(from_uid);
            user_mes.setTo_uid(to_uid);
            user_mes.setMes_title(mes_title);
            user_mes.setMes_content(mes_content);
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date date = new Date();
            final String now = sdf.format(date);
            user_mes.setMes_date(now);
            user_mes.setStat(2);
            user_mes.setType(0);
            mesdao.addMes(user_mes);
            System.out.println("jinlai");
            out.print("success");
            System.out.println("chuqu");
        }
        else if (type.equals("save")) {
            final String from_uid = request.getParameter("from_id");
            final String to_uid = request.getParameter("to_id");
            final String mes_title = request.getParameter("mes_title");
            final String mes_content = request.getParameter("mes_content");
            user_mes.setFrom_uid(from_uid);
            user_mes.setTo_uid(to_uid);
            user_mes.setMes_title(mes_title);
            user_mes.setMes_content(mes_content);
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final Date date = new Date();
            final String now = sdf.format(date);
            user_mes.setMes_date(now);
            user_mes.setStat(0);
            user_mes.setType(0);
            mesdao.addMes(user_mes);
            out.print("success");
        }
        else if (type.equals("collect")) {
            final String uid = request.getParameter("uid");
            final String mes_id = request.getParameter("mes_id");
            final String from_uid2 = request.getParameter("from_id");
            final String to_uid2 = request.getParameter("to_id");
            System.out.println(mes_id);
            if (from_uid2.equals(uid)) {
                int collectF = mesdao.querayCollectF(Integer.parseInt(mes_id), uid);
                collectF = -collectF;
                mesdao.changecollect(Integer.parseInt(mes_id), collectF, "collecf");
                out.print("success");
            }
            else if (to_uid2.equals(uid)) {
                int collectT = mesdao.querayCollectT(Integer.parseInt(mes_id), uid);
                collectT = -collectT;
                mesdao.changecollect(Integer.parseInt(mes_id), collectT, "collecT");
                out.print("success");
            }
        }
        else if (type.equals("delete")) {
            final String[] mes_id2 = request.getParameterValues("mes_id");
            for (int i = 0; i < mes_id2.length; ++i) {
                mesdao.deleteMes(Integer.parseInt(mes_id2[i]));
            }
            System.out.println(request.getParameter("queryType"));
            request.getRequestDispatcher("innerMessage.jsp?queryType=" + request.getParameter("queryType")).forward((ServletRequest)request, (ServletResponse)response);
        }
        else if (type.equals("read")) {
            final String boxtype = request.getParameter("boxtype");
            final String mes_id = request.getParameter("mes_id");
            if (boxtype.equals("receive")) {
                mesdao.Read(Integer.parseInt(mes_id));
            }
        }
        else if (type.equals("multiread")) {
            final String[] mes_id2 = request.getParameterValues("mes_id");
            for (int i = 0; i < mes_id2.length; ++i) {
                mesdao.Read(Integer.parseInt(mes_id2[i]));
            }
            request.getRequestDispatcher("innerMessage.jsp?queryType=" + request.getParameter("queryType")).forward((ServletRequest)request, (ServletResponse)response);
        }
    }
}
