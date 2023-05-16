// 
// 
// 

package dao;

import java.util.List;
import entity.Enter;

public interface EnterDao
{
    int addEnter(Enter p0);
    
    int deleteEnter(int p0);
    
    int deleteEnterAgree(int p0, String p1);
    
    List<Enter> queryEnterByOrg(int p0, int p1);
    
    List<Enter> queryExist(int p0, String p1);
    
    List<Enter> querySexNum(int p0, String p1);
    
    List<Enter> queryGradeNum(int p0, String p1);
}
