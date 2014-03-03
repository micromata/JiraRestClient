package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.HistoryItemBean;
import de.micromata.jira.rest.util.JsonConstants;

public class HistoryItemParser implements JsonConstants {

	public static HistoryItemBean parse(JsonObject object) {
		HistoryItemBean bean = new HistoryItemBean();
		
		JsonElement fieldElement = object.get(PROP_FIELD);
		if(checkNotNull(fieldElement)) {
			String field = fieldElement.getAsString();
			bean.setField(field);
		}
		
		JsonElement fieldtypeElement = object.get(PROP_FIELDTYPE);
		if(checkNotNull(fieldtypeElement)) {
			String fieldtype = fieldtypeElement.getAsString();
			bean.setFieldType(fieldtype);
		}
		
		JsonElement fromElement = object.get(PROP_FROM);
		if(checkNotNull(fromElement)) {
			String from = fromElement.getAsString();
			bean.setFrom(from);
		}
		
		JsonElement fromStringElement = object.get(PROP_FROM_STRING);
		if(checkNotNull(fromStringElement)) {
			String fromString = fromStringElement.getAsString();
			bean.setFromString(fromString);
		}
		
		JsonElement toElement = object.get(PROP_TO);
		if(checkNotNull(toElement)) {
			String to = toElement.getAsString();
			bean.setTo(to);
		}
		
		JsonElement toStringElement = object.get(PROP_TO_STRING);
		if(checkNotNull(toStringElement)) {
			String toString = toStringElement.getAsString();
			bean.setToString(toString);
		}
		
		return bean;
	}
	
	public static List<HistoryItemBean> parse(List<JsonObject> list) {
		List<HistoryItemBean> historyItems = new ArrayList<HistoryItemBean>();
		for(JsonObject o : list) {
			HistoryItemBean bean = parse(o);
			historyItems.add(bean);
		}
		return historyItems;
	}

}
