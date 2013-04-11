package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.TypeBean;
import de.micromata.jira.rest.util.JsonElementUtil;

public class TypeParser extends BaseParser {

	public static TypeBean parse(JsonObject object) {
		TypeBean bean = new TypeBean();
		parseBaseProperties(bean, object);
        JsonElement inwardElement = object.get(PROP_INWARD);
        if(JsonElementUtil.checkNotNull(inwardElement) == true){
            String iw = inwardElement.getAsString();
            bean.setInward(iw);
        }

        JsonElement outwardElement = object.get(PROP_OUTWARD);
        if(JsonElementUtil.checkNotNull(outwardElement) == true){
            String ow = outwardElement.getAsString();
            bean.setOutward(ow);
        }
		return bean;
	}

}
