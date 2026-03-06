package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String logoUrl;
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
                ", mascotList=" + mascotList +
                '}';
    }
}
