// 
// 
// 

package entity;

public class News
{
    private int news_id;
    private int org_id;
    private String news_title;
    private String news_content;
    private String news_date;
    
    public News() {
        this.news_content = null;
    }
    
    public int getNews_id() {
        return this.news_id;
    }
    
    public int getOrg_id() {
        return this.org_id;
    }
    
    public String getNews_title() {
        return this.news_title;
    }
    
    public String getNews_content() {
        return this.news_content;
    }
    
    public String getNews_date() {
        return this.news_date;
    }
    
    public void showNews() {
        System.out.println("");
        System.out.println(this.news_id);
        System.out.println(this.org_id);
        System.out.println(this.news_title);
        System.out.println(this.news_content);
        System.out.println(this.news_date);
    }
}
