package de.micromata.jira.rest.core.domain;

import com.google.gson.annotations.Expose;

public class AttachmentMetaBean {

    @Expose
    private boolean enabled;
    @Expose
    private int uploadLimit;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getUploadLimit() {
        return uploadLimit;
    }

    public void setUploadLimit(int uploadLimit) {
        this.uploadLimit = uploadLimit;
    }
}
