package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ComponentBean;
import de.micromata.jira.rest.domain.UserBean;

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
        UserBean userBean = UserParser.parse(object.get(ELEM_LEAD).getAsJsonObject());
        String at = object.get(PROP_ASSIGNEETYPE).getAsString();
        UserBean assigneeBean = UserParser.parse(object.get(ELEM_ASSIGNEE).getAsJsonObject());
        String rat = object.get(PROP_REAL_ASSIGNEE_TYPE).getAsString();
        UserBean realAssignee = UserParser.parse(object.get(ELEM_REAL_ASSIGNEE).getAsJsonObject());
        bean.setAssigneeTypeValid(isAssigneeTypeValid);
        bean.setDescription(description);
        bean.setLead(userBean);
        bean.setAssigneeType(at);
        bean.setAssignee(assigneeBean);
        bean.setRealAssignee(realAssignee);
        bean.setRealAssigneeType(rat);

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
