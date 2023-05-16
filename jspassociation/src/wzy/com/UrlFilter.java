// 
// 
// 

package wzy.com;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.Filter;

public class UrlFilter implements Filter
{
    public static final String DEFAULT_URI_ENCODE = "UTF-8";
    private FilterConfig config;
    private String encode;
    
    public UrlFilter() {
        this.config = null;
        this.encode = null;
    }
    
    public void init(final FilterConfig config) throws ServletException {
        this.config = config;
        this.encode = config.getInitParameter("DEFAULT_URI_ENCODE");
        if (this.encode == null) {
            this.encode = "UTF-8";
        }
    }
    
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)res;
        final String ae = request.getHeader("Accept-Encoding");
        if (request.getMethod().equals("GET")) {
            request = (HttpServletRequest)new RequestWrapper(request, this.encode);
        }
        else {
            request.setCharacterEncoding(this.encode);
        }
        final String uri = request.getRequestURI();
        String ch = URLDecoder.decode(uri, this.encode);
        if (!uri.equals(ch)) {
            ch = ch.substring(request.getContextPath().length());
            this.config.getServletContext().getRequestDispatcher(ch).forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        if (ae != null && ae.toLowerCase().indexOf("gzip") != -1) {
            final ResponseWrapper re = new ResponseWrapper(response, this.encode);
            chain.doFilter((ServletRequest)request, (ServletResponse)re);
            re.finishResponse();
            return;
        }
        chain.doFilter((ServletRequest)request, (ServletResponse)response);
    }
    
    public void destroy() {
        this.config = null;
    }
}
