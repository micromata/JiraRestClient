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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.micromata.jira.rest.core.domain.ErrorBean;
import de.micromata.jira.rest.core.util.GsonParserUtil;
import de.micromata.jira.rest.core.util.JsonConstants;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class ErrorParser {

    public static ErrorBean parse(InputStream inputStream) throws UnsupportedEncodingException {
        ErrorBean errorBean = new ErrorBean();
        JsonObject object = GsonParserUtil.parseJsonObject(inputStream);
        JsonArray errorMessages = object.getAsJsonArray(JsonConstants.PROP_ERROR_MESSAGES);
        for (JsonElement jsonElement : errorMessages) {

        }
        JsonObject errors = object.getAsJsonObject(JsonConstants.PROP_ERRORS);
        Set<Map.Entry<String, JsonElement>> entries = errors.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String field = entry.getKey();
            String message = entry.getValue().getAsString();
            errorBean.getErrors().put(field, message);
        }
        return errorBean;
    }
}
