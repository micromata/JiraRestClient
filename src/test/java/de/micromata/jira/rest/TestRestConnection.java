package de.micromata.jira.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.jira.rest.domain.BasicProjectBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.domain.ComponentBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.domain.JqlSearchResultBean;
import de.micromata.jira.rest.domain.ProjectBean;
import de.micromata.jira.rest.domain.VersionBean;
import de.micromata.jira.rest.jql.EField;
import de.micromata.jira.rest.jql.EKeyword;
import de.micromata.jira.rest.jql.EOperator;
import de.micromata.jira.rest.jql.JqlClause;
import de.micromata.jira.rest.jql.JqlConstants;
import de.micromata.jira.rest.jql.JqlSearchBean;
import de.micromata.jira.rest.util.RestConstants;
import de.micromata.jira.rest.util.RestException;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 17:17
 */

public class TestRestConnection implements JqlConstants, RestConstants {

	private JiraRestClient jiraRestClient;
	
	private RestWrapper restWrapper;
	
	public TestRestConnection() {
		String uri = "http://localhost:2990/jira";
        String username = "admin";
        String password = "admin";

        jiraRestClient = new JiraRestClient(uri, username, password);
        restWrapper = new RestWrapperImpl();
	}
	
    public static void main(String[] args) throws URISyntaxException, RestException {
        TestRestConnection testRestConnection = new TestRestConnection();
        testRestConnection.testRestConnection();
//        testRestConnection.testGetAllProjects();
//        testRestConnection.testGetProjectByKey();
//        testRestConnection.testGetProjectVersions();
//        testRestConnection.testGetProjectComponents();
//        testRestConnection.testGetIssuesForProject();
        testRestConnection.testSearchIssuesForProject();
//        testRestConnection.testExtendedSearchIssuesForProject();
//        testRestConnection.testGetIssueByKey();
//        testRestConnection.testGetCommentsByIssue();
//        testRestConnection.testGetIssueTypes();
    }

    public void testRestConnection() throws URISyntaxException {
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";
        boolean test = restWrapper.testRestConnection(uri, username, password);

        System.out.println("testRestConnection: " + test);
    }

    public void testGetAllProjects() throws URISyntaxException, RestException {
        List<BasicProjectBean> allProjects = restWrapper.getAllProjects(jiraRestClient);
        System.out.println("testGetProject: " + !allProjects.isEmpty());
    }
    
    public void testGetProjectByKey() throws RestException {
    	ProjectBean projectByKey = restWrapper.getProjectByKey(jiraRestClient, "DEMO");
    	
    	System.out.println("testGetProjectByKey: " + projectByKey.getName().equals("DEMO"));
    }

    public void testGetProjectVersions() throws RestException {
    	List<VersionBean> versions = restWrapper.getProjectVersions(jiraRestClient, "DEMO");
    	
    	System.out.println("testGetProjectVersions: " + !versions.isEmpty());
    }
    
    public void testGetProjectComponents() throws RestException {
    	List<ComponentBean> components = restWrapper.getProjectComponents(jiraRestClient, "DEMO");
    	
    	System.out.println("testGetProjectComponents: " + !components.isEmpty());
    }

    public void testGetIssuesForProject() throws RestException {
        JqlSearchResultBean resultBean = restWrapper.getIssuesForProject(jiraRestClient, "DEMO");

        System.out.println("testGetIssueForProject: " + !resultBean.getIssueBeans().isEmpty());
    }
    
    public void testSearchIssuesForProject() throws RestException {
    	JqlSearchBean jsb = new JqlSearchBean();
    	List<JqlClause> clauses = new ArrayList<JqlClause>();
    	clauses.add(new JqlClause(EField.PROJECT, EOperator.EQUALS, "DEMO", EKeyword.AND));
    	clauses.add(new JqlClause(EField.STATUS, EOperator.EQUALS, STATUS_OPEN, EKeyword.AND));
    	clauses.add(new JqlClause(EField.TYPE, EOperator.EQUALS, ISSUETYPE_BUG, null));
    	jsb.setClauses(clauses);
    	jsb.setFieldAll(true);
        jsb.setStartAt(0);
        jsb.setMaxResult(10);

        JqlSearchResultBean jqlSearchResultBean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);

        System.out.println("testSearchIssuesForProject: " + !jqlSearchResultBean.getIssueBeans().isEmpty());
    }
    
    public void testExtendedSearchIssuesForProject() throws RestException {
    	JqlSearchBean jsb = new JqlSearchBean();
    	jsb.getClauses().add(new JqlClause(EField.PROJECT, EOperator.EQUALS, "DEMO", null));
//    	jsb.getClauses().add(new JqlClause(EField.STATUS, EOperator.EQUALS, STATUS_OPEN, EKeyword.AND));
//    	jsb.getClauses().add(new JqlClause(EField.TYPE, EOperator.EQUALS, ISSUETYPE_BUG, null));
    	jsb.setStartAt(1);
    	jsb.setMaxResult(2);
    	jsb.setFieldAll(true);

        JqlSearchResultBean jqlSearchResultBean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
    	
    	System.out.println("testExtendedSearchIssuesForProject: " + !jqlSearchResultBean.getIssueBeans().isEmpty());
    }
    
    public void testGetIssueByKey() throws RestException {
    	String issueKey = "DEMO-1";
    	IssueBean issueBean = restWrapper.getIssueByKey(jiraRestClient, issueKey);
    	
    	System.out.println("testGetIssueByKey: " + issueBean.getIssueType().getName().equals("Bug"));
    }

    public void testGetCommentsByIssue() throws RestException {
    	String issueKey = "DEMO-1";
    	CommentSummaryBean commentSummaryBean = restWrapper.getCommentsByIssue(jiraRestClient, issueKey);
    	
    	System.out.println("testGetCommentByIssue: " + !commentSummaryBean.getComments().isEmpty());
    }

    public void testGetIssueTypes() throws RestException {
        List<IssueTypeBean> issueTypes = restWrapper.getIssueTypes(jiraRestClient);
        System.out.println("testGetIssueTypes: " + !issueTypes.isEmpty());
    }
    
    public void testJqlSearchString() throws RestException {
    	JqlSearchBean jsb = new JqlSearchBean();
    	jsb.getClauses().add(new JqlClause(EField.PROJECT, EOperator.EQUALS, "DEMO", null));
//    	jsb.getClauses().add(new JqlClause(EField.STATUS, EOperator.EQUALS, STATUS_OPEN, EKeyword.AND));
//    	jsb.getClauses().add(new JqlClause(EField.TYPE, EOperator.EQUALS, ISSUETYPE_BUG, null));
    	jsb.setStartAt(1);
    	jsb.setMaxResult(2);
    	jsb.setFieldAll(true);

        JqlSearchResultBean jqlSearchResultBean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
    	
    	System.out.println("testExtendedSearchIssuesForProject: " + !jqlSearchResultBean.getIssueBeans().isEmpty());
    }
}
