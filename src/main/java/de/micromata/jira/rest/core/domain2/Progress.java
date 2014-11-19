
package de.micromata.jira.rest.core.domain2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Progress {

    @Expose
    private Integer percent;
    @Expose
    private Integer progress;
    @Expose
    private Integer total;

    /**
     * 
     * @return
     *     The percent
     */
    public Integer getPercent() {
        return percent;
    }

    /**
     * 
     * @param percent
     *     The percent
     */
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    /**
     * 
     * @return
     *     The progress
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * 
     * @param progress
     *     The progress
     */
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

}
