// 
// 
// 

package dao;

import entity.Org_user;
import java.util.List;

public interface ComUserDao
{
    int deleteComUser(int p0, String p1);
    
    int addComUser(int p0, String p1);
    
    int addComLeader(int p0, String p1);
    
    List<Org_user> queryUserByOrg(int p0);
    
    List<Org_user> queryUserByOrgUid(int p0, String p1);
    
    int updatePosition(int p0, String p1, String p2);
    
    List<Org_user> queryOrgByUid(String p0);
    
    int updateManaPri(int p0, String p1, int p2);
    
    int updateNotiPri(int p0, String p1, int p2);
    
    int updateActiaPri(int p0, String p1, int p2);
    
    String queryLeader(int p0);
    
    String queryLeaderName(int p0);
}
