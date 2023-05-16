// 
// 
// 

package wzy.CommunitySquare;

import entity.layer;
import entity.forum_post;
import java.util.List;
import comm.BaseDao;
import java.sql.Timestamp;

public class Forum_Ctr
{
    public static int addLayer(final int post_id, final String uid, final String content) {
        final Object[] obs = { post_id, uid, content, new Timestamp(System.currentTimeMillis()) };
        String sql = "insert into layer (post_id,uid,content,date) values(?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int id = bd.executeUpdate2(sql, obs);
        sql = "update forum_post  set layers=layers+1 where post_id =?";
        final Object[] obs2 = { post_id };
        bd.executeUpdate(sql, obs2);
        bd = null;
        return id;
    }
    
    public static int creatPost(final String uid, final String title, final String content) {
        final Object[] obs = { uid, title, new Timestamp(System.currentTimeMillis()) };
        final String sql = "insert into forum_post (uid,title,date) values(?,?,?)";
        BaseDao bd = new BaseDao();
        final int id = bd.executeUpdate2(sql, obs);
        bd = null;
        return id;
    }
    
    public static int updateImgName(final String img_name, final int post_id, final int layer_id) {
        BaseDao bd = new BaseDao();
        final String sql = "update layer set img_name=? where post_id=? and layer_id=?";
        final Object[] obs = { img_name, post_id, layer_id };
        final int i = bd.executeUpdate(sql, obs);
        bd = null;
        return i;
    }
    
    public static List<forum_post> getPostsList(final int ReqNum, final boolean byLayers) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        String sql = null;
        if (byLayers) {
            sql = "select * from forum_post order by layers desc";
        }
        else {
            sql = "select * from forum_post order by post_id desc";
        }
        final List<forum_post> plist = (List<forum_post>)bd.executeQuery(sql, null, forum_post.class, 9, ReqNum, true);
        bd = null;
        return plist;
    }
    
    public static forum_post getPostById(final int post_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from forum_post where post_id=" + post_id;
        final List<forum_post> plist = (List<forum_post>)bd.executeQuery(sql, null, forum_post.class);
        bd = null;
        return plist.get(0);
    }
    
    public static layer getlayerById(final int post_id, final int layer_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from layer where post_id=" + post_id + " and layer_id=" + layer_id;
        final List<layer> layerList = (List<layer>)bd.executeQuery(sql, null, layer.class);
        bd = null;
        return layerList.get(0);
    }
    
    public static List<layer> getLayersList(final int post_id, final int ReqNum, final boolean isdesc) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        String sql = null;
        if (isdesc) {
            sql = "select * from layer where post_id=" + post_id + " order by layer_id desc";
        }
        else {
            sql = "select * from layer where post_id=" + post_id + " order by layer_id ";
        }
        final List<layer> llist = (List<layer>)bd.executeQuery(sql, null, layer.class, 9, ReqNum, true);
        bd = null;
        return llist;
    }
}
