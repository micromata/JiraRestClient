package de.micromata.jira.rest.util;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
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

    public static URI buildSearchURI(URI baseUri) {
    	return UriBuilder.fromUri(baseUri).path(SEARCH).build();
    }
}
