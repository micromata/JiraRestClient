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

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * JQL search requirements.
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class JqlSearchBean {

    /**
     * Result list start at.
     */
    private Integer startAt = null;

    /**
     * Maximum result list size.
     */
    private Integer maxResults = null;

    /**
     * Result fields for a query.
     */
    private List<String> fields = null;

    private String jql = StringUtils.EMPTY;

    private List<String> expand = new ArrayList<String>();

    /**
     * Adds fields which should be returned after the request.
     *
     * @param fields = returned fields
     */
    public void addField(EField... fields) {
        for (EField f : fields) {
            getFields().add(f.toString());
        }
    }

    public void addExpand(EField... fields){
        for (EField field : fields) {
            getExpand().add(field.toString());
        }
    }

    /**
     * Gets the start at.
     *
     * @return the start at
     */
    public Integer getStartAt() {
        return startAt;
    }

    /**
     * Sets the start at.
     *
     * @param startAt the new start at
     */
    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    /**
     * Gets the max result.
     *
     * @return the max result
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Sets the max result.
     *
     * @param maxResults the new max result
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Gets the fields.
     *
     * @return the fields
     */
    public List<String> getFields() {
        if (fields == null) {
            fields = new ArrayList<String>();
        }
        return fields;
    }

    public String getJql() {
        return jql;
    }

    public void setJql(String jql) {
        this.jql = jql;
    }

    public List<String> getExpand() {
        if(expand == null){
            expand = new ArrayList<String>();
        }
        return expand;
    }
}
