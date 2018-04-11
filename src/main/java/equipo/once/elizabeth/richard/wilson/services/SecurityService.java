package equipo.once.elizabeth.richard.wilson.services;

/**
 * Created on 4/11/2018.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
