package pl.kamilberenhard.transped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilberenhard.transped.model.Role;

import java.util.Map;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByAuthority(String authority);
}
