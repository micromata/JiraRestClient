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
import de.micromata.jira.rest.core.domain.ResolutionBean;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class ResolutionParser extends BaseParser {

    public static ResolutionBean parse(JsonObject object) {
        ResolutionBean bean = new ResolutionBean();
        parseBaseProperties(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (checkNotNull(descriptionElement)) {
            String des = descriptionElement.getAsString();
            bean.setDescription(des);
        }

        JsonElement iconURLElement = object.get(PROP_ICONURL);
        if (checkNotNull(iconURLElement)) {
            String iurl = iconURLElement.getAsString();
            URI uri = URIParser.parseStringToURI(iurl);
            bean.setIconUrl(uri);
        }
        return bean;
    }

}
