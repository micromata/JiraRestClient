/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
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
