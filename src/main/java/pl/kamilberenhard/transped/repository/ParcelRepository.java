package pl.kamilberenhard.transped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilberenhard.transped.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
