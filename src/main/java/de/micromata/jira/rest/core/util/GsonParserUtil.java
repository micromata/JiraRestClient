/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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

import de.micromata.jira.rest.core.domain.VisibilityBean;
import de.micromata.jira.rest.core.domain.WorklogBean;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class GsonParserUtil {

    private static final JsonParser parser = new JsonParser();

    public static List<JsonObject> parseJsonObjects(InputStream inputStream) throws UnsupportedEncodingException {
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        JsonElement parse = parser.parse(jsonReader);
        JsonArray asJsonArray = parse.getAsJsonArray();
        return parseJsonArray(asJsonArray);
    }

    public static JsonObject parseJsonObject(InputStream inputStream) throws UnsupportedEncodingException {
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        JsonElement parse = parser.parse(jsonReader);
        return parse.getAsJsonObject();
    }


    public static List<JsonObject> parseJsonArray(JsonArray array) {
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
        if (visibilityBean != null) {
            JsonObject visbilityObject = new JsonObject();
            visbilityObject.addProperty(JsonConstants.PROP_TYPE, visibilityBean.getType());
            visbilityObject.addProperty(JsonConstants.PROP_VALUE, visibilityBean.getValue());
            parent.add(JsonConstants.ELEM_VISIBILITY, visbilityObject);
        }

        String jsonString = new Gson().toJson(parent);
        return jsonString;
    }
    

}
