// 
// 
// 

package wzy.com.GZIP;

import javax.servlet.WriteListener;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;
import javax.servlet.ServletOutputStream;

public class GZIPResponseStream extends ServletOutputStream
{
    protected ByteArrayOutputStream byteArrayOutputStream;
    protected GZIPOutputStream gzipOutputStream;
    protected boolean closed;
    protected HttpServletResponse response;
    protected ServletOutputStream outputStream;
    
    public GZIPResponseStream(final HttpServletResponse response) throws IOException {
        this.byteArrayOutputStream = null;
        this.gzipOutputStream = null;
        this.closed = false;
        this.response = null;
        this.outputStream = null;
        this.closed = false;
        this.response = response;
        this.outputStream = response.getOutputStream();
        this.byteArrayOutputStream = new ByteArrayOutputStream();
        this.gzipOutputStream = new GZIPOutputStream(this.byteArrayOutputStream);
    }
    
    public void close() throws IOException {
        if (this.closed) {
            throw new IOException("\u8f93\u51fa\u6d41\u5df2\u7ecf\u88ab\u5173\u95ed");
        }
        this.gzipOutputStream.finish();
        final byte[] bytes = this.byteArrayOutputStream.toByteArray();
        this.response.addHeader("Content-Length", Integer.toString(bytes.length));
        this.response.addHeader("Content-Encoding", "gzip");
        this.outputStream.write(bytes);
        this.outputStream.flush();
        this.outputStream.close();
        this.closed = true;
    }
    
    public void flush() throws IOException {
        if (this.closed) {
            throw new IOException("\u8f93\u51fa\u6d41\u5df2\u5173\u95ed\uff0c\u4e0d\u80fd\u88ab\u5237\u65b0");
        }
        this.gzipOutputStream.flush();
    }
    
    public void write(final int b) throws IOException {
        if (this.closed) {
            throw new IOException("\u8f93\u51fa\u6d41\u5173\u95ed\u4e2d");
        }
        this.gzipOutputStream.write((byte)b);
    }
    
    public void write(final byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }
    
    public void write(final byte[] b, final int off, final int len) throws IOException {
        if (this.closed) {
            throw new IOException("\u8f93\u51fa\u6d41\u5173\u95ed\u4e2d");
        }
        this.gzipOutputStream.write(b, off, len);
    }
    
    public boolean closed() {
        return this.closed;
    }
    
    public boolean isReady() {
        return false;
    }
    
    public void setWriteListener(final WriteListener writeListener) {
    }
}
