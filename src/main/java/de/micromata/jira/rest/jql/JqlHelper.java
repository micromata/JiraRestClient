package de.micromata.jira.rest.jql;


import org.apache.commons.lang3.StringUtils;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 14:24
 */
public class JqlHelper implements JqlConstants {


    public static String buildJqlString(JqlBean jqlBean) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.trimToNull(jqlBean.getProjectKey()) != null) {
            sb.append(PROJECT + " = " + jqlBean.getProjectKey() + " ");
        }
        if (StringUtils.trimToNull(jqlBean.getIssueType()) != null) {
            sb.append(AND + " ");
            sb.append(ISSUETYPE + " = " + jqlBean.getIssueType() + " ");
        }
        if (StringUtils.trimToNull(jqlBean.getStatus()) != null) {
            sb.append(AND + " ");
            sb.append(STATUS + " = " + jqlBean.getStatus());
        }
        
        return sb.toString();
    }
}
