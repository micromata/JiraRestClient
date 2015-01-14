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

    public static final String AUTHORIZATION = "Authorization";

    public static final String BASIC = "Basic";

    // REST Paths
    public static final String BASE_REST_PATH = "/rest/api/2";

    public static final String PROJECT = "/project";

    public static final String USER = "/user";

    public static final String SEARCH = "/search";

    public static final String ISSUE = "/issue";

    public static final String COMMENT = "/comment";

    public static final String VERSIONS = "/versions";

    public static final String COMPONENTS = "/components";

    public static final String ISSUETPYES = "/issuetype";

    public static final String STATUS = "/status";

    public static final String PRIORITY = "/priority";

    public static final String TRANSITIONS = "/transitions";

    public static final String WORKLOG = "/worklog";

    public static final String ATTACHMENTS = "/attachments";

    public static final String ATTACHMENT = "/attachment";

    public static final String ASSIGNABLE = "/assignable";

    public static final String FILTER = "/filter";

    public static final String FAVORITE = "/favourite";

    public static final String FIELD = "/field";

    public static final String META = "/meta";
}
