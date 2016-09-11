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

package de.micromata.jira.rest.core.misc;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public interface RestPathConstants {

    // Common Stuff for Jersey Client

    String AUTHORIZATION = "Authorization";

    String BASIC = "Basic";

    // REST Paths
    String BASE_REST_PATH = "/rest/api/2";

    String PROJECT = "/project";

    String USER = "/user";

    String SEARCH = "/search";

    String ISSUE = "/issue";

    String COMMENT = "/comment";

    String VERSIONS = "/versions";

    String COMPONENTS = "/components";

    String ISSUETPYES = "/issuetype";

    String STATUS = "/status";

    String PRIORITY = "/priority";

    String TRANSITIONS = "/transitions";

    String WORKLOG = "/worklog";

    String ATTACHMENTS = "/attachments";

    String ATTACHMENT = "/attachment";

    String ASSIGNABLE = "/assignable";

    String FILTER = "/filter";

    String FAVORITE = "/favourite";

    String FIELD = "/field";

    String META = "/meta";

    String CREATEMETA = "/createmeta";

    String MYPERMISSIONS = "/mypermissions";

    String CONFIGURATION = "/configuration";
}
