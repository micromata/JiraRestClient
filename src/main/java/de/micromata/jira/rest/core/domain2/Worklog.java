package de.micromata.jira.rest.core.domain2;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Worklog {

    @Expose
    private Integer maxResults;
    @Expose
    private Integer startAt;
    @Expose
    private Integer total;
    @Expose
    private List<Object> worklogs = new ArrayList<Object>();

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Object> getWorklogs() {
        return worklogs;
    }

    public void setWorklogs(List<Object> worklogs) {
        this.worklogs = worklogs;
    }
}
