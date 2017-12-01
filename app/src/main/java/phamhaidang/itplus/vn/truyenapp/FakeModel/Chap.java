package phamhaidang.itplus.vn.truyenapp.FakeModel;

import java.io.Serializable;
import java.util.ArrayList;

public class Chap implements Serializable{
    private int id;
    private int chap;
    private int mangaid;
    private ArrayList<String> imagelist;

    public Chap() {
    }

    public Chap( int mangaid,int chap, ArrayList<String> imagelist) {
        this.chap = chap;
        this.mangaid = mangaid;
        this.imagelist = imagelist;
    }

    public int getChap() {
        return chap;
    }

    public void setChap(int chap) {
        this.chap = chap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMangaid() {
        return mangaid;
    }

    public void setMangaid(int mangaid) {
        this.mangaid = mangaid;
    }

    public ArrayList<String> getImagelist() {
        return imagelist;
    }

    public void setImagelist(ArrayList<String> imagelist) {
        this.imagelist = imagelist;
    }
}
