package pl.kamilberenhard.transped.model;

public class LoginUserDTO {

    private String username;
    private String JWT;

    public LoginUserDTO(String username, String JWT) {
        this.username = username;
        this.JWT = JWT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }
}
