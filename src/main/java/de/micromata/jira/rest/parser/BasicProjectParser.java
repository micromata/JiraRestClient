package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AvatarURLBean;
import de.micromata.jira.rest.domain.BasicProjectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class BasicProjectParser extends BaseParser {


    public static void parseBasicProject(BasicProjectBean bean, JsonObject object) {
        parseBaseProperties(bean, object);
        String key = object.get(PROP_KEY).getAsString();
        AvatarURLBean parse = AvatarURLParser.parse(object.getAsJsonObject(ELEM_AVATAR_URLS));
        bean.setAvatarURLs(parse);
        bean.setKey(key);
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
