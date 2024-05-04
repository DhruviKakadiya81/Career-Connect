/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;


@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/Login.xhtml"
        )
)


@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/mysql",
        callerQuery = "select password from user_master where f_name = ?",
        groupsQuery = "select role_name from role_master where f_name = ?",
        priority = 30)


@Named(value = "config")
@ApplicationScoped
public class config {

    
    public config() {
    }
    
}
