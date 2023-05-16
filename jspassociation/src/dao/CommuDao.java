// 
// 
// 

package dao;

import entity.Community;
import java.util.List;

public interface CommuDao
{
    List<Community> queryAllCommu();
    
    List<Community> queryCommuBystat(int p0);
    
    int addCommu(Community p0);
    
    int deleteCommu(int p0);
    
    int updateStat(int p0, int p1);
    
    Community queryCommuByOrg(int p0);
    
    List<Community> queryOrgBykey(String p0);
}
