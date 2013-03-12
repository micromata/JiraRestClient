package de.micromata.jira.rest.util;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 28.02.13
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public interface RestConstants {

    // Allgemeines für den Jersey Client

    public static final String AUTHORIZATION = "Authorization";

    public static final String BASIC = "Basic ";

    // Pfade der REST-Schnittstelle

    public static final String BASE_REST_PATH = "/rest/api/2";

    public static final String PROJECT = "/project";

    public static final String USER = "/user";

    public static final String SEARCH = "/search";

    // Parameternamen

    public static final String PARAM_USERNAME = "username";

    public static final String JQL = "jql";

    public static final String FIELDS = "fields";

}
