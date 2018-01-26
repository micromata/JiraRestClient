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
@Deprecated
public interface JsonConstants {

    String PROP_ID = "id";

    String PROP_SELF = "self";

    String PROP_NAME = "name";

    String PROP_KEY = "key";

    String PROP_DESCRIPTION = "description";

    String PROP_DISPLAYNAME = "displayName";

    String PROP_ACTIVE = "active";

    String PROP_16x16 = "16x16";

    String PROP_48x48 = "48x48";

    String PROP_ASSIGNEETYPE = "assigneeType";

    String PROP_ISASSIGNEETYPEVALID = "isAssigneeTypeValid";

    String PROP_RELEASEDATE = "releaseDate";

    String PROP_OVERDUE = "overdue";

    String PROP_RELEASED = "released";

    String PROP_ARCHIVED = "archived";

    String PROP_SUBTASK = "subtask";

    String PROP_SUBTASKS = "subtasks";

    String PROP_ICONURL = "iconUrl";

    String PROP_SUMMARY = "summary";

    String PROP_DUEDATE = "duedate";

    String PROP_ISSUETYPE = "issuetype";

    String PROP_HAS_VOTED = "hasVoted";


    String PROP_RESOLUTIONDATE = "resolutiondate";

    String PROP_TIMESPENT = "timeSpent";

    String PROP_EMAIL_ADRESS = "emailAddress";

    String PROP_AGGREGATETIMEORIGINALESTIMATE = "aggregatetimeoriginalestimate";

    String PROP_UPDATED = "updated";

    String PROP_CREATED = "created";

    String PROP_ISSUELINKS = "issuelinks";

    String PROP_LABELS = "labels";

    String PROP_WORKRATIO = "workratio";

    String PROP_ATTACHMENT = "attachment";

    String PROP_AGGREGATETIMEESTIMATE = "aggregatetimeestimate";

    String PROP_ENVIRONMENT = "environment";

    String PROP_TIMEESTIMATE = "timeestimate";

    String PROP_AGGREGATEPROGRESS = "aggregateprogress";

    String PROP_LAST_VIEWED = "lastViewed";

    String PROP_COMMENT = "comment";

    String PROP_COMMENTS = "comments";

    String PROP_TIMEORIGINALESTIMATE = "timeoriginalestimate";

    String PROP_AGGREGATETIMESPENT = "aggregatetimespent";

    String PROP_WORKLOGS = "worklogs";

    String PROP_WATCH_COUNT = "watchCount";

    String PROP_IS_WATCHING = "isWatching";

    String PROP_ORIGINALESTIMATE = "originalEstimate";

    String PROP_REMAININGESTIMATE = "remainingEstimate";

    String PROP_ORIGINAL_ESTIMATE_SECONDS = "originalEstimateSeconds";

    String PROP_REMAINING_ESTIMATE_SECONDS = "remainingEstimateSeconds";

    String PROP_TIME_SPENT_SECONDS = "timeSpentSeconds";

    String PROP_VOTES = "votes";

    String PROP_RESOLUTION = "resolution";

    String PROP_INWARD = "inward";

    String PROP_OUTWARD = "outward";

    String PROP_TYPE = "type";

    String PROP_VALUE = "value";

    String PROP_STARTED = "started";

    String PROP_FILENAME = "filename";

    String PROP_SIZE = "size";

    String PROP_MIME_TYPE = "mimeType";

    String PROP_CONTENT = "content";

    String PROP_THUMBNAIL = "thumbnail";

    String PROP_REAL_ASSIGNEE_TYPE = "realAssigneeType";

    String PROP_BODY = "body";

    String PROP_USER_RELEASE_DATE = "userReleaseDate";

    String PROP_STEPS = "steps";

    String PROP_DEFAULT = "default";

    String PROP_TO = "to";

    String PROP_TRANSITIONS = "transitions";

    String PROP_ERROR_MESSAGES = "errorMessages";

    String PROP_ERRORS = "errors";

    String PROP_REQUIRED = "required";

    String PROP_FROM = "from";
    
    String PROP_FROM_STRING = "fromString";
    
    String PROP_TO_STRING = "toString";
    
    String PROP_FIELDTYPE = "fieldtype";

    String PROP_FIELD = "field";
    
    // Properties und Elemente der JQL-Suche

    String PROP_EXPAND = "expand";

    String PROP_STARTAT = "startAt";

    String PROP_MAXRESULTS = "maxResults";

    String PROP_TOTAL = "total";

    String ELEM_ISSUES = "issues";

    // ElementNamen

    String ELEM_COMPONENTS = "components";

    String ELEM_ISSUETYPE = "issuetype";

    String ELEM_ISSUETYPES = "issueTypes";

    String ELEM_VERSIONS = "versions";

    String ELEM_FIX_VERSIONS = "fixVersions";

    String ELEM_ROLES = "roles";

    String ELEM_ASSIGNEE = "assignee";

    String ELEM_LEAD = "lead";

    String ELEM_AVATAR_URLS = "avatarUrls";

    String ELEM_FIELDS = "fields";

    String ELEM_STATUS = "status";

    String ELEM_PROGRESS = "progress";

    String ELEM_TIMETRACKING = "timetracking";

    String ELEM_VOTES = "votes";

    String ELEM_REPORTER = "reporter";

    String ELEM_PRIORITY = "priority";

    String ELEM_WATCHES = "watches";

    String ELEM_WORKLOG = "worklog";

    String ELEM_TYPE = "type";

    String ELEM_OUTWARD_ISSUE = "outwardIssue";

    String ELEM_INWARD_ISSUE = "inwardIssue";

    String ELEM_AUTHOR = "author";

    String ELEM_UPDATE_AUTHOR = "updateAuthor";

    String ELEM_VISIBILITY = "visibility";

    String ELEM_ATTACHMENT = "attachment";

    String ELEM_PROJECT = "project";

    String ELEM_AGGREGATEPROGRESS = "aggregateprogress";

    String ELEM_REAL_ASSIGNEE = "realAssignee";

    String ELEM_COMMENT = "comment";

    String ELEM_PARENT = "parent";

    String ELEM_TRANSITION = "transition";

    String ELEM_CHANGELOG = "changelog";

    String ELEM_ITEMS = "items";
    
    String ELEM_HISTORIES = "histories";

    String ELEM_RENDERED_FIELDS = "renderedFields";

    // Rollen

    String ROLE_ADMINISTRATORS = "Administrator";

    String ROLE_USERS = "Users";

    String ROLE_DEVELOPERS = "Developers";

    //Issue Type für die JQL Suche
    
    String ISSUETYPE_IMPROVEMENT = "Improvement";

    String ISSUETYPE_BUG = "Bug";

    String ISSUETYPE_NEW_FEATURE = "New Feature";

    String ISSUETYPE_SUBTASK = "Sub-Task";

    String ISSUETYPE_TASK = "Task";
    
    //Priority für die JQL Suche
    
    String PRIORITY_MAJOR = "Major";
    
    String PRIORITY_BLOCKER = "Blocker";
    
    String PRIORITY_CRITICAL = "Critical";
    
    String PRIORITY_MINOR = "Minor";
    
    String PRIORITY_TRIVIAL = "Trivial";
}
