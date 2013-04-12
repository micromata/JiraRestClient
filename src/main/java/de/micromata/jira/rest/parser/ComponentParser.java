package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.ComponentBean;
import de.micromata.jira.rest.domain.UserBean;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

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
        
        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if(checkNotNull(descriptionElement)) {
        	String description = descriptionElement.getAsString();
        	bean.setDescription(description);
        }
        
        JsonElement isAssigneeTypeValidElement = object.get(PROP_ISASSIGNEETYPEVALID);
        if(checkNotNull(isAssigneeTypeValidElement)) {
        	bean.setAssigneeTypeValid(isAssigneeTypeValidElement.getAsBoolean());        	
        }
        
        JsonElement leadElement = object.get(ELEM_LEAD);
        if(checkNotNull(leadElement)) {
        	UserBean userBean = UserParser.parse(leadElement.getAsJsonObject());
        	bean.setLead(userBean);
        }
        
        JsonElement assigneeTypeElement = object.get(PROP_ASSIGNEETYPE);
        if(checkNotNull(assigneeTypeElement)) {        	
        	bean.setAssigneeType(assigneeTypeElement.getAsString());
        }
        
        JsonElement assigneeElement = object.get(ELEM_ASSIGNEE);
        if(checkNotNull(assigneeElement)) {
        	UserBean assigneeBean = UserParser.parse(assigneeElement.getAsJsonObject());
        	bean.setAssignee(assigneeBean);        	
        }
        
        JsonElement realAssigneeTypeElement = object.get(PROP_REAL_ASSIGNEE_TYPE);
        if(checkNotNull(realAssigneeTypeElement)) {
	        bean.setRealAssigneeType(realAssigneeTypeElement.getAsString());
        }
        
        JsonElement realAssigneeElement = object.get(ELEM_REAL_ASSIGNEE);
        if(checkNotNull(realAssigneeElement)) {
        	UserBean realAssignee = UserParser.parse(realAssigneeElement.getAsJsonObject());
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
