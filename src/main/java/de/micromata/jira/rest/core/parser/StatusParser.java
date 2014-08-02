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
import de.micromata.jira.rest.core.domain.StatusBean;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class StatusParser extends BaseParser {

    public static StatusBean parse(JsonObject jsonObject) {
        StatusBean bean = new StatusBean();
        parseBaseProperties(bean, jsonObject);

        JsonElement descObject = jsonObject.get(PROP_DESCRIPTION);
        if (checkNotNull(descObject)) {
            bean.setDescription(descObject.getAsString());
        }

        JsonElement iconUrlObject = jsonObject.get(PROP_ICONURL);
        if (checkNotNull(iconUrlObject)) {
            String iconUrlString = iconUrlObject.getAsString();
            URI uri = URIParser.parseStringToURI(iconUrlString);
            bean.setIconUrl(uri);
        }
        return bean;
    }


    public static List<StatusBean> parse(List<JsonObject> jsonObjectList) {
        List<StatusBean> retval = new ArrayList<StatusBean>();
        for (JsonObject jsonObject : jsonObjectList) {
            StatusBean parse = parse(jsonObject);
            retval.add(parse);
        }
        return retval;
    }

}
