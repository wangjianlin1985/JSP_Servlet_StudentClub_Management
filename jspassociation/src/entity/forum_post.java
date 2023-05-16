// 
// 
// 

package entity;

public class forum_post
{
    private int post_id;
    private String uid;
    private String title;
    private String date;
    private int layers;
    
    public int getPost_id() {
        return this.post_id;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public int getLayers() {
        return this.layers;
    }
}
