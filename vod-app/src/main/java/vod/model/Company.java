package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, max = 40)
    @Column(name = "name")
    private String name;
    @Column(name = "logo_url")
    private String logoUrl;
    @ManyToMany(mappedBy = "companies", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Mascot> mascotList = new ArrayList<>();

    public Company() {}

    public Company(int id, String name, String logoUrl) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<Mascot> getMascotList() {
        return mascotList;
    }

    public void setMascotList(List<Mascot> mascotList) {
        this.mascotList = mascotList;
    }

    public void addMascot(Mascot m){ mascotList.add(m);}

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                //", mascotList=" + mascotList +
                '}';
    }
}
