// 
// 
// 

package entity;

import java.sql.Timestamp;
import comm.BaseDao;
import java.util.List;

public class User
{
    private String uid;
    private String uname;
    private String upwd;
    private String sex;
    private String birth;
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(final String sex) {
        this.sex = sex;
    }
    
    public String getBirth() {
        return this.birth;
    }
    
    public void setBirth(final String birth) {
        this.birth = birth;
    }
    
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(final String uname) {
        this.uname = uname;
    }
    
    public String getUpwd() {
        return this.upwd;
    }
    
    public void setUpwd(final String upwd) {
        this.upwd = upwd;
    }
    
    public List<User_Message> getMesList(final int ReqNum, final boolean needContent) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        final String sql = "select from_uid,title,mes_date from user_message where to_uid='" + this.uid + "' " + " order by mes_date desc";
        final List<User_Message> UMlist = (List<User_Message>)bd.executeQuery(sql, null, User_Message.class, 2, ReqNum, needContent);
        bd = null;
        return UMlist;
    }
    
    public User_Message getMesFromKey(final String from_uid, final String mes_date) {
        BaseDao db = new BaseDao();
        final String sql = "select from_uid,title,message,mes_date from user_message where to_uid='" + this.uid + "' and from_uid='" + from_uid + "' and mes_date='" + mes_date + "'";
        final User_Message um = (User_Message)db.executeQuery(sql, null, User_Message.class).get(0);
        db = null;
        return um;
    }
    
    public int setMes(final String to_uid, final String title, final String message) {
        final Object[] obs = { to_uid, this.uid, title, message, new Timestamp(System.currentTimeMillis()) };
        final String sql = "insert user_message (to_uid,from_uid,title,message,mes_date) values(?,?,?,?,?)";
        final BaseDao bd = new BaseDao();
        final int i = bd.executeUpdate(sql, obs);
        return i;
    }
}
