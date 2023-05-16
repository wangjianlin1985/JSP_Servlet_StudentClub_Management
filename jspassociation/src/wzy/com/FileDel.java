// 
// 
// 

package wzy.com;

import entity.Video;
import entity.Img;
import java.io.File;
import comm.BaseDao;
import wzy.CommunitySquare.CommSquare;

public class FileDel
{
    public static void DelUserImg(final String uid, final String uploadPath) {
        String sql = null;
        Img img = null;
        int img_id = -1;
        String fileName = null;
        try {
            img = CommSquare.getUserImg(uid);
            if (img != null) {
                img_id = img.getImg_id();
                fileName = img.getImg_name();
            }
            final BaseDao bd = new BaseDao();
            if (img_id > 0) {
                sql = "delete from img where img_id=?";
                final Object[] obs1 = { img_id };
                bd.executeUpdate(sql, obs1);
            }
            final File file = new File(String.valueOf(uploadPath) + File.separator + fileName);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void DelCommPortrait(final int org_id, final String uploadPath) {
        String sql = null;
        Img img = null;
        int img_id = -1;
        String fileName = null;
        try {
            img = CommSquare.getCommPortrait(org_id);
            if (img != null) {
                img_id = img.getImg_id();
                fileName = img.getImg_name();
            }
            final BaseDao bd = new BaseDao();
            if (img_id > 0) {
                sql = "delete from img where img_id=?";
                final Object[] obs1 = { img_id };
                bd.executeUpdate(sql, obs1);
                sql = "delete from comm_portrait where org_id=?";
                final Object[] obs2 = { org_id };
                bd.executeUpdate(sql, obs2);
            }
            final File file = new File(String.valueOf(uploadPath) + File.separator + fileName);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String DelVideo(final int video_id, final String uploadPath) {
        String sql = null;
        try {
            final BaseDao bd = new BaseDao();
            String video_name = null;
            final Video delvideo = CommSquare.getVideoById(video_id);
            if (delvideo != null) {
                video_name = delvideo.getVideo_name();
            }
            sql = "delete from homepage_video where video_name=?";
            final Object[] _obs = { video_name };
            bd.executeUpdate(sql, _obs);
            sql = "delete from video where video_id=?";
            final Object[] obs = { video_id };
            bd.executeUpdate(sql, obs);
            final File file = new File(String.valueOf(uploadPath) + File.separator + video_name);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }
    
    public static String DelCommImg(final int img_id, final String uploadPath) {
        String sql = null;
        try {
            final BaseDao bd = new BaseDao();
            String img_name = null;
            final Img delimg = CommSquare.getImgById(img_id);
            if (delimg != null) {
                img_name = delimg.getImg_name();
            }
            sql = "delete from homepage_img where img_name=?";
            final Object[] _obs = { img_name };
            bd.executeUpdate(sql, _obs);
            sql = "delete from img where img_id=?";
            final Object[] obs = { img_id };
            bd.executeUpdate(sql, obs);
            final File file = new File(String.valueOf(uploadPath) + File.separator + img_name);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }
}
