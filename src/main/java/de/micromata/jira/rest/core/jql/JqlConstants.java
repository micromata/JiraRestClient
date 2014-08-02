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

package de.micromata.jira.rest.core.jql;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
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
}
