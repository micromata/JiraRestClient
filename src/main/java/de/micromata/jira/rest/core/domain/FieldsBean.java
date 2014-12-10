package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

public class FieldsBean {

    @Expose
    private AggregateprogressBean aggregateprogress;
    @Expose
    private Integer aggregatetimeestimate;
    @Expose
    private Integer aggregatetimeoriginalestimate;
    @Expose
    private Integer aggregatetimespent;
    @Expose
    private UserBean assignee;
    @Expose
    private List<AttachmentBean> attachment;
    @Expose
    private CommentsBean comment;
    @Expose
    private List<ComponentBean> components;
    @Expose
    private String created;
    @Expose
    private UserBean creator;
    @Expose
    private String description;
    @Expose
    private String duedate;
    @Expose
    private String environment;
    @Expose
    private List<VersionBean> fixVersions;
    @Expose
    private List<IssuelinkBean> issuelinks;
    @Expose
    private IssuetypeBean issuetype;
    @Expose
    private List<String> labels;
    @Expose
    private String lastViewed;
    @Expose
    private PriorityBean priority;
    @Expose
    private ProgressBean progress;
    @Expose
    private ProjectBean project;
    @Expose
    private UserBean reporter;
    @Expose
    private ResolutionBean resolution;
    @Expose
    private Object resolutiondate;
    @Expose
    private StatusBean status;
    @Expose
    private List<IssueBean> subtasks;
    @Expose
    private String summary;
    @Expose
    private Integer timeestimate;
    @Expose
    private Integer timeoriginalestimate;
    @Expose
    private Object timespent;
    @Expose
    private TimetrackingBean timetracking;
    @Expose
    private String updated;
    @Expose
    private List<VersionBean> versions;
    @Expose
    private VotesBean votes;
    @Expose
    private WatchesBean watches;
    @Expose
    private WorklogBean worklog;
    @Expose
    private Integer workratio;

    public AggregateprogressBean getAggregateprogress() {
        return aggregateprogress;
    }

    public void setAggregateprogress(AggregateprogressBean aggregateprogress) {
        this.aggregateprogress = aggregateprogress;
    }

    public Integer getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(Integer aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public Integer getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(Integer aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public Integer getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Integer aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    public UserBean getAssignee() {
        return assignee;
    }

    public void setAssignee(UserBean assignee) {
        this.assignee = assignee;
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

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UserBean getCreator() {
        return creator;
    }

    public void setCreator(UserBean creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<VersionBean> getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(List<VersionBean> fixVersions) {
        this.fixVersions = fixVersions;
    }

    public List<IssuelinkBean> getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(List<IssuelinkBean> issuelinks) {
        this.issuelinks = issuelinks;
    }

    public IssuetypeBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssuetypeBean issuetype) {
        this.issuetype = issuetype;
    }

    public List<String> getLabels(){
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public PriorityBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityBean priority) {
        this.priority = priority;
    }

    public ProgressBean getProgress() {
        return progress;
    }

    public void setProgress(ProgressBean progress) {
        this.progress = progress;
    }

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public UserBean getReporter() {
        return reporter;
    }

    public void setReporter(UserBean reporter) {
        this.reporter = reporter;
    }

    public ResolutionBean getResolution() {
        return resolution;
    }

    public void setResolution(ResolutionBean resolution) {
        this.resolution = resolution;
    }

    public Object getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(Object resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<IssueBean> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<IssueBean> subtasks) {
        this.subtasks = subtasks;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(Integer timeestimate) {
        this.timeestimate = timeestimate;
    }

    public Integer getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(Integer timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public Object getTimespent() {
        return timespent;
    }

    public void setTimespent(Object timespent) {
        this.timespent = timespent;
    }

    public TimetrackingBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(TimetrackingBean timetracking) {
        this.timetracking = timetracking;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public VotesBean getVotes() {
        return votes;
    }

    public void setVotes(VotesBean votes) {
        this.votes = votes;
    }

    public WatchesBean getWatches() {
        return watches;
    }

    public void setWatches(WatchesBean watches) {
        this.watches = watches;
    }

    public WorklogBean getWorklog() {
        return worklog;
    }

    public void setWorklog(WorklogBean worklog) {
        this.worklog = worklog;
    }

    public Integer getWorkratio() {
        return workratio;
    }

    public void setWorkratio(Integer workratio) {
        this.workratio = workratio;
    }
}