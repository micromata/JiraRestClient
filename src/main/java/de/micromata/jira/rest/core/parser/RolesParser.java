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
import de.micromata.jira.rest.core.util.ERoles;
import de.micromata.jira.rest.core.util.JsonConstants;
import de.micromata.jira.rest.core.util.URIParser;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class RolesParser implements JsonConstants {

    public static Map<ERoles, URI> parse(JsonObject object) {
        Map<ERoles, URI> roles = new HashMap<ERoles, URI>();

        for (ERoles r : ERoles.values()) {
            JsonElement element = object.get(r.getName());
            if (element != null) {
                String string = element.getAsString();
                URI uri = URIParser.parseStringToURI(string);
                roles.put(r, uri);
            }
        }
        return roles;
    }

}
