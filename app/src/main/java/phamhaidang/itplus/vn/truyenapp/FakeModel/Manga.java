package phamhaidang.itplus.vn.truyenapp.FakeModel;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Manga  implements Serializable{
    private int id;
    private String name;
    private ArrayList<String> genre;
    private String status;
    private String description;
    private Date pubDate;
    private int views;
    private Double rate;
    private String avatar;

    public Manga() {
    }

    public Manga(String name, ArrayList<String> genre, String status, String description, Date pubDate, int views, Double rate, String avatar) {
        this.name = name;
        this.genre = genre;
        this.status = status;
        this.description = description;
        this.pubDate = pubDate;
        this.views = views;
        this.rate = rate;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
