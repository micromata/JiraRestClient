package de.micromata.jira.rest.util;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import de.micromata.jira.rest.jql.JqlSearchBean;

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

    public static URI buildSearchURI(URI baseUri, JqlSearchBean jsb) {
        String jql = jsb.toString();
        UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
        path.queryParam(JQL, jql);
        if (jsb.getFields().isEmpty() == false) {
            path.queryParam(FIELDS, buildFieldParameter(jsb.getFields()));
        }
        return path.build();
    }
    
    public static URI buildExtendedSearchURI(URI baseUri, JqlSearchBean jsb) {
    	String jql = jsb.toString();
    	int startAt = jsb.getStartAt();
    	int maxResults = jsb.getMaxResult();
    	
    	UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
    	path.queryParam(JQL, jql);
    	path.queryParam(START_AT, startAt);
    	path.queryParam(MAX_RESULTS, maxResults);
    	if(jsb.isFieldAll()) {
    		path.queryParam(FIELDS, FIELDS_ALL);
    	} else if(jsb.isFieldNavigable()) {
    		path.queryParam(FIELDS, FIELDS_NAVIGABLE);
    	} else if (!jsb.getFields().isEmpty()) {
            path.queryParam(FIELDS, buildFieldParameter(jsb.getFields()));
        }
    	return path.build();
    }

    private static <E> String buildFieldParameter(List<E> fieldNames) {
        StringBuilder sb = new StringBuilder();

        Iterator<E> iterator = fieldNames.iterator();
        sb.append(iterator.next());
        while (iterator.hasNext()) {
            sb.append(",");
            sb.append(iterator.next());
        }
//        sb.append(fieldNames.get(0));
//        for (int i = 1; i < fieldNames.size(); i++) {
//            sb.append(",");
//            sb.append(fieldNames.get(i));
//        }
        return sb.toString();


    }


}
