package de.micromata.jira.rest.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: Christian
 * Date: 01.03.13
 * Time: 18:06
 */
public class URIParser {

       public static URI parseStringToURI(String uri){
           try {
               return new URI(uri);
           } catch (URISyntaxException e) {
               e.printStackTrace();
           }
           return null;
       }



}
