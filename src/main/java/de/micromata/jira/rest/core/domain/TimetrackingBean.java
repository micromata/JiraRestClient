
package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;


public class TimetrackingBean {

    @Expose
    private String originalEstimate;
    @Expose
    private Integer originalEstimateSeconds;
    @Expose
    private String remainingEstimate;
    @Expose
    private Integer remainingEstimateSeconds;

    public String getOriginalEstimate() {
        return originalEstimate;
    }

    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public Integer getOriginalEstimateSeconds() {
        return originalEstimateSeconds;
    }

    public void setOriginalEstimateSeconds(Integer originalEstimateSeconds) {
        this.originalEstimateSeconds = originalEstimateSeconds;
    }

    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public Integer getRemainingEstimateSeconds() {
        return remainingEstimateSeconds;
    }

    public void setRemainingEstimateSeconds(Integer remainingEstimateSeconds) {
        this.remainingEstimateSeconds = remainingEstimateSeconds;
    }
}
