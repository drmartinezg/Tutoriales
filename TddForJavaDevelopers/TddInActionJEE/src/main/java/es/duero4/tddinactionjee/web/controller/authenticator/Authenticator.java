package es.duero4.tddinactionjee.web.controller.authenticator;

/**
 *
 * @author Ramon
 */
public interface Authenticator {
    
    boolean isValidLogin(String username, String password);
    
}
