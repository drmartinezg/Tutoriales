package es.duero4.tddinactionjee.web.controller.servlet;

import es.duero4.tddinactionjee.web.controller.authenticator.AuthenticationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon
 */
class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    protected AuthenticationService getAuthenticationService() {
        return null;
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Always reject login
        response.sendRedirect("/invalidlogin");
    }
    
    
    
}
