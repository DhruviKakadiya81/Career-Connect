/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author HP
 */

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/project_sem8_db",
        callerQuery = "select password from user_master where email = ?",
        groupsQuery = "select GROUPNAME from groups where username = ?",
        priority = 30)


@Named(value = "career")
@ApplicationScoped
public class career {

    
    public career() {
    }
    
}
