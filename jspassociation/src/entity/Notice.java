// 
// 
// 

package entity;

public class Notice
{
    private int org_id;
    private String noti_content;
    private String noti_date;
    private int noti_id;
    private String noti_title;
    private int stat;
    
    public int getStat() {
        return this.stat;
    }
    
    public void setStat(final int stat) {
        this.stat = stat;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public void setOrg_id(final int org_id) {
        this.org_id = org_id;
    }
    
    public String getNoti_content() {
        return this.noti_content;
    }
    
    public void setNoti_content(final String noti_content) {
        this.noti_content = noti_content;
    }
    
    public String getNoti_date() {
        return this.noti_date;
    }
    
    public void setNoti_date(final String noti_date) {
        this.noti_date = noti_date;
    }
    
    public int getNoti_id() {
        return this.noti_id;
    }
    
    public void setNoti_id(final int noti_id) {
        this.noti_id = noti_id;
    }
    
    public String getNoti_title() {
        return this.noti_title;
    }
    
    public void setNoti_title(final String noti_title) {
        this.noti_title = noti_title;
    }
}
