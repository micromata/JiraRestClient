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

package de.micromata.jira.rest;

import de.micromata.jira.rest.domain.*;
import de.micromata.jira.rest.jql.*;
import de.micromata.jira.rest.util.RestConstants;
import de.micromata.jira.rest.util.RestException;
import junit.framework.Assert;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 17:17
 */

public class TestRestConnection implements JqlConstants, RestConstants {

    private JiraRestClient jiraRestClient;
    private RestWrapper restWrapper;


    public static void main(String[] args) throws URISyntaxException, RestException, IOException {
        new TestRestConnection().run();
    }

    public void run() throws URISyntaxException, RestException, IOException {
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";
        restWrapper = new RestWrapperImpl();
        jiraRestClient = new JiraRestClient();
        int status = jiraRestClient.connect(uri, username, password);
        if (status != HttpURLConnection.HTTP_OK) {
            System.out.println("FehlerStatus: " + status);
        }
//        testRestConnection();
//        testGetAllProjects();
//        testGetProjectByKey();
//        testGetProjectVersions();
//        testGetProjectComponents();
//        testGetIssuesForProject();
//        testSearchIssuesForProject();
//        testExtendedSearchIssuesForProject();
//        testGetIssueByKey();
//        testGetCommentsByIssue();
//        testGetIssueTypes();
        testGetIssueTransitionsByKey();
//        testUpdateIssueTransitionByKey();
//        testAggregateTimeOriginalEstimate();
//        testPutWorklogsInIssue();
//        testGetAttachment();
//        testGetPriorities();
    }


    public void testRestConnection() throws URISyntaxException, RestException {
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";
        boolean test = restWrapper.testRestConnection(uri, username, password);
        System.out.println("testRestConnection: " + test);
    }

    public void testGetAllProjects() throws URISyntaxException, RestException {
        List<BasicProjectBean> allProjects = restWrapper.getAllProjects(jiraRestClient);
        System.out.println("testGetAllProject: " + !allProjects.isEmpty());
    }

    public void testGetProjectByKey() throws RestException {
        ProjectBean projectByKey = restWrapper.getProjectByKey(jiraRestClient, "DEMO");

        System.out.println("testGetProjectByKey: " + projectByKey.getKey().equals("DEMO"));
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
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO")
                .or().addCondition(EField.STATUS, EOperator.EQUALS, STATUS_OPEN)
                .orderBy(SortOrder.ASC, EField.CREATED);
        jsb.setJql(jql);
        jsb.addField(EField.ALL);

        JqlSearchResultBean jqlSearchResultBean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);

        System.out.println("testSearchIssuesForProject: " + !jqlSearchResultBean.getIssueBeans().isEmpty());
    }

    public void testExtendedSearchIssuesForProject() throws RestException {
        JqlSearchBean jsb = new JqlSearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO").build();
        jsb.setJql(jql);
        jsb.setStartAt(1);
        jsb.setMaxResults(2);
        jsb.addField(EField.ISSUE_KEY, EField.STATUS, EField.DUE, EField.SUMMARY, EField.ISSUE_TYPE, EField.PRIORITY);

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

    public void testGetIssueTransitionsByKey() throws RestException {
        String issueKey = "DEMO-1";
        Map<Long, TransitionBean> issueTransitions = restWrapper.getIssueTransitionsByKey(jiraRestClient, issueKey);

        System.out.println("testGetIssueTransitions: " + !issueTransitions.isEmpty());
    }

    public void testUpdateIssueTransitionByKey() throws RestException {
        String issueKey = "DEMO-1";

        //Suche Issue-Status
        JqlSearchBean jsb = new JqlSearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO")
                .and().addCondition(EField.ISSUE_KEY, EOperator.EQUALS, issueKey).build();
        jsb.setJql(jql);
        jsb.addField(EField.STATUS);

        //aktueller Status vom Issue
        JqlSearchResultBean bean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
        String status = bean.getIssueBeans().iterator().next().getStatus().getName();
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Aktueller Status: " + status);

        //zufällige Auswahl einer möglichen Transition
        Map<Long, TransitionBean> availableIssueTransitions = restWrapper.getIssueTransitionsByKey(jiraRestClient, issueKey);

        System.out.println("Mögliche Transitions für das Issue: " + issueKey);
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Long id : availableIssueTransitions.keySet()) {
            TransitionBean tb = availableIssueTransitions.get(id);
            System.out.println("Transition ID: " + id + " Name: " + tb.getName());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");

        Object[] transitions = availableIssueTransitions.keySet().toArray();
        int choice = (int) (Math.random() * transitions.length);
        int transitionId = Integer.parseInt(transitions[choice].toString());
        String transitionName = availableIssueTransitions.get(transitionId).getName();
        System.out.println("Folgende Transition gewählt: ID=" + transitionId + " Name=" + transitionName);

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, issueKey, transitionId);

        //Status vom Issue nach Update
        bean = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
        status = bean.getIssueBeans().iterator().next().getStatus().getName();
        System.out.println("Status nach Update: " + status);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("testUpdateIssueTransitionByKey: " + update);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public void testAggregateTimeOriginalEstimate() throws RestException {
        //Die Gesamt geschätzte Zeit für einen Vorgang

        JqlSearchBean jsb = new JqlSearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO").and().addCondition(EField.ISSUE_KEY, EOperator.EQUALS, "DEMO-4").build();
        jsb.setJql(jql);
        jsb.addField(EField.ALL);

        JqlSearchResultBean jsrb = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
        List<IssueBean> list = jsrb.getIssueBeans();
        IssueBean issueBean = list.get(0);
        Long aggregateTimeOriginalEstimate = issueBean.getAggregateTimeOriginalEstimate();
        System.out.println("Geschätzte Zeit in Sekunden: " + aggregateTimeOriginalEstimate);

        //Umrechnung 5 Tage Woche und 8 Std am Tag
        long weekInSec = 5 * 8 * 60 * 60;
        long dayInSec = 8 * 60 * 60;
        long hourInSec = 60 * 60;

        long remainingDays = aggregateTimeOriginalEstimate % weekInSec;
        long remainingHours = remainingDays % dayInSec;

        long w = aggregateTimeOriginalEstimate / weekInSec;
        long d = remainingDays / dayInSec;
        long h = remainingHours / hourInSec;
        System.out.println("Geschätze Zeit: " + w + "w " + d + "d " + h + "h");

        System.out.println("testAggregateTimeOriginalEstimate: " + (aggregateTimeOriginalEstimate != null));
    }

    public void testPutWorklogsInIssue() throws RestException {

        //Setzt die protokollierte Zeit anhand der Worklogs zu einem Vorgang
        //dient zum Abgleich der Zeiten
        //Im folgenden Test wird aus dem Vorgang DEMO-4 in DEMO-6 ein Worklog von der dauer 3d eingefügt

        //schaut sich den zu aktualisierenden Vorgang an
        JqlSearchBean jsb = new JqlSearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO").and().addCondition(EField.ISSUE_KEY, EOperator.EQUALS, "DEMO-6").build();
        jsb.setJql(jql);
        jsb.addField(EField.ALL);

        JqlSearchResultBean jsrb = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
        List<IssueBean> toList = jsrb.getIssueBeans();
        IssueBean issueBean = toList.get(0);
        Long timeSpent = issueBean.getTimetracking().getTimeSpentSeconds();
        String timeSpentString = issueBean.getTimetracking().getTimeSpent();
        System.out.println("Protokollierte Zeit in Sekunden: " + timeSpent);
        System.out.println("Protokollierte Zeit: " + timeSpentString);

        //hole ein Worklog aus einem Vorgang
        jql = builder.addCondition(EField.PROJECT, EOperator.EQUALS, "DEMO").and().addCondition(EField.ISSUE_KEY, EOperator.EQUALS, "DEMO-4").build();
        jsb.setJql(jql);
        jsb.addField(EField.ALL);
        jsrb = restWrapper.searchIssuesForProject(jiraRestClient, jsb);
        List<IssueBean> fromList = jsrb.getIssueBeans();
        Iterator<WorklogBean> iterator = fromList.iterator().next().getWorklogs().getWorklogs().iterator();

        Assert.assertTrue("Keine Worklogs verfügbar, die Liste ist leer!", iterator.hasNext());

        WorklogBean worklogBean = iterator.next();
        boolean putWorklogsInIssue = restWrapper.transferWorklogInIssue(jiraRestClient, "DEMO-6", worklogBean);

        System.out.println("testPutWorklogsInIssue: " + putWorklogsInIssue);
    }

    public void testGetAttachment() throws RestException, URISyntaxException, IOException {
        URI uri = new URI("http://localhost:2990/jira/secure/attachment/10000/IssueTypes.png");
        InputStream inputStream = restWrapper.getAttachment(jiraRestClient, uri);
        byte[] bytes = IOUtils.toByteArray(inputStream);

        System.out.println("testGetAttachment: " + (bytes.length > 0));
    }

    private void testGetPriorities() throws RestException {
        List<PriorityBean> priorities = restWrapper.getPriorities(jiraRestClient);
        System.out.println("testGetPriorities: " + !priorities.isEmpty());
    }


}
