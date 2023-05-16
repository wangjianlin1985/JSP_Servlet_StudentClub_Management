// 
// 
// 

package entity;

public class Img
{
    private int img_id;
    private String img_name;
    private String date;
    private String uid;
    private int org_id;
    
    public Img() {
        this.uid = null;
    }
    
    public int getImg_id() {
        return this.img_id;
    }
    
    public String getImg_name() {
        return this.img_name;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
}
