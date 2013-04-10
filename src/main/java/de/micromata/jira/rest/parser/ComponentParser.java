package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
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
        bean.setDescription(description);
        JsonElement element = object.get(PROP_ISASSIGNEETYPEVALID);
        if(element != null) {
        	bean.setAssigneeTypeValid(element.getAsBoolean());        	
        }
        element = object.get(ELEM_LEAD);
        if(element != null) {
        	UserBean userBean = UserParser.parse(element.getAsJsonObject());
        	bean.setLead(userBean);
        }
        element = object.get(PROP_ASSIGNEETYPE);
        if(element != null) {        	
        	bean.setAssigneeType(element.getAsString());
        }
        element = object.get(ELEM_ASSIGNEE);
        if(element != null) {
        	UserBean assigneeBean = UserParser.parse(element.getAsJsonObject());
        	bean.setAssignee(assigneeBean);        	
        }
        element = object.get(PROP_REAL_ASSIGNEE_TYPE);
        if(element != null) {
	        bean.setRealAssigneeType(element.getAsString());
        }
        element = object.get(ELEM_REAL_ASSIGNEE);
        if(element != null) {
        	UserBean realAssignee = UserParser.parse(element.getAsJsonObject());
        	bean.setRealAssignee(realAssignee);
        }

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
