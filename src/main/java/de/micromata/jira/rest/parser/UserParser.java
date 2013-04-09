package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.domain.UserBean;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class UserParser extends BaseParser {


    public static UserBean parse(JsonObject object) {
        UserBean bean = new UserBean();
        parseBaseProperties(bean, object);
        boolean active = object.get(PROP_ACTIVE).getAsBoolean();
        String displayName = object.get(PROP_DISPLAYNAME).getAsString();
        JsonObject avatarUrls = object.get(ELEM_AVATAR_URLS).getAsJsonObject();
        AvatarURLBean avatarURLBean = AvatarURLParser.parse(avatarUrls);
        JsonElement element = object.get(PROP_EMAIL_ADRESS);
        if(element != null) {
	        String ea = element.getAsString();
	        bean.setEmailAddress(ea);
        }
        bean.setActive(active);
        bean.setDisplayName(displayName);
        bean.setAvatarUrl(avatarURLBean);
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
