// 
// 
// 

package dao;

import java.util.List;
import entity.Notice;

public interface NotiDao
{
    int addNoti(Notice p0);
    
    int deleteNoti(int p0);
    
    int update(Notice p0);
    
    List<Notice> queryAllNoti();
    
    List<Notice> queryNotiByOrg(int p0);
    
    Notice queryNotiByNoti(int p0);
    
    List<Notice> queryAllAgreed();
    
    List<Notice> queryAllApply();
    
    void AgreeApply(int[] p0);
    
    int addApplyNoti(Notice p0);
    
    void deleteApplyNoti(int[] p0);
}
