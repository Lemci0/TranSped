package pl.kamilberenhard.transped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilberenhard.transped.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
