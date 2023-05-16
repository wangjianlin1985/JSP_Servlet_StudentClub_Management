// 
// 
// 

package daoImpl;

import java.util.List;
import entity.Activity;
import dao.ActiDao;
import comm.BaseDao;

public class ActiDaoImpl extends BaseDao implements ActiDao
{
    @Override
    public int addActi(final Activity Acti) {
        final Object[] obs = { Acti.getOrg_id(), Acti.getAct_date(), Acti.getAct_content(), Acti.getAct_title() };
        return this.executeUpdate("insert into Activity values(null,?,?,?,?)", obs);
    }
    
    @Override
    public List<Activity> queryAllActi() {
        return (List<Activity>)this.executeQuery("select * from Activity", null, Activity.class);
    }
    
    @Override
    public int deleteActi(final int Act_id) {
        return this.executeUpdate("delete from Activity where Act_id =" + Act_id, null);
    }
    
    @Override
    public int update(final Activity Acti) {
        final Object[] obs = { Acti.getAct_content(), Acti.getAct_title(), Acti.getAct_id() };
        return this.executeUpdate("update Activity set Act_content=?,Act_title=? where Act_id=?", obs);
    }
    
    @Override
    public List<Activity> queryActiByOrg(final int org_id) {
        return (List<Activity>)this.executeQuery("select * from Activity where org_id =" + org_id + " order by act_date DESC", null, Activity.class);
    }
}
