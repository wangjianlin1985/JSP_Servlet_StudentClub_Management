// 
// 
// 

package entity;

public class User_Message
{
    private int mes_id;
    private String from_uid;
    private String to_uid;
    private String mes_title;
    private String mes_content;
    private String mes_date;
    private int stat;
    private int collectF;
    private int collectT;
    private int type;
    
    public int getMes_id() {
        return this.mes_id;
    }
    
    public void setMes_id(final int mes_id) {
        this.mes_id = mes_id;
    }
    
    public void setStat(final int stat) {
        this.stat = stat;
    }
    
    public int getStat() {
        return this.stat;
    }
    
    public int getCollectF() {
        return this.collectF;
    }
    
    public void setCollectF(final int collectF) {
        this.collectF = collectF;
    }
    
    public int getCollectT() {
        return this.collectT;
    }
    
    public void setCollectT(final int collectT) {
        this.collectT = collectT;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public String getFrom_uid() {
        return this.from_uid;
    }
    
    public void setFrom_uid(final String from_uid) {
        this.from_uid = from_uid;
    }
    
    public String getTo_uid() {
        return this.to_uid;
    }
    
    public void setTo_uid(final String to_uid) {
        this.to_uid = to_uid;
    }
    
    public String getMes_title() {
        return this.mes_title;
    }
    
    public void setMes_title(final String mes_title) {
        this.mes_title = mes_title;
    }
    
    public String getMes_content() {
        return this.mes_content;
    }
    
    public void setMes_content(final String mes_content) {
        this.mes_content = mes_content;
    }
    
    public String getMes_date() {
        return this.mes_date;
    }
    
    public void setMes_date(final String mes_date) {
        this.mes_date = mes_date;
    }
}
