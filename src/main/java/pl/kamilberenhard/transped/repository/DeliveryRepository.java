package pl.kamilberenhard.transped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilberenhard.transped.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
