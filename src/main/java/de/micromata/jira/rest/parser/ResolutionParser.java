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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ResolutionBean;
import de.micromata.jira.rest.util.URIParser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class ResolutionParser extends BaseParser {

	public static ResolutionBean parse(JsonObject object) {
		ResolutionBean bean = new ResolutionBean();
		parseBaseProperties(bean, object);
        
		JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if(checkNotNull(descriptionElement)){
            String des = descriptionElement.getAsString();
            bean.setDescription(des);
        }

        JsonElement iconURLElement = object.get(PROP_ICONURL);
        if(checkNotNull(iconURLElement)){
            String iurl = iconURLElement.getAsString();
            URI uri = URIParser.parseStringToURI(iurl);
            bean.setIconUrl(uri);
        }
		return bean;
	}

}
