package de.micromata.jira.rest.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.JsonElementUtil;

public class ErrorParser {

	public static String parse(String entity) {
		StringBuffer sb = new StringBuffer();
		JsonObject object = GsonParserUtil.parseJsonObject(entity);
		JsonArray array = object.getAsJsonArray(JsonConstants.PROP_ERROR_MESSAGES);
		if(JsonElementUtil.checkNotNull(array)) {
			for(JsonElement je : array) {
				sb.append(" => " + je.getAsString());
			}
		}
		
		return sb.toString();
	}
}
