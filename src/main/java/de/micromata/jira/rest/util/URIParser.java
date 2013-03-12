package de.micromata.jira.rest.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class URIParser {

       public static URI parseStringToURI(String uri){
           try {
               return new URI(uri);
           } catch (URISyntaxException e) {
               e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
           }
           return null;
       }



}
