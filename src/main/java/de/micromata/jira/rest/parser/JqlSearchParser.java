/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class JqlSearchParser implements JsonConstants {

    public static JqlSearchResultBean parse(JsonObject jsonObject){
        JqlSearchResultBean searchResultBean = new JqlSearchResultBean();
        
        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if(checkNotNull(expandElement)){
            searchResultBean.setExpand(expandElement.getAsString());
        }
        
        JsonElement startAtElement = jsonObject.get(PROP_STARTAT);
        if(checkNotNull(startAtElement)){
            searchResultBean.setStartAt(startAtElement.getAsInt());
        }
        
        JsonElement maxresultsElement = jsonObject.get(PROP_MAXRESULTS);
        if(checkNotNull(maxresultsElement)){
            searchResultBean.setMaxResults(maxresultsElement.getAsInt());
        }
        
        JsonElement totalElement = jsonObject.get(PROP_TOTAL);
        if(checkNotNull(totalElement)){
            searchResultBean.setTotal(totalElement.getAsInt());
        }
        
        JsonElement issuesElement = jsonObject.get(ELEM_ISSUES);
        if(checkNotNull(issuesElement)) {
	        List<JsonObject> jsonObjects = GsonParserUtil.parseJsonArray(issuesElement.getAsJsonArray());
	        List<IssueBean> issueBeans = IssueParser.parse(jsonObjects);
	        searchResultBean.setIssueBeans(issueBeans);
        }
        return searchResultBean;
    }

}
