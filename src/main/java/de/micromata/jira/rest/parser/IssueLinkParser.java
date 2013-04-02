package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBasicBean;
import de.micromata.jira.rest.domain.IssueLinkBean;
import de.micromata.jira.rest.domain.TypeBean;

public class IssueLinkParser extends BaseParser {
	
	public static IssueLinkBean parse(JsonObject object) {
		IssueLinkBean bean = new IssueLinkBean();
		parseBaseProperties(bean, object);
		JsonElement jsonElement = object.get(ELEM_TYPE);
		if(jsonElement != null) {
			JsonObject asJsonObject = jsonElement.getAsJsonObject();
			TypeBean typeBean = de.micromata.jira.rest.parser.TypeParser.parse(asJsonObject);
			bean.setTypeBean(typeBean);
		}
		jsonElement = object.get(ELEM_OUTWARD_ISSUE);
		if(jsonElement != null) {
			JsonObject asJsonObject = jsonElement.getAsJsonObject();
			IssueBasicBean oib = IssueBasicParser.parse(asJsonObject);
			bean.setOutwardIssue(oib);			
		}
		jsonElement = object.get(ELEM_INWARD_ISSUE);
		if(jsonElement != null) {
			JsonObject asJsonObject = jsonElement.getAsJsonObject();
			IssueBasicBean iib = IssueBasicParser.parse(asJsonObject);
			bean.setInwardIssue(iib);	
		}
		return bean;
	}

	public static List<IssueLinkBean> parse(List<JsonObject> objects) {
		List<IssueLinkBean> issueLinks = new ArrayList<IssueLinkBean>();
		for(JsonObject o : objects) {
			IssueLinkBean bean = parse(o);
			issueLinks.add(bean);
		}
		return issueLinks;
	}

}
