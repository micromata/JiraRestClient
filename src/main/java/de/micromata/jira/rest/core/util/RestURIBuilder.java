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

package de.micromata.jira.rest.core.util;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class RestURIBuilder implements RestConstants {


    public static URI buildAllProjectURI(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(PROJECT).build();
    }

    public static URI buildProjectByKeyURI(URI baseURI, String projectKey) {
        return UriBuilder.fromUri(baseURI).path(PROJECT).path(projectKey).build();
    }

    public static URI buildProjectVersionsByKeyURI(URI baseURI, String projectKey) {
        return UriBuilder.fromUri(baseURI).path(PROJECT).path(projectKey).path(VERSIONS).build();
    }

    public static URI buildProjectComponentsByKeyURI(URI baseURI, String projectKey) {
        return UriBuilder.fromUri(baseURI).path(PROJECT).path(projectKey).path(COMPONENTS).build();
    }

    public static URI buildIssueByKeyURI(URI baseURI, String issueKey) {
        return UriBuilder.fromUri(baseURI).path(ISSUE).path(issueKey).build();
    }

    public static URI buildIssueByKeyURIWithExpandRenderedFields(URI baseURI, String issueKey) {
        UriBuilder path = UriBuilder.fromUri(baseURI).path(ISSUE).path(issueKey);
        path.queryParam(EXPAND, RENDERED_FIELD);
        return path.build();
    }

    public static URI buildCommentByIssueURI(URI baseURI, String issueKey) {
        return UriBuilder.fromUri(baseURI).path(ISSUE).path(issueKey).path(COMMENT).build();
    }

    public static URI buildIssueTypeURI(URI baseURI) {
        return UriBuilder.fromUri(baseURI).path(ISSUETPYES).build();
    }

    public static URI buildStateURI(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(STATUS).build();
    }

    public static URI buildPrioritieURI(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(PRIORITY).build();
    }

    public static URI buildSearchURI(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(SEARCH).build();
    }

    public static URI buildGetUserByUsername(URI baseUri, String username) {
        UriBuilder path = UriBuilder.fromUri(baseUri).path(USER);
        path.queryParam(PARAM_USERNAME, username);
        return path.build();
    }

    public static URI buildIssueTransitionsByKeyURI(URI baseUri, String issueKey) {
        return UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS).build();
    }

    public static URI buildIssueTransitionsByKeyExpandFields(URI baseUri, String issueKey) {
        UriBuilder path = UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(TRANSITIONS);
        path.queryParam(EXPAND, TRANSITIONS_FIELDS);
        return path.build();
    }

    public static URI buildIssueWorklogByKeyURI(URI baseUri, String issueKey) {
        return UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(WORKLOG).build();
    }

    public static URI buildIssueURI(URI baseURI) {
        return UriBuilder.fromUri(baseURI).path(ISSUE).build();
    }

    public static URI buildAddAttachmentURI(URI baseUri, String issueKey){
        return UriBuilder.fromUri(baseUri).path(ISSUE).path(issueKey).path(ATTACHMENTS).build();
    }
}
