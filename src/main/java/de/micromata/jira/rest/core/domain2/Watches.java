
package de.micromata.jira.rest.core.domain2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Watches {

    @Expose
    private Boolean isWatching;
    @Expose
    private String self;
    @Expose
    private Integer watchCount;

    /**
     * 
     * @return
     *     The isWatching
     */
    public Boolean getIsWatching() {
        return isWatching;
    }

    /**
     * 
     * @param isWatching
     *     The isWatching
     */
    public void setIsWatching(Boolean isWatching) {
        this.isWatching = isWatching;
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
     *     The watchCount
     */
    public Integer getWatchCount() {
        return watchCount;
    }

    /**
     * 
     * @param watchCount
     *     The watchCount
     */
    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

}
