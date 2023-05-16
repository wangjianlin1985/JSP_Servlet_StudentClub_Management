// 
// 
// 

package wzy.com;

import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import wzy.com.GZIP.GZIPResponseStream;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper
{
    private HttpServletResponse response;
    private ServletOutputStream outputStream;
    private PrintWriter printWriter;
    private String encoding;
    
    public ResponseWrapper(final HttpServletResponse response) {
        super(response);
        this.response = null;
        this.outputStream = null;
        this.printWriter = null;
        this.encoding = null;
        this.response = response;
    }
    
    public ResponseWrapper(final HttpServletResponse response, final String encoding) {
        super(response);
        this.response = null;
        this.outputStream = null;
        this.printWriter = null;
        this.encoding = null;
        this.response = response;
        this.encoding = encoding;
    }
    
    public ServletOutputStream createOutputStream() throws IOException {
        return new GZIPResponseStream(this.response);
    }
    
    public void finishResponse() {
        try {
            if (this.printWriter != null) {
                this.printWriter.close();
            }
            else if (this.outputStream != null) {
                this.outputStream.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void flushBuffer() throws IOException {
        this.outputStream.flush();
    }
    
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.printWriter != null) {
            throw new IOException("getWriter()\u5df2\u7ecf\u88ab\u8c03\u7528");
        }
        if (this.outputStream == null) {
            this.outputStream = this.createOutputStream();
        }
        return this.outputStream;
    }
    
    public PrintWriter getWriter() throws IOException {
        if (this.printWriter != null) {
            return this.printWriter;
        }
        if (this.outputStream != null) {
            throw new IllegalStateException("getOutputStream()\u5df2\u7ecf\u88ab\u8c03\u7528");
        }
        this.outputStream = this.createOutputStream();
        return this.printWriter = new PrintWriter(new OutputStreamWriter((OutputStream)this.outputStream, this.encoding));
    }
}
