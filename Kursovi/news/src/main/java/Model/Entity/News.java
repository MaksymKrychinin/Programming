package Model.Entity;

import java.sql.Date;

public class News {
    String news;
    String newsCatalog;
    Date date;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNewsCatalog() {
        return newsCatalog;
    }

    public void setNewsCatalog(String newsCatalog) {
        this.newsCatalog = newsCatalog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public News(String news, String newsCatalog, Date date) {
        this.news = news;
        this.newsCatalog = newsCatalog;
        this.date = date;
    }

}
