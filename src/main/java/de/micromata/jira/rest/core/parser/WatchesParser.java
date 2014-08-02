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
import de.micromata.jira.rest.core.domain.WatchesBean;
import de.micromata.jira.rest.core.util.JsonElementUtil;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class WatchesParser extends BaseParser {

    public static WatchesBean parse(JsonObject object) {
        WatchesBean bean = new WatchesBean();
        parseBaseProperties(bean, object);
        JsonElement watchCountElement = object.get(PROP_WATCH_COUNT);
        if (JsonElementUtil.checkNotNull(watchCountElement) == true) {
            int wc = watchCountElement.getAsInt();
            bean.setWatchCount(wc);
        }

        JsonElement isWatchingElement = object.get(PROP_IS_WATCHING);
        if (JsonElementUtil.checkNotNull(isWatchingElement) == true) {
            boolean iw = isWatchingElement.getAsBoolean();
            bean.setWatching(iw);
        }
        return bean;
    }
}
