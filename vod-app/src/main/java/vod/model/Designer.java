package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "designer")
    @JsonIgnore
    private List<Mascot> mascotList = new ArrayList<>();
    public Designer() {}
    public Designer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Mascot> getMascotList() {
        return mascotList;
    }

    public void setMascotList(List<Mascot> mascotList) {
        this.mascotList = mascotList;
    }

    public void addMascot(Mascot m){
        mascotList.add(m);
    }
    @Override
    public String toString() {
        return "Designer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mascotsCount=" + (mascotList != null ? mascotList.size() : 0)+
                '}';
    }
}
