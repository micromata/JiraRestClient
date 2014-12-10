package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class RenderedFields {

    @Expose
    private String aggregatetimeestimate;
    @Expose
    private String aggregatetimeoriginalestimate;
    @Expose
    private Timetracking timetracking;
    @Expose
    private String environment;
    @Expose
    private String created;
    @Expose
    private String updated;
    @Expose
    private String description;
    @Expose
    private String timeestimate;
    @Expose
    private String duedate;
    @Expose
    private String lastViewed;
    @Expose
    private List<Attachment> attachment = new ArrayList<Attachment>();
    @Expose
    private Comments comment;
    @Expose
    private String timeoriginalestimate;
    @Expose
    private Object timespent;
    @Expose
    private Worklog worklog;
    @Expose
    private Object aggregatetimespent;

    public String getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(String aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public String getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public Timetracking getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(Timetracking timetracking) {
        this.timetracking = timetracking;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(String timeestimate) {
        this.timeestimate = timeestimate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public String getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(String timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public Object getTimespent() {
        return timespent;
    }

    public void setTimespent(Object timespent) {
        this.timespent = timespent;
    }

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

    public Object getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Object aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }
}
