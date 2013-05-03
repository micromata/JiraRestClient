package de.micromata.jira.rest.parser;

import static de.micromata.jira.rest.util.JsonElementUtil.checkNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AggregateprogressBean;
import de.micromata.jira.rest.domain.AttachmentBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.domain.ComponentBean;
import de.micromata.jira.rest.domain.IssueBasicBean;
import de.micromata.jira.rest.domain.IssueBean;
import de.micromata.jira.rest.domain.IssueLinkBean;
import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.domain.PriorityBean;
import de.micromata.jira.rest.domain.ProgressBean;
import de.micromata.jira.rest.domain.ProjectBean;
import de.micromata.jira.rest.domain.ResolutionBean;
import de.micromata.jira.rest.domain.StatusBean;
import de.micromata.jira.rest.domain.TimetrackingBean;
import de.micromata.jira.rest.domain.UserBean;
import de.micromata.jira.rest.domain.VersionBean;
import de.micromata.jira.rest.domain.VotesBean;
import de.micromata.jira.rest.domain.WatchesBean;
import de.micromata.jira.rest.domain.WorklogSummaryBean;
import de.micromata.jira.rest.util.DateParser;
import de.micromata.jira.rest.util.GsonParserUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class IssueParser extends BaseParser {


    public static IssueBean parse(JsonObject jsonObject){
        IssueBean issueBean = new IssueBean();
        parseBaseProperties(issueBean, jsonObject);
        JsonElement keyElement = jsonObject.get(PROP_KEY);
        if(checkNotNull(keyElement)){
            issueBean.setKey(keyElement.getAsString());
        }
        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if(checkNotNull(expandElement)){
            issueBean.setExpand(expandElement.getAsString());
        }

        JsonElement fieldsElement = jsonObject.get(ELEM_FIELDS);
        if(checkNotNull(fieldsElement)){
            JsonObject fieldObject = fieldsElement.getAsJsonObject();
            JsonElement summaryElement = fieldObject.get(PROP_SUMMARY);
            if(checkNotNull(summaryElement)){
                issueBean.setSummary(summaryElement.getAsString());
            }
            JsonElement progressElement = fieldObject.get(ELEM_PROGRESS);
            if(checkNotNull(progressElement)) {
            	JsonObject progressObject = progressElement.getAsJsonObject();
            	ProgressBean progress = ProgressParser.parse(progressObject);
            	issueBean.setProgress(progress);
            }
            JsonElement timetrackingElement = fieldObject.get(ELEM_TIMETRACKING);
            if(checkNotNull(timetrackingElement)) {
            	JsonObject timetrackingObject = progressElement.getAsJsonObject();
            	TimetrackingBean timetracking = TimetrackingParser.parse(timetrackingObject);
            	issueBean.setTimetracking(timetracking);
            }
            JsonElement issuetypeElement = fieldObject.get(ELEM_ISSUETYPE);
            if(checkNotNull(issuetypeElement)){
                JsonObject isseuTypeObject = issuetypeElement.getAsJsonObject();
                IssueTypeBean issueType = IssueTypeParser.parse(isseuTypeObject);
                issueBean.setIssueType(issueType);
            }
            JsonElement votesElement = fieldObject.get(ELEM_VOTES);
            if(checkNotNull(votesElement)){
            	JsonObject votesObject = votesElement.getAsJsonObject();
            	VotesBean votes = VotesParser.parse(votesObject);
            	issueBean.setVotes(votes);
            }
            JsonElement resolutionElement = fieldObject.get(PROP_RESOLUTION);
            if(checkNotNull(resolutionElement)) {
            	JsonObject resolutionObject = resolutionElement.getAsJsonObject();
            	ResolutionBean resolution = ResolutionParser.parse(resolutionObject);
            	issueBean.setResolution(resolution);
            }
            JsonElement resolutionDateElement = fieldObject.get(PROP_RESOLUTIONDATE);
            if(checkNotNull(resolutionDateElement)) {
            	String resolutionDate = resolutionDateElement.getAsString();
            	Date date = DateParser.parseDateFormat(resolutionDate, DateParser.Format.YYYY_MM_DD);
            	issueBean.setResolutionDate(date);
            }
            JsonElement fixVersionElement = fieldObject.get(PROP_FIX_VERSIONS);
            if(checkNotNull(fixVersionElement)) {
            	List<Integer> fixVersions = new ArrayList<>();
            	
            	for(JsonElement j : fixVersionElement.getAsJsonArray()) {
					JsonElement element = j.getAsJsonObject().get(PROP_ID);
					fixVersions.add(element.getAsInt());
				}
            	issueBean.setFixVersions(fixVersions);
            }
            JsonElement timeSpentElement = fieldObject.get(PROP_TIMESPENT);
            if(checkNotNull(timeSpentElement)) {
            	String timespent = timeSpentElement.getAsString();
            	issueBean.setTimeSpent(timespent);
            }
            JsonElement aggregateTimeOriginalEstimateElement = fieldObject.get(PROP_AGGREGATETIMEORIGINALESTIMATE);
            if(checkNotNull(aggregateTimeOriginalEstimateElement)) {
            	String aggregateTimeOriginalEstimate = aggregateTimeOriginalEstimateElement.getAsString();
            	issueBean.setAggregateTimeOriginalEstimate(aggregateTimeOriginalEstimate);
            }
            JsonElement aggregateTimeEstimateElement = fieldObject.get(PROP_AGGREGATETIMEESTIMATE);
            if(checkNotNull(aggregateTimeEstimateElement)) {
            	String aggregateTimeEstimate = aggregateTimeEstimateElement.getAsString();
            	issueBean.setAggregateTimeEstimate(aggregateTimeEstimate);
            }
            JsonElement updatedElement = fieldObject.get(PROP_UPDATED);
            if(checkNotNull(updatedElement)) {
            	Date date = DateParser.parseDateFormat(updatedElement.getAsString(), DateParser.Format.YYYY_MM_DD);
            	issueBean.setUpdated(date);
            }
            JsonElement createdElement = fieldObject.get(PROP_CREATED);
            if(checkNotNull(createdElement))  {
            	Date date = DateParser.parseDateFormat(createdElement.getAsString(), DateParser.Format.YYYY_MM_DD);
            	issueBean.setCreated(date);
            }
            JsonElement descriptionElement = fieldObject.get(PROP_DESCRIPTION);
            if(checkNotNull(descriptionElement)) {
            	issueBean.setDescription(descriptionElement.getAsString());
            }
            JsonElement reporterElement = fieldObject.get(ELEM_REPORTER);
            if(checkNotNull(reporterElement)){
            	JsonObject reporterObject = reporterElement.getAsJsonObject();
            	UserBean reporter = UserParser.parse(reporterObject);
            	issueBean.setReporter(reporter);
            }
            JsonElement priorityElement = fieldObject.get(ELEM_PRIORITY);
            if(checkNotNull(priorityElement)){
            	JsonObject priorityObject = priorityElement.getAsJsonObject();
            	PriorityBean priority = PriorityParser.parse(priorityObject);
            	issueBean.setPriority(priority);
            }
            JsonElement issueLinksElement = fieldObject.get(PROP_ISSUELINKS);
            if(checkNotNull(issueLinksElement)){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(issueLinksElement.getAsJsonArray());
            	List<IssueLinkBean> issueLinks = IssueLinkParser.parse(list);
            	issueBean.setIssueLinks(issueLinks);
            }
            JsonElement watchesElement = fieldObject.get(ELEM_WATCHES);
            if(checkNotNull(watchesElement)){
            	JsonObject watchesObject = watchesElement.getAsJsonObject();
            	WatchesBean watches = WatchesParser.parse(watchesObject);
            	issueBean.setWatches(watches);
            }
            JsonElement worklogElement = fieldObject.get(ELEM_WORKLOG);
            if(checkNotNull(worklogElement)){
            	JsonObject worklogObject = worklogElement.getAsJsonObject();
            	WorklogSummaryBean worklogs = WorklogSummaryParser.parse(worklogObject);
            	issueBean.setWorklogs(worklogs);
            }
            JsonElement subtasksElement = fieldObject.get(PROP_SUBTASKS);
            if(checkNotNull(subtasksElement)){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(subtasksElement.getAsJsonArray());
            	List<IssueBasicBean> subtasks = IssueBasicParser.parse(list);
            	issueBean.setSubtasks(subtasks);
            }
            JsonElement statusElement = fieldObject.get(ELEM_STATUS);
            if(checkNotNull(statusElement)){
                JsonObject statusObject = statusElement.getAsJsonObject();
                StatusBean status = StatusParser.parse(statusObject);
                issueBean.setStatus(status);
            }
            JsonElement labelsElement = fieldObject.get(PROP_LABELS);
            if(checkNotNull(labelsElement)) {
            	//TODO
            }
            JsonElement workratioElement = fieldObject.get(PROP_WORKRATIO);
            if(checkNotNull(workratioElement)) {
            	issueBean.setWorkratio(workratioElement.getAsInt());
            }
            JsonElement assigneeElement = fieldObject.get(ELEM_ASSIGNEE);
            if(checkNotNull(assigneeElement)){
            	JsonObject assigneeObject = assigneeElement.getAsJsonObject();
            	UserBean assignee = UserParser.parse(assigneeObject);
            	issueBean.setAssignee(assignee);
            }
            JsonElement attachmentElement = fieldObject.get(ELEM_ATTACHMENT);
            if(checkNotNull(attachmentElement)){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(attachmentElement.getAsJsonArray());
            	List<AttachmentBean> attachments = AttachmentParser.parse(list);
            	issueBean.setAttachments(attachments);
            }
            JsonElement projectElement = fieldObject.get(ELEM_PROJECT);
            if(checkNotNull(projectElement)){
            	JsonObject projectObject = projectElement.getAsJsonObject();
            	ProjectBean project = ProjectParser.parse(projectObject);
            	issueBean.setProject(project);
            }
            JsonElement versionElement = fieldObject.get(ELEM_VERSIONS);
            if(checkNotNull(versionElement)){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(versionElement.getAsJsonArray());
            	List<VersionBean> versions = VersionParser.parse(list);
            	issueBean.setVersions(versions);
            }
            JsonElement environmentElement = fieldObject.get(PROP_ENVIRONMENT);
            if(checkNotNull(environmentElement)) {
            	issueBean.setEnvironment(environmentElement.getAsString());
            }
            JsonElement timeestimateElement = fieldObject.get(PROP_TIMEESTIMATE);
            if(checkNotNull(timeestimateElement)) {
            	issueBean.setTimeestimate(timeestimateElement.getAsString());
            }
            JsonElement timeoriginalestimateElement = fieldObject.get(PROP_TIMEORIGINALESTIMATE);
            if(checkNotNull(timeoriginalestimateElement)) {
            	issueBean.setTimeoriginalestimate(timeoriginalestimateElement.getAsString());
            }
            JsonElement aggregatetimespentElement = fieldObject.get(PROP_AGGREGATETIMESPENT);
            if(checkNotNull(aggregatetimespentElement)) {
            	issueBean.setAggregatetimespent(aggregatetimespentElement.getAsString());
            }
            JsonElement aggregateprogressElement = fieldObject.get(ELEM_AGGREGATEPROGRESS);
            if(checkNotNull(aggregateprogressElement)){
            	JsonObject aggregateprogressObject = aggregateprogressElement.getAsJsonObject();
            	AggregateprogressBean aggregateprogress = AggregateprogressParser.parse(aggregateprogressObject);
            	issueBean.setAggregateprogress(aggregateprogress);
            }
            JsonElement lastViewedElement = fieldObject.get(PROP_LAST_VIEWED);
            if(checkNotNull(lastViewedElement)) {
            	Date date = DateParser.parseDateFormat(lastViewedElement.getAsString(), DateParser.Format.YYYY_MM_DD);
            	issueBean.setLastViewed(date);
            }
            JsonElement componentsElement = fieldObject.get(ELEM_COMPONENTS);
            if(checkNotNull(componentsElement)){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(componentsElement.getAsJsonArray());
            	List<ComponentBean> components = ComponentParser.parse(list);
            	issueBean.setComponents(components);
            }
            JsonElement dueDateElement = fieldObject.get(PROP_DUEDATE);
            if(checkNotNull(dueDateElement)){
                String dueDateString = dueDateElement.getAsString();
                Date dueDate = DateParser.parseDateFormat(dueDateString, DateParser.Format.YYYY_MM_DD);
                issueBean.setDueDate(dueDate);
            }
            JsonElement commentElement = fieldObject.get(ELEM_COMMENT);
            if(checkNotNull(commentElement)){
            	JsonObject commentObject = commentElement.getAsJsonObject();
            	CommentSummaryBean comments = CommentSummaryParser.parse(commentObject);
            	issueBean.setComments(comments);
            }
            JsonElement parentElement = fieldObject.get(ELEM_PARENT);
            if(checkNotNull(parentElement)){
            	JsonObject parentObject = parentElement.getAsJsonObject();
            	IssueBasicBean parent = IssueBasicParser.parse(parentObject);
            	issueBean.setParent(parent);
            }
        }
        return issueBean;
    }


    public static List<IssueBean> parse(List<JsonObject> jsonObjects) {
        List<IssueBean> retval = new ArrayList<IssueBean>();
        for (JsonObject jsonObject : jsonObjects) {
              retval.add(parse(jsonObject));
        }
        return retval;
    }
}
