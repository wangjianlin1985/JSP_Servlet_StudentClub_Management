// 
// 
// 

package daoImpl;

import dao.UserDao;
import entity.Org_user;
import java.util.List;
import dao.ComUserDao;
import comm.BaseDao;

public class ComUserDaoImpl extends BaseDao implements ComUserDao
{
    @Override
    public int deleteComUser(final int org_id, final String uid) {
        return this.executeUpdate("delete from org_user where org_id=" + org_id + " and uid='" + uid + "'", null);
    }
    
    @Override
    public int addComUser(final int org_id, final String uid) {
        final Object[] obj = { "\u666e\u901a" };
        return this.executeUpdate("insert into org_user values(" + org_id + ",'" + uid + "',?,0,0,0)", obj);
    }
    
    @Override
    public int addComLeader(final int org_id, final String uid) {
        final Object[] obj = { "\u793e\u957f" };
        return this.executeUpdate("insert into org_user values(" + org_id + ",'" + uid + "',?,1,1,1)", obj);
    }
    
    @Override
    public List<Org_user> queryUserByOrg(final int org_id) {
        return (List<Org_user>)this.executeQuery("select *from org_user where org_id =" + org_id, null, Org_user.class);
    }
    
    @Override
    public List<Org_user> queryUserByOrgUid(final int org_id, final String uid) {
        return (List<Org_user>)this.executeQuery("select *from org_user where org_id =" + org_id + " and uid ='" + uid + "'", null, Org_user.class);
    }
    
    @Override
    public int updatePosition(final int org_id, final String uid, final String position) {
        return this.executeUpdate("update org_user set position ='" + position + "' where org_id=" + org_id + " and uid='" + uid + "'", null);
    }
    
    @Override
    public List<Org_user> queryOrgByUid(final String uid) {
        return (List<Org_user>)this.executeQuery("select *from org_user where  uid ='" + uid + "'", null, Org_user.class);
    }
    
    @Override
    public int updateManaPri(final int org_id, final String uid, final int stat) {
        return this.executeUpdate("update org_user set priManaUser=" + stat + " where org_id=" + org_id + " and uid=" + uid, null);
    }
    
    @Override
    public int updateNotiPri(final int org_id, final String uid, final int stat) {
        return this.executeUpdate("update org_user set priNoNews=" + stat + " where org_id=" + org_id + " and uid=" + uid, null);
    }
    
    @Override
    public int updateActiaPri(final int org_id, final String uid, final int stat) {
        return this.executeUpdate("update org_user set priActi=" + stat + " where org_id=" + org_id + " and uid=" + uid, null);
    }
    
    @Override
    public String queryLeader(final int org_id) {
        final List<Org_user> list = (List<Org_user>)this.executeQuery("select *from org_user where org_id=" + org_id + " and position='\u793e\u957f'", null, Org_user.class);
        return list.get(0).getUid();
    }
    
    @Override
    public String queryLeaderName(final int org_id) {
        final List<Org_user> list = (List<Org_user>)this.executeQuery("select *from org_user where org_id=" + org_id + " and position='\u793e\u957f'", null, Org_user.class);
        final String uid = list.get(0).getUid();
        final UserDao userdao = new UserDaoImpl();
        return userdao.queryUserNameByUid(uid);
    }
}
