package de.micromata.jira.rest.parser;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

/**
 * User: Christian
 * Date: 12.03.13
 * Time: 15:32
 */
public class JqlSearchParser implements JsonConstants {

    public static JqlSearchResultBean parse(JsonObject jsonObject){
        JqlSearchResultBean searchResultBean = new JqlSearchResultBean();
        
        String expand = StringUtils.EMPTY;
        if(jsonObject.get(PROP_EXPAND) != null) {
        	expand = jsonObject.get(PROP_EXPAND).getAsString();
        }
        
        int startAt = jsonObject.get(PROP_STARTAT).getAsInt();
        int maxResults = jsonObject.get(PROP_MAXRESULTS).getAsInt();
        int total = jsonObject.get(PROP_TOTAL).getAsInt();
        searchResultBean.setExpand(expand);
        searchResultBean.setStartAt(startAt);
        searchResultBean.setMaxResults(maxResults);
        searchResultBean.setTotal(total);
        List<JsonObject> jsonObjects = GsonParserUtil.parseJsonArray(jsonObject.getAsJsonArray(ELEM_ISSUES));
        List<IssueBean> issueBeans = IssueParser.parse(jsonObjects);
        searchResultBean.setIssueBeans(issueBeans);
        return searchResultBean;
    }

}
