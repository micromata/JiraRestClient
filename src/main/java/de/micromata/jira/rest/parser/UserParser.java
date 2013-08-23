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

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.domain.UserBean;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public class UserParser extends BaseParser {


    public static UserBean parse(JsonObject object) {
        UserBean bean = new UserBean();
        parseBaseProperties(bean, object);
        
        JsonElement activeElement = object.get(PROP_ACTIVE);
        if(checkNotNull(activeElement)) {
        	boolean active = activeElement.getAsBoolean();
        	bean.setActive(active);
        }
        
        JsonElement displaynameElement = object.get(PROP_DISPLAYNAME);
        if(checkNotNull(displaynameElement)) {
        	String displayName = displaynameElement.getAsString();
        	bean.setDisplayName(displayName);
        }
        
        JsonElement avatarUrlsElement = object.get(ELEM_AVATAR_URLS);
        if(checkNotNull(avatarUrlsElement)) {
        	JsonObject avatarUrls = avatarUrlsElement.getAsJsonObject();
        	AvatarURLBean avatarURLBean = AvatarURLParser.parse(avatarUrls);
        	bean.setAvatarUrl(avatarURLBean);
        }
        
        JsonElement emailAdressElement = object.get(PROP_EMAIL_ADRESS);
        if(checkNotNull(emailAdressElement)) {
	        String ea = emailAdressElement.getAsString();
	        bean.setEmailAddress(ea);
        }
        return bean;
    }


    public static List<UserBean> parse(List<JsonObject> objects) {
        List<UserBean> retval = new ArrayList<UserBean>();
        for (JsonObject object : objects) {
            UserBean connectUserBean = parse(object);
            retval.add(connectUserBean);
        }
        return retval;
    }
}
