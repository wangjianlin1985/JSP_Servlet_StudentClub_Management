// 
// 
// 

package entity;

public class layer
{
    private int post_id;
    private int layer_id;
    private String uid;
    private String content;
    private String date;
    private String img_name;
    
    public layer() {
        this.img_name = null;
    }
    
    public int getPost_id() {
        return this.post_id;
    }
    
    public int getLayer_id() {
        return this.layer_id;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getImg_name() {
        return this.img_name;
    }
}
