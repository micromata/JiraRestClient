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

import de.micromata.jira.rest.domain.TransitionBean;
import de.micromata.jira.rest.util.RestException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TestIssueTransition {

    private static JiraRestClient jiraRestClient;

    private static RestWrapper restWrapper;

    private static final String ISSUE_KEY = "DEMO-1";

    private static Map<Integer, TransitionBean> currentIssueTransitions;

    public static void main(String[] args) throws URISyntaxException, RestException {
        URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";

        jiraRestClient = new JiraRestClient();
        jiraRestClient.connect(uri, username, password);
        restWrapper = new RestWrapperImpl();

        initAvailableTransitionStates();

        testTransitionCloseToReopen();
//        testTransitionOpenToClose();
//        testTransitionOpenToStart();
//        testTransitionStartToStop();
//        testTransitionOpenToResolve();
//        testTransitionResolveToClose();


        showAvailableTransitionStates();
    }

    public static void initAvailableTransitionStates() throws RestException {
        currentIssueTransitions = restWrapper.getIssueTransitionsByKey(jiraRestClient, ISSUE_KEY);

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Mögliche Transitions für das Issue: " + ISSUE_KEY);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (int id : currentIssueTransitions.keySet()) {
            TransitionBean tb = currentIssueTransitions.get(id);
            System.out.println("Transition ID: " + id + " Name: " + tb.getName() + " Assignee: " + tb.isAssigneeRequired());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public static void showAvailableTransitionStates() throws RestException {
        currentIssueTransitions = restWrapper.getIssueTransitionsByKey(jiraRestClient, ISSUE_KEY);

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Mögliche Transitions für den nächsten Test:\n");
        for (int id : currentIssueTransitions.keySet()) {
            TransitionBean tb = currentIssueTransitions.get(id);
            System.out.println("Transition ID: " + id + " Name: " + tb.getName() + " Assignee: " + tb.isAssigneeRequired());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public static void testTransitionCloseToReopen() throws RestException {
        int transitionId = 3;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") reopened: " + update);
    }

    public static void testTransitionOpenToClose() throws RestException {
        int transitionId = 2;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") closed: " + update);
    }

    public static void testTransitionOpenToStart() throws RestException {
        int transitionId = 4;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") started: " + update);
    }

    public static void testTransitionStartToStop() throws RestException {
        int transitionId = 301;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") stoped: " + update);
    }

    public static void testTransitionOpenToResolve() throws RestException {
        int transitionId = 5;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") resolved: " + update);
    }

    public static void testTransitionResolveToClose() throws RestException {
        int transitionId = 701;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") closed: " + update);
    }
}
