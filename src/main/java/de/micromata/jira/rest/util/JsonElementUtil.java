package de.micromata.jira.rest.util;

import com.google.gson.JsonElement;

/**
 * User: Christian
 * Date: 11.04.13
 * Time: 15:34
 */
public class JsonElementUtil {


    public static boolean checkNotNull(JsonElement jsonElement){
        if(jsonElement != null && jsonElement.isJsonNull() == false){
            return true;
        }
        return false;
    }
}
