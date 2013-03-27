package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.domain.ReporterBean;

public class ReporterParser extends BaseParser {

	public static ReporterBean parse(JsonObject object) {
		ReporterBean bean = new ReporterBean();
		parseBaseProperties(bean, object);
		String ea = object.get(PROP_EMAIL_ADRESS).getAsString();
		bean.setEmailAddress(ea);
		String dn = object.get(PROP_DISPLAYNAME).getAsString();
		bean.setDisplayName(dn);
		boolean ac = object.get(PROP_ACTIVE).getAsBoolean();
		bean.setActive(ac);
		JsonElement jsonElement = object.get(ELEM_AVATAR_URLS);
		if(jsonElement != null) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			AvatarURLBean avatarURLBean = AvatarURLParser.parse(jsonObject);
			bean.setAvatarURLBean(avatarURLBean);
		}
		return bean;
	}

}
