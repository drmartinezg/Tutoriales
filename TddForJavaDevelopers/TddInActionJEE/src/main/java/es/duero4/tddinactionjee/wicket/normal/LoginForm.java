/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.duero4.tddinactionjee.wicket.normal;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 *
 * @author Ramon
 */
class LoginForm extends Form {

    public LoginForm(String name) {
        super(name, new CompoundPropertyModel(new LoginInfo()));
        add(new TextField("j_username"));
        add(new PasswordTextField("j_password"));
    }
}
