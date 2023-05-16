// 
// 
// 

package daoImpl;

import dao.PriDao;
import comm.BaseDao;

public class PriDaoImpl extends BaseDao implements PriDao
{
    @Override
    public int queryPri(final String uid, final int org_id, final String pri) {
        final Object[] obj = { org_id, uid };
        return this.QueryPri("select " + pri + " from org_user where org_id=? and uid=?", obj, pri);
    }
    
    public int QueryPri(final String sql, final Object[] para, final String pri) {
        this.connection();
        int hasPri = 0;
        try {
            this.ps = this.conn.prepareStatement(sql);
            if (para != null && para.length > 0) {
                for (int i = 0; i < para.length; ++i) {
                    this.ps.setObject(i + 1, para[i]);
                }
            }
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                hasPri = this.rs.getInt(pri);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return hasPri;
        }
        finally {
            this.free();
        }
        this.free();
        return hasPri;
    }
}
