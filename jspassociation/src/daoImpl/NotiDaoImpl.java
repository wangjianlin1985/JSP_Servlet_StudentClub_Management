// 
// 
// 

package daoImpl;

import entity.Notice;
import java.util.List;
import dao.NotiDao;
import comm.BaseDao;

public class NotiDaoImpl extends BaseDao implements NotiDao
{
    @Override
    public List<Notice> queryAllNoti() {
        return (List<Notice>)this.executeQuery("select * from comm_notice", null, Notice.class);
    }
    
    @Override
    public int addNoti(final Notice noti) {
        final Object[] obs = { noti.getOrg_id(), noti.getNoti_content(), noti.getNoti_date(), noti.getNoti_id(), noti.getNoti_title(), "0" };
        return this.executeUpdate("insert into comm_notice values(?,?,?,?,?,?)", obs);
    }
    
    @Override
    public int deleteNoti(final int noti_id) {
        final Object[] obs = { noti_id };
        return this.executeUpdate("delete from comm_notice where  Noti_id=?", obs);
    }
    
    @Override
    public int update(final Notice noti) {
        final Object[] obs = { noti.getNoti_content(), noti.getNoti_title(), noti.getNoti_id(), noti.getOrg_id() };
        return this.executeUpdate("update comm_noti set noti_content=?,noti_title=? where noti_id=? and org_id=?", obs);
    }
    
    @Override
    public List<Notice> queryNotiByOrg(final int org_id) {
        return (List<Notice>)this.executeQuery("select * from comm_notice where org_id=" + org_id + " order by noti_date DESC", null, Notice.class);
    }
    
    @Override
    public Notice queryNotiByNoti(final int noti_id) {
        final List<Notice> list = (List<Notice>)this.executeQuery("select * from comm_notice where noti_id=" + noti_id, null, Notice.class);
        return list.get(0);
    }
    
    @Override
    public List<Notice> queryAllAgreed() {
        return (List<Notice>)this.executeQuery("select * from comm_notice where stat='2'", null, Notice.class);
    }
    
    @Override
    public List<Notice> queryAllApply() {
        return (List<Notice>)this.executeQuery("select * from comm_notice where stat='1' order by noti_date DESC", null, Notice.class);
    }
    
    @Override
    public void AgreeApply(final int[] noti_id) {
        for (int i = 0; i < noti_id.length; ++i) {
            this.executeUpdate("update comm_notice set stat='1' where noti_id=" + noti_id[i], null);
        }
    }
    
    @Override
    public int addApplyNoti(final Notice noti) {
        final Object[] obs = { noti.getOrg_id(), noti.getNoti_content(), noti.getNoti_date(), noti.getNoti_id(), noti.getNoti_title(), 1 };
        return this.executeUpdate("insert into comm_notice values(?,?,?,?,?,?)", obs);
    }
    
    @Override
    public void deleteApplyNoti(final int[] noti_id) {
        for (int i = 0; i < noti_id.length; ++i) {
            this.executeUpdate("delete from comm_notice where  noti_id=" + noti_id[i], null);
        }
    }
}
