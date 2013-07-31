package es.duero4.tddinactionjee.web.controller.authenticator;

/**
 *
 * @author Ramon
 */
public interface AuthenticationService {
    
    boolean isValidLogin(String username, String password);
    
}
