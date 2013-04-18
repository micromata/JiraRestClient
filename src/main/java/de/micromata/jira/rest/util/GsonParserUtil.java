package de.micromata.jira.rest.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.micromata.jira.rest.jql.JqlSearchBean;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class GsonParserUtil {

    private static final JsonParser parser = new JsonParser();

    public static List<JsonObject> parseJsonObjects(String json){

        JsonElement parse = parser.parse(json);
        JsonArray asJsonArray = parse.getAsJsonArray();
        return parseJsonArray(asJsonArray);
    }

    public static JsonObject parseJsonObject(String json){
        JsonElement jsonElement = parser.parse(json);
        return jsonElement.getAsJsonObject();
    }


    public static List<JsonObject> parseJsonArray(JsonArray array){
        List<JsonObject> retval = new ArrayList<JsonObject>();
        for (JsonElement jsonElement : array) {
            retval.add(jsonElement.getAsJsonObject());
        }
        return retval;
    }
    
    public static String parseObjectToJson(JqlSearchBean jsb) {
    	Gson gson = new Gson();
        String jsonString = gson.toJson(jsb);
    	return jsonString;
    }
}
