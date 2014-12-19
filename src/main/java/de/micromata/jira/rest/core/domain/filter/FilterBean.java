
package de.micromata.jira.rest.core.domain.filter;

import com.google.gson.annotations.Expose;
import de.micromata.jira.rest.core.domain.UserBean;

import java.util.ArrayList;
import java.util.List;

public class FilterBean {

    @Expose
    private String self;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private UserBean owner;
    @Expose
    private String jql;
    @Expose
    private String viewUrl;
    @Expose
    private String searchUrl;
    @Expose
    private Boolean favourite;
    @Expose
    private List<Object> sharePermissions = new ArrayList<Object>();
    @Expose
    private SharedUsers sharedUsers;
    @Expose
    private Subscriptions subscriptions;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJql() {
        return jql;
    }

    public void setJql(String jql) {
        this.jql = jql;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBean getOwner() {
        return owner;
    }

    public void setOwner(UserBean owner) {
        this.owner = owner;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public SharedUsers getSharedUsers() {
        return sharedUsers;
    }

    public void setSharedUsers(SharedUsers sharedUsers) {
        this.sharedUsers = sharedUsers;
    }

    public List<Object> getSharePermissions() {
        return sharePermissions;
    }

    public void setSharePermissions(List<Object> sharePermissions) {
        this.sharePermissions = sharePermissions;
    }

    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
}
