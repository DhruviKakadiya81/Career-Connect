/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author HP
 */

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "project_sem8_db_jndi",
        callerQuery = "select Password from user_master where Email = ?",
        groupsQuery = "select Group_name from role_master where Email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)


@ApplicationScoped
public class Career_Connect {
    
}
