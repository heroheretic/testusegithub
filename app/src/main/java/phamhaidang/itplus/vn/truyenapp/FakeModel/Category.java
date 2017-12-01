package phamhaidang.itplus.vn.truyenapp.FakeModel;

public class Category implements Comparable<Category>{
    private int id;
    private String genre;

    public Category() {
    }

    public Category(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int compareTo(Category category) {
        if(this.getGenre().compareToIgnoreCase(category.getGenre())>0)
            return 1;
        if(this.getGenre().compareToIgnoreCase(category.getGenre())==0)
            return 0;
            return -1;
    }
}
