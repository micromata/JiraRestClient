package de.micromata.jira.rest.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 06.03.13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class IssueBean extends BaseBean {

    private String expand = StringUtils.EMPTY;

    private String key = StringUtils.EMPTY;

    private String summary = StringUtils.EMPTY;

    private IssueTypeBean issueType = null;

    private StatusBean status = null;

    private Date dueDate = null;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public IssueTypeBean getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueTypeBean issueType) {
        this.issueType = issueType;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
