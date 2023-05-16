// 
// 
// 

package wzy.CommunitySquare;

import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import entity.comm_portrait;
import entity.homepage_news;
import entity.homepage_img;
import entity.Img;
import entity.homepage_video;
import entity.Video;
import java.util.ArrayList;
import entity.News;
import java.util.List;
import entity.Community;
import comm.BaseDao;
import java.sql.Timestamp;

public class CommSquare
{
    public static int CreatComm(final String uid, final String org_name, final String org_intro) {
        final Object[] obs = { org_intro, org_name, new Timestamp(System.currentTimeMillis()), 0, uid };
        String sql = "insert into community (org_intro,org_name,org_found_date,org_status,uid) values(?,?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int i = bd.executeUpdate(sql, obs);
        if (i != 0) {
            sql = "select * from community where org_name='" + org_name + "' and uid='" + uid + "'";
            final Community community = (Community)bd.executeQuery(sql, null, Community.class).get(0);
            bd = null;
            return community.getOrg_id();
        }
        return -1;
    }
    
    public static Community getCommunity(final int org_id) {
        BaseDao bd = new BaseDao();
        final List<Community> Clist = (List<Community>)bd.executeQuery("select org_id,org_intro,org_name,org_found_date,org_status,uid from community where org_id=" + org_id, null, Community.class);
        bd = null;
        if (Clist.isEmpty()) {
            return null;
        }
        return Clist.get(0);
    }
    
    public static int setCommNotice(final int _org_id, final int _noti_id, final String _noti_title, final String _noti_content) {
        final Object[] obs = { _org_id, _noti_id, _noti_title, _noti_content, new Timestamp(System.currentTimeMillis()) };
        final String sql = "insert into comm_notice (org_id,noti_id,noti_title,noti_content,noti_date) values(?,?,?,?,?)";
        final BaseDao bd = new BaseDao();
        final int i = bd.executeUpdate(sql, obs);
        return i;
    }
    
    public static int setCommNews(final int _org_id, final String _news_title, final String _news_content) {
        final Object[] obs = { _org_id, _news_title, _news_content, new Timestamp(System.currentTimeMillis()) };
        final String sql = "insert into news (org_id,news_title,news_content,news_date) values(?,?,?,?)";
        final BaseDao bd = new BaseDao();
        final int news_id = bd.executeUpdate2(sql, obs);
        return news_id;
    }
    
    public static int setRecruitment(final int _org_id, final int _rec_id, final String _rec_title, final String _content, final String _rec_need) {
        final Object[] obs = { _org_id, _rec_id, _rec_title, _content, new Timestamp(System.currentTimeMillis()), _rec_need };
        final String sql = "insert into recruitment (org_id,rec_id,rec_title,content,release_date,rec_need) values(?,?,?,?,?,?)";
        final BaseDao bd = new BaseDao();
        final int i = bd.executeUpdate(sql, obs);
        return i;
    }
    
    public static List<Recruitment> getRecruitmentList(final int ReqNum, final boolean needContent) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        final BaseDao bd = new BaseDao();
        List<Recruitment> Rlist;
        if (!needContent) {
            final String sql = "select org_id,rec_id,rec_title,release_date,status,rec_need from recruitment where status=1 order by release_date desc";
            Rlist = (List<Recruitment>)bd.executeQuery(sql, null, Recruitment.class, 3, ReqNum, false);
        }
        else {
            final String sql = "select org_id,rec_id,rec_title,content,release_date,status,rec_need from recruitment where status=1 order by release_date desc";
            Rlist = (List<Recruitment>)bd.executeQuery(sql, null, Recruitment.class, 99, ReqNum, true);
        }
        return Rlist;
    }
    
    public static List<Notice> getCommNoticeList(final int _org_id, final int ReqNum, final boolean needContent) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        List<Notice> Nlist;
        if (!needContent) {
            final String sql = "select org_id,noti_id,noti_title,noti_date from comm_notice where org_id='" + _org_id + "' order by noti_date desc";
            Nlist = (List<Notice>)bd.executeQuery(sql, null, Notice.class, 3, ReqNum, false);
        }
        else {
            final String sql = "select org_id,noti_id,noti_title,noti_content,noti_date from comm_notice where org_id='" + _org_id + "' order by noti_date desc";
            Nlist = (List<Notice>)bd.executeQuery(sql, null, Notice.class, 99, ReqNum, true);
        }
        bd = null;
        return Nlist;
    }
    
    public static List<Notice> getCommNoticeList(final int ReqNum, final boolean needContent) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        List<Notice> Nlist;
        if (!needContent) {
            final String sql = "select org_id,noti_id,noti_title,noti_date from comm_notice order by noti_date desc";
            Nlist = (List<Notice>)bd.executeQuery(sql, null, Notice.class, 3, ReqNum, false);
        }
        else {
            final String sql = "select org_id,noti_id,noti_title,noti_content,noti_date from comm_notice order by noti_date desc";
            Nlist = (List<Notice>)bd.executeQuery(sql, null, Notice.class, 99, ReqNum, true);
        }
        bd = null;
        return Nlist;
    }
    
    public static List<News> getCommNewsList(final int ReqNum, final boolean needContent) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        List<News> Nlist;
        if (!needContent) {
            final String sql = "select news_id,org_id,news_title,news_date from news ";
            Nlist = (List<News>)bd.executeQuery(sql, null, News.class, 3, ReqNum, false);
        }
        else {
            final String sql = "select news_id,org_id,news_title,news_content,news_date from news ";
            Nlist = (List<News>)bd.executeQuery(sql, null, News.class, 99, ReqNum, true);
        }
        bd = null;
        return Nlist;
    }
    
    public static List<News> getCommNewsListById(final int org_id, final boolean needContent) {
        BaseDao bd = new BaseDao();
        List<News> Nlist;
        if (!needContent) {
            final String sql = "select news_id,org_id,news_title,news_date from news where org_id=" + org_id;
            Nlist = (List<News>)bd.executeQuery(sql, null, News.class, 3, 0, false);
        }
        else {
            final String sql = "select news_id,org_id,news_title,news_content,news_date from news where org_id=" + org_id;
            Nlist = (List<News>)bd.executeQuery(sql, null, News.class, 99, 0, true);
        }
        bd = null;
        return Nlist;
    }
    
    public static News getNewsFormId(final int news_id) {
        BaseDao db = new BaseDao();
        final String sql = "select * from news where news_id=" + news_id;
        final List<News> _newslist = (List<News>)db.executeQuery(sql, null, News.class);
        db = null;
        if (_newslist.isEmpty()) {
            return null;
        }
        return _newslist.get(0);
    }
    
    public static List<News> getNewsFormIdS(final List<Integer> ids) {
        String insql = "";
        final int lenth = ids.size();
        for (int i = 0; i < lenth - 1; ++i) {
            insql = String.valueOf(insql) + ids.get(i) + ",";
        }
        List<News> _news;
        try {
            insql = String.valueOf(insql) + ids.get(lenth - 1) + ")";
            BaseDao db = new BaseDao();
            final String sql = "select * from news where news_id in (" + insql;
            _news = (List<News>)db.executeQuery(sql, null, News.class);
            db = null;
        }
        catch (Exception e) {
            return new ArrayList<News>();
        }
        return _news;
    }
    
    public static int deleteNews(final int news_id) {
        BaseDao db = new BaseDao();
        final String sql = "delete  from news where news_id=?";
        final Object[] obs = { news_id };
        final int i = db.executeUpdate(sql, obs);
        db = null;
        return i;
    }
    
    public static Notice getNoticeFormId(final int org_id, final int notice_id) {
        BaseDao db = new BaseDao();
        final String sql = "select org_id,noti_id,noti_title,noti_content,noti_date from comm_notice where org_id=" + org_id + " and noti_id=" + notice_id;
        final List<Notice> _noticelist = (List<Notice>)db.executeQuery(sql, null, Notice.class);
        db = null;
        if (_noticelist.isEmpty()) {
            return null;
        }
        return _noticelist.get(0);
    }
    
    public static Recruitment getRecruitmentFromId(final int org_id, final int rec_id) {
        BaseDao db = new BaseDao();
        final String sql = "select org_id,rec_id,rec_title,content,release_date,status,rec_need from recruitment where org_id=" + org_id + " and rec_id=" + rec_id;
        final List<Recruitment> _reclist = (List<Recruitment>)db.executeQuery(sql, null, Recruitment.class);
        db = null;
        if (_reclist.isEmpty()) {
            return null;
        }
        return _reclist.get(0);
    }
    
    public static List<Video> getVideoList(final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        final String sql = "select * from video order by video_id desc";
        final List<Video> Vlist = (List<Video>)bd.executeQuery(sql, null, Video.class, 9, ReqNum, true);
        bd = null;
        return Vlist;
    }
    
    public static int setVideo(final int _org_id, final String videoname) {
        final Object[] obs = { videoname, new Timestamp(System.currentTimeMillis()) };
        final String sql = "insert into video (video_name,date) values(?,?)";
        BaseDao bd = new BaseDao();
        final int id = bd.executeUpdate2(sql, obs);
        bd = null;
        return id;
    }
    
    public static Video getVideoById(final int video_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from video where video_id=" + video_id;
        final List<Video> videoList = (List<Video>)bd.executeQuery(sql, null, Video.class);
        bd = null;
        if (videoList.isEmpty()) {
            return null;
        }
        return videoList.get(0);
    }
    
    public static List<Video> getVideosFormIdS(final List<Integer> ids) {
        String insql = "";
        final int lenth = ids.size();
        for (int i = 0; i < lenth - 1; ++i) {
            insql = String.valueOf(insql) + ids.get(i) + ",";
        }
        insql = String.valueOf(insql) + ids.get(lenth - 1) + ")";
        BaseDao db = new BaseDao();
        final String sql = "select * from video where video_id in (" + insql;
        final List<Video> _videos = (List<Video>)db.executeQuery(sql, null, Video.class);
        db = null;
        return _videos;
    }
    
    public static int ApplyHomepageVideo(final String video_name) {
        final Object[] obs = { video_name, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_video (video_name,applytime,status,nextdel) values(?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static int ApplyHomepageVideo(final String video_name, final String org_name) {
        final Object[] obs = { video_name, org_name, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_video (video_name,org_name,applytime,status,nextdel) values(?,?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static String setHomepageVideo(final List<Integer> ids) {
        try {
            BaseDao bd = new BaseDao();
            String sql = "update homepage_video set status=?";
            final Object[] obs = { 0 };
            bd.executeUpdate(sql, obs);
            sql = "update homepage_video set status=?,nextdel=? where apply_id=?";
            for (int length = (ids.size() > 5) ? 5 : ids.size(), i = 0; i < length; ++i) {
                final Object[] obs2 = { 1, 1, ids.get(i) };
                bd.executeUpdate(sql, obs2);
            }
            sql = "delete from homepage_video where status=? and nextdel=?";
            final Object[] obs3 = { 0, 1 };
            bd.executeUpdate(sql, obs3);
            bd = null;
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "0";
    }
    
    public static List<homepage_video> getHomepageVideoApplyList(final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        final String sql = "select * from homepage_video where status=0";
        final List<homepage_video> hplist = (List<homepage_video>)bd.executeQuery(sql, null, homepage_video.class, 9, ReqNum, true);
        bd = null;
        return hplist;
    }
    
    public static List<homepage_video> getHomepageVideoList() {
        final String sql = "select * from homepage_video where status=1";
        BaseDao bd = new BaseDao();
        final List<homepage_video> hplist = (List<homepage_video>)bd.executeQuery(sql, null, homepage_video.class);
        bd = null;
        return hplist;
    }
    
    public static Img getImgById(final int img_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select img_id,img_name,date,uid,org_id from img where img_id=" + img_id;
        final List<Img> imgList = (List<Img>)bd.executeQuery(sql, null, Img.class);
        bd = null;
        if (imgList.isEmpty()) {
            return null;
        }
        return imgList.get(0);
    }
    
    public static List<Img> getImgsFormIdS(final List<Integer> ids) {
        String insql = "";
        final int lenth = ids.size();
        for (int i = 0; i < lenth - 1; ++i) {
            insql = String.valueOf(insql) + ids.get(i) + ",";
        }
        insql = String.valueOf(insql) + ids.get(lenth - 1) + ")";
        BaseDao db = new BaseDao();
        final String sql = "select img_id,img_name,date,uid,org_id from img where img_id in (" + insql;
        final List<Img> _imgs = (List<Img>)db.executeQuery(sql, null, Img.class);
        db = null;
        return _imgs;
    }
    
    public static List<Img> getCommImgList(final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        final String sql = "select * from img where org_id is not null order by img_id desc";
        final List<Img> Ilist = (List<Img>)bd.executeQuery(sql, null, Img.class, 9, ReqNum, true);
        bd = null;
        return Ilist;
    }
    
    public static List<Img> getCommImgList(final int org_id, final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        final BaseDao bd = new BaseDao();
        final String sql = "select * from img where org_id=" + org_id + " order by img_id desc";
        final List<Img> Ilist = (List<Img>)bd.executeQuery(sql, null, Img.class, 9, ReqNum, true);
        return Ilist;
    }
    
    public static int ApplyHomepageImg(final String img_name) {
        final Object[] obs = { img_name, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_img (img_name,applytime,status,nextdel) values(?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static int ApplyHomepageImg(final String img_name, final String org_name) {
        final Object[] obs = { img_name, org_name, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_img (img_name,org_name,applytime,status,nextdel) values(?,?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static String setHomepageImg(final List<Integer> ids) {
        try {
            BaseDao bd = new BaseDao();
            String sql = "update homepage_img set status=?";
            final Object[] obs = { 0 };
            bd.executeUpdate(sql, obs);
            sql = "update homepage_img set status=?,nextdel=? where apply_id=?";
            for (int length = (ids.size() > 4) ? 4 : ids.size(), i = 0; i < length; ++i) {
                final Object[] obs2 = { 1, 1, ids.get(i) };
                bd.executeUpdate(sql, obs2);
            }
            sql = "delete from homepage_img where status=? and nextdel=?";
            final Object[] obs3 = { 0, 1 };
            bd.executeUpdate(sql, obs3);
            bd = null;
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "0";
    }
    
    public static List<homepage_img> getHomepageImgApplyList(final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return null;
        }
        BaseDao bd = new BaseDao();
        final String sql = "select * from homepage_img where status=0";
        List<homepage_img> hplist = (List<homepage_img>)bd.executeQuery(sql, null, homepage_img.class, 9, ReqNum, true);
        bd = null;
        if (hplist == null) {
            hplist = new ArrayList<homepage_img>();
        }
        return hplist;
    }
    
    public static List<homepage_img> getHomepageImgList() {
        final String sql = "select * from homepage_img where status=1";
        BaseDao bd = new BaseDao();
        final List<homepage_img> hplist = (List<homepage_img>)bd.executeQuery(sql, null, homepage_img.class);
        bd = null;
        return hplist;
    }
    
    public static int ApplyHomepageNews(final int news_id) {
        final Object[] obs = { news_id, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_news (news_id,applytime,status,nextdel) values(?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static int ApplyHomepageNews(final int news_id, final String org_name) {
        final Object[] obs = { news_id, org_name, new Timestamp(System.currentTimeMillis()), 0, 0 };
        final String sql = "insert into homepage_news (news_id,org_name,applytime,status,nextdel) values(?,?,?,?,?)";
        BaseDao bd = new BaseDao();
        final int apply_id = bd.executeUpdate2(sql, obs);
        bd = null;
        return apply_id;
    }
    
    public static String setHomepageNews(final List<Integer> ids) {
        try {
            BaseDao bd = new BaseDao();
            String sql = "update homepage_news set status=?";
            final Object[] obs = { 0 };
            bd.executeUpdate(sql, obs);
            sql = "update homepage_news set status=?,nextdel=? where apply_id=?";
            for (int length = (ids.size() > 5) ? 5 : ids.size(), i = 0; i < length; ++i) {
                final Object[] obs2 = { 1, 1, ids.get(i) };
                bd.executeUpdate(sql, obs2);
            }
            sql = "delete from homepage_news where status=? and nextdel=?";
            final Object[] obs3 = { 0, 1 };
            bd.executeUpdate(sql, obs3);
            bd = null;
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "0";
    }
    
    public static List<homepage_news> getHomepageNewsApplyList(final int ReqNum) {
        if (ReqNum < 0) {
            System.out.println("ReqNum Error");
            return new ArrayList<homepage_news>();
        }
        BaseDao bd = new BaseDao();
        final String sql = "select apply_id,news_id,org_name,applytime,status,nextdel from homepage_news where status=0";
        List<homepage_news> hplist = (List<homepage_news>)bd.executeQuery(sql, null, homepage_news.class, 9, ReqNum, true);
        bd = null;
        if (hplist == null) {
            hplist = new ArrayList<homepage_news>();
        }
        return hplist;
    }
    
    public static List<homepage_news> getHomepageNewsList() {
        final String sql = "select apply_id,news_id,org_name,applytime,status,nextdel from homepage_news where status=1";
        BaseDao bd = new BaseDao();
        final List<homepage_news> hplist = (List<homepage_news>)bd.executeQuery(sql, null, homepage_news.class);
        bd = null;
        return hplist;
    }
    
    public static Img getUserImg(final String uid) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from img where uid='" + uid + "' order by img_id desc";
        final List<Img> imgList = (List<Img>)bd.executeQuery(sql, null, Img.class, 9, 1, true);
        bd = null;
        if (imgList.isEmpty()) {
            return null;
        }
        return imgList.get(0);
    }
    
    private static int setImg(final String img_name, final int org_id) {
        final Object[] obs = { img_name, new Timestamp(System.currentTimeMillis()), org_id };
        final String sql = "insert into img (img_name,date,org_id) values(?,?,?)";
        BaseDao bd = new BaseDao();
        final int id = bd.executeUpdate2(sql, obs);
        bd = null;
        return id;
    }
    
    private static int setImg(final String img_name, final String uid) {
        final Object[] obs = { img_name, new Timestamp(System.currentTimeMillis()), uid };
        final String sql = "insert into img (img_id,img_name,date,uid) values(default,?,?,?)";
        final BaseDao bd = new BaseDao();
        final int id = bd.executeUpdate2(sql, obs);
        return id;
    }
    
    public static int setCommImg(final int org_id, final String img_name) {
        final int img_id = setImg(img_name, org_id);
        return img_id;
    }
    
    public static int setUserImg(final String uid, final String img_name) {
        final int img_id = setImg(img_name, uid);
        if (img_id == -1) {
            return -1;
        }
        return img_id;
    }
    
    public static List<Video> getVideoFromOrg(final int org_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from video where video_name like '" + org_id + "%' order by video_id desc";
        final List<Video> Ilist = (List<Video>)bd.executeQuery(sql, null, Video.class);
        bd = null;
        return Ilist;
    }
    
    public static int delNews(final int news_id) {
        final BaseDao bd = new BaseDao();
        final String sql = "delete from news where news_id=?";
        final Object[] obs = { news_id };
        return bd.executeUpdate(sql, obs);
    }
    
    public static int delNotice(final int org_id, final int noti_id) {
        final BaseDao bd = new BaseDao();
        final String sql = "delete from comm_notice where org_id=? and noti_id=?";
        final Object[] obs = { org_id, noti_id };
        return bd.executeUpdate(sql, obs);
    }
    
    public static int setCommPortrait(final int org_id, final int img_id) {
        BaseDao bd = new BaseDao();
        final Object[] obs = { org_id, img_id };
        final String sql = "insert into comm_portrait (org_id,img_id) values(?,?)";
        final int i = bd.executeUpdate(sql, obs);
        bd = null;
        return i;
    }
    
    public static Img getCommPortrait(final int org_id) {
        BaseDao bd = new BaseDao();
        final String sql = "select * from comm_portrait where org_id=" + org_id;
        final List<comm_portrait> idList = (List<comm_portrait>)bd.executeQuery(sql, null, comm_portrait.class);
        bd = null;
        if (idList.isEmpty()) {
            return null;
        }
        return getImgById(idList.get(0).getImg_id());
    }
    
    public static void delOverdueNewsById(final int apply_id, final int news_id) {
        final String sql = "delete from homepage_news where apply_id=?";
        final Object[] obs = { apply_id };
        BaseDao bd = new BaseDao();
        bd.executeUpdate(sql, obs);
        bd = null;
        deleteNews(news_id);
    }
    
    public static void delOverdueApplyNews() {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String date = df.format(new Date());
        final String sql = "select * from homepage_news where status=0 and date_add(applytime,INTERVAL 15 DAY)<'" + date + "'";
        BaseDao bd = new BaseDao();
        final List<homepage_news> homepage_newsList = (List<homepage_news>)bd.executeQuery(sql, null, homepage_news.class);
        bd = null;
        for (final homepage_news hpn : homepage_newsList) {
            delOverdueNewsById(hpn.getApply_id(), hpn.getNews_id());
        }
    }
    
    public static void delOverdueApplyImg() {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String date = df.format(new Date());
        String sql = "select * from homepage_img where status=0 and date_add(applytime,INTERVAL 15 DAY)<'" + date + "'";
        BaseDao bd = new BaseDao();
        final List<homepage_img> homepage_imgList = (List<homepage_img>)bd.executeQuery(sql, null, homepage_img.class);
        for (final homepage_img hpi : homepage_imgList) {
            sql = "delete from homepage_img where apply_id=?";
            final Object[] obs = { hpi.getApply_id() };
            bd.executeUpdate(sql, obs);
        }
        bd = null;
    }
    
    public static void delOverdueApplyVideo() {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String date = df.format(new Date());
        String sql = "select * from homepage_video where status=0 and date_add(applytime,INTERVAL 15 DAY)<'" + date + "'";
        BaseDao bd = new BaseDao();
        final List<homepage_video> homepage_videoList = (List<homepage_video>)bd.executeQuery(sql, null, homepage_video.class);
        for (final homepage_video hpv : homepage_videoList) {
            sql = "delete from homepage_video where apply_id=?";
            final Object[] obs = { hpv.getApply_id() };
            bd.executeUpdate(sql, obs);
        }
        bd = null;
    }
}
