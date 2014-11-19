package de.micromata.jira.rest.core.domain2;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class Comments {

    @Expose
    private List<Comment> comments = new ArrayList<Comment>();
    @Expose
    private Integer maxResults;
    @Expose
    private Integer startAt;
    @Expose
    private Integer total;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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
}
