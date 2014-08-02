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
import de.micromata.jira.rest.core.domain.IssueTypeBean;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueTypeParser extends BaseParser {

    public static IssueTypeBean parse(JsonObject object) {
        IssueTypeBean bean = new IssueTypeBean();
        parseBaseProperties(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (checkNotNull(descriptionElement)) {
            String description = descriptionElement.getAsString();
            bean.setDescription(description);
        }

        JsonElement subtaskElement = object.get(PROP_SUBTASK);
        if (checkNotNull(subtaskElement)) {
            boolean subtask = subtaskElement.getAsBoolean();
            bean.setSubtask(subtask);
        }

        JsonElement iconUrlElement = object.get(PROP_ICONURL);
        if (checkNotNull(iconUrlElement)) {
            String iconURL = iconUrlElement.getAsString();
            URI uriIcon = URIParser.parseStringToURI(iconURL);
            bean.setIconURL(uriIcon);
        }
        return bean;
    }

    public static List<IssueTypeBean> parse(List<JsonObject> objects) {
        List<IssueTypeBean> retval = new ArrayList<IssueTypeBean>();
        for (JsonObject object : objects) {
            IssueTypeBean issueTypeBean = parse(object);
            retval.add(issueTypeBean);
        }
        return retval;
    }

}
