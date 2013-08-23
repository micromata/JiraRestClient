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

import de.micromata.jira.rest.domain.WatchesBean;
import de.micromata.jira.rest.util.JsonElementUtil;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class WatchesParser extends BaseParser {

	public static WatchesBean parse(JsonObject object) {
		WatchesBean bean = new WatchesBean();
		parseBaseProperties(bean, object);
        JsonElement watchCountElement = object.get(PROP_WATCH_COUNT);
        if(JsonElementUtil.checkNotNull(watchCountElement) == true){
            int wc = watchCountElement.getAsInt();
            bean.setWatchCount(wc);
        }

        JsonElement isWatchingElement = object.get(PROP_IS_WATCHING);
        if(JsonElementUtil.checkNotNull(isWatchingElement) == true){
            boolean iw = isWatchingElement.getAsBoolean();
            bean.setWatching(iw);
        }
		return bean;
	}
}
