package de.micromata.jira.rest.util;

import de.micromata.jira.rest.jql.JqlBean;
import de.micromata.jira.rest.jql.JqlHelper;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

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

    public static URI buildSearchURI(URI baseUri, JqlBean jqlBean) {
        String jql = JqlHelper.buildJqlString(jqlBean);
        UriBuilder path = UriBuilder.fromUri(baseUri).path(SEARCH);
        path.queryParam(JQL, jql);
        if (jqlBean.getFields().isEmpty() == false) {
            path.queryParam(FIELDS, buildFieldParameter(jqlBean.getFields()));
        }
        return path.build();
    }

    private static String buildFieldParameter(List<String> fieldNames) {
        StringBuilder sb = new StringBuilder();

        Iterator<String> iterator = fieldNames.iterator();
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
