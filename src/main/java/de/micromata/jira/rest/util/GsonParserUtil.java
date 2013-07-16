package de.micromata.jira.rest.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.google.gson.stream.JsonReader;
import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.domain.WorklogBean;

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

    public static JsonObject parseJsonObject(InputStream inputStream){
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        JsonElement parse = parser.parse(jsonReader);
        return parse.getAsJsonObject();
    }


    public static List<JsonObject> parseJsonArray(JsonArray array){
        List<JsonObject> retval = new ArrayList<JsonObject>();
        for (JsonElement jsonElement : array) {
            retval.add(jsonElement.getAsJsonObject());
        }
        return retval;
    }
    
    public static String parseObjectToJson(Object object) {
    	Gson gson = new Gson();
    	String jsonString = gson.toJson(object);
    	return jsonString;
    }
    
    public static String parseTransitionToJson(int transitionId) {
    	JsonObject parent = new JsonObject();
    	JsonObject transitionObject = new JsonObject();
    	transitionObject.addProperty(JsonConstants.PROP_ID, transitionId);
    	parent.add(JsonConstants.ELEM_TRANSITION, transitionObject);
//    	if(assigneeName != null) {
//    		JsonObject fieldsObject = new JsonObject();
//
//    		JsonObject assigneeObject = new JsonObject();
//    		assigneeObject.addProperty(JsonConstants.PROP_NAME, assigneeName);
//    		fieldsObject.add(JsonConstants.ELEM_ASSIGNEE, assigneeObject);
//    	}
    	String jsonString = new Gson().toJson(parent);
    	return jsonString;
    }
    
    public static String parseWorklogToJson(WorklogBean worklog) {
    	JsonObject parent = new JsonObject();
    	
    	JsonObject authorObject = new JsonObject();
    	authorObject.addProperty(JsonConstants.PROP_NAME, worklog.getAuthor().getName());
    	parent.add(JsonConstants.ELEM_AUTHOR, authorObject);
    	
    	JsonObject updateAuthorObject = new JsonObject();
    	updateAuthorObject.addProperty(JsonConstants.PROP_NAME, worklog.getUpdateAuthor().getName());
    	parent.add(JsonConstants.ELEM_UPDATE_AUTHOR, updateAuthorObject);
    	
    	parent.addProperty(JsonConstants.PROP_COMMENT, worklog.getComment());
    	parent.addProperty(JsonConstants.PROP_TIME_SPENT_SECONDS, worklog.getTimeSpentSeconds());
    	
    	SimpleDateFormat simpleDateFormat = DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ.getSimpleDateFormat();
    	Date date = worklog.getStarted();
    	parent.addProperty(JsonConstants.PROP_STARTED, simpleDateFormat.format(date));

    	VisibilityBean visibilityBean = worklog.getVisibility();
    	if(visibilityBean != null) {
    		JsonObject visbilityObject = new JsonObject();
    		visbilityObject.addProperty(JsonConstants.PROP_TYPE, visibilityBean.getType());
    		visbilityObject.addProperty(JsonConstants.PROP_VALUE, visibilityBean.getValue());
        	parent.add(JsonConstants.ELEM_VISIBILITY, visbilityObject);
    	}
    	
    	String jsonString = new Gson().toJson(parent);
    	return jsonString;
    }
}
