package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.domain.BasicProjectBean;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

/**
 * User: Christian
 * Date: 07.03.13
 * Time: 11:58
 */
public class BasicProjectParser extends BaseParser {


    public static void parseBasicProject(BasicProjectBean bean, JsonObject object) {
        parseBaseProperties(bean, object);
        
        JsonElement keyElement = object.get(PROP_KEY);
        if(checkNotNull(keyElement)) {
        	String key = keyElement.getAsString();
        	bean.setKey(key);
        }
        
        JsonElement avatarUrlsElement = object.get(ELEM_AVATAR_URLS);
        if(checkNotNull(avatarUrlsElement)) {
	        AvatarURLBean parse = AvatarURLParser.parse(avatarUrlsElement.getAsJsonObject());
	        bean.setAvatarURLs(parse);
        }
    }

    public static List<BasicProjectBean> parseBasicProject(List<JsonObject> objects) {
        List<BasicProjectBean> retval = new ArrayList<BasicProjectBean>();
        for (JsonObject jsonObject : objects) {
        	BasicProjectBean bean = new BasicProjectBean();
        	parseBasicProject(bean, jsonObject);
            retval.add(bean);
        }
        return retval;
    }
}
