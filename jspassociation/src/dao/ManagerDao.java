// 
// 
// 

package dao;

import entity.Manager;

public interface ManagerDao
{
    Manager login(Manager p0);
    
    Manager queryUserByUid(String p0);
}
