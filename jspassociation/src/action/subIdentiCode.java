// 
// 
// 

package action;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "subIdentiCode", value = { "/subIdentiCode" })
public class subIdentiCode extends HttpServlet
{
    public static Properties pro;
    
    static {
        (subIdentiCode.pro = new Properties()).setProperty("from", "yuanmamatouemail@163.com");
        subIdentiCode.pro.setProperty("password", "yuanmamatou1234");
        subIdentiCode.pro.setProperty("mail.smtp.ssl.enable", "true");
        subIdentiCode.pro.setProperty("mail.smtp.host", "smtp.163.com");
        subIdentiCode.pro.setProperty("mail.smtp.port", "465");
        subIdentiCode.pro.setProperty("mail.smtp.auth", "true");
        subIdentiCode.pro.setProperty("mail.debug", "true");
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String emailAddr = request.getParameter("email");
        final PrintWriter out = response.getWriter();
        if (emailAddr == null || emailAddr.equals("")) {
            out.println("fail");
            return;
        }
        final HttpSession httpSession = request.getSession();
        final Date date = (Date)httpSession.getAttribute("validateTime");
        if (date != null) {
            final Date now = new Date();
            final long interval = now.getTime() - date.getTime();
            if (interval < 60000L) {
                out.println("fail");
                return;
            }
        }
        final Session session = Session.getDefaultInstance(subIdentiCode.pro, (Authenticator)new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(subIdentiCode.pro.getProperty("from"), subIdentiCode.pro.getProperty("password"));
            }
        });
        try {
            final MimeMessage message = new MimeMessage(session);
            message.setFrom((Address)new InternetAddress(subIdentiCode.pro.getProperty("from")));
            message.addRecipients(Message.RecipientType.TO, (Address[])new InternetAddress[] { new InternetAddress(emailAddr) });
            message.setSubject("\u793e\u56e2\u7ba1\u7406\u7cfb\u7edf\u6ce8\u518c\u9a8c\u8bc1\u7801");
            final StringBuffer str = new StringBuffer();
            for (int i = 0; i < 6; ++i) {
                int a = (int)(Math.random() * 3.0);
                switch (a) {
                    case 0: {
                        a = (int)(Math.random() * 10.0) + 48;
                        break;
                    }
                    case 1: {
                        a = (int)(Math.random() * 26.0) + 65;
                        break;
                    }
                    case 2: {
                        a = (int)(Math.random() * 26.0) + 97;
                        break;
                    }
                }
                str.append((char)a);
            }
            message.setText("\u6b22\u8fce\u60a8\u6ce8\u518c\u793e\u56e2\u7ba1\u7406\u7cfb\u7edf\uff0c\u60a8\u7684code\u4e3a" + str.toString() + ",5\u5206\u949f\u5185\u6709\u6548\uff0c\u8bf7\u4e0d\u8981\u544a\u8bc9\u522b\u4eba\u54e6~");
            Transport.send((Message)message);
            httpSession.setAttribute("validateCode", (Object)str.toString());
            httpSession.setAttribute("validateTime", (Object)new Date());
            out.println("success");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
