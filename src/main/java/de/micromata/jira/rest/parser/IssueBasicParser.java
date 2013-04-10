package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.IssueBasicBean;
import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.domain.PriorityBean;
import de.micromata.jira.rest.domain.StatusBean;

public class IssueBasicParser extends BaseParser {

	public static IssueBasicBean parse(JsonObject object) {
		IssueBasicBean bean = new IssueBasicBean();
		
		parseBaseProperties(bean, object);
		
		JsonElement keyElement = object.get(PROP_KEY);
        bean.setKey(keyElement.getAsString());
        
        JsonElement fieldsElement = object.get(ELEM_FIELDS);
        if(fieldsElement != null){
            JsonObject fieldObject = fieldsElement.getAsJsonObject();
            JsonElement summaryElement = fieldObject.get(PROP_SUMMARY);
            if(summaryElement != null){
                bean.setSummary(summaryElement.getAsString());
            }
            JsonElement issuetypeElement = fieldObject.get(ELEM_ISSUETYPE);
            if(issuetypeElement != null){
                JsonObject isseuTypeObject = issuetypeElement.getAsJsonObject();
                IssueTypeBean issueType = IssueTypeParser.parse(isseuTypeObject);
                bean.setIssueType(issueType);
            }
            JsonElement statusElement = fieldObject.get(ELEM_STATUS);
            if(statusElement != null){
                JsonObject statusObject = statusElement.getAsJsonObject();
                StatusBean status = StatusParser.parse(statusObject);
                bean.setStatus(status);
            }
            JsonElement priorityElement = fieldObject.get(ELEM_PRIORITY);
            if(priorityElement != null){
            	JsonObject priorityObject = priorityElement.getAsJsonObject();
            	PriorityBean priority = PriorityParser.parse(priorityObject);
            	bean.setPriority(priority);
            }
        }
		return bean;
	}

    public static List<IssueBasicBean> parse(List<JsonObject> objects) {
        List<IssueBasicBean> issues = new ArrayList<IssueBasicBean>();
        for (JsonObject o : objects) {
        	IssueBasicBean issueBasicBean = parse(o);
            issues.add(issueBasicBean);
        }
        return issues;
    }
}
