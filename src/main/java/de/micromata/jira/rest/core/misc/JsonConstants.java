/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.misc;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public interface JsonConstants {

    public static final String PROP_ID = "id";

    public static final String PROP_SELF = "self";

    public static final String PROP_NAME = "name";

    public static final String PROP_KEY = "key";

    public static final String PROP_DESCRIPTION = "description";

    public static final String PROP_DISPLAYNAME = "displayName";

    public static final String PROP_ACTIVE = "active";

    public static final String PROP_16x16 = "16x16";

    public static final String PROP_48x48 = "48x48";

    public static final String PROP_ASSIGNEETYPE = "assigneeType";

    public static final String PROP_ISASSIGNEETYPEVALID = "isAssigneeTypeValid";

    public static final String PROP_RELEASEDATE = "releaseDate";

    public static final String PROP_OVERDUE = "overdue";

    public static final String PROP_RELEASED = "released";

    public static final String PROP_ARCHIVED = "archived";

    public static final String PROP_SUBTASK = "subtask";

    public static final String PROP_SUBTASKS = "subtasks";

    public static final String PROP_ICONURL = "iconUrl";

    public static final String PROP_SUMMARY = "summary";

    public static final String PROP_DUEDATE = "duedate";

    public static final String PROP_ISSUETYPE = "issuetype";

    public static final String PROP_HAS_VOTED = "hasVoted";


    public static final String PROP_RESOLUTIONDATE = "resolutiondate";

    public static final String PROP_TIMESPENT = "timeSpent";

    public static final String PROP_EMAIL_ADRESS = "emailAddress";

    public static final String PROP_AGGREGATETIMEORIGINALESTIMATE = "aggregatetimeoriginalestimate";

    public static final String PROP_UPDATED = "updated";

    public static final String PROP_CREATED = "created";

    public static final String PROP_ISSUELINKS = "issuelinks";

    public static final String PROP_LABELS = "labels";

    public static final String PROP_WORKRATIO = "workratio";

    public static final String PROP_ATTACHMENT = "attachment";

    public static final String PROP_AGGREGATETIMEESTIMATE = "aggregatetimeestimate";

    public static final String PROP_ENVIRONMENT = "environment";

    public static final String PROP_TIMEESTIMATE = "timeestimate";

    public static final String PROP_AGGREGATEPROGRESS = "aggregateprogress";

    public static final String PROP_LAST_VIEWED = "lastViewed";

    public static final String PROP_COMMENT = "comment";

    public static final String PROP_COMMENTS = "comments";

    public static final String PROP_TIMEORIGINALESTIMATE = "timeoriginalestimate";

    public static final String PROP_AGGREGATETIMESPENT = "aggregatetimespent";

    public static final String PROP_WORKLOGS = "worklogs";

    public static final String PROP_WATCH_COUNT = "watchCount";

    public static final String PROP_IS_WATCHING = "isWatching";

    public static final String PROP_ORIGINALESTIMATE = "originalEstimate";

    public static final String PROP_REMAININGESTIMATE = "remainingEstimate";

    public static final String PROP_ORIGINAL_ESTIMATE_SECONDS = "originalEstimateSeconds";

    public static final String PROP_REMAINING_ESTIMATE_SECONDS = "remainingEstimateSeconds";

    public static final String PROP_TIME_SPENT_SECONDS = "timeSpentSeconds";

    public static final String PROP_VOTES = "votes";

    public static final String PROP_RESOLUTION = "resolution";

    public static final String PROP_INWARD = "inward";

    public static final String PROP_OUTWARD = "outward";

    public static final String PROP_TYPE = "type";

    public static final String PROP_VALUE = "value";

    public static final String PROP_STARTED = "started";

    public static final String PROP_FILENAME = "filename";

    public static final String PROP_SIZE = "size";

    public static final String PROP_MIME_TYPE = "mimeType";

    public static final String PROP_CONTENT = "content";

    public static final String PROP_THUMBNAIL = "thumbnail";

    public static final String PROP_REAL_ASSIGNEE_TYPE = "realAssigneeType";

    public static final String PROP_BODY = "body";

    public static final String PROP_USER_RELEASE_DATE = "userReleaseDate";

    public static final String PROP_STEPS = "steps";

    public static final String PROP_DEFAULT = "default";

    public static final String PROP_TO = "to";

    public static final String PROP_TRANSITIONS = "transitions";

    public static final String PROP_ERROR_MESSAGES = "errorMessages";

    public static final String PROP_ERRORS = "errors";

    public static final String PROP_REQUIRED = "required";

    public static final String PROP_FROM = "from";
    
    public static final String PROP_FROM_STRING = "fromString";
    
    public static final String PROP_TO_STRING = "toString";
    
    public static final String PROP_FIELDTYPE = "fieldtype";

    public static final String PROP_FIELD = "field";
    
    // Properties und Elemente der JQL-Suche

    public static final String PROP_EXPAND = "expand";

    public static final String PROP_STARTAT = "startAt";

    public static final String PROP_MAXRESULTS = "maxResults";

    public static final String PROP_TOTAL = "total";

    public static final String ELEM_ISSUES = "issues";

    // ElementNamen

    public static final String ELEM_COMPONENTS = "components";

    public static final String ELEM_ISSUETYPE = "issuetype";

    public static final String ELEM_ISSUETYPES = "issueTypes";

    public static final String ELEM_VERSIONS = "versions";

    public static final String ELEM_FIX_VERSIONS = "fixVersions";

    public static final String ELEM_ROLES = "roles";

    public static final String ELEM_ASSIGNEE = "assignee";

    public static final String ELEM_LEAD = "lead";

    public static final String ELEM_AVATAR_URLS = "avatarUrls";

    public static final String ELEM_FIELDS = "fields";

    public static final String ELEM_STATUS = "status";

    public static final String ELEM_PROGRESS = "progress";

    public static final String ELEM_TIMETRACKING = "timetracking";

    public static final String ELEM_VOTES = "votes";

    public static final String ELEM_REPORTER = "reporter";

    public static final String ELEM_PRIORITY = "priority";

    public static final String ELEM_WATCHES = "watches";

    public static final String ELEM_WORKLOG = "worklog";

    public static final String ELEM_TYPE = "type";

    public static final String ELEM_OUTWARD_ISSUE = "outwardIssue";

    public static final String ELEM_INWARD_ISSUE = "inwardIssue";

    public static final String ELEM_AUTHOR = "author";

    public static final String ELEM_UPDATE_AUTHOR = "updateAuthor";

    public static final String ELEM_VISIBILITY = "visibility";

    public static final String ELEM_ATTACHMENT = "attachment";

    public static final String ELEM_PROJECT = "project";

    public static final String ELEM_AGGREGATEPROGRESS = "aggregateprogress";

    public static final String ELEM_REAL_ASSIGNEE = "realAssignee";

    public static final String ELEM_COMMENT = "comment";

    public static final String ELEM_PARENT = "parent";

    public static final String ELEM_TRANSITION = "transition";

    public static final String ELEM_CHANGELOG = "changelog";

    public static final String ELEM_ITEMS = "items";
    
    public static final String ELEM_HISTORIES = "histories";

    public static final String ELEM_RENDERED_FIELDS = "renderedFields";

    // Rollen

    public static final String ROLE_ADMINISTRATORS = "Administrator";

    public static final String ROLE_USERS = "Users";

    public static final String ROLE_DEVELOPERS = "Developers";

    //Issue Type für die JQL Suche
    
    public static final String ISSUETYPE_IMPROVEMENT = "Improvement"; 

    public static final String ISSUETYPE_BUG = "Bug"; 

    public static final String ISSUETYPE_NEW_FEATURE = "New Feature"; 

    public static final String ISSUETYPE_SUBTASK = "Sub-Task"; 

    public static final String ISSUETYPE_TASK = "Task"; 
    
    //Priority für die JQL Suche
    
    public static final String PRIORITY_MAJOR = "Major";
    
    public static final String PRIORITY_BLOCKER = "Blocker";
    
    public static final String PRIORITY_CRITICAL = "Critical";
    
    public static final String PRIORITY_MINOR = "Minor";
    
    public static final String PRIORITY_TRIVIAL = "Trivial";
}
