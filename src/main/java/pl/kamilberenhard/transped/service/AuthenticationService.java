package pl.kamilberenhard.transped.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.LoginUserDTO;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

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

    public LoginUserDTO loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginUserDTO(username, token);

        } catch(AuthenticationException e){
            return new LoginUserDTO(null, "");
        }
    }
}
