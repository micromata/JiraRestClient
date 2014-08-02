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
import de.micromata.jira.rest.core.domain.IssueBean;
import de.micromata.jira.rest.core.domain.JqlSearchResultBean;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.JsonConstants;

import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class JqlSearchParser implements JsonConstants {

    public static JqlSearchResultBean parse(JsonObject jsonObject) {
        JqlSearchResultBean searchResultBean = new JqlSearchResultBean();

        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if (checkNotNull(expandElement)) {
            searchResultBean.setExpand(expandElement.getAsString());
        }

        JsonElement startAtElement = jsonObject.get(PROP_STARTAT);
        if (checkNotNull(startAtElement)) {
            searchResultBean.setStartAt(startAtElement.getAsInt());
        }

        JsonElement maxresultsElement = jsonObject.get(PROP_MAXRESULTS);
        if (checkNotNull(maxresultsElement)) {
            searchResultBean.setMaxResults(maxresultsElement.getAsInt());
        }

        JsonElement totalElement = jsonObject.get(PROP_TOTAL);
        if (checkNotNull(totalElement)) {
            searchResultBean.setTotal(totalElement.getAsInt());
        }

        JsonElement issuesElement = jsonObject.get(ELEM_ISSUES);
        if (checkNotNull(issuesElement)) {
            List<JsonObject> jsonObjects = GsonParserUtil.parseJsonArray(issuesElement.getAsJsonArray());
            List<IssueBean> issueBeans = IssueParser.parse(jsonObjects);
            searchResultBean.setIssueBeans(issueBeans);
        }
        return searchResultBean;
    }

}
