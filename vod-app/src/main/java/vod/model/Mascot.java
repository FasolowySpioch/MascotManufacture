package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Mascot {
    private int id;
    private String name;
    private String photo; //What it is, dragon, bear etc.
    private Designer designer; // 1 -> N
    private List<Company> companyArrayList = new ArrayList<>(); //N - N
    private float rating;
    public Mascot(int i, String n, String t, Designer d, float r){
        this.id = i;
        this.name = n;
        this.photo = t;
        this.designer = d;
        this.rating = r;
    }
    public Mascot() {}

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public List<Company> getCompanyArrayList() {
        return companyArrayList;
    }

    public void setCompanyArrayList(List<Company> companyArrayList) {
        this.companyArrayList = companyArrayList;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void addCompany(Company c){companyArrayList.add(c);}
    @Override
    public String toString() {
        return "Mascot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", designerId=" + (designer != null ? designer.getId() : null) +
                ", rating=" + rating +
                '}';
    }
}
