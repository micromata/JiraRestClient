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
import de.micromata.jira.rest.core.domain.AvatarURLBean;
import de.micromata.jira.rest.core.domain.BasicProjectBean;

import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class BasicProjectParser extends BaseParser {


    public static void parseBasicProject(BasicProjectBean bean, JsonObject object) {
        parseBaseProperties(bean, object);

        JsonElement keyElement = object.get(PROP_KEY);
        if (checkNotNull(keyElement)) {
            String key = keyElement.getAsString();
            bean.setKey(key);
        }

        JsonElement avatarUrlsElement = object.get(ELEM_AVATAR_URLS);
        if (checkNotNull(avatarUrlsElement)) {
            AvatarURLBean parse = AvatarURLParser.parse(avatarUrlsElement.getAsJsonObject());
            bean.setAvatarURLs(parse);
        }
    }

    public static List<BasicProjectBean> parseBasicProject(List<JsonObject> objects) {
        List<BasicProjectBean> retval = new ArrayList<BasicProjectBean>();
        for (JsonObject jsonObject : objects) {
            BasicProjectBean bean = new BasicProjectBean();
            parseBasicProject(bean, jsonObject);
            retval.add(bean);
        }
        return retval;
    }
}
