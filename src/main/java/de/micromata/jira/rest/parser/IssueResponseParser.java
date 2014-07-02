package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.IssueResponse;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * Created by Christian on 01.07.2014.
 */
public class IssueResponseParser extends BaseParser {

    public static IssueResponse parse(JsonObject jsonObject){
        IssueResponse retval = new IssueResponse();
        parseBaseProperties(retval, jsonObject);
        JsonElement keyElement = jsonObject.get(PROP_KEY);
        if (checkNotNull(keyElement)) {
            retval.setKey(keyElement.getAsString());
        }
        return retval;
    }
}
