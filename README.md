# JiraRestClient

This is a simple JiraRestClient to use the RestAPI V2.0 of Jira.

## Usage

Download and build the jar.

Before you build the Client you can test the Connection with the following Code:

    URI uri = new URI("https://team.micromata.de/jira");
    String username = "username";
    String password = "password";
    Jira RestClient jiraRestClient = JiraRestClient.create(uri, username, password);

Then you can get the Client yo need with:

    jiraRestClient.getIssueClient();
    jiraRestClient.getProjectClient();
    jiraRestClient.getSearchClient();
    jiraRestClient.getUserClient();


Enjoy 


### Usage inside a Jira Plugin

I build this Client to use it inside a Jira5Plugin, because there is nothing else to use to avoid the hell of Jars with the Classloader. :)

To use it inside a Jira5Plugin you have to exclude some libs in your dependency and add the libs Jira is providing:

        <dependency>
             <groupId>de.micromata</groupId>
             <artifactId>jiraRestClient</artifactId>
             <version>1.0-SNAPSHOT</version>
             <exclusions>
                 <exclusion>
                     <groupId>com.google.code.gson</groupId>
                     <artifactId>gson</artifactId>
                 </exclusion>
                 <exclusion>
                     <groupId>org.apache.commons</groupId>
                     <artifactId>commons-lang3</artifactId>
                 </exclusion>
                 <exclusion>
                     <groupId>com.sun.jersey</groupId>
                     <artifactId>jersey-client</artifactId>
                 </exclusion>
                 <exclusion>
                     <groupId>com.sun.jersey</groupId>
                     <artifactId>jersey-core</artifactId>
                 </exclusion>
                 <exclusion>
                     <groupId>com.sun.jersey</groupId>
                     <artifactId>jersey-json</artifactId>
                 </exclusion>
                 <exclusion>
                     <groupId>javax.servlet</groupId>
                     <artifactId>servlet-api</artifactId>
                 </exclusion>
             </exclusions>
         </dependency>
         <dependency>
             <groupId>com.sun.jersey</groupId>
             <artifactId>jersey-client</artifactId>
             <version>1.8-atlassian-6</version>
             <scope>provided</scope>
         </dependency>
         <dependency>
             <groupId>com.sun.jersey</groupId>
             <artifactId>jersey-core</artifactId>
             <version>1.8-atlassian-6</version>
             <scope>provided</scope>
         </dependency>
         <dependency>
             <groupId>com.sun.jersey</groupId>
             <artifactId>jersey-json</artifactId>
             <version>1.8-atlassian-6</version>
             <scope>provided</scope>
         </dependency>
         <dependency>
             <groupId>javax.servlet</groupId>
             <artifactId>servlet-api</artifactId>
             <version>2.3</version>
             <scope>provided</scope>
         </dependency>




