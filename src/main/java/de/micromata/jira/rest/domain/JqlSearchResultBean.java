/*
 * Micromata GmbH
 * Copyright (c)
 *
 * 23.08.13 09:14
 * connect
 * Christian
 */

package de.micromata.jira.rest.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class JqlSearchResultBean {

    private String expand = StringUtils.EMPTY;

    private int startAt = 0;

    private int maxResults = 0;

    private int total = 0;

    private List<IssueBean> issueBeans;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<IssueBean> getIssueBeans() {
        if(issueBeans == null){
            issueBeans = new ArrayList<IssueBean>();
        }
        return issueBeans;
    }

    public void setIssueBeans(List<IssueBean> issueBeans) {
        this.issueBeans = issueBeans;
    }
}
