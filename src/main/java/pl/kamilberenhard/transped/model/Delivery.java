package pl.kamilberenhard.transped.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryId;

    @ManyToOne
    @JoinColumn(name = "driverId")
    private Driver driver;

    @OneToMany(mappedBy = "delivery")
    private List<Parcel> parcels;

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }
}
