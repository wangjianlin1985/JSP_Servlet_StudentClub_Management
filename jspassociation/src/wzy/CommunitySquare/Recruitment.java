// 
// 
// 

package wzy.CommunitySquare;

public class Recruitment
{
    private int org_id;
    private int rec_id;
    private String rec_title;
    private String content;
    private String release_date;
    private int rec_status;
    private String rec_need;
    
    public Recruitment() {
        this.rec_status = 1;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String getRelease_date() {
        return this.release_date;
    }
    
    public String getRec_title() {
        return this.rec_title;
    }
    
    public int getRec_id() {
        return this.rec_id;
    }
    
    public int getRec_status() {
        return this.rec_status;
    }
    
    public void setRec_status(final int status) {
        this.rec_status = status;
    }
    
    public String getRec_need() {
        return this.rec_need;
    }
    
    public void showRe() {
        System.out.println("");
        System.out.println(this.org_id);
        System.out.println(this.rec_id);
        System.out.println(this.rec_title);
        System.out.println(this.content);
        System.out.println(this.release_date);
        System.out.println(this.rec_status);
        System.out.println(this.rec_need);
    }
}
