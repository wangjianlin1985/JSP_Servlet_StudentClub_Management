// 
// 
// 

package entity;

public class Recruitment
{
    private int org_id;
    private String content;
    private String release_date;
    private String rec_title;
    private int rec_id;
    private int status;
    private String rec_need;
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
    
    public int getRec_id() {
        return this.rec_id;
    }
    
    public void setRec_id(final int rec_id) {
        this.rec_id = rec_id;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public void setOrg_id(final int org_id) {
        this.org_id = org_id;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public String getRelease_date() {
        return this.release_date;
    }
    
    public void setRelease_date(final String release_date) {
        this.release_date = release_date;
    }
    
    public String getRec_title() {
        return this.rec_title;
    }
    
    public void setRec_title(final String rec_title) {
        this.rec_title = rec_title;
    }
    
    public String getRec_need() {
        return this.rec_need;
    }
    
    public void setRec_need(final String rec_need) {
        this.rec_need = rec_need;
    }
}
