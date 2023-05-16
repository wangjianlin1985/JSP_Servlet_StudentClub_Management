// 
// 
// 

package dao;

import java.util.List;
import entity.Activity;

public interface ActiDao
{
    int addActi(Activity p0);
    
    int deleteActi(int p0);
    
    int update(Activity p0);
    
    List<Activity> queryAllActi();
    
    List<Activity> queryActiByOrg(int p0);
}
