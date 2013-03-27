package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AssigneeBean;
import de.micromata.jira.rest.domain.AvatarURLBean;

public class AssigneeParser extends BaseParser {

	public static AssigneeBean parse(JsonObject object) {
		AssigneeBean bean = new AssigneeBean();
		parseBaseProperties(bean, object);
		String ea = object.get(PROP_EMAIL_ADRESS).getAsString();
		String dn = object.get(PROP_DISPLAYNAME).getAsString();
		boolean ac = object.get(PROP_ACTIVE).getAsBoolean();
		AvatarURLBean avatarURLBean = AvatarURLParser.parse(object.get(ELEM_AVATAR_URLS).getAsJsonObject());
		bean.setActive(ac);
		bean.setAvatarURL(avatarURLBean);
		bean.setEmailAddress(ea);
		bean.setDisplayName(dn);
		return bean;
	}

}
