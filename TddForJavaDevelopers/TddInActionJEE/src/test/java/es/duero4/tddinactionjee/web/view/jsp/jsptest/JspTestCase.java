package es.duero4.tddinactionjee.web.view.jsp.jsptest;

import net.sf.jsptest.HtmlTestCase;

/**
 *
 * @author Ramon
 */
public abstract class JspTestCase extends HtmlTestCase {

    @Override
    protected String getWebRoot() {
        return "./src/test/resources/jsp";
    }
}
