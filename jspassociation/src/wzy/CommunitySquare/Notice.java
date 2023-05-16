// 
// 
// 

package wzy.CommunitySquare;

public class Notice
{
    private int org_id;
    private int noti_id;
    private String noti_title;
    private String noti_content;
    private String noti_date;
    
    public Notice() {
        this.noti_content = null;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public String getNoti_content() {
        return this.noti_content;
    }
    
    public String getNoti_date() {
        return this.noti_date;
    }
    
    public String getNoti_title() {
        return this.noti_title;
    }
    
    public int getNoti_id() {
        return this.noti_id;
    }
    
    public void showNotice() {
        System.out.println("");
        System.out.println(this.org_id);
        System.out.println(this.noti_id);
        System.out.println(this.noti_title);
        System.out.println(this.noti_content);
        System.out.println(this.noti_date);
    }
}
