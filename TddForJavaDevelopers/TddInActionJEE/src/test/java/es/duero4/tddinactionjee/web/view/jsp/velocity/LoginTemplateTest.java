package es.duero4.tddinactionjee.web.view.jsp.velocity;

import org.junit.Test;

/**
 *
 * @author Ramon
 */
public class LoginTemplateTest extends VelocityTestCase {

    // Override "web root" to shorten template paths in test
    @Override
    protected  String getWebRoot() {
        return "./src/test/resources/websrc/velocity";
    }
    
    @Test
    public void formFieldsArePresent() throws Exception {
        render("/login.vtl");
        assertFormFieldPresent("j_username");
        assertFormFieldPresent("j_password");
        assertFormSubmitButtonPresent("login");
    }

    @Test
    public void previousUsernameIsRetained() throws Exception {
        String previousUsername = "Bob";
        setAttribute("j_username", previousUsername);
        render("/login.vtl");
        assertFormFieldValue("j_username", previousUsername);
    }

    @Test
    public void errorsAreRenderedForTheUser() throws Exception {
        setAttribute("error", "Invalid password");
        render("/login.vtl");
        assertTextPresent("Invalid password");
    }
    
}
