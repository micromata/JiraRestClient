package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.ComponentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
public class ComponentParser extends BaseParser {


    public static ComponentBean parse(JsonObject object){
        ComponentBean bean = new ComponentBean();
        parseBaseProperties(bean, object);
        String description = object.get(PROP_DESCRIPTION).getAsString();
        boolean isAssigneeTypeValid = object.get(PROP_ISASSIGNEETYPEVALID).getAsBoolean();
        bean.setAssigneeTypeValid(isAssigneeTypeValid);
        bean.setDescription(description);

        return bean;
    }


    public static List<ComponentBean> parse(List<JsonObject> objects){
        List<ComponentBean> retval = new ArrayList<ComponentBean>();
        for (JsonObject object : objects) {
            ComponentBean componentBean = parse(object);
            retval.add(componentBean);
        }
        return retval;

    }

}
