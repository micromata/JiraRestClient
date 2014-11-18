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
import de.micromata.jira.rest.core.domain.UserBean;

import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class UserParser extends BaseParser {


    public static UserBean parse(JsonObject object) {
        UserBean bean = new UserBean();
        parseBaseProperties(bean, object);

        JsonElement keyElement = object.get(PROP_KEY);
        if(checkNotNull(keyElement)){
            String key = keyElement.getAsString();
            bean.setKey(key);
        }

        JsonElement activeElement = object.get(PROP_ACTIVE);
        if (checkNotNull(activeElement)) {
            boolean active = activeElement.getAsBoolean();
            bean.setActive(active);
        }

        JsonElement displaynameElement = object.get(PROP_DISPLAYNAME);
        if (checkNotNull(displaynameElement)) {
            String displayName = displaynameElement.getAsString();
            bean.setDisplayName(displayName);
        }

        JsonElement avatarUrlsElement = object.get(ELEM_AVATAR_URLS);
        if (checkNotNull(avatarUrlsElement)) {
            JsonObject avatarUrls = avatarUrlsElement.getAsJsonObject();
            AvatarURLBean avatarURLBean = AvatarURLParser.parse(avatarUrls);
            bean.setAvatarUrl(avatarURLBean);
        }

        JsonElement emailAdressElement = object.get(PROP_EMAIL_ADRESS);
        if (checkNotNull(emailAdressElement)) {
            String ea = emailAdressElement.getAsString();
            bean.setEmailAddress(ea);
        }
        return bean;
    }


    public static List<UserBean> parse(List<JsonObject> objects) {
        List<UserBean> retval = new ArrayList<UserBean>();
        for (JsonObject object : objects) {
            UserBean connectUserBean = parse(object);
            retval.add(connectUserBean);
        }
        return retval;
    }
}
