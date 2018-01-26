package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class RenderedFieldsBean {

    @Expose
    private String aggregatetimeestimate;
    @Expose
    private String aggregatetimeoriginalestimate;
    @Expose
    private TimetrackingBean timetracking;
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
    private List<AttachmentBean> attachment = new ArrayList<>();
    @Expose
    private CommentsBean comment;
    @Expose
    private String timeoriginalestimate;
    @Expose
    private Object timespent;
    @Expose
    private WorklogBean worklog;
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

    public TimetrackingBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(TimetrackingBean timetracking) {
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

    public List<AttachmentBean> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<AttachmentBean> attachment) {
        this.attachment = attachment;
    }

    public CommentsBean getComment() {
        return comment;
    }

    public void setComment(CommentsBean comment) {
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

    public WorklogBean getWorklog() {
        return worklog;
    }

    public void setWorklog(WorklogBean worklog) {
        this.worklog = worklog;
    }

    public Object getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Object aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }
}
