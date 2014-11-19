
package de.micromata.jira.rest.core.domain2;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Fields {

    @Expose
    private Aggregateprogress aggregateprogress;
    @Expose
    private Integer aggregatetimeestimate;
    @Expose
    private Integer aggregatetimeoriginalestimate;
    @Expose
    private Object aggregatetimespent;
    @Expose
    private Assignee assignee;
    @Expose
    private List<Attachment> attachment = new ArrayList<Attachment>();
    @Expose
    private Comments comment;
    @Expose
    private List<Component> components = new ArrayList<Component>();
    @Expose
    private String created;
    @Expose
    private Creator creator;
    @Expose
    private String description;
    @Expose
    private String duedate;
    @Expose
    private String environment;
    @Expose
    private List<FixVersion> fixVersions = new ArrayList<FixVersion>();
    @Expose
    private List<Object> issuelinks = new ArrayList<Object>();
    @Expose
    private Issuetype issuetype;
    @Expose
    private List<String> labels = new ArrayList<String>();
    @Expose
    private String lastViewed;
    @Expose
    private Priority priority;
    @Expose
    private Progress progress;
    @Expose
    private Project project;
    @Expose
    private Reporter reporter;
    @Expose
    private Object resolution;
    @Expose
    private Object resolutiondate;
    @Expose
    private Status status;
    @Expose
    private List<Object> subtasks = new ArrayList<Object>();
    @Expose
    private String summary;
    @Expose
    private Integer timeestimate;
    @Expose
    private Integer timeoriginalestimate;
    @Expose
    private Object timespent;
    @Expose
    private Timetracking timetracking;
    @Expose
    private String updated;
    @Expose
    private List<Version> versions = new ArrayList<Version>();
    @Expose
    private Votes votes;
    @Expose
    private Watches watches;
    @Expose
    private Worklog worklog;
    @Expose
    private Integer workratio;

    /**
     * 
     * @return
     *     The aggregateprogress
     */
    public Aggregateprogress getAggregateprogress() {
        return aggregateprogress;
    }

    /**
     * 
     * @param aggregateprogress
     *     The aggregateprogress
     */
    public void setAggregateprogress(Aggregateprogress aggregateprogress) {
        this.aggregateprogress = aggregateprogress;
    }

    /**
     * 
     * @return
     *     The aggregatetimeestimate
     */
    public Integer getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    /**
     * 
     * @param aggregatetimeestimate
     *     The aggregatetimeestimate
     */
    public void setAggregatetimeestimate(Integer aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    /**
     * 
     * @return
     *     The aggregatetimeoriginalestimate
     */
    public Integer getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    /**
     * 
     * @param aggregatetimeoriginalestimate
     *     The aggregatetimeoriginalestimate
     */
    public void setAggregatetimeoriginalestimate(Integer aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    /**
     * 
     * @return
     *     The aggregatetimespent
     */
    public Object getAggregatetimespent() {
        return aggregatetimespent;
    }

    /**
     * 
     * @param aggregatetimespent
     *     The aggregatetimespent
     */
    public void setAggregatetimespent(Object aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    /**
     * 
     * @return
     *     The assignee
     */
    public Assignee getAssignee() {
        return assignee;
    }

    /**
     * 
     * @param assignee
     *     The assignee
     */
    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    /**
     * 
     * @return
     *     The attachment
     */
    public List<Attachment> getAttachment() {
        return attachment;
    }

    /**
     * 
     * @param attachment
     *     The attachment
     */
    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    /**
     * 
     * @return
     *     The comment
     */
    public Comments getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    public void setComment(Comments comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * 
     * @param components
     *     The components
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The creator
     */
    public Creator getCreator() {
        return creator;
    }

    /**
     * 
     * @param creator
     *     The creator
     */
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The duedate
     */
    public String getDuedate() {
        return duedate;
    }

    /**
     * 
     * @param duedate
     *     The duedate
     */
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    /**
     * 
     * @return
     *     The environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * 
     * @param environment
     *     The environment
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * 
     * @return
     *     The fixVersions
     */
    public List<FixVersion> getFixVersions() {
        return fixVersions;
    }

    /**
     * 
     * @param fixVersions
     *     The fixVersions
     */
    public void setFixVersions(List<FixVersion> fixVersions) {
        this.fixVersions = fixVersions;
    }

    /**
     * 
     * @return
     *     The issuelinks
     */
    public List<Object> getIssuelinks() {
        return issuelinks;
    }

    /**
     * 
     * @param issuelinks
     *     The issuelinks
     */
    public void setIssuelinks(List<Object> issuelinks) {
        this.issuelinks = issuelinks;
    }

    /**
     * 
     * @return
     *     The issuetype
     */
    public Issuetype getIssuetype() {
        return issuetype;
    }

    /**
     * 
     * @param issuetype
     *     The issuetype
     */
    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    /**
     * 
     * @return
     *     The labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * 
     * @param labels
     *     The labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     * 
     * @return
     *     The lastViewed
     */
    public String getLastViewed() {
        return lastViewed;
    }

    /**
     * 
     * @param lastViewed
     *     The lastViewed
     */
    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    /**
     * 
     * @return
     *     The priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * 
     * @param priority
     *     The priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * 
     * @return
     *     The progress
     */
    public Progress getProgress() {
        return progress;
    }

    /**
     * 
     * @param progress
     *     The progress
     */
    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    /**
     * 
     * @return
     *     The project
     */
    public Project getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * 
     * @return
     *     The reporter
     */
    public Reporter getReporter() {
        return reporter;
    }

    /**
     * 
     * @param reporter
     *     The reporter
     */
    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    /**
     * 
     * @return
     *     The resolution
     */
    public Object getResolution() {
        return resolution;
    }

    /**
     * 
     * @param resolution
     *     The resolution
     */
    public void setResolution(Object resolution) {
        this.resolution = resolution;
    }

    /**
     * 
     * @return
     *     The resolutiondate
     */
    public Object getResolutiondate() {
        return resolutiondate;
    }

    /**
     * 
     * @param resolutiondate
     *     The resolutiondate
     */
    public void setResolutiondate(Object resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    /**
     * 
     * @return
     *     The status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The subtasks
     */
    public List<Object> getSubtasks() {
        return subtasks;
    }

    /**
     * 
     * @param subtasks
     *     The subtasks
     */
    public void setSubtasks(List<Object> subtasks) {
        this.subtasks = subtasks;
    }

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     *     The timeestimate
     */
    public Integer getTimeestimate() {
        return timeestimate;
    }

    /**
     * 
     * @param timeestimate
     *     The timeestimate
     */
    public void setTimeestimate(Integer timeestimate) {
        this.timeestimate = timeestimate;
    }

    /**
     * 
     * @return
     *     The timeoriginalestimate
     */
    public Integer getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    /**
     * 
     * @param timeoriginalestimate
     *     The timeoriginalestimate
     */
    public void setTimeoriginalestimate(Integer timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    /**
     * 
     * @return
     *     The timespent
     */
    public Object getTimespent() {
        return timespent;
    }

    /**
     * 
     * @param timespent
     *     The timespent
     */
    public void setTimespent(Object timespent) {
        this.timespent = timespent;
    }

    /**
     * 
     * @return
     *     The timetracking
     */
    public Timetracking getTimetracking() {
        return timetracking;
    }

    /**
     * 
     * @param timetracking
     *     The timetracking
     */
    public void setTimetracking(Timetracking timetracking) {
        this.timetracking = timetracking;
    }

    /**
     * 
     * @return
     *     The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The versions
     */
    public List<Version> getVersions() {
        return versions;
    }

    /**
     * 
     * @param versions
     *     The versions
     */
    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    /**
     * 
     * @return
     *     The votes
     */
    public Votes getVotes() {
        return votes;
    }

    /**
     * 
     * @param votes
     *     The votes
     */
    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    /**
     * 
     * @return
     *     The watches
     */
    public Watches getWatches() {
        return watches;
    }

    /**
     * 
     * @param watches
     *     The watches
     */
    public void setWatches(Watches watches) {
        this.watches = watches;
    }

    /**
     * 
     * @return
     *     The worklog
     */
    public Worklog getWorklog() {
        return worklog;
    }

    /**
     * 
     * @param worklog
     *     The worklog
     */
    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

    /**
     * 
     * @return
     *     The workratio
     */
    public Integer getWorkratio() {
        return workratio;
    }

    /**
     * 
     * @param workratio
     *     The workratio
     */
    public void setWorkratio(Integer workratio) {
        this.workratio = workratio;
    }

}
