package de.micromata.jira.rest.core.domain.system;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 11.09.2016.
 */
public class TimeTrackingConfigurationBean {

    @Expose
    private Integer  workingHoursPerDay;

    @Expose
    private Integer workingDaysPerWeek;

    @Expose
    private String timeFormat;

    @Expose
    private String defaultUnit;

    public Integer getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public Integer getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(Integer workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }
}
