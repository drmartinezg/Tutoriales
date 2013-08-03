package es.duero4.tddinactionjee.web.view.jsp.jsptest;

/**
 *
 * @author Ramon
 */
public class LoginPageTest extends JspTestCase {
    
    public void testFormFieldsArePresent() throws Exception {
        get("/login.jsp");
        form().shouldHaveField("j_username");
        form().shouldHaveField("j_password");
        form().shouldHaveSubmitButton("login");
    }
}
