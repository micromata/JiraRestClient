# JiraRestClient

This is a simple JiraRestClient to use the RestAPI V2.0 of Jira.

## Usage

Download and build the jar.


Bevor you build the Client you can test the Connection with the following Code:

    URI uri = new URI("https://team.micromata.de/jira");
    String username = "irgendeinusername";
    String password = "irgendeinpassword";
    boolean success = restWrapper.testRestConnection(uri, username, password);


The only Thing to do is to create a JiraRestClient like this:

    JiraRestClient jiraRestClient = new JiraRestClient(uri, username, password);

With this Client you can use the RestWrapper:

    RestWrapper restWrapper = new RestWrapperImpl();

Every single Methode of the RestWrapper needs the JiraRestClient to get the Informations from the Jira.

Enjoy an has fun!


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




