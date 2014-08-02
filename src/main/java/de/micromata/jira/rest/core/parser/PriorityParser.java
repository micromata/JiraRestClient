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
import de.micromata.jira.rest.core.domain.PriorityBean;
import de.micromata.jira.rest.core.util.JsonElementUtil;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class PriorityParser extends BaseParser {

    public static PriorityBean parse(JsonObject object) {
        PriorityBean bean = new PriorityBean();
        parseBaseProperties(bean, object);

        JsonElement iconUrlElement = object.get(PROP_ICONURL);
        if (JsonElementUtil.checkNotNull(iconUrlElement)) {
            String url = iconUrlElement.getAsString();
            URI uri = URIParser.parseStringToURI(url);
            bean.setIconUrl(uri);
        }
        return bean;
    }

    public static List<PriorityBean> parse(List<JsonObject> jsonObjectList) {
        List<PriorityBean> retval = new ArrayList<PriorityBean>();
        for (JsonObject jsonObject : jsonObjectList) {
            PriorityBean parse = parse(jsonObject);
            retval.add(parse);
        }
        return retval;
    }

}
