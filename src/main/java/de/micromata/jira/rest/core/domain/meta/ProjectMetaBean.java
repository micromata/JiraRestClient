package de.micromata.jira.rest.core.domain.meta;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class ProjectMetaBean extends BaseBean {

    @Expose
    private String key;

    @Expose
    private List<IssueTypeMetaBean> issuetypes = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<IssueTypeMetaBean> getIssuetypes() {
        return issuetypes;
    }

    public void setIssuetypes(List<IssueTypeMetaBean> issuetypes) {
        this.issuetypes = issuetypes;
    }
}
