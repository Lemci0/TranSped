package pl.kamilberenhard.transped.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driverId;

    private String firstName;

    private String lastName;

    private float truckVolume;

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
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

    public float getTruckVolume() {
        return truckVolume;
    }

    public void setTruckVolume(float truckVolume) {
        this.truckVolume = truckVolume;
    }
}
