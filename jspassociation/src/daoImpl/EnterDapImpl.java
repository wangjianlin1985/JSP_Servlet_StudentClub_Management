// 
// 
// 

package daoImpl;

import java.util.List;
import entity.Enter;
import dao.EnterDao;
import comm.BaseDao;

public class EnterDapImpl extends BaseDao implements EnterDao
{
    @Override
    public int addEnter(final Enter enter) {
        final Object[] obs = { enter.getOrg_id(), enter.getRec_id(), enter.getUid(), enter.getName(), enter.getSex(), enter.getGrade(), enter.getQq(), enter.getTel(), enter.getMail() };
        return this.executeUpdate("insert into Enter values(?,?,?,?,?,?,?,?,?)", obs);
    }
    
    @Override
    public int deleteEnter(final int rec_id) {
        return this.executeUpdate("delete from Enter where  rec_id=" + rec_id, null);
    }
    
    @Override
    public int deleteEnterAgree(final int rec_id, final String uid) {
        return this.executeUpdate("delete from Enter where  rec_id=" + rec_id + " and uid='" + uid + "'", null);
    }
    
    @Override
    public List<Enter> queryEnterByOrg(final int org_id, final int rec_id) {
        return (List<Enter>)this.executeQuery("select * from Enter where org_id =" + org_id + " and rec_id=" + rec_id, null, Enter.class);
    }
    
    @Override
    public List<Enter> queryExist(final int org_id, final String uid) {
        return (List<Enter>)this.executeQuery("select * from Enter where org_id=" + org_id + " and uid='" + uid + "'", null, Enter.class);
    }
    
    @Override
    public List<Enter> querySexNum(final int rec_id, final String sex) {
        return (List<Enter>)this.executeQuery("select * from Enter where rec_id=" + rec_id + " and sex='" + sex + "'", null, Enter.class);
    }
    
    @Override
    public List<Enter> queryGradeNum(final int rec_id, final String grade) {
        return (List<Enter>)this.executeQuery("select * from Enter where rec_id=" + rec_id + " and grade='" + grade + "'", null, Enter.class);
    }
}
