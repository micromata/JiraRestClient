package de.micromata.jira.rest.core.domain.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * User: Christian Schulze (c.schulze@micromata.de)
 * Date: 09.04.16
 */
public class PermissionsBean {

    @SerializedName("VIEW_WORKFLOW_READONLY")
    @Expose
    private PermissionBean viewWorkflowReadonly;

    @SerializedName("CREATE_ISSUES")
    @Expose
    private PermissionBean createIssues;

    @SerializedName("BULK_CHANGE")
    @Expose
    private PermissionBean bulkChange;

    @SerializedName("CREATE_ATTACHMENT")
    @Expose
    private PermissionBean createAttachment;

    @SerializedName("DELETE_OWN_COMMENTS")
    @Expose
    private PermissionBean deleteOwnComments;

    @SerializedName("WORK_ON_ISSUES")
    @Expose
    private PermissionBean workOnIssues;

    @SerializedName("PROJECT_ADMIN")
    @Expose
    private PermissionBean projectAdmin;

    @SerializedName("COMMENT_EDIT_ALL")
    @Expose
    private PermissionBean commentEditAll;

    @SerializedName("ATTACHMENT_DELETE_OWN")
    @Expose
    private PermissionBean attachmentDeleteOwn;

    @SerializedName("WORKLOG_DELETE_OWN")
    @Expose
    private PermissionBean worklogDeleteOwn;

    @SerializedName("CLOSE_ISSUE")
    @Expose
    private PermissionBean closeIssue;

    @SerializedName("MANAGE_WATCHER_LIST")
    @Expose
    private PermissionBean manageWatcherList;

    @SerializedName("VIEW_VOTERS_AND_WATCHERS")
    @Expose
    private PermissionBean viewVotersAndWatchers;

    @SerializedName("ADD_COMMENTS")
    @Expose
    private PermissionBean addComments;

    @SerializedName("COMMENT_DELETE_ALL")
    @Expose
    private PermissionBean commentDeleteAll;

    @SerializedName("CREATE_ISSUE")
    @Expose
    private PermissionBean createIssue;

    @SerializedName("DELETE_OWN_ATTACHMENTS")
    @Expose
    private PermissionBean deleteOwnAttachments;

    @SerializedName("ASSIGN_ISSUE")
    @Expose
    private PermissionBean assignIssue;

    @SerializedName("LINK_ISSUE")
    @Expose
    private PermissionBean linkIssue;

    @SerializedName("EDIT_OWN_WORKLOGS")
    @Expose
    private PermissionBean editOwnWorklogs;

    @SerializedName("CREATE_ATTACHMENTS")
    @Expose
    private PermissionBean createAttachments;

    @SerializedName("EDIT_ALL_WORKLOGS")
    @Expose
    private PermissionBean editAllWorklogs;

    @SerializedName("SCHEDULE_ISSUE")
    @Expose
    private PermissionBean scheduleIssue;

    @SerializedName("CLOSE_ISSUES")
    @Expose
    private PermissionBean closeIssues;

    @SerializedName("SET_ISSUE_SECURITY")
    @Expose
    private PermissionBean setIssueSecurity;

    @SerializedName("SCHEDULE_ISSUES")
    @Expose
    private PermissionBean scheduleIssues;

    @SerializedName("WORKLOG_DELETE_ALL")
    @Expose
    private PermissionBean worklogDeleteAll;

    @SerializedName("COMMENT_DELETE_OWN")
    @Expose
    private PermissionBean commentDeleteOwn;

    @SerializedName("ADMINISTER_PROJECTS")
    @Expose
    private PermissionBean administerProjects;

    @SerializedName("DELETE_ALL_COMMENTS")
    @Expose
    private PermissionBean deleteAllComments;

    @SerializedName("RESOLVE_ISSUES")
    @Expose
    private PermissionBean resolveIssues;

    @SerializedName("VIEW_READONLY_WORKFLOW")
    @Expose
    private PermissionBean viewReadonlyWorkflow;

    @SerializedName("ADMINISTER")
    @Expose
    private PermissionBean administer;

    @SerializedName("MOVE_ISSUES")
    @Expose
    private PermissionBean moveIssues;

    @SerializedName("TRANSITION_ISSUES")
    @Expose
    private PermissionBean transitionIssues;

    @SerializedName("SYSTEM_ADMIN")
    @Expose
    private PermissionBean systemAdmin;

    @SerializedName("DELETE_OWN_WORKLOGS")
    @Expose
    private PermissionBean deleteOwnWorklogs;

    @SerializedName("BROWSE")
    @Expose
    private PermissionBean brwose;

    @SerializedName("EDIT_ISSUE")
    @Expose
    private PermissionBean editIssue;

    @SerializedName("MODIFY_REPORTER")
    @Expose
    private PermissionBean modifyReporter;

    @SerializedName("EDIT_ISSUES")
    @Expose
    private PermissionBean editIssues;

    @SerializedName("MANAGE_WATCHERS")
    @Expose
    private PermissionBean manageWatchers;

    @SerializedName("EDIT_OWN_COMMENTS")
    @Expose
    private PermissionBean editOwnComments;

    @SerializedName("ASSIGN_ISSUES")
    @Expose
    private PermissionBean assignIssues;

    @SerializedName("BROWSE_PROJECTS")
    @Expose
    private PermissionBean browseProjects;

    @SerializedName("VIEW_VERSION_CONTROL")
    @Expose
    private PermissionBean viewVersionControl;

    @SerializedName("WORK_ISSUE")
    @Expose
    private PermissionBean workIssue;

    @SerializedName("COMMENT_ISSUE")
    @Expose
    private PermissionBean commentIssue;

    @SerializedName("WORKLOG_EDIT_ALL")
    @Expose
    private PermissionBean worklogEditAll;

    @SerializedName("EDIT_ALL_COMMENTS")
    @Expose
    private PermissionBean editAllComments;

    @SerializedName("DELETE_ISSUE")
    @Expose
    private PermissionBean deleteIssue;

    @SerializedName("USER_PICKER")
    @Expose
    private PermissionBean userPicker;

    @SerializedName("CREATE_SHARED_OBJECTS")
    @Expose
    private PermissionBean createSharedObjects;

    @SerializedName("ATTACHMENT_DELETE_ALL")
    @Expose
    private PermissionBean attachmentDeleteAll;

    @SerializedName("DELETE_ISSUES")
    @Expose
    private PermissionBean deleteIssues;

    @SerializedName("MANAGE_GROUP_FILTER_SUBSCRIPTIONS")
    @Expose
    private PermissionBean manageGroupFilterSubscriptions;

    @SerializedName("RESOLVE_ISSUE")
    @Expose
    private PermissionBean resolveIssue;

    @SerializedName("ASSIGNABLE_USER")
    @Expose
    private PermissionBean assignableUser;

    @SerializedName("TRANSITION_ISSUE")
    @Expose
    private PermissionBean transitionIssue;

    @SerializedName("COMMENT_EDIT_OWN")
    @Expose
    private PermissionBean commentEditOwn;

    @SerializedName("MOVE_ISSUE")
    @Expose
    private PermissionBean moveIssue;

    @SerializedName("WORKLOG_EDIT_OWN")
    @Expose
    private PermissionBean worklogEditOwn;

    @SerializedName("DELETE_ALL_WORKLOGS")
    @Expose
    private PermissionBean deleteAllWorklogs;

    @SerializedName("LINK_ISSUES")
    @Expose
    private PermissionBean linkIssues;

    public PermissionBean getViewWorkflowReadonly() {
        return viewWorkflowReadonly;
    }

    public void setViewWorkflowReadonly(PermissionBean viewWorkflowReadonly) {
        this.viewWorkflowReadonly = viewWorkflowReadonly;
    }

    public PermissionBean getCreateIssues() {
        return createIssues;
    }

    public void setCreateIssues(PermissionBean createIssues) {
        this.createIssues = createIssues;
    }

    public PermissionBean getBulkChange() {
        return bulkChange;
    }

    public void setBulkChange(PermissionBean bulkChange) {
        this.bulkChange = bulkChange;
    }

    public PermissionBean getCreateAttachment() {
        return createAttachment;
    }

    public void setCreateAttachment(PermissionBean createAttachment) {
        this.createAttachment = createAttachment;
    }

    public PermissionBean getDeleteOwnComments() {
        return deleteOwnComments;
    }

    public void setDeleteOwnComments(PermissionBean deleteOwnComments) {
        this.deleteOwnComments = deleteOwnComments;
    }

    public PermissionBean getWorkOnIssues() {
        return workOnIssues;
    }

    public void setWorkOnIssues(PermissionBean workOnIssues) {
        this.workOnIssues = workOnIssues;
    }

    public PermissionBean getProjectAdmin() {
        return projectAdmin;
    }

    public void setProjectAdmin(PermissionBean projectAdmin) {
        this.projectAdmin = projectAdmin;
    }

    public PermissionBean getCommentEditAll() {
        return commentEditAll;
    }

    public void setCommentEditAll(PermissionBean commentEditAll) {
        this.commentEditAll = commentEditAll;
    }

    public PermissionBean getAttachmentDeleteOwn() {
        return attachmentDeleteOwn;
    }

    public void setAttachmentDeleteOwn(PermissionBean attachmentDeleteOwn) {
        this.attachmentDeleteOwn = attachmentDeleteOwn;
    }

    public PermissionBean getWorklogDeleteOwn() {
        return worklogDeleteOwn;
    }

    public void setWorklogDeleteOwn(PermissionBean worklogDeleteOwn) {
        this.worklogDeleteOwn = worklogDeleteOwn;
    }

    public PermissionBean getCloseIssue() {
        return closeIssue;
    }

    public void setCloseIssue(PermissionBean closeIssue) {
        this.closeIssue = closeIssue;
    }

    public PermissionBean getManageWatcherList() {
        return manageWatcherList;
    }

    public void setManageWatcherList(PermissionBean manageWatcherList) {
        this.manageWatcherList = manageWatcherList;
    }

    public PermissionBean getViewVotersAndWatchers() {
        return viewVotersAndWatchers;
    }

    public void setViewVotersAndWatchers(PermissionBean viewVotersAndWatchers) {
        this.viewVotersAndWatchers = viewVotersAndWatchers;
    }

    public PermissionBean getAddComments() {
        return addComments;
    }

    public void setAddComments(PermissionBean addComments) {
        this.addComments = addComments;
    }

    public PermissionBean getCommentDeleteAll() {
        return commentDeleteAll;
    }

    public void setCommentDeleteAll(PermissionBean commentDeleteAll) {
        this.commentDeleteAll = commentDeleteAll;
    }

    public PermissionBean getCreateIssue() {
        return createIssue;
    }

    public void setCreateIssue(PermissionBean createIssue) {
        this.createIssue = createIssue;
    }

    public PermissionBean getDeleteOwnAttachments() {
        return deleteOwnAttachments;
    }

    public void setDeleteOwnAttachments(PermissionBean deleteOwnAttachments) {
        this.deleteOwnAttachments = deleteOwnAttachments;
    }

    public PermissionBean getAssignIssue() {
        return assignIssue;
    }

    public void setAssignIssue(PermissionBean assignIssue) {
        this.assignIssue = assignIssue;
    }

    public PermissionBean getLinkIssue() {
        return linkIssue;
    }

    public void setLinkIssue(PermissionBean linkIssue) {
        this.linkIssue = linkIssue;
    }

    public PermissionBean getEditOwnWorklogs() {
        return editOwnWorklogs;
    }

    public void setEditOwnWorklogs(PermissionBean editOwnWorklogs) {
        this.editOwnWorklogs = editOwnWorklogs;
    }

    public PermissionBean getCreateAttachments() {
        return createAttachments;
    }

    public void setCreateAttachments(PermissionBean createAttachments) {
        this.createAttachments = createAttachments;
    }

    public PermissionBean getEditAllWorklogs() {
        return editAllWorklogs;
    }

    public void setEditAllWorklogs(PermissionBean editAllWorklogs) {
        this.editAllWorklogs = editAllWorklogs;
    }

    public PermissionBean getScheduleIssue() {
        return scheduleIssue;
    }

    public void setScheduleIssue(PermissionBean scheduleIssue) {
        this.scheduleIssue = scheduleIssue;
    }

    public PermissionBean getCloseIssues() {
        return closeIssues;
    }

    public void setCloseIssues(PermissionBean closeIssues) {
        this.closeIssues = closeIssues;
    }

    public PermissionBean getSetIssueSecurity() {
        return setIssueSecurity;
    }

    public void setSetIssueSecurity(PermissionBean setIssueSecurity) {
        this.setIssueSecurity = setIssueSecurity;
    }

    public PermissionBean getScheduleIssues() {
        return scheduleIssues;
    }

    public void setScheduleIssues(PermissionBean scheduleIssues) {
        this.scheduleIssues = scheduleIssues;
    }

    public PermissionBean getWorklogDeleteAll() {
        return worklogDeleteAll;
    }

    public void setWorklogDeleteAll(PermissionBean worklogDeleteAll) {
        this.worklogDeleteAll = worklogDeleteAll;
    }

    public PermissionBean getCommentDeleteOwn() {
        return commentDeleteOwn;
    }

    public void setCommentDeleteOwn(PermissionBean commentDeleteOwn) {
        this.commentDeleteOwn = commentDeleteOwn;
    }

    public PermissionBean getAdministerProjects() {
        return administerProjects;
    }

    public void setAdministerProjects(PermissionBean administerProjects) {
        this.administerProjects = administerProjects;
    }

    public PermissionBean getDeleteAllComments() {
        return deleteAllComments;
    }

    public void setDeleteAllComments(PermissionBean deleteAllComments) {
        this.deleteAllComments = deleteAllComments;
    }

    public PermissionBean getResolveIssues() {
        return resolveIssues;
    }

    public void setResolveIssues(PermissionBean resolveIssues) {
        this.resolveIssues = resolveIssues;
    }

    public PermissionBean getViewReadonlyWorkflow() {
        return viewReadonlyWorkflow;
    }

    public void setViewReadonlyWorkflow(PermissionBean viewReadonlyWorkflow) {
        this.viewReadonlyWorkflow = viewReadonlyWorkflow;
    }

    public PermissionBean getAdminister() {
        return administer;
    }

    public void setAdminister(PermissionBean administer) {
        this.administer = administer;
    }

    public PermissionBean getMoveIssues() {
        return moveIssues;
    }

    public void setMoveIssues(PermissionBean moveIssues) {
        this.moveIssues = moveIssues;
    }

    public PermissionBean getTransitionIssues() {
        return transitionIssues;
    }

    public void setTransitionIssues(PermissionBean transitionIssues) {
        this.transitionIssues = transitionIssues;
    }

    public PermissionBean getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(PermissionBean systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public PermissionBean getDeleteOwnWorklogs() {
        return deleteOwnWorklogs;
    }

    public void setDeleteOwnWorklogs(PermissionBean deleteOwnWorklogs) {
        this.deleteOwnWorklogs = deleteOwnWorklogs;
    }

    public PermissionBean getBrwose() {
        return brwose;
    }

    public void setBrwose(PermissionBean brwose) {
        this.brwose = brwose;
    }

    public PermissionBean getEditIssue() {
        return editIssue;
    }

    public void setEditIssue(PermissionBean editIssue) {
        this.editIssue = editIssue;
    }

    public PermissionBean getModifyReporter() {
        return modifyReporter;
    }

    public void setModifyReporter(PermissionBean modifyReporter) {
        this.modifyReporter = modifyReporter;
    }

    public PermissionBean getEditIssues() {
        return editIssues;
    }

    public void setEditIssues(PermissionBean editIssues) {
        this.editIssues = editIssues;
    }

    public PermissionBean getManageWatchers() {
        return manageWatchers;
    }

    public void setManageWatchers(PermissionBean manageWatchers) {
        this.manageWatchers = manageWatchers;
    }

    public PermissionBean getEditOwnComments() {
        return editOwnComments;
    }

    public void setEditOwnComments(PermissionBean editOwnComments) {
        this.editOwnComments = editOwnComments;
    }

    public PermissionBean getAssignIssues() {
        return assignIssues;
    }

    public void setAssignIssues(PermissionBean assignIssues) {
        this.assignIssues = assignIssues;
    }

    public PermissionBean getBrowseProjects() {
        return browseProjects;
    }

    public void setBrowseProjects(PermissionBean browseProjects) {
        this.browseProjects = browseProjects;
    }

    public PermissionBean getViewVersionControl() {
        return viewVersionControl;
    }

    public void setViewVersionControl(PermissionBean viewVersionControl) {
        this.viewVersionControl = viewVersionControl;
    }

    public PermissionBean getWorkIssue() {
        return workIssue;
    }

    public void setWorkIssue(PermissionBean workIssue) {
        this.workIssue = workIssue;
    }

    public PermissionBean getCommentIssue() {
        return commentIssue;
    }

    public void setCommentIssue(PermissionBean commentIssue) {
        this.commentIssue = commentIssue;
    }

    public PermissionBean getWorklogEditAll() {
        return worklogEditAll;
    }

    public void setWorklogEditAll(PermissionBean worklogEditAll) {
        this.worklogEditAll = worklogEditAll;
    }

    public PermissionBean getEditAllComments() {
        return editAllComments;
    }

    public void setEditAllComments(PermissionBean editAllComments) {
        this.editAllComments = editAllComments;
    }

    public PermissionBean getDeleteIssue() {
        return deleteIssue;
    }

    public void setDeleteIssue(PermissionBean deleteIssue) {
        this.deleteIssue = deleteIssue;
    }

    public PermissionBean getUserPicker() {
        return userPicker;
    }

    public void setUserPicker(PermissionBean userPicker) {
        this.userPicker = userPicker;
    }

    public PermissionBean getCreateSharedObjects() {
        return createSharedObjects;
    }

    public void setCreateSharedObjects(PermissionBean createSharedObjects) {
        this.createSharedObjects = createSharedObjects;
    }

    public PermissionBean getAttachmentDeleteAll() {
        return attachmentDeleteAll;
    }

    public void setAttachmentDeleteAll(PermissionBean attachmentDeleteAll) {
        this.attachmentDeleteAll = attachmentDeleteAll;
    }

    public PermissionBean getDeleteIssues() {
        return deleteIssues;
    }

    public void setDeleteIssues(PermissionBean deleteIssues) {
        this.deleteIssues = deleteIssues;
    }

    public PermissionBean getManageGroupFilterSubscriptions() {
        return manageGroupFilterSubscriptions;
    }

    public void setManageGroupFilterSubscriptions(PermissionBean manageGroupFilterSubscriptions) {
        this.manageGroupFilterSubscriptions = manageGroupFilterSubscriptions;
    }

    public PermissionBean getResolveIssue() {
        return resolveIssue;
    }

    public void setResolveIssue(PermissionBean resolveIssue) {
        this.resolveIssue = resolveIssue;
    }

    public PermissionBean getAssignableUser() {
        return assignableUser;
    }

    public void setAssignableUser(PermissionBean assignableUser) {
        this.assignableUser = assignableUser;
    }

    public PermissionBean getTransitionIssue() {
        return transitionIssue;
    }

    public void setTransitionIssue(PermissionBean transitionIssue) {
        this.transitionIssue = transitionIssue;
    }

    public PermissionBean getCommentEditOwn() {
        return commentEditOwn;
    }

    public void setCommentEditOwn(PermissionBean commentEditOwn) {
        this.commentEditOwn = commentEditOwn;
    }

    public PermissionBean getMoveIssue() {
        return moveIssue;
    }

    public void setMoveIssue(PermissionBean moveIssue) {
        this.moveIssue = moveIssue;
    }

    public PermissionBean getWorklogEditOwn() {
        return worklogEditOwn;
    }

    public void setWorklogEditOwn(PermissionBean worklogEditOwn) {
        this.worklogEditOwn = worklogEditOwn;
    }

    public PermissionBean getDeleteAllWorklogs() {
        return deleteAllWorklogs;
    }

    public void setDeleteAllWorklogs(PermissionBean deleteAllWorklogs) {
        this.deleteAllWorklogs = deleteAllWorklogs;
    }

    public PermissionBean getLinkIssues() {
        return linkIssues;
    }

    public void setLinkIssues(PermissionBean linkIssues) {
        this.linkIssues = linkIssues;
    }
}
