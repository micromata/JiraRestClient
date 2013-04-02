package de.micromata.jira.rest.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

import java.util.List;

/**
 * User: Christian
 * Date: 12.03.13
 * Time: 15:32
 */
public class JqlSearchParser implements JsonConstants {

    public static JqlSearchResultBean parse(JsonObject jsonObject){
        JqlSearchResultBean searchResultBean = new JqlSearchResultBean();
        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if(expandElement != null){
            searchResultBean.setExpand(expandElement.getAsString());
        }
        JsonElement startAtElement = jsonObject.get(PROP_STARTAT);
        if(startAtElement != null){
            searchResultBean.setStartAt(startAtElement.getAsInt());
        }
        JsonElement maxresultsElement = jsonObject.get(PROP_MAXRESULTS);
        if(maxresultsElement != null){
            searchResultBean.setMaxResults(maxresultsElement.getAsInt());
        }
        JsonElement totalElement = jsonObject.get(PROP_TOTAL);
        if(totalElement != null){
            searchResultBean.setTotal(totalElement.getAsInt());
        }
        List<JsonObject> jsonObjects = GsonParserUtil.parseJsonArray(jsonObject.getAsJsonArray(ELEM_ISSUES));
        List<IssueBean> issueBeans = IssueParser.parse(jsonObjects);
        searchResultBean.setIssueBeans(issueBeans);
        return searchResultBean;
    }

}
