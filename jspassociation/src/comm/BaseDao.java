// 
// 
// 

package comm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class BaseDao
{
    private static String driver;
    private String url;
    private String user;
    private String pwd;
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;
    
    static {
        BaseDao.driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(BaseDao.driver);
            System.out.println("\u9a71\u52a8\u5668\u6b63\u786e\u52a0\u8f7d");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public BaseDao() {
        this.url = "jdbc:mysql://127.0.0.1:3306/jsp_association?useUnicode=true&characterEncoding=utf-8";
        this.user = "root";
        this.pwd = "123456";
        this.conn = null;
        this.ps = null;
        this.rs = null;
    }
    
    public void connection() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.user, this.pwd);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void free() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int executeUpdate(final String sql, final Object[] para) {
        int row = 0;
        this.connection();
        try {
            this.ps = this.conn.prepareStatement(sql);
            if (para != null && para.length >= 1) {
                for (int i = 0; i < para.length; ++i) {
                    this.ps.setObject(i + 1, para[i]);
                }
            }
            row = this.ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return row;
        }
        finally {
            this.free();
        }
        this.free();
        return row;
    }
    
    public int executeUpdate2(final String sql, final Object[] para) {
        this.connection();
        int autoIncKeyFromApi = -1;
        try {
            this.ps = this.conn.prepareStatement(sql, 1);
            if (para != null && para.length >= 1) {
                for (int i = 0; i < para.length; ++i) {
                    this.ps.setObject(i + 1, para[i]);
                }
            }
            this.ps.executeUpdate();
            final ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return autoIncKeyFromApi;
        }
        finally {
            this.free();
        }
        this.free();
        return autoIncKeyFromApi;
    }
    
    public List executeQuery(final String sql, final Object[] para, final Class cls) {
        final List list = new ArrayList();
        this.connection();
        try {
            this.ps = this.conn.prepareStatement(sql);
            if (para != null && para.length > 0) {
                for (int i = 0; i < para.length; ++i) {
                    this.ps.setObject(i + 1, para[i]);
                }
            }
            this.rs = this.ps.executeQuery();
            final Field[] fields = cls.getDeclaredFields();
            while (this.rs.next()) {
                final Object obj = cls.newInstance();
                for (int j = 0; j < fields.length; ++j) {
                    final Field field = fields[j];
                    field.setAccessible(true);
                    final String fieldname = field.getType().getName();
                    if (fieldname.equals("int")) {
                        field.set(obj, this.rs.getInt(j + 1));
                    }
                    if (fieldname.equals("java.lang.String")) {
                        field.set(obj, this.rs.getString(j + 1));
                    }
                    if (fieldname.equals("double")) {
                        field.set(obj, this.rs.getDouble(j + 1));
                    }
                    if (fieldname.equals("java.util.Date")) {
                        field.set(obj, this.rs.getDate(j + 1));
                    }
                }
                list.add(obj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.free();
        }
        this.free();
        return list;
    }
    
    public List executeQuery(final String sql, final Object[] para, final Class cls, final int del, final int ReqNum, final boolean needContent) {
        final List list = new ArrayList();
        this.connection();
        try {
            this.ps = this.conn.prepareStatement(sql);
            if (para != null && para.length > 0) {
                for (int i = 0; i < para.length; ++i) {
                    this.ps.setObject(i + 1, para[i]);
                }
            }
            this.rs = this.ps.executeQuery();
            final Field[] fields = cls.getDeclaredFields();
            int count = 0;
            int limit;
            if (ReqNum == 0) {
                limit = 99999;
            }
            else {
                limit = ReqNum;
            }
            while (count < limit) {
                if (!this.rs.next()) {
                    break;
                }
                final Object obj = cls.newInstance();
                int fieldnum = fields.length;
                if (!needContent) {
                    --fieldnum;
                }
                for (int j = 0; j < fieldnum; ++j) {
                    Field field;
                    if (j >= del) {
                        field = fields[j + 1];
                    }
                    else {
                        field = fields[j];
                    }
                    field.setAccessible(true);
                    final String fieldname = field.getType().getName();
                    if (fieldname.equals("int")) {
                        field.set(obj, this.rs.getInt(j + 1));
                    }
                    if (fieldname.equals("java.lang.String")) {
                        field.set(obj, this.rs.getString(j + 1));
                    }
                    if (fieldname.equals("double")) {
                        field.set(obj, this.rs.getDouble(j + 1));
                    }
                    if (fieldname.equals("java.util.Date")) {
                        field.set(obj, this.rs.getDate(j + 1));
                    }
                }
                list.add(obj);
                ++count;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.free();
        }
        this.free();
        return list;
    }
}
