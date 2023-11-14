package pl.kamilberenhard.transped;

import jakarta.transaction.TransactionScoped;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Role;
import pl.kamilberenhard.transped.model.User;
import pl.kamilberenhard.transped.repository.RoleRepository;
import pl.kamilberenhard.transped.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TranSpedApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranSpedApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findById(1).isPresent()) return;
			Role adminRole = roleRepository.save(new Role(1, "ADMIN"));
			roleRepository.save(new Role(2, "SPEDITOR"));
			roleRepository.save(new Role(3, "CLIENT"));
			roleRepository.save(new Role(4, "DRIVER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User(1,"admin@admin.pl", "Admin", "Admin", passwordEncode.encode("admin"), roles);

			userRepository.save(admin);
		};
	}

}
