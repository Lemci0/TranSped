package pl.kamilberenhard.transped.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String street;

    private String city;

    private String postalCode;

    @OneToMany
    @JoinColumn(name = "clientId")
    private List<Parcel> parcel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<Parcel> getParcel() {
        return parcel;
    }

    public void setParcel(List<Parcel> parcel) {
        this.parcel = parcel;
    }
}
