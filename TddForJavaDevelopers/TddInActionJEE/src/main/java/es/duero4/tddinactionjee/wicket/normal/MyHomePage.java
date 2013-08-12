package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.PageLink;

/**
 *
 * @author Ramon
 */
public class MyHomePage extends WebPage {

    public MyHomePage() {
        add(new Label("welcomeMessage", "Welcome to the home page!"));
        add(new PageLink("linkToLoginPage", LoginPage.class ));
    }
    
}
