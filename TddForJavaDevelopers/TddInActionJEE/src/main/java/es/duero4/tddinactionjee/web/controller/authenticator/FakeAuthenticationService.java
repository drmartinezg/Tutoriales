package es.duero4.tddinactionjee.web.controller.authenticator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ramon
 */
public class FakeAuthenticationService implements AuthenticationService {

    private Map<String, String> users = new HashMap<String, String>();
    
    public void addUser(String user, String pass) {
        users.put(user, pass);
    }
    
    public boolean isValidLogin(String username, String password) {
        return users.containsKey(username) && password.equals(users.get(username));
    }
    
}
