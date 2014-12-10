package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class CommentsBean {

    @Expose
    private List<CommentBean> comments = new ArrayList<CommentBean>();
    @Expose
    private Integer maxResults;
    @Expose
    private Integer startAt;
    @Expose
    private Integer total;

    public List<CommentBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentBean> comments) {
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
