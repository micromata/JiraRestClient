package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class VotesBean {

    @Expose
    private Boolean hasVoted;
    @Expose
    private String self;
    @Expose
    private Integer votes;

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
