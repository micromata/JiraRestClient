package de.micromata.jira.rest.util;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class RestURIBuilder implements RestConstants {

    public static URI buildAllProjectURI(URI baseUri){
        return UriBuilder.fromUri(baseUri).path(PROJECT).build();
    }

    public static URI buildProjectByKeyURI(URI baseURI, String projectKey){
        return UriBuilder.fromUri(baseURI).path(PROJECT).path(projectKey).build();
    }

    public static URI buildSearchURI(URI baseUri, String jql){
        UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
        path.queryParam(JQL, jql);
        return path.build();
    }


}
