// 
// 
// 

package daoImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.Community;
import java.util.List;
import dao.CommuDao;
import comm.BaseDao;

public class CommuDaoImpl extends BaseDao implements CommuDao
{
    @Override
    public List<Community> queryAllCommu() {
        return (List<Community>)this.executeQuery("select * from community", null, Community.class);
    }
    
    @Override
    public List<Community> queryCommuBystat(final int stat) {
        return (List<Community>)this.executeQuery("select * from community where org_status=" + stat, null, Community.class);
    }
    
    @Override
    public int addCommu(final Community comm) {
        final Object[] obs = { comm.getOrg_intro(), comm.getOrg_name(), comm.getOrg_found_date(), comm.getOrg_status(), comm.getUid() };
        return this.executeUpdate("insert into community values(default,?,?,?,?,?)", obs);
    }
    
    @Override
    public int deleteCommu(final int org_id) {
        return this.executeUpdate("delete from community where org_id=" + org_id, null);
    }
    
    @Override
    public int updateStat(final int org_id, final int stat) {
        return this.executeUpdate("update community set org_status=" + stat + " where org_id=" + org_id, null);
    }
    
    @Override
    public Community queryCommuByOrg(final int org_id) {
        final List<Community> list = (List<Community>)this.executeQuery("select * from community where org_id=" + org_id, null, Community.class);
        final Community community = list.get(0);
        return community;
    }
    
    @Override
    public List<Community> queryOrgBykey(final String keywd) {
        final List<Community> list = this.queryCommuBystat(1);
        final String regEx = ".*" + keywd + ".*";
        final Pattern pattern = Pattern.compile(regEx, 2);
        for (int i = 0; i < list.size(); ++i) {
            final Matcher matcher = pattern.matcher(list.get(i).getOrg_name());
            final boolean rs = matcher.find();
            if (!rs) {
                list.remove(i);
                --i;
            }
        }
        return list;
    }
}
