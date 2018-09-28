package com.example.franck.mapchain.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkingHour {

    @SerializedName("break_end_time")
    @Expose
    private String breakEndTime;
    @SerializedName("break_start_time")
    @Expose
    private String breakStartTime;
    @SerializedName("close_time")
    @Expose
    private String closeTime;
    @SerializedName("days")
    @Expose
    private List<String> days = null;
    @SerializedName("open_time")
    @Expose
    private String openTime;

    public String getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(String breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public String getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(String breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

}
