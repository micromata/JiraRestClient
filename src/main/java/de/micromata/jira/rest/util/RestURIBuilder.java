/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
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

    public static URI buildCommentByIssueURI(URI baseURI, String issueKey) {
    	return UriBuilder.fromUri(baseURI).path(ISSUE).path(issueKey).path(COMMENT).build();
    }

    public static URI buildIssueTypeURI(URI baseURI){
        return UriBuilder.fromUri(baseURI).path(ISSUETPYES).build();
    }

    public static URI buildStateURI(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(STATUS).build();
    }

    public static URI buildPrioritieURI(URI baseUri){
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
}
