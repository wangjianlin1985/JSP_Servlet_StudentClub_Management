// 
// 
// 

package wzy.comm;

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
    
    public BaseDao() {
        this.url = "jdbc:mysql://localhost:3306/groups?useUnicode=true&characterEncoding=utf-8";
        this.user = "root";
        this.pwd = "199722";
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
        }
        finally {
            this.free();
        }
        return row;
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
        }
        finally {
            this.free();
        }
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
            while (count < limit && this.rs.next()) {
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
        }
        finally {
            this.free();
        }
        return list;
    }
    
    static {
        BaseDao.driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(BaseDao.driver);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
