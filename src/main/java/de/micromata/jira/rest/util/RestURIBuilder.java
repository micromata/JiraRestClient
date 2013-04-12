package de.micromata.jira.rest.util;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.jql.JqlHelper;
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

    public static URI buildSearchURI(URI baseUri, JqlBean jqlBean) {
        String jql = JqlHelper.buildJqlString(jqlBean);
        UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
        path.queryParam(JQL, jql);
        if (jqlBean.getFields().isEmpty() == false) {
            path.queryParam(FIELDS, buildFieldParameter(jqlBean.getFields()));
        }
        return path.build();
    }
    
    public static URI buildExtendedSearchURI(URI baseUri, JqlSearchBean jqlBean) {
    	String jql = jqlBean.toString();
    	int startAt = jqlBean.getStartAt();
    	int maxResults = jqlBean.getMaxResult();
    	
    	UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
    	path.queryParam(JQL, jql);
    	path.queryParam(START_AT, startAt);
    	path.queryParam(MAX_RESULTS, maxResults);
    	if(jqlBean.isFieldAll()) {
    		path.queryParam(FIELDS, FIELDS_ALL);
    	} else if(jqlBean.isFieldNavigable()) {
    		path.queryParam(FIELDS, FIELDS_NAVIGABLE);
    	} else if (!jqlBean.getFields().isEmpty()) {
            path.queryParam(FIELDS, buildFieldParameter(jqlBean.getFields()));
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
