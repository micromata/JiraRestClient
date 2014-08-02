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
import de.micromata.jira.rest.core.domain.VisibilityBean;
import de.micromata.jira.rest.core.util.JsonConstants;
import de.micromata.jira.rest.core.util.JsonElementUtil;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class VisibilityParser implements JsonConstants {

    public static VisibilityBean parse(JsonObject obj) {
        VisibilityBean bean = new VisibilityBean();
        JsonElement typeElement = obj.get(PROP_TYPE);
        if (JsonElementUtil.checkNotNull(typeElement) == true) {
            String ty = typeElement.getAsString();
            bean.setType(ty);
        }

        JsonElement valueElement = obj.get(PROP_VALUE);
        if (JsonElementUtil.checkNotNull(valueElement) == true) {
            String va = valueElement.getAsString();
            bean.setValue(va);
        }
        return bean;
    }

}
