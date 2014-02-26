package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.HistoryItemBean;
import de.micromata.jira.rest.domain.IssueHistoryBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.util.DateParser;
import de.micromata.jira.rest.util.GsonParserUtil;
import de.micromata.jira.rest.util.JsonConstants;

public class IssueHistoryParser implements JsonConstants {

	public static IssueHistoryBean parse(JsonObject jsonObject) {

		IssueHistoryBean issueHistoryBean = new IssueHistoryBean();
		
		JsonElement idElement = jsonObject.get(PROP_ID);
		if(checkNotNull(idElement)) {
			long id = idElement.getAsLong();
			issueHistoryBean.setId(id);
		}
		
		JsonElement authorElement = jsonObject.get(ELEM_AUTHOR);
		if(checkNotNull(authorElement)) {
			UserBean author = UserParser.parse(authorElement.getAsJsonObject());
			issueHistoryBean.setAuthor(author);
		}
		
		JsonElement createdElement = jsonObject.get(PROP_CREATED);
		if(checkNotNull(createdElement)) {
			Date date = DateParser.parseDateFormat(createdElement.getAsString(), DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ);
			issueHistoryBean.setCreated(date);
		}
		
		JsonElement itemsElement = jsonObject.get(ELEM_ITEMS);
		if(checkNotNull(itemsElement)) {
			List<JsonObject> list = GsonParserUtil.parseJsonArray(itemsElement.getAsJsonArray());
			List<HistoryItemBean> historyItems = HistoryItemParser.parse(list);
			issueHistoryBean.setItems(historyItems);
		}
		
		return issueHistoryBean;
	}

	public static List<IssueHistoryBean> parse(List<JsonObject> objects) {

		List<IssueHistoryBean> list = new ArrayList<IssueHistoryBean>();
		for (JsonObject o : objects) {
			IssueHistoryBean bean = parse(o);
            list.add(bean);
        }
		return list;
	}
}
