package pl.kamilberenhard.transped.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kamilberenhard.transped.model.LoginUserDTO;
import pl.kamilberenhard.transped.model.User;
import pl.kamilberenhard.transped.model.UserLoginDTO;
import pl.kamilberenhard.transped.model.UserRegistrationDTO;
import pl.kamilberenhard.transped.service.AuthenticationService;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register/client")
    public User registerClient(@RequestBody UserRegistrationDTO user) {
        return authenticationService.registerClient(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
    }

    @PostMapping("/register/speditor")
    public User registerSpeditor(@RequestBody UserRegistrationDTO user) {
        return authenticationService.registerSpeditor(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
    }

    @PostMapping("/register/driver")
    public User registerDriver(@RequestBody UserRegistrationDTO user) {
        return authenticationService.registerDriver(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
    }

    @PostMapping("/login")
    public LoginUserDTO loginUser(@RequestBody UserLoginDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
