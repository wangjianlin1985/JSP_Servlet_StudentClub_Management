// 
// 
// 

package action;

import dao.CommuDao;
import javax.servlet.http.HttpSession;
import entity.Community;
import daoImpl.CommuDaoImpl;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CreateOrgServlet")
public class CreateOrgServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\u521b\u5efa\u793e\u56e2");
        final HttpSession session = request.getSession();
        final String org_name = request.getParameter("club_name");
        final String org_content = request.getParameter("club_content");
        final String uid = request.getParameter("uid");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = new Date();
        final String now = sdf.format(date);
        final CommuDao commudao = new CommuDaoImpl();
        final Community comm = new Community();
        comm.setOrg_intro(org_content);
        comm.setOrg_name(org_name);
        comm.setOrg_found_date(now);
        comm.setOrg_status("0");
        comm.setUid((String)session.getAttribute("uid"));
        commudao.addCommu(comm);
        final String script = "<script>alert('\u63d0\u4ea4\u7533\u8bf7\u6210\u529f\uff0c\u70b9\u51fb\u8fd4\u56de\u56de\u5230\u5e7f\u573a\uff0c\u6216\u8005\u7ee7\u7eed\u7533\u8bf7');location.href='createClub.jsp'</script>";
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(script);
    }
}
