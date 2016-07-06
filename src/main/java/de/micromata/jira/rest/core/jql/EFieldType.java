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

import java.util.Arrays;
import java.util.List;

import static de.micromata.jira.rest.core.jql.EOperator.*;

/**
 * The type of a field sets the supporting operators.
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public enum EFieldType {

    /**
     * The version.
     */
    VERSION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The user.
     */
    USER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The category.
     */
    CATEGORY(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The text.
     */
    TEXT(CONTAINS, DOES_NOT_CONTAIN, IS, IS_NOT),

    /**
     * The component.
     */
    COMPONENT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The date.
     */
    DATE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The filter.
     */
    FILTER(EQUALS, NOT_EQUALS, IN, NOT_IN),

    /**
     * The issue.
     */
    ISSUE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The security level.
     */
    SECURITY_LEVEL(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The duration.
     */
    DURATION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The priority.
     */
    PRIORITY(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The project.
     */
    PROJECT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The resolution.
     */
    RESOLUTION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The number.
     */
    NUMBER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The status.
     */
    STATUS(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The text master.
     */
    TEXT_MASTER(CONTAINS),

    /**
     * The issue type.
     */
    ISSUE_TYPE(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The custom type.
     */
    CUSTOM_TYPE;



    /**
     * List of supported operators for a type of field.
     */
    private final List<EOperator> supportedOperators;

    /**
     * Instantiates a new field type.
     *
     * @param supportedOperators = the supported operators for a type
     */
    EFieldType(EOperator... supportedOperators) {
        this.supportedOperators = Arrays.asList(supportedOperators);
    }

    /**
     * Gets the list of supported opperators.
     *
     * @return the supported opperators
     */
    public List<EOperator> getSupportedOperators() {
        return supportedOperators;
    }
}
