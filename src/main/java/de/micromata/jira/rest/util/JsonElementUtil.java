/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

import com.google.gson.JsonElement;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class JsonElementUtil {


    public static boolean checkNotNull(JsonElement jsonElement){
        if(jsonElement != null && jsonElement.isJsonNull() == false){
            return true;
        }
        return false;
    }
}
