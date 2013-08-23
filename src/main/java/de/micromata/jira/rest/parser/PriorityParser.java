/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.PriorityBean;
import de.micromata.jira.rest.domain.StatusBean;
import de.micromata.jira.rest.util.JsonElementUtil;
import de.micromata.jira.rest.util.URIParser;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class PriorityParser extends BaseParser {

	public static PriorityBean parse(JsonObject object) {
		PriorityBean bean = new PriorityBean();
		parseBaseProperties(bean, object);
		
		JsonElement iconUrlElement = object.get(PROP_ICONURL);
		if(JsonElementUtil.checkNotNull(iconUrlElement)) {
			String url = iconUrlElement.getAsString();
			URI uri = URIParser.parseStringToURI(url);
			bean.setIconUrl(uri);
		}
		return bean;
	}

    public static List<PriorityBean> parse(List<JsonObject> jsonObjectList){
        List<PriorityBean> retval = new ArrayList<PriorityBean>();
        for (JsonObject jsonObject : jsonObjectList) {
            PriorityBean parse = parse(jsonObject);
            retval.add(parse);
        }
        return retval;
    }

}
