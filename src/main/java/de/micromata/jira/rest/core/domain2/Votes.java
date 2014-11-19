
package de.micromata.jira.rest.core.domain2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Votes {

    @Expose
    private Boolean hasVoted;
    @Expose
    private String self;
    @Expose
    private Integer votes;

    /**
     * 
     * @return
     *     The hasVoted
     */
    public Boolean getHasVoted() {
        return hasVoted;
    }

    /**
     * 
     * @param hasVoted
     *     The hasVoted
     */
    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    /**
     * 
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The votes
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     * 
     * @param votes
     *     The votes
     */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}
