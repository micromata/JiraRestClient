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
import de.micromata.jira.rest.core.domain.IssueLinkBean;
import de.micromata.jira.rest.core.domain.TypeBean;

import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueLinkParser extends BaseParser {

    public static IssueLinkBean parse(JsonObject object) {
        IssueLinkBean bean = new IssueLinkBean();
        parseBaseProperties(bean, object);

        JsonElement typeElement = object.get(ELEM_TYPE);
        if (checkNotNull(typeElement)) {
            JsonObject asJsonObject = typeElement.getAsJsonObject();
            TypeBean typeBean = de.micromata.jira.rest.core.parser.TypeParser.parse(asJsonObject);
            bean.setTypeBean(typeBean);
        }

        JsonElement outwardIssueElement = object.get(ELEM_OUTWARD_ISSUE);
        if (checkNotNull(outwardIssueElement)) {
            JsonObject asJsonObject = outwardIssueElement.getAsJsonObject();
            IssueBasicBean oib = IssueBasicParser.parse(asJsonObject);
            bean.setOutwardIssue(oib);
        }

        JsonElement inwardIssueElement = object.get(ELEM_INWARD_ISSUE);
        if (checkNotNull(inwardIssueElement)) {
            JsonObject asJsonObject = inwardIssueElement.getAsJsonObject();
            IssueBasicBean iib = IssueBasicParser.parse(asJsonObject);
            bean.setInwardIssue(iib);
        }
        return bean;
    }

    public static List<IssueLinkBean> parse(List<JsonObject> objects) {
        List<IssueLinkBean> issueLinks = new ArrayList<IssueLinkBean>();
        for (JsonObject o : objects) {
            IssueLinkBean bean = parse(o);
            issueLinks.add(bean);
        }
        return issueLinks;
    }

}
