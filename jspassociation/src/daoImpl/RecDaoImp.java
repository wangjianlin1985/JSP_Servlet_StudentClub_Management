// 
// 
// 

package daoImpl;

import java.util.List;
import entity.Recruitment;
import dao.RecDao;
import comm.BaseDao;

public class RecDaoImp extends BaseDao implements RecDao
{
    @Override
    public int addRec(final Recruitment rec) {
        final Object[] obs = { rec.getOrg_id(), rec.getContent(), rec.getRelease_date(), rec.getRec_title(), rec.getStatus(), rec.getRec_need() };
        return this.executeUpdate("insert into recruitment values(?,?,?,?,null,?,?)", obs);
    }
    
    @Override
    public int update(final Recruitment rec) {
        final Object[] obs = { rec.getContent(), rec.getRec_title(), rec.getRec_id(), rec.getOrg_id() };
        return this.executeUpdate("update recruitment set content=?,rec_title=? where rec_id=? and org_id=?", obs);
    }
    
    @Override
    public int updateRecNeed(final int rec_id, final String rec_need) {
        return this.executeUpdate("update recruitment set rec_need='" + rec_need + "' where rec_id=" + rec_id, null);
    }
    
    @Override
    public int deleteRec(final int rec_id) {
        return this.executeUpdate("delete from recruitment where rec_id=" + rec_id, null);
    }
    
    @Override
    public List<Recruitment> queryAllByOrg(final int org_id) {
        return (List<Recruitment>)this.executeQuery("select * from recruitment where org_id= " + org_id, null, Recruitment.class);
    }
    
    @Override
    public int StopRec(final int rec_id) {
        return this.executeUpdate("update recruitment set status=0 where rec_id='" + rec_id + "'", null);
    }
    
    @Override
    public String RecNeed(final int rec_id) {
        final List<Recruitment> list = (List<Recruitment>)this.executeQuery("select * from recruitment where rec_id=" + rec_id, null, Recruitment.class);
        if (list.size() > 0) {
            return list.get(0).getRec_need();
        }
        return null;
    }
}
