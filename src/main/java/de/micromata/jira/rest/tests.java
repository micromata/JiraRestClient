package de.micromata.jira.rest;

import de.micromata.jira.rest.JiraRestClient;
import de.micromata.jira.rest.core.domain.IssueBean;
import de.micromata.jira.rest.core.domain.field.FieldBean;
import de.micromata.jira.rest.core.jql.JqlConstants;
import de.micromata.jira.rest.core.misc.RestPathConstants;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 
public class tests {
    static final String ISSUEKEY_TO_SEARCH = "AIT-1301";
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws  Exception {
		
		

		 ExecutorService executorService = Executors.newFixedThreadPool(100);
	    String testSystemUrl = "https://abnamroclearing.metis.prd:59509/jira";
	    String login = "n70761";
	    String password = "Lrmggvh65";
		 URI uri = new URI(testSystemUrl);  System.out.println("aaaaa");
		 JiraRestClient  jiraRestClient = new JiraRestClient(executorService);
	        jiraRestClient.connect(uri, login, password);
	        
	        Future<IssueBean> future = jiraRestClient.getIssueClient().getIssueByKey(ISSUEKEY_TO_SEARCH);
	        
	        
	        if(future.get().equals(null)) {
	        	System.out.println("sssss");
	        }
	        
	        System.out.println(future.toString());
	        System.out.println(future.get().getKey());
	        final IssueBean issueBean = future.get();
	        
	       
 
	}

}
