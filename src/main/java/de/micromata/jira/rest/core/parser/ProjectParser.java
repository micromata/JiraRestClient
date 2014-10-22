/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.core.domain.*;
import de.micromata.jira.rest.core.util.ERoles;
import de.micromata.jira.rest.core.util.GsonParserUtil;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class ProjectParser extends BasicProjectParser {


    public static ProjectBean parse(JsonObject object) {
        ProjectBean bean = new ProjectBean();
        parseBasicProject(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (checkNotNull(descriptionElement)) {
            String description = descriptionElement.getAsString();
            bean.setDescription(description);
        }

        JsonObject lead = object.getAsJsonObject(ELEM_LEAD);
        if (checkNotNull(lead)) {
            UserBean userBean = UserParser.parse(lead);
            bean.setLead(userBean);
        }

        JsonArray componentJsonArray = object.getAsJsonArray(ELEM_COMPONENTS);
        if (checkNotNull(componentJsonArray)) {
            List<JsonObject> componentJonObjects = GsonParserUtil.parseJsonArray(componentJsonArray);
            List<ComponentBean> componentBeans = ComponentParser.parse(componentJonObjects);
            bean.setComponents(componentBeans);
        }

        JsonArray versionJsonArray = object.getAsJsonArray(ELEM_VERSIONS);
        if (checkNotNull(versionJsonArray)) {
            List<JsonObject> versionJsonObjects = GsonParserUtil.parseJsonArray(versionJsonArray);
            List<VersionBean> connectVersionBeans = VersionParser.parse(versionJsonObjects);
            bean.setVersions(connectVersionBeans);
        }

        JsonArray issuetypesJsonArray = object.getAsJsonArray(ELEM_ISSUETYPES);
        if (checkNotNull(issuetypesJsonArray)) {
            List<JsonObject> issuetypeJsonObjects = GsonParserUtil.parseJsonArray(issuetypesJsonArray);
            List<IssueTypeBean> issueTypeBeans = IssueTypeParser.parse(issuetypeJsonObjects);
            bean.setIssueTypes(issueTypeBeans);
        }

        JsonElement assigneeTypeElement = object.get(PROP_ASSIGNEETYPE);
        if (checkNotNull(assigneeTypeElement)) {
            String assigneeType = assigneeTypeElement.getAsString();
            bean.setAssigneeType(assigneeType);
        }

        JsonElement rolesElement = object.get(ELEM_ROLES);
        if (checkNotNull(rolesElement)) {
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
