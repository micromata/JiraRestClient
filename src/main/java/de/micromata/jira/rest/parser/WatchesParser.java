package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.WatchesBean;

public class WatchesParser extends BaseParser {

	public static WatchesBean parse(JsonObject object) {
		WatchesBean bean = new WatchesBean();
		parseBaseProperties(bean, object);
		int wc = object.get(PROP_WATCH_COUNT).getAsInt();
		boolean iw = object.get(PROP_IS_WATCHING).getAsBoolean();
		bean.setWatchCount(wc);
		bean.setWatching(iw);
		return bean;
	}
}
