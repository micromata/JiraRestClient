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
import de.micromata.jira.rest.core.domain.IssueBasicBean;
import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.domain.StatusBean;

import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueBasicParser extends BaseParser {

    public static IssueBasicBean parse(JsonObject object) {
        IssueBasicBean bean = new IssueBasicBean();

        parseBaseProperties(bean, object);

        JsonElement keyElement = object.get(PROP_KEY);
        if (checkNotNull(keyElement)) {
            bean.setKey(keyElement.getAsString());
        }

        JsonElement fieldsElement = object.get(ELEM_FIELDS);
        if (checkNotNull(fieldsElement)) {
            JsonObject fieldObject = fieldsElement.getAsJsonObject();
            JsonElement summaryElement = fieldObject.get(PROP_SUMMARY);
            if (checkNotNull(summaryElement)) {
                bean.setSummary(summaryElement.getAsString());
            }
            JsonElement issuetypeElement = fieldObject.get(ELEM_ISSUETYPE);
            if (checkNotNull(issuetypeElement)) {
                JsonObject isseuTypeObject = issuetypeElement.getAsJsonObject();
                IssueTypeBean issueType = IssueTypeParser.parse(isseuTypeObject);
                bean.setIssueType(issueType);
            }
            JsonElement statusElement = fieldObject.get(ELEM_STATUS);
            if (checkNotNull(statusElement)) {
                JsonObject statusObject = statusElement.getAsJsonObject();
                StatusBean status = StatusParser.parse(statusObject);
                bean.setStatus(status);
            }
            JsonElement priorityElement = fieldObject.get(ELEM_PRIORITY);
            if (checkNotNull(priorityElement)) {
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
