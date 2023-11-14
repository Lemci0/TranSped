package pl.kamilberenhard.transped.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Role;
import pl.kamilberenhard.transped.model.User;
import pl.kamilberenhard.transped.repository.RoleRepository;
import pl.kamilberenhard.transped.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User registerClient(String username, String firstName, String lastName, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("CLIENT").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(role);

        return userRepository.save(new User(0, username, firstName, lastName, encodedPassword, authorities));
    }

    @Transactional
    public User registerSpeditor(String username, String firstName, String lastName, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("SPEDITOR").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(role);

        return userRepository.save(new User(0, username, firstName, lastName, encodedPassword, authorities));
    }

    @Transactional
    public User registerDriver(String username, String firstName, String lastName, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("DRIVER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(role);

        return userRepository.save(new User(0, username, firstName, lastName, encodedPassword, authorities));
    }
}
