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

    String PROJECT = "project";

    String ORDER_BY = "ORDER_BY";

    String ISSUETYPE = "issuetype";

    String STATUS = "status";

    String AND = "and";

    String OR = "or";

    // Issue Field Names für die JQL Suche

    String FIELD_SUMMARY = "summary";

    String FIELD_ISSUETYPE = "issuetype";

    String FIELD_STATUS = "status";

    String FIELD_DUEDATE = "duedate";

    String FIELD_PRIORITY = "priority";

    //Issue Status für die JQL Suche

    String STATUS_OPEN = "open";

    String STATUS_CLOSED = "closed";

    String STATUS_RESOLVED = "resolved";

    String STATUS_IN_PROGRESS = "\"in progress\"";

    String STATUS_REOPENED = "reopened";

    //Issue Type für die JQL Suche

    String ISSUETYPE_IMPROVEMENT = "improvement";

    String ISSUETYPE_BUG = "bug";

    String ISSUETYPE_NEW_FEATURE = "\"new feature\"";

    String ISSUETYPE_SUBTASK = "sub-task";

    String ISSUETYPE_TASK = "task";

    //Priority für die SQL Suche

    String PRIORITY_MAJOR = "major";

    String PRIORITY_BLOCKER = "blocker";

    String PRIORITY_CRITICAL = "critical";

    String PRIORITY_MINOR = "minor";

    String PRIORITY_TRIVIAL = "trivial";
}
