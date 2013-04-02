package de.micromata.jira.rest.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import de.micromata.jira.rest.domain.AggregateprogressBean;
import de.micromata.jira.rest.domain.AttachmentBean;
import de.micromata.jira.rest.domain.CommentSummaryBean;
import de.micromata.jira.rest.domain.ComponentBean;
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
        if(keyElement != null){
            issueBean.setKey(keyElement.getAsString());
        }
        JsonElement expandElement = jsonObject.get(PROP_EXPAND);
        if(expandElement != null){
            issueBean.setExpand(expandElement.getAsString());
        }

        JsonElement fieldsElement = jsonObject.get(ELEM_FIELDS);
        if(fieldsElement != null){
            JsonObject fieldObject = fieldsElement.getAsJsonObject();
            JsonElement summaryElement = fieldObject.get(PROP_SUMMARY);
            if(summaryElement != null){
                issueBean.setSummary(summaryElement.getAsString());
            }
            JsonElement progressElement = fieldObject.get(ELEM_PROGRESS);
            if(progressElement != null) {
            	JsonObject progressObject = progressElement.getAsJsonObject();
            	ProgressBean progress = ProgressParser.parse(progressObject);
            	issueBean.setProgress(progress);
            }
            JsonElement timetrackingElement = fieldObject.get(ELEM_TIMETRACKING);
            if(timetrackingElement != null) {
            	JsonObject timetrackingObject = progressElement.getAsJsonObject();
            	TimetrackingBean timetracking = TimetrackingParser.parse(timetrackingObject);
            	issueBean.setTimetracking(timetracking);
            }
            JsonElement issuetypeElement = fieldObject.get(ELEM_ISSUETYPE);
            if(issuetypeElement != null){
                JsonObject isseuTypeObject = issuetypeElement.getAsJsonObject();
                IssueTypeBean issueType = IssueTypeParser.parse(isseuTypeObject);
                issueBean.setIssueType(issueType);
            }
            JsonElement votesElement = fieldObject.get(ELEM_VOTES);
            if(votesElement != null){
            	JsonObject votesObject = votesElement.getAsJsonObject();
            	VotesBean votes = VotesParser.parse(votesObject);
            	issueBean.setVotes(votes);
            }
            JsonElement resolutionElement = fieldObject.get(PROP_RESOLUTION);
            if(resolutionElement != null && !resolutionElement.isJsonNull()) {
            	JsonObject resolutionObject = resolutionElement.getAsJsonObject();
            	ResolutionBean resolution = ResolutionParser.parse(resolutionObject);
            	issueBean.setResolution(resolution);
            }
            JsonElement resolutionDateElement = fieldObject.get(PROP_RESOLUTIONDATE);
            if(resolutionDateElement != null && !resolutionDateElement.isJsonNull()) {
            	String resolutionDate = resolutionDateElement.getAsString();
            	Date date = DateParser.parseDateFormat1(resolutionDate);
            	issueBean.setResolutionDate(date);
            }
            JsonArray fixVersionArray = fieldObject.getAsJsonArray(PROP_FIX_VERSIONS);
            if(fixVersionArray != null && fixVersionArray.size() > 0) {
            	List<Integer> fixVersions = new ArrayList<>();
            	
            	for(JsonElement j : fixVersionArray) {
					JsonElement element = j.getAsJsonObject().get(PROP_ID);
					fixVersions.add(element.getAsInt());
				}
            	issueBean.setFixVersions(fixVersions);
            }
            JsonElement timeSpentElement = fieldObject.get(PROP_TIMESPENT);
            if(timeSpentElement != null && !timeSpentElement.isJsonNull()) {
            	String timespent = timeSpentElement.getAsString();
            	issueBean.setTimeSpent(timespent);
            }
            JsonElement aggregateTimeOriginalEstimateElement = fieldObject.get(PROP_AGGREGATETIMEORIGINALESTIMATE);
            if(aggregateTimeOriginalEstimateElement != null && !aggregateTimeOriginalEstimateElement.isJsonNull()) {
            	String aggregateTimeOriginalEstimate = aggregateTimeOriginalEstimateElement.getAsString();
            	issueBean.setAggregateTimeOriginalEstimate(aggregateTimeOriginalEstimate);
            }
            JsonElement aggregateTimeEstimateElement = fieldObject.get(PROP_AGGREGATETIMEESTIMATE);
            if(aggregateTimeEstimateElement != null && !aggregateTimeEstimateElement.isJsonNull()) {
            	String aggregateTimeEstimate = aggregateTimeEstimateElement.getAsString();
            	issueBean.setAggregateTimeEstimate(aggregateTimeEstimate);
            }
            JsonElement updatedElement = fieldObject.get(PROP_UPDATED);
            if(updatedElement != null) {
            	Date date = DateParser.parseDateFormat1(updatedElement.getAsString());
            	issueBean.setUpdated(date);
            }
            JsonElement createdElement = fieldObject.get(PROP_CREATED);
            if(createdElement != null) {
            	Date date = DateParser.parseDateFormat1(createdElement.getAsString());
            	issueBean.setCreated(date);
            }
            JsonElement descriptionElement = fieldObject.get(PROP_DESCRIPTION);
            if(descriptionElement != null) {
            	issueBean.setDescription(descriptionElement.getAsString());
            }
            JsonElement reporterElement = fieldObject.get(ELEM_REPORTER);
            if(reporterElement != null){
            	JsonObject reporterObject = reporterElement.getAsJsonObject();
            	UserBean reporter = UserParser.parse(reporterObject);
            	issueBean.setReporter(reporter);
            }
            JsonElement priorityElement = fieldObject.get(ELEM_PRIORITY);
            if(priorityElement != null){
            	JsonObject priorityObject = priorityElement.getAsJsonObject();
            	PriorityBean priority = PriorityParser.parse(priorityObject);
            	issueBean.setPriority(priority);
            }
            JsonArray issueLinksArray = fieldObject.getAsJsonArray(PROP_ISSUELINKS);
            if(issueLinksArray != null && issueLinksArray.size() > 0){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(issueLinksArray);
            	List<IssueLinkBean> issueLinks = IssueLinkParser.parse(list);
            	issueBean.setIssueLinks(issueLinks);
            }
            JsonElement watchesElement = fieldObject.get(ELEM_WATCHES);
            if(watchesElement != null){
            	JsonObject watchesObject = watchesElement.getAsJsonObject();
            	WatchesBean watches = WatchesParser.parse(watchesObject);
            	issueBean.setWatches(watches);
            }
            JsonElement worklogElement = fieldObject.get(ELEM_WORKLOG);
            if(worklogElement != null){
            	JsonObject worklogObject = worklogElement.getAsJsonObject();
            	WorklogSummaryBean worklogs = WorklogSummaryParser.parse(worklogObject);
            	issueBean.setWorklogs(worklogs);
            }
            JsonArray subtasksArray = fieldObject.getAsJsonArray(PROP_SUBTASKS);
            if(subtasksArray != null){
            	//TODO
            }
            JsonElement statusElement = fieldObject.get(ELEM_STATUS);
            if(statusElement != null){
                JsonObject statusObject = statusElement.getAsJsonObject();
                StatusBean status = StatusParser.parse(statusObject);
                issueBean.setStatus(status);
            }
            JsonArray labelsArray = fieldObject.getAsJsonArray(PROP_LABELS);
            if(labelsArray != null) {
            	//TODO
            }
            JsonElement workratioElement = fieldObject.get(PROP_WORKRATIO);
            if(workratioElement != null) {
            	issueBean.setWorkratio(workratioElement.getAsInt());
            }
            JsonElement assigneeElement = fieldObject.get(ELEM_ASSIGNEE);
            if(assigneeElement != null){
            	JsonObject assigneeObject = assigneeElement.getAsJsonObject();
            	UserBean assignee = UserParser.parse(assigneeObject);
            	issueBean.setAssignee(assignee);
            }
            JsonArray attachmentArray = fieldObject.getAsJsonArray(ELEM_ATTACHMENT);
            if(attachmentArray != null && attachmentArray.size() > 0){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(attachmentArray);
            	List<AttachmentBean> attachments = AttachmentParser.parse(list);
            	issueBean.setAttachments(attachments);
            }
            JsonElement projectElement = fieldObject.get(ELEM_PROJECT);
            if(projectElement != null){
            	JsonObject projectObject = projectElement.getAsJsonObject();
            	ProjectBean project = ProjectParser.parse(projectObject);
            	issueBean.setProject(project);
            }
            JsonArray versionArray = fieldObject.getAsJsonArray(ELEM_VERSIONS);
            if(versionArray != null && versionArray.size() > 0){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(attachmentArray);
            	List<VersionBean> versions = VersionParser.parse(list);
            	issueBean.setVersions(versions);
            }
            JsonElement environmentElement = fieldObject.get(PROP_ENVIRONMENT);
            if(environmentElement != null && !environmentElement.isJsonNull()) {
            	issueBean.setEnvironment(environmentElement.getAsString());
            }
            JsonElement timeestimateElement = fieldObject.get(PROP_TIMEESTIMATE);
            if(timeestimateElement != null && !timeestimateElement.isJsonNull()) {
            	issueBean.setTimeestimate(timeestimateElement.getAsString());
            }
            JsonElement timeoriginalestimateElement = fieldObject.get(PROP_TIMEORIGINALESTIMATE);
            if(timeoriginalestimateElement != null && !timeoriginalestimateElement.isJsonNull()) {
            	issueBean.setTimeoriginalestimate(timeoriginalestimateElement.getAsString());
            }
            JsonElement aggregatetimespentElement = fieldObject.get(PROP_AGGREGATETIMESPENT);
            if(aggregatetimespentElement != null && !aggregatetimespentElement.isJsonNull()) {
            	issueBean.setAggregatetimespent(aggregatetimespentElement.getAsString());
            }
            JsonElement aggregateprogressElement = fieldObject.get(ELEM_AGGREGATEPROGRESS);
            if(aggregateprogressElement != null){
            	JsonObject aggregateprogressObject = aggregateprogressElement.getAsJsonObject();
            	AggregateprogressBean aggregateprogress = AggregateprogressParser.parse(aggregateprogressObject);
            	issueBean.setAggregateprogress(aggregateprogress);
            }
            JsonElement lastViewedElement = fieldObject.get(PROP_LAST_VIEWED);
            if(lastViewedElement != null) {
            	Date date = DateParser.parseDateFormat1(lastViewedElement.getAsString());
            	issueBean.setLastViewed(date);
            }
            JsonArray componentArray = fieldObject.getAsJsonArray(ELEM_COMPONENTS);
            if(componentArray != null && componentArray.size() > 0){
            	List<JsonObject> list = GsonParserUtil.parseJsonArray(componentArray);
            	List<ComponentBean> components = ComponentParser.parse(list);
            	issueBean.setComponents(components);
            }
            JsonElement jsonElement = fieldObject.get(PROP_DUEDATE);
            if(jsonElement != null && jsonElement instanceof JsonNull == false){
                String dueDateString = jsonElement.getAsString();
                Date dueDate = DateParser.parseDateFormat1(dueDateString);
                issueBean.setDueDate(dueDate);
            }
            JsonElement commentElement = fieldObject.get(ELEM_COMMENT);
            if(commentElement != null){
            	JsonObject commentObject = commentElement.getAsJsonObject();
            	CommentSummaryBean comments = CommentSummaryParser.parse(commentObject);
            	issueBean.setComments(comments);
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
