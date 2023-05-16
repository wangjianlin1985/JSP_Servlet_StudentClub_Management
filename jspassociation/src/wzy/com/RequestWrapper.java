// 
// 
// 

package wzy.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper
{
    private String encoding;
    
    public RequestWrapper(final HttpServletRequest request) {
        super(request);
    }
    
    public RequestWrapper(final HttpServletRequest request, final String encoding) {
        super(request);
        this.encoding = encoding;
    }
    
    public String getParameter(final String name) {
        final String value = this.getRequest().getParameter(name);
        return value;
    }
}
