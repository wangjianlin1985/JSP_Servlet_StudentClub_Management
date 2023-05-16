// 
// 
// 

package dao;

import entity.User_Message;
import java.util.List;

public interface MesDao
{
    List<User_Message> ShowReceive(String p0);
    
    List<User_Message> ShowSend(String p0);
    
    List<User_Message> ShowDraf(String p0);
    
    List<User_Message> showCollect(String p0);
    
    int addMes(User_Message p0);
    
    int deleteMes(int p0);
    
    int sendDraf(int p0);
    
    int Read(int p0);
    
    int changecollect(int p0, int p1, String p2);
    
    int querayCollectF(int p0, String p1);
    
    int querayCollectT(int p0, String p1);
    
    String[] rencentUser(String p0);
    
    int noReadcount(String p0);
}
