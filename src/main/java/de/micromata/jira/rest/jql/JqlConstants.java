package de.micromata.jira.rest.jql;

/**
 * User: Christian
 * Date: 11.03.13
 * Time: 14:26
 */
public interface JqlConstants {

    public static final String PROJECT = "project";

    public static final String ORDER_BY = "ORDER_BY";

    public static final String ISSUETYPE = "issuetype";

    public static final String STATUS = "status";

    public static final String AND = "and";

    public static final String OR = "or";

    // Issue Field Names für die JQL Suche

    public static final String FIELD_SUMMARY = "summary";

    public static final String FIELD_ISSUETYPE = "issuetype";

    public static final String FIELD_STATUS = "status";

    public static final String FIELD_DUEDATE = "duedate";

    public static final String FIELD_PRIORITY = "priority";
    
    //Issue Status für die JQL Suche
    
    public static final String STATUS_OPEN = "open";
    
    public static final String STATUS_CLOSED = "closed";
    
    public static final String STATUS_RESOLVED = "resolved";
    
    public static final String STATUS_IN_PROGRESS = "in progress";
    
    public static final String STATUS_REOPENED = "reopened";

    //Issue Type für die JQL Suche
    
    public static final String ISSUETYPE_IMPROVEMENT = "improvement"; 

    public static final String ISSUETYPE_BUG = "bug"; 

    public static final String ISSUETYPE_NEW_FEATURE = "new feature"; 

    public static final String ISSUETYPE_SUBTASK = "sub-task"; 

    public static final String ISSUETYPE_TASK = "task"; 
    
    //Priority für die SQL Suche
    
    public static final String PRIORITY_MAJOR = "major";
    
    public static final String PRIORITY_BLOCKER = "blocker";
    
    public static final String PRIORITY_CRITICAL = "critical";
    
    public static final String PRIORITY_MINOR = "minor";
    
    public static final String PRIORITY_TRIVIAL = "trivial";
    
    // Rückgabe der Felder bei Suchfunktion
    
    public static final String FIELDS_ALL = "*all"; //set by default
    
    public static final String FIELDS_NAVIGABLE = "*navigable";
}
