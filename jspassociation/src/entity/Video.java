// 
// 
// 

package entity;

import org.apache.commons.lang.StringUtils;

public class Video
{
    private int video_id;
    private String video_name;
    private String date;
    
    public int getVideo_id() {
        return this.video_id;
    }
    
    public String getVideo_name() {
        return this.video_name;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public int getOrgId() {
        return Integer.parseInt(StringUtils.substringBefore(this.video_name, "^"));
    }
}
