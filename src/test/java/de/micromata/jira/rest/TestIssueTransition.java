package de.micromata.jira.rest;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.*;

import de.micromata.jira.rest.domain.TransitionBean;
import de.micromata.jira.rest.util.RestException;

@Ignore
public class TestIssueTransition {

	private static JiraRestClient jiraRestClient;
	
	private static RestWrapper restWrapper;
	
	private static final String ISSUE_KEY = "DEMO-1";
	
	private static Map<Integer, TransitionBean> currentIssueTransitions;
	
	public static void main(String[] args) throws URISyntaxException, RestException {
		URI uri = new URI("http://localhost:2990/jira");
        String username = "admin";
        String password = "admin";

        jiraRestClient = new JiraRestClient(uri, username, password);
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
