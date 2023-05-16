// 
// 
// 

package entity;

public class Org_user
{
    private int org_id;
    private String uid;
    private String position;
    private int priManaUser;
    private int priNoNews;
    private int priActi;
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public void setOrg_id(final int org_id) {
        this.org_id = org_id;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(final String position) {
        this.position = position;
    }
    
    public int getPriManaUser() {
        return this.priManaUser;
    }
    
    public void setPriManaUser(final int priManaUser) {
        this.priManaUser = priManaUser;
    }
    
    public int getPriNoNews() {
        return this.priNoNews;
    }
    
    public void setPriNoNews(final int priNoNews) {
        this.priNoNews = priNoNews;
    }
    
    public int getPriActi() {
        return this.priActi;
    }
    
    public void setPriActi(final int priActi) {
        this.priActi = priActi;
    }
}
