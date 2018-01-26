package de.micromata.jira.rest.core.domain.filter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SharedUsers {

    @Expose
    private Integer size;
    @Expose
    private List<Object> items = new ArrayList<>();
    @SerializedName("max-results")
    @Expose
    private Integer maxResults;
    @SerializedName("start-index")
    @Expose
    private Integer startIndex;
    @SerializedName("end-index")
    @Expose
    private Integer endIndex;

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
