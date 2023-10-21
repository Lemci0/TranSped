package pl.kamilberenhard.transped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kamilberenhard.transped.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    @Query("SELECT p FROM Parcel p WHERE p.delivery.deliveryId = ?1")
    public Parcel findByDeliveryId(long deliveryId);
}
