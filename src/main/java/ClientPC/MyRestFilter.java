/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package ClientPC;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import jwtrest.TokenProvider;
import record.KeepRecord;

/**
 *
 * @author HP
 */
//@WebFilter(filterName = "MyRestFilter", urlPatterns = {"/*"})
@Provider
@PreMatching
public class MyRestFilter implements ClientRequestFilter {
    
     public static String mytoken;
   // @Inject KeepRecord keepRecord;
    
    public MyRestFilter() {      
       // mytoken = token;
     }
 
    @Override
     public void filter(ClientRequestContext requestContext) throws IOException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
             System.out.println(" In form Auth Client Filter "+ mytoken);
      
       
           requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION,"Bearer "+ KeepRecord.getToken());
      
     // System.out.println(" After cookie header Auth Client Filter "+ mytoken);
   
    }
    
//         client.register(new MyRestFilter());

     
//     static {
//        //for localhost testing only
//        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
//                new javax.net.ssl.HostnameVerifier() {
//
//            public boolean verify(String hostname,
//                    javax.net.ssl.SSLSession sslSession) {
//                if (hostname.equals("localhost")) {
//                    return true;
//                }
//                return false;
//            }
//        });
//    }
}
