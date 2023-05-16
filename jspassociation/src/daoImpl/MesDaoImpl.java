// 
// 
// 

package daoImpl;

import java.util.ArrayList;
import entity.User_Message;
import java.util.List;
import dao.MesDao;
import comm.BaseDao;

public class MesDaoImpl extends BaseDao implements MesDao
{
    @Override
    public List<User_Message> ShowReceive(final String uid) {
        return (List<User_Message>)this.executeQuery("select * from User_message where to_uid='" + uid + "' and stat!=0", null, User_Message.class);
    }
    
    @Override
    public List<User_Message> ShowSend(final String uid) {
        return (List<User_Message>)this.executeQuery("select * from User_message where from_uid='" + uid + "' and stat!=0", null, User_Message.class);
    }
    
    @Override
    public List<User_Message> ShowDraf(final String uid) {
        return (List<User_Message>)this.executeQuery("select * from User_message where from_uid='" + uid + "' and stat=0", null, User_Message.class);
    }
    
    @Override
    public List<User_Message> showCollect(final String uid) {
        final List<User_Message> list1 = (List<User_Message>)this.executeQuery("select * from User_message where from_uid='" + uid + "' and collecF=1", null, User_Message.class);
        final List<User_Message> list2 = (List<User_Message>)this.executeQuery("select * from User_message where to_uid='" + uid + "' and collecT=1", null, User_Message.class);
        final List<User_Message> list3 = new ArrayList<User_Message>();
        if (list1.size() > 0) {
            for (int i = 0; i < list1.size(); ++i) {
                System.out.println(list1.get(i).getMes_content());
                list3.add(list1.get(i));
            }
        }
        if (list2.size() > 0) {
            for (int i = 0; i < list2.size(); ++i) {
                list3.add(list2.get(i));
            }
        }
        return list3;
    }
    
    @Override
    public int addMes(final User_Message user_mes) {
        final Object[] obs = { user_mes.getFrom_uid(), user_mes.getTo_uid(), user_mes.getMes_title(), user_mes.getMes_content(), user_mes.getMes_date(), user_mes.getStat(), -1, -1, user_mes.getType() };
        return this.executeUpdate("insert into User_message values(null,?,?,?,?,?,?,?,?,?)", obs);
    }
    
    @Override
    public int deleteMes(final int mes_id) {
        return this.executeUpdate("delete from User_message where  mes_id=" + mes_id, null);
    }
    
    @Override
    public int sendDraf(final int mes_id) {
        return this.executeUpdate("update User_message set stat=2 where mes_id=" + mes_id, null);
    }
    
    @Override
    public int Read(final int mes_id) {
        return this.executeUpdate("update User_message set stat=1 where  mes_id=" + mes_id, null);
    }
    
    @Override
    public int changecollect(final int mes_id, final int collect, final String whocollect) {
        return this.executeUpdate("update User_message set " + whocollect + "=" + collect + " where mes_id=" + mes_id, null);
    }
    
    @Override
    public int querayCollectF(final int mes_id, final String uid) {
        final List<User_Message> list = (List<User_Message>)this.executeQuery("select * from User_message where from_uid='" + uid + "' and mes_id=" + mes_id, null, User_Message.class);
        final User_Message user_mes = list.get(0);
        return user_mes.getCollectF();
    }
    
    @Override
    public int querayCollectT(final int mes_id, final String uid) {
        final List<User_Message> list = (List<User_Message>)this.executeQuery("select * from User_message where to_uid='" + uid + "' and mes_id=" + mes_id, null, User_Message.class);
        final User_Message user_mes = list.get(0);
        return user_mes.getCollectT();
    }
    
    @Override
    public int noReadcount(final String uid) {
        final List<User_Message> list = (List<User_Message>)this.executeQuery("select * from User_message where to_uid='" + uid + "' and stat=2", null, User_Message.class);
        return list.size();
    }
    
    @Override
    public String[] rencentUser(final String uid) {
        this.connection();
        final String[] recentUser = new String[5];
        final List list = new ArrayList();
        try {
            this.ps = this.conn.prepareStatement("select DISTINCT to_uid from (select to_uid,mes_date from user_message where from_uid='" + uid + "' ORDER BY mes_date DESC) s ");
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                list.add(this.rs.getString("to_uid"));
            }
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i) != null) {
                    recentUser[i] = (String)list.get(i);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return recentUser;
        }
        finally {
            this.free();
        }
        this.free();
        return recentUser;
    }
}
