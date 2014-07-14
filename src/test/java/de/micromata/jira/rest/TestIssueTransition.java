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

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestIssueTransition extends BaseTest{


    private static final String ISSUE_KEY = "DEMO-1";

    public static void main(String[] args) throws URISyntaxException, RestException {
        new TestIssueTransition().run();
    }


    public void run() throws URISyntaxException, RestException {
        connect();
        initAvailableTransitionStates();

        testTransitionCloseToReopen();
//        testTransitionOpenToClose();
//        testTransitionOpenToStart();
//        testTransitionStartToStop();
//        testTransitionOpenToResolve();
//        testTransitionResolveToClose();
        showAvailableTransitionStates();
    }

    public void initAvailableTransitionStates() throws RestException {
        List<TransitionBean> issueTransitionsByKey = restWrapper.getIssueTransitionsByKey(jiraRestClient, ISSUE_KEY);

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Mögliche Transitions für das Issue: " + ISSUE_KEY);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (TransitionBean tb : issueTransitionsByKey) {
            System.out.println("Transition ID: " + tb.getId() + " Name: " + tb.getName() + " Assignee: " + tb.isAssigneeRequired());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public void showAvailableTransitionStates() throws RestException {
        List<TransitionBean> issueTransitionsByKey = restWrapper.getIssueTransitionsByKey(jiraRestClient, ISSUE_KEY);

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Mögliche Transitions für den nächsten Test:\n");
        for (TransitionBean tb : issueTransitionsByKey) {
            System.out.println("Transition ID: " + tb + " Name: " + tb.getName() + " Assignee: " + tb.isAssigneeRequired());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public void testTransitionCloseToReopen() throws RestException {
        int transitionId = 3;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") reopened: " + update);
    }

    public void testTransitionOpenToClose() throws RestException {
        int transitionId = 2;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") closed: " + update);
    }

    public void testTransitionOpenToStart() throws RestException {
        int transitionId = 4;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") started: " + update);
    }

    public void testTransitionStartToStop() throws RestException {
        int transitionId = 301;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") stoped: " + update);
    }

    public void testTransitionOpenToResolve() throws RestException {
        int transitionId = 5;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") resolved: " + update);
    }

    public void testTransitionResolveToClose() throws RestException {
        int transitionId = 701;

        boolean update = restWrapper.updateIssueTransitionByKey(jiraRestClient, ISSUE_KEY, transitionId);

        assertTrue(update);
        System.out.println("Transition (ID=" + transitionId + ") closed: " + update);
    }
}
