/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBasicBean;
import de.micromata.jira.rest.domain.IssueLinkBean;
import de.micromata.jira.rest.domain.TypeBean;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class IssueLinkParser extends BaseParser {
	
	public static IssueLinkBean parse(JsonObject object) {
		IssueLinkBean bean = new IssueLinkBean();
		parseBaseProperties(bean, object);
		
		JsonElement typeElement = object.get(ELEM_TYPE);
		if(checkNotNull(typeElement)) {
			JsonObject asJsonObject = typeElement.getAsJsonObject();
			TypeBean typeBean = de.micromata.jira.rest.parser.TypeParser.parse(asJsonObject);
			bean.setTypeBean(typeBean);
		}
		
		JsonElement outwardIssueElement = object.get(ELEM_OUTWARD_ISSUE);
		if(checkNotNull(outwardIssueElement)) {
			JsonObject asJsonObject = outwardIssueElement.getAsJsonObject();
			IssueBasicBean oib = IssueBasicParser.parse(asJsonObject);
			bean.setOutwardIssue(oib);			
		}
		
		JsonElement inwardIssueElement = object.get(ELEM_INWARD_ISSUE);
		if(checkNotNull(inwardIssueElement)) {
			JsonObject asJsonObject = inwardIssueElement.getAsJsonObject();
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
