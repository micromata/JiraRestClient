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
import de.micromata.jira.rest.core.domain.AggregateprogressBean;
import de.micromata.jira.rest.core.util.JsonConstants;

import static de.micromata.jira.rest.core.util.JsonElementUtil.checkNotNull;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class AggregateprogressParser implements JsonConstants {

    public static AggregateprogressBean parse(JsonObject object) {
        AggregateprogressBean bean = new AggregateprogressBean();
        JsonElement progressElement = object.get(ELEM_PROGRESS);
        if (checkNotNull(progressElement)) {
            int pr = progressElement.getAsInt();
            bean.setProgress(pr);
        }
        JsonElement totalElement = object.get(PROP_TOTAL);
        if (checkNotNull(totalElement)) {
            int to = totalElement.getAsInt();
            bean.setTotal(to);
        }
        return bean;
    }
}
