// 
// 
// 

package entity;

public class homepage_img
{
    private int apply_id;
    private String img_name;
    private String org_name;
    private String applytime;
    private int status;
    private int nextdel;
    
    public int getApply_id() {
        return this.apply_id;
    }
    
    public String getImg_name() {
        return this.img_name;
    }
    
    public String getOrg_name() {
        return this.org_name;
    }
    
    public String getApplytime() {
        return this.applytime;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public int getNextdel() {
        return this.nextdel;
    }
    
    public void show() {
        System.out.println("----");
        System.out.println(this.apply_id);
        System.out.println(this.img_name);
        System.out.println(this.org_name);
        System.out.println(this.applytime);
        System.out.println(this.status);
        System.out.println(this.nextdel);
        System.out.println("----");
        System.out.println("");
    }
}
