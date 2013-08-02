package es.duero4.tddinactionjee.web.controller.spring;

import es.duero4.tddinactionjee.web.controller.authenticator.AuthenticationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Ramon
 */
class LoginController implements Controller {
    private AuthenticationService authenticator;

    public LoginController() {
    }

    void setAuthenticationService(AuthenticationService authService) {
        this.authenticator = authService;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String user = request.getParameter("j_username");
        String pass = request.getParameter("j_password");
        if (authenticator.isValidLogin(user, pass)) {
            return new ModelAndView("frontpage");
        }
        return new ModelAndView("wrongpassword");
    }

}
