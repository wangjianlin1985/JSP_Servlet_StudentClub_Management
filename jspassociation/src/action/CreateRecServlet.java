// 
// 
// 

package action;

import dao.RecDao;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import entity.Recruitment;
import daoImpl.RecDaoImp;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class CreateRecServlet extends HttpServlet
{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\u521b\u5efa\u62db\u65b0\u4e8b\u4ef6");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = new Date();
        final String now = sdf.format(date);
        final String org_id = request.getParameter("org_id");
        final String rec_title = request.getParameter("rec_title");
        final String rec_content = request.getParameter("rec_content");
        final RecDao recdao = new RecDaoImp();
        final Recruitment rec = new Recruitment();
        rec.setOrg_id(Integer.parseInt(org_id));
        rec.setContent(rec_content);
        rec.setRelease_date(now);
        rec.setRec_title(rec_title);
        rec.setStatus(1);
        rec.setRec_need("0,0,0,0,0,0");
        recdao.addRec(rec);
        request.getRequestDispatcher("recurit-sys.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
}
