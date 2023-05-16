// 
// 
// 

package entity;

public class Community
{
    private int org_id;
    private String org_intro;
    private String org_name;
    private String org_found_date;
    private String org_status;
    private String uid;
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
    
    public String getOrg_status() {
        return this.org_status;
    }
    
    public void setOrg_status(final String org_status) {
        this.org_status = org_status;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public void setOrg_id(final int org_id) {
        this.org_id = org_id;
    }
    
    public String getOrg_intro() {
        return this.org_intro;
    }
    
    public void setOrg_intro(final String org_intro) {
        this.org_intro = org_intro;
    }
    
    public String getOrg_name() {
        return this.org_name;
    }
    
    public void setOrg_name(final String org_name) {
        this.org_name = org_name;
    }
    
    public String getOrg_found_date() {
        return this.org_found_date;
    }
    
    public void setOrg_found_date(final String org_found_date) {
        this.org_found_date = org_found_date;
    }
}
