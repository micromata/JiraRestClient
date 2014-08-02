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
import de.micromata.jira.rest.core.domain.UserBean;
import de.micromata.jira.rest.core.domain.VisibilityBean;
import de.micromata.jira.rest.core.util.DateParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class CommentParser extends BaseParser {

    public static CommentBean parse(JsonObject object) {
        CommentBean bean = new CommentBean();
        parseBaseProperties(bean, object);

        JsonElement bodyElement = object.get(PROP_BODY);
        if (checkNotNull(bodyElement)) {
            String body = bodyElement.getAsString();
            bean.setBody(body);
        }

        JsonElement authorElement = object.get(ELEM_AUTHOR);
        if (checkNotNull(authorElement)) {
            UserBean au = UserParser.parse(authorElement.getAsJsonObject());
            bean.setAuthor(au);
        }

        JsonElement updateAuthorElement = object.get(ELEM_UPDATE_AUTHOR);
        if (checkNotNull(updateAuthorElement)) {
            UserBean uau = UserParser.parse(updateAuthorElement.getAsJsonObject());
            bean.setUpdateAuthor(uau);
        }

        JsonElement createdElement = object.get(PROP_CREATED);
        if (checkNotNull(createdElement)) {
            Date created = DateParser.parseDateFormat(createdElement.getAsString(), DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ);
            bean.setCreated(created);
        }

        JsonElement updatedElement = object.get(PROP_UPDATED);
        if (checkNotNull(updatedElement)) {
            Date updated = DateParser.parseDateFormat(updatedElement.getAsString(), DateParser.Format.YYYY_MM_DD_T_HH_MM_SS_SSSZ);
            bean.setUpdated(updated);
        }

        JsonElement visibilityElement = object.get(ELEM_VISIBILITY);
        if (checkNotNull(visibilityElement)) {
            VisibilityBean visibilityBean = VisibilityParser.parse(visibilityElement.getAsJsonObject());
            bean.setVisibility(visibilityBean);
        }
        return bean;
    }

    public static List<CommentBean> parse(List<JsonObject> objects) {
        List<CommentBean> list = new ArrayList<CommentBean>();
        for (JsonObject o : objects) {
            CommentBean bean = parse(o);
            list.add(bean);
        }
        return list;
    }
}
