// 
// 
// 

package entity;

public class Activity
{
    private int Act_id;
    private int org_id;
    private String Act_date;
    private String Act_content;
    private String Act_title;
    
    public String getAct_title() {
        return this.Act_title;
    }
    
    public void setAct_title(final String act_title) {
        this.Act_title = act_title;
    }
    
    public int getAct_id() {
        return this.Act_id;
    }
    
    public void setAct_id(final int act_id) {
        this.Act_id = act_id;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public void setOrg_id(final int org_id) {
        this.org_id = org_id;
    }
    
    public String getAct_date() {
        return this.Act_date;
    }
    
    public void setAct_date(final String act_date) {
        this.Act_date = act_date;
    }
    
    public String getAct_content() {
        return this.Act_content;
    }
    
    public void setAct_content(final String act_content) {
        this.Act_content = act_content;
    }
}
