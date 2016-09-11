package de.micromata.jira.rest.core.domain.system;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 11.09.2016.
 */
public class ConfigurationBean {

    @Expose
    private boolean votingEnabled;
    @Expose
    private boolean watchingEnabled;
    @Expose
    private boolean unassignedIssuesAllowed;
    @Expose
    private boolean subTasksEnabled;
    @Expose
    private boolean issueLinkingEnabled;
    @Expose
    private boolean timeTrackingEnabled;
    @Expose
    private boolean attachmentsEnabled;
    @Expose
    private TimeTrackingConfigurationBean timeTrackingConfiguration;

    public boolean isVotingEnabled() {
        return votingEnabled;
    }

    public void setVotingEnabled(boolean votingEnabled) {
        this.votingEnabled = votingEnabled;
    }

    public boolean isWatchingEnabled() {
        return watchingEnabled;
    }

    public void setWatchingEnabled(boolean watchingEnabled) {
        this.watchingEnabled = watchingEnabled;
    }

    public boolean isUnassignedIssuesAllowed() {
        return unassignedIssuesAllowed;
    }

    public void setUnassignedIssuesAllowed(boolean unassignedIssuesAllowed) {
        this.unassignedIssuesAllowed = unassignedIssuesAllowed;
    }

    public boolean isSubTasksEnabled() {
        return subTasksEnabled;
    }

    public void setSubTasksEnabled(boolean subTasksEnabled) {
        this.subTasksEnabled = subTasksEnabled;
    }

    public boolean issueLinkingEnabled() {
        return issueLinkingEnabled;
    }

    public void setIssueLinkingEnabled(boolean issueLinkingEnabled) {
        this.issueLinkingEnabled = issueLinkingEnabled;
    }

    public boolean isTimeTrackingEnabled() {
        return timeTrackingEnabled;
    }

    public void setTimeTrackingEnabled(boolean timeTrackingEnabled) {
        this.timeTrackingEnabled = timeTrackingEnabled;
    }

    public boolean isAttachmentsEnabled() {
        return attachmentsEnabled;
    }

    public void setAttachmentsEnabled(boolean attachmentsEnabled) {
        this.attachmentsEnabled = attachmentsEnabled;
    }

    public TimeTrackingConfigurationBean getTimeTrackingConfiguration() {
        return timeTrackingConfiguration;
    }

    public void setTimeTrackingConfiguration(TimeTrackingConfigurationBean timeTrackingConfiguration) {
        this.timeTrackingConfiguration = timeTrackingConfiguration;
    }
}
