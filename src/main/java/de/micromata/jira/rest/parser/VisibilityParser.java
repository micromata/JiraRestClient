/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.VisibilityBean;
import de.micromata.jira.rest.util.JsonConstants;
import de.micromata.jira.rest.util.JsonElementUtil;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class VisibilityParser implements JsonConstants {

	public static VisibilityBean parse(JsonObject obj) {
		VisibilityBean bean = new VisibilityBean();
        JsonElement typeElement = obj.get(PROP_TYPE);
        if(JsonElementUtil.checkNotNull(typeElement) == true){
            String ty = typeElement.getAsString();
            bean.setType(ty);
        }

        JsonElement valueElement = obj.get(PROP_VALUE);
        if(JsonElementUtil.checkNotNull(valueElement) == true){
            String va = valueElement.getAsString();
            bean.setValue(va);
        }
		return bean;
	}

}
