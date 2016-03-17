# JiraRestClient

This is a simple JiraRestClient to use the RestAPI V2.0 of Jira.

## Version 2.1.1

* adding support for IssueType Fields Meta Data.

## Version 2.1

* adding support for CustomFields. All standard CustomFields coming with Jira.

## Version 2.0

* change Apache HttpClient from Major-Version 3 to 4

## Usage

Use the static Method of the Class JiraRestClient to create a new Instance of the Client.
You need your user credentials and the url to the Jira, also you can configure a proxy for the connection.

With the Client you can use the seperated Clients for Issues, Projects, Users, Search and System.

* IssueClient - everything to issues. Include also Attachments, Transitions, Comments and Worklog
* ProjectClient - everything to projects. Include also Components and Versions
* UserClient - everything to users.
* SearchClient - for jql search
* SystemClient - every global Info form the Jira. You can get Status, Priority, IssueTypes Informations.



