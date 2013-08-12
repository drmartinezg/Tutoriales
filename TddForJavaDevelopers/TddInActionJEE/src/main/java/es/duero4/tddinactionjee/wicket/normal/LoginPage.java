package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author Ramon
 */
public class LoginPage extends WebPage {

    public LoginPage() {
        add(new LoginForm("login_form"));
    }
    
}
