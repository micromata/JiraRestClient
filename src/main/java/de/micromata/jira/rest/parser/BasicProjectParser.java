package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;
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


    public static BasicProjectBean parse(JsonObject object) {
        BasicProjectBean bean = new BasicProjectBean();
        parseBaseProperties(bean, object);
        String key = object.get(PROP_KEY).getAsString();
        bean.setKey(key);
        return  bean;
    }


    public static List<BasicProjectBean> parse(List<JsonObject> objects) {
        List<BasicProjectBean> retval = new ArrayList<BasicProjectBean>();
        for (JsonObject jsonObject : objects) {
            retval.add(parse(jsonObject));
        }
        return retval;
    }
}
