// 
// 
// 

package dao;

import java.util.List;
import entity.Recruitment;

public interface RecDao
{
    int addRec(Recruitment p0);
    
    int deleteRec(int p0);
    
    int update(Recruitment p0);
    
    int updateRecNeed(int p0, String p1);
    
    int StopRec(int p0);
    
    List<Recruitment> queryAllByOrg(int p0);
    
    String RecNeed(int p0);
}
