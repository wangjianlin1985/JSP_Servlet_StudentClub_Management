// 
// 
// 

package daoImpl;

import java.util.List;
import entity.Manager;
import dao.ManagerDao;
import comm.BaseDao;

public class ManagerDaoImpl extends BaseDao implements ManagerDao
{
    @Override
    public Manager login(final Manager mana) {
        final List<Manager> list = (List<Manager>)this.executeQuery("select * from manager where mid ='" + mana.getMid() + "' and password='" + mana.getPassword() + "'", null, Manager.class);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public Manager queryUserByUid(final String mid) {
        final List<Manager> list = (List<Manager>)this.executeQuery("select * from manager where mid ='" + mid + "'", null, Manager.class);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
