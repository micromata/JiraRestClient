package de.micromata.jira.rest.core.parser;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.core.domain.ChangelogBean;
import de.micromata.jira.rest.core.domain.IssueHistoryBean;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.JsonConstants;

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
