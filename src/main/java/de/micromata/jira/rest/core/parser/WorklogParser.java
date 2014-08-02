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
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.domain.VisibilityBean;
import de.micromata.jira.rest.core.domain.WorklogBean;
import de.micromata.jira.rest.core.util.DateParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class WorklogParser extends BaseParser {

    private static WorklogBean parse(JsonObject object) {
        WorklogBean bean = new WorklogBean();
        parseBaseProperties(bean, object);

        JsonElement authorElement = object.get(ELEM_AUTHOR);
        if (checkNotNull(authorElement)) {
            JsonObject obj = authorElement.getAsJsonObject();
            UserBean author = UserParser.parse(obj);
            bean.setAuthor(author);
        }

        JsonElement updateAuthorElement = object.get(ELEM_UPDATE_AUTHOR);
        if (checkNotNull(updateAuthorElement)) {
            JsonObject updateAuthorObj = updateAuthorElement.getAsJsonObject();
            UserBean updateAuthor = UserParser.parse(updateAuthorObj);
            bean.setUpdateAuthor(updateAuthor);
        }

        JsonElement commentElement = object.get(PROP_COMMENT);
        if (checkNotNull(commentElement)) {
            String com = commentElement.getAsString();
            bean.setComment(com);
        }

        JsonElement timeSpentElement = object.get(PROP_TIMESPENT);
        if (checkNotNull(timeSpentElement)) {
            String ts = timeSpentElement.getAsString();
            bean.setTimeSpent(ts);
        }

        JsonElement startedElement = object.get(PROP_STARTED);
        if (checkNotNull(startedElement)) {
            String d = startedElement.getAsString();
            Date date = DateParser.parseDateFormat(d, DateParser.Format.YYYY_MM_DD);
            bean.setStarted(date);
        }
        JsonElement timeSpentSecondsElement = object.get(PROP_TIME_SPENT_SECONDS);
        if (checkNotNull(timeSpentSecondsElement)) {
            long tss = timeSpentSecondsElement.getAsLong();
            bean.setTimeSpentSeconds(tss);
        }

        JsonElement visibilityElement = object.get(ELEM_VISIBILITY);
        if (checkNotNull(visibilityElement)) {
            JsonObject visibilityObj = visibilityElement.getAsJsonObject();
            VisibilityBean visibility = VisibilityParser.parse(visibilityObj);
            bean.setVisibility(visibility);
        }

        return bean;
    }

    public static List<WorklogBean> parse(List<JsonObject> objects) {
        List<WorklogBean> worklogs = new ArrayList<WorklogBean>();
        for (JsonObject o : objects) {
            WorklogBean web = parse(o);
            worklogs.add(web);
        }

        return worklogs;
    }


}
