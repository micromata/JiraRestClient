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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.core.domain.ComponentBean;
import de.micromata.jira.rest.core.domain.UserBean;

import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class ComponentParser extends BaseParser {


    public static ComponentBean parse(JsonObject object) {
        ComponentBean bean = new ComponentBean();
        parseBaseProperties(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (checkNotNull(descriptionElement)) {
            String description = descriptionElement.getAsString();
            bean.setDescription(description);
        }

        JsonElement isAssigneeTypeValidElement = object.get(PROP_ISASSIGNEETYPEVALID);
        if (checkNotNull(isAssigneeTypeValidElement)) {
            bean.setAssigneeTypeValid(isAssigneeTypeValidElement.getAsBoolean());
        }

        JsonElement leadElement = object.get(ELEM_LEAD);
        if (checkNotNull(leadElement)) {
            UserBean userBean = UserParser.parse(leadElement.getAsJsonObject());
            bean.setLead(userBean);
        }

        JsonElement assigneeTypeElement = object.get(PROP_ASSIGNEETYPE);
        if (checkNotNull(assigneeTypeElement)) {
            bean.setAssigneeType(assigneeTypeElement.getAsString());
        }

        JsonElement assigneeElement = object.get(ELEM_ASSIGNEE);
        if (checkNotNull(assigneeElement)) {
            UserBean assigneeBean = UserParser.parse(assigneeElement.getAsJsonObject());
            bean.setAssignee(assigneeBean);
        }

        JsonElement realAssigneeTypeElement = object.get(PROP_REAL_ASSIGNEE_TYPE);
        if (checkNotNull(realAssigneeTypeElement)) {
            bean.setRealAssigneeType(realAssigneeTypeElement.getAsString());
        }

        JsonElement realAssigneeElement = object.get(ELEM_REAL_ASSIGNEE);
        if (checkNotNull(realAssigneeElement)) {
            UserBean realAssignee = UserParser.parse(realAssigneeElement.getAsJsonObject());
            bean.setRealAssignee(realAssignee);
        }

        return bean;
    }


    public static List<ComponentBean> parse(List<JsonObject> objects) {
        List<ComponentBean> retval = new ArrayList<ComponentBean>();
        for (JsonObject object : objects) {
            ComponentBean componentBean = parse(object);
            retval.add(componentBean);
        }
        return retval;

    }

}
