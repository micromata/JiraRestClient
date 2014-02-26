package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ChangelogBean;
import de.micromata.jira.rest.domain.IssueHistoryBean;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

public class ChangelogParser implements JsonConstants {

	public static ChangelogBean parse(JsonObject jsonObject) {
		ChangelogBean changelogBean = new ChangelogBean();
		
		JsonElement startAtElement = jsonObject.get(PROP_STARTAT);
        if (checkNotNull(startAtElement)) {
            changelogBean.setStartAt(startAtElement.getAsInt());
        }

        JsonElement maxresultsElement = jsonObject.get(PROP_MAXRESULTS);
        if (checkNotNull(maxresultsElement)) {
            changelogBean.setMaxResults(maxresultsElement.getAsInt());
        }

        JsonElement totalElement = jsonObject.get(PROP_TOTAL);
        if (checkNotNull(totalElement)) {
            changelogBean.setTotal(totalElement.getAsInt());
        }
        
        JsonElement historiesElement = jsonObject.get(ELEM_HISTORIES);
        if (checkNotNull(historiesElement)) {
        	List<JsonObject> list = GsonParserUtil.parseJsonArray(historiesElement.getAsJsonArray());
        	List<IssueHistoryBean> issueHistoryList = IssueHistoryParser.parse(list);
        	changelogBean.setHistories(issueHistoryList);
        }
		
		return changelogBean;
	}
}
