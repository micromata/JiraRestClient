# JiraRestClient

A simple JAVA Client to access the [JIRA&copy; REST-API](https://docs.atlassian.com/jira/REST/cloud/).

## Usage 

Everything you need is a ExecutorService (java.util.concurrent.ExecutorService) for Thread-Pooling.

```java

  ExecutorService executorService = Executors.newFixedThreadPool(100);
  ProxyHost proxy = new ProxyHost("proxy", 3128);
  URI uri = new URI(URL_TO_JIRA_SERVER);
  JiraRestClient jiraRestClient = new JiraRestClient(executorService);
  jiraRestClient.connect(uri, USERNAME, PASSWORD);

```
After you create the JiraRestClient and connecting to your JIRA&copy;, you can get the specific client from the JiraRestClient.

* IssueClient - everything to issues. Include also Attachments, Transitions, Comments and Worklog
* ProjectClient - everything to projects. Include also Components and Versions
* UserClient - everything to users.
* SearchClient - for jql search
* SystemClient - every global Info form the Jira. You can get Status, Priority, IssueTypes Informations.

## Tests 

For more Information about usage and some Code Snippets look into the Unit-Tests inside the project. 






