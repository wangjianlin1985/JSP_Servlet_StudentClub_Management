// 
// 
// 

package dao;

import java.util.List;
import entity.User;

public interface UserDao
{
    int addUser(User p0);
    
    int deleteUser(String p0);
    
    int update(User p0);
    
    User queryUserByName(String p0);
    
    User queryUserByUid(String p0);
    
    String queryUserNameByUid(String p0);
    
    User login(User p0);
    
    List<User> queryAllUser();
    
    List<User> queryExist(String p0);
    
    String MD5(String p0);
}
