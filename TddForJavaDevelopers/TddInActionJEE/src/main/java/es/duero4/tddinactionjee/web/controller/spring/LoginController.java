package es.duero4.tddinactionjee.web.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Ramon
 */
class LoginController implements Controller {

    public LoginController() {
    }

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        return new ModelAndView("wrongpassword");
    }
    
}
