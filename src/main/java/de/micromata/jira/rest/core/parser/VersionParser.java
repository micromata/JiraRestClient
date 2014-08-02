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
import de.micromata.jira.rest.core.domain.VersionBean;
import de.micromata.jira.rest.core.util.DateParser;
import de.micromata.jira.rest.core.util.JsonElementUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class VersionParser extends BaseParser {

    public static VersionBean parse(JsonObject object) {
        VersionBean bean = new VersionBean();
        parseBaseProperties(bean, object);
        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (JsonElementUtil.checkNotNull(descriptionElement) == true) {
            String description = descriptionElement.getAsString();
            bean.setDescription(description);
        }

        JsonElement releaseDateElement = object.get(PROP_RELEASEDATE);
        if (JsonElementUtil.checkNotNull(releaseDateElement) == true) {
            String relesaseDateString = releaseDateElement.getAsString();
            Date releaseDate = DateParser.parseDateFormat(relesaseDateString, DateParser.Format.YYYY_MM_DD);
            bean.setReleaseDate(releaseDate);
        }

        JsonElement archivedElement = object.get(PROP_ARCHIVED);
        if (JsonElementUtil.checkNotNull(archivedElement) == true) {
            boolean archived = archivedElement.getAsBoolean();
            bean.setArchived(archived);
        }

        JsonElement releasedElement = object.get(PROP_RELEASED);
        if (JsonElementUtil.checkNotNull(releasedElement) == true) {
            boolean released = releasedElement.getAsBoolean();
            bean.setReleased(released);
        }

        JsonElement overdueElement = object.get(PROP_OVERDUE);
        if (JsonElementUtil.checkNotNull(overdueElement) == true) {
            boolean overdue = overdueElement.getAsBoolean();
            bean.setOverdue(overdue);
        }

        JsonElement userReleaseDateElement = object.get(PROP_USER_RELEASE_DATE);
        if (JsonElementUtil.checkNotNull(userReleaseDateElement) == true) {
            Date date = DateParser.parseDateFormat(userReleaseDateElement.getAsString(), DateParser.Format.DD_MMM_YY);
            bean.setUserReleaseDate(date);
        }
        return bean;
    }

    public static List<VersionBean> parse(List<JsonObject> objects) {
        List<VersionBean> retval = new ArrayList<VersionBean>();
        for (JsonObject object : objects) {
            VersionBean versionBean = parse(object);
            retval.add(versionBean);
        }
        return retval;
    }
}

