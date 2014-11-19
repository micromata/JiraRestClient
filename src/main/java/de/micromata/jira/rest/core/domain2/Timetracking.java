
package de.micromata.jira.rest.core.domain2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Timetracking {

    @Expose
    private String originalEstimate;
    @Expose
    private Integer originalEstimateSeconds;
    @Expose
    private String remainingEstimate;
    @Expose
    private Integer remainingEstimateSeconds;

    /**
     * 
     * @return
     *     The originalEstimate
     */
    public String getOriginalEstimate() {
        return originalEstimate;
    }

    /**
     * 
     * @param originalEstimate
     *     The originalEstimate
     */
    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    /**
     * 
     * @return
     *     The originalEstimateSeconds
     */
    public Integer getOriginalEstimateSeconds() {
        return originalEstimateSeconds;
    }

    /**
     * 
     * @param originalEstimateSeconds
     *     The originalEstimateSeconds
     */
    public void setOriginalEstimateSeconds(Integer originalEstimateSeconds) {
        this.originalEstimateSeconds = originalEstimateSeconds;
    }

    /**
     * 
     * @return
     *     The remainingEstimate
     */
    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    /**
     * 
     * @param remainingEstimate
     *     The remainingEstimate
     */
    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    /**
     * 
     * @return
     *     The remainingEstimateSeconds
     */
    public Integer getRemainingEstimateSeconds() {
        return remainingEstimateSeconds;
    }

    /**
     * 
     * @param remainingEstimateSeconds
     *     The remainingEstimateSeconds
     */
    public void setRemainingEstimateSeconds(Integer remainingEstimateSeconds) {
        this.remainingEstimateSeconds = remainingEstimateSeconds;
    }

}
