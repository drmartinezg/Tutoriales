package es.duero4.tddinactionjee.web.view.jsp.velocity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void previousUsernameIsRetained() throws Exception {
        String previousUsername = "Bob";
        setAttribute("username", previousUsername);
        render("/login.vtl");
        assertFormFieldValue("j_username", previousUsername);
    }
}
