package es.duero4.tddinactionjee.web.view.jsp.velocity;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
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

    private void assertFormFieldValue(String name, String expectedValue) throws Exception {
        String xpath = xpathForField(name);
        assertNodeExists(xpath);
        String actual = getString(xpath + "/@value");
        assertEquals(expectedValue, actual);
    }

    private String xpathForField(String name) {
        return "//form//input[@name='" + name + "']";
    }

    private void assertNodeExists(String xpath) throws Exception {
        assertNotNull("Node doesn't exist; " + xpath, getNode(xpath));
    }
    
    private Node getNode(String xpath) throws Exception {
        return (Node) evaluate(xpath, XPathConstants.NODE);
    }

    private String getString(String xpath) throws Exception {
        return (String) evaluate(xpath, XPathConstants.STRING);
    }
    
    private Object evaluate(String xpath, QName type) throws Exception {
        XPath engine = XPathFactory.newInstance().newXPath();
        return engine.evaluate(xpath, getResponse(), type);
    }
    
    
}
