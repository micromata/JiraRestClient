/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.util;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 *
 */
public interface RestConstants {

    // Common Stuff for Jersey Client

    public static final String AUTHORIZATION = "Authorization";

    public static final String BASIC = "Basic ";

    // REST Paths

    public static final String BASE_REST_PATH = "/rest/api/2";

    public static final String PROJECT = "/project";

    public static final String USER = "/user";

    public static final String SEARCH = "/search";
    
    public static final String ISSUE = "/issue";
    
    public static final String COMMENT = "/comment";
    
    public static final String VERSIONS = "/versions";
    
    public static final String COMPONENTS = "/components";

    public static final String ISSUETPYES = "/issuetype";

    public static final String STATUS = "/status";

    public static final String PRIORITY = "/priority";
    
    public static final String TRANSITIONS = "/transitions";
    
    public static final String WORKLOG = "/worklog";

    // Parameternames

    public static final String PARAM_USERNAME = "username";

    public static final String JQL = "jql";
    
    public static final String START_AT = "startAt";
    
    public static final String MAX_RESULTS = "maxResults";

    public static final String FIELDS = "fields";
    
    public static final String EXPAND = "expand";
    
    public static final String TRANSITIONS_FIELDS = "transitions.fields";
}
