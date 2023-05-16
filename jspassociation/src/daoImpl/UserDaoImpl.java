// 
// 
// 

package daoImpl;

import java.security.MessageDigest;
import java.util.List;
import entity.User;
import dao.UserDao;
import comm.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao
{
    @Override
    public User login(final User u) {
        final List<User> list = (List<User>)this.executeQuery("select * from user where uid ='" + u.getUid() + "' and upwd='" + u.getUpwd() + "'", null, User.class);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public List<User> queryAllUser() {
        return (List<User>)this.executeQuery("select * from user", null, User.class);
    }
    
    @Override
    public int addUser(final User u) {
        final Object[] obs = { u.getUid(), u.getUname(), u.getUpwd(), u.getSex(), u.getBirth() };
        return this.executeUpdate("insert into user values(?,?,?,?,?)", obs);
    }
    
    @Override
    public int deleteUser(final String uid) {
        return this.executeUpdate("delete from user where uid ='" + uid + "'", null);
    }
    
    @Override
    public int update(final User u) {
        final Object[] obs = { u.getUname(), u.getUpwd(), u.getSex(), u.getBirth(), u.getUid() };
        return this.executeUpdate("update user set  uname=?,upwd=?,sex=?,birth=? where uid=?", obs);
    }
    
    @Override
    public User queryUserByName(final String name) {
        final List<User> list = (List<User>)this.executeQuery("select * from user where uname ='" + name + "'", null, User.class);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public User queryUserByUid(final String uid) {
        final List<User> list = (List<User>)this.executeQuery("select * from user where uid ='" + uid + "'", null, User.class);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public String queryUserNameByUid(final String uid) {
        final List<User> list = (List<User>)this.executeQuery("select * from user where uid ='" + uid + "'", null, User.class);
        if (list.size() > 0) {
            return list.get(0).getUname();
        }
        return null;
    }
    
    @Override
    public List<User> queryExist(final String uid) {
        return (List<User>)this.executeQuery("select * from user where uid ='" + uid + "'", null, User.class);
    }
    
    @Override
    public String MD5(final String paswd) {
        final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            final byte[] btInput = paswd.getBytes();
            final MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            final byte[] md = mdInst.digest();
            final int j = md.length;
            final char[] str = new char[j * 2];
            int k = 0;
            for (final byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xF];
                str[k++] = hexDigits[byte0 & 0xF];
            }
            final char[] str2 = new char[j];
            for (int l = 0; l < j; ++l) {
                str2[l] = str[l];
            }
            return new String(str2);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
