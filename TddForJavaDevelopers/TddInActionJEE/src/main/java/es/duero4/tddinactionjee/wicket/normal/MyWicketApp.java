package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.Page;

/**
 *
 * @author Ramon
 */
class MyWicketApp extends WebApplication {

    public MyWicketApp() {
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return MyHomePage.class;
    }

}
