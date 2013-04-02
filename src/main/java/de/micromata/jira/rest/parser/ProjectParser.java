package de.micromata.jira.rest.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.util.ERoles;
import de.micromata.jira.rest.util.GsonParserUtil;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class ProjectParser extends BasicProjectParser {


    public static ProjectBean parse(JsonObject object) {
        ProjectBean bean = new ProjectBean();
        parseBasicProject(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if(descriptionElement != null) {
        	String description = descriptionElement.getAsString();
        	bean.setDescription(description);
        }
        
        JsonObject lead = object.getAsJsonObject(ELEM_LEAD);
        if(lead != null) {
	        UserBean userBean = UserParser.parse(lead);
	        bean.setLead(userBean);
        }
        
        JsonArray componentJsonArray = object.getAsJsonArray(ELEM_COMPONENTS);
        if (componentJsonArray != null) {
            List<JsonObject> componentJonObjects = GsonParserUtil.parseJsonArray(componentJsonArray);
            List<ComponentBean> componentBeans = ComponentParser.parse(componentJonObjects);
            bean.setComponents(componentBeans);
        }

        JsonArray versionJsonArray = object.getAsJsonArray(ELEM_VERSIONS);
        if (versionJsonArray != null) {
            List<JsonObject> versionJsonObjects = GsonParserUtil.parseJsonArray(versionJsonArray);
            List<VersionBean> connectVersionBeans = VersionParser.parse(versionJsonObjects);
            bean.setVersions(connectVersionBeans);
        }

        JsonArray issuetypesJsonArray = object.getAsJsonArray(ELEM_ISSUETYPE);
        if (issuetypesJsonArray != null) {
            List<JsonObject> issuetypeJsonObjects = GsonParserUtil.parseJsonArray(issuetypesJsonArray);
            List<IssueTypeBean> issueTypeBeans = IssueTypeParser.parse(issuetypeJsonObjects);
            bean.setIssueTypes(issueTypeBeans);
        }
        
        JsonElement assigneeTypeElement = object.get(PROP_ASSIGNEETYPE);
        if(assigneeTypeElement != null) {
        	String assigneeType = assigneeTypeElement.getAsString();
        	bean.setAssigneeType(assigneeType);
        }
        
        JsonElement rolesElement = object.get(ELEM_ROLES);
        if(rolesElement != null) {
        	Map<ERoles, URI> roles = RolesParser.parse(object.getAsJsonObject());
        	bean.setRoles(roles);
        }

        return bean;
    }

    public static List<ProjectBean> parse(List<JsonObject> objects) {
        List<ProjectBean> retval = new ArrayList<ProjectBean>();
        for (JsonObject jsonObject : objects) {
            ProjectBean projectBean = parse(jsonObject);
            retval.add(projectBean);
        }
        return retval;
    }


}
