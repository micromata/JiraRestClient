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
import de.micromata.jira.rest.core.domain.CommentBean;
import de.micromata.jira.rest.core.domain.CommentSummaryBean;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.JsonConstants;

import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class CommentSummaryParser implements JsonConstants {

    public static CommentSummaryBean parse(JsonObject object) {
        CommentSummaryBean bean = new CommentSummaryBean();

        JsonElement startAtElement = object.get(PROP_STARTAT);
        if (checkNotNull(startAtElement)) {
            int sa = startAtElement.getAsInt();
            bean.setStartAt(sa);
        }

        JsonElement totalElement = object.get(PROP_TOTAL);
        if (checkNotNull(totalElement)) {
            int to = totalElement.getAsInt();
            bean.setTotal(to);
        }

        JsonElement maxResultsElement = object.get(PROP_MAXRESULTS);
        if (checkNotNull(maxResultsElement)) {
            int mr = maxResultsElement.getAsInt();
            bean.setMaxResults(mr);
        }

        JsonElement commentsElement = object.get(PROP_COMMENTS);
        if (checkNotNull(commentsElement)) {
            List<JsonObject> list = GsonParserUtil.parseJsonArray(commentsElement.getAsJsonArray());
            List<CommentBean> comments = CommentParser.parse(list);
            bean.setComments(comments);
        }
        return bean;
    }

}
