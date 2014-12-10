package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class ProgressBean {

    @Expose
    private Integer percent;
    @Expose
    private Integer progress;
    @Expose
    private Integer total;

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
