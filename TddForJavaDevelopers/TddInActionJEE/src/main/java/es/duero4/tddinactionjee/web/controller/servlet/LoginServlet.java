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
        String user = request.getParameter("j_username");
        String pass = request.getParameter("j_password");
        // Branch execution based AuthenticationService's ruling
        if (getAuthenticationService().isValidLogin(user, pass)) {
            response.sendRedirect("/frontpage");
            request.getSession().setAttribute("username", user);
        } else {
            response.sendRedirect("/invalidlogin");
        }
    }
    
    
    
}
