# JiraRestClient

This is a simple JiraRestClient to use the RestAPI V2.0 of Jira.

# Warning

**This is the master snapshot branch and is not recommened to use this in productive enviroment.**

## Usage

Use the static Method of the Class JiraRestClient to create a new Instance of the Client.
You need your user credentials and the url to the Jira, also you can configure a proxy for the connection.

With the Client you can use the seperated Clients for Issues, Projects, Users, Search and System.

* IssueClient - everything to issues. Include also Attachments, Transitions, Comments and Worklog
* ProjectClient - everything to projects. Include also Components and Versions
* UserClient - everything to users.
* SearchClient - for jql search
* SystemClient - every global Info form the Jira. You can get Status, Priority, IssueTypes Informations.



