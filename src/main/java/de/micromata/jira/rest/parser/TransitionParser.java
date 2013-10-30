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

package de.micromata.jira.rest.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.TransitionBean;
import de.micromata.jira.rest.util.URIParser;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class TransitionParser extends BaseParser {

    public static TransitionBean parse(JsonObject object) {
        TransitionBean bean = new TransitionBean();
        parseBaseProperties(bean, object);

        JsonElement descriptionElement = object.get(PROP_DESCRIPTION);
        if (checkNotNull(descriptionElement)) {
            bean.setDescription(descriptionElement.getAsString());
        }
        JsonElement iconUrlElement = object.get(PROP_ICONURL);
        if (checkNotNull(iconUrlElement)) {
            String uri = iconUrlElement.getAsString();
            URI iconUrl = URIParser.parseStringToURI(uri);
            bean.setIconUrl(iconUrl);
        }
        JsonElement toElement = object.get(PROP_TO);
        if (checkNotNull(toElement)) {
            JsonObject toObject = toElement.getAsJsonObject();
            TransitionBean toBean = parse(toObject);
            bean.setTo(toBean);
        }
//		JsonElement fieldsElement = object.get(ELEM_FIELDS);
//		if(checkNotNull(fieldsElement)) {
//			JsonObject fieldsObject = fieldsElement.getAsJsonObject();
//			JsonElement assigneeElement = fieldsObject.get(ELEM_ASSIGNEE);
//			if(checkNotNull(assigneeElement)) {
//				JsonObject assigneeObject = assigneeElement.getAsJsonObject();
//				JsonElement requiredElement = assigneeObject.get(PROP_REQUIRED);
//				if(checkNotNull(requiredElement)) {
//					boolean assigneeRequired = requiredElement.getAsBoolean();
//					bean.setAssigneeRequired(assigneeRequired);
//				}
//			}
//		}

        return bean;
    }

    public static Map<Long, TransitionBean> parse(List<JsonObject> list) {
        Map<Long, TransitionBean> transitions = new HashMap<Long, TransitionBean>();

        for (JsonObject o : list) {
            TransitionBean bean = parse(o);
            transitions.put(Long.valueOf(bean.getId()), bean);
        }

        return transitions;
    }
}
