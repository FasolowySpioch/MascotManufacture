package vod.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Mascot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, max = 40)
    private String name;
    private String photo; //What it is, dragon, bear etc.
    @ManyToOne
    @JoinColumn(name = "designer_id")
    private Designer designer; // 1 -> N

    //@JsonIgnore
    //private List<Company> companies = new ArrayList<>(); //N - N

    @ManyToMany
    @JoinTable(name="mascot_company",
    joinColumns = @JoinColumn(name = "mascot_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="company_id", referencedColumnName = "id")
    )
    private List<Company> companies = new ArrayList<>();
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

    public List<Company> getcompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void addCompany(Company c){companies.add(c);}
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
