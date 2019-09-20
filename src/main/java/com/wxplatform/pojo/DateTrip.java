package com.wxplatform.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateTrip implements Serializable {
    private String datetripid;

    private String date;

    private String time;

    private Integer week;

    private String xqday;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer datetriptype;

    private String datetripcontent;

    private String participants;

    private String hostdepartment;

    private String place;

    private String editor;

    private String membername;

    private String tripstatus;

    private String datetripname;

    public String getDatetripName() {
        return datetripname;
    }

    public void setDatetripName(String datetripname) {
        this.datetripname = datetripname == null ? null : datetripname.trim();
    }

    public String getDatetripid() {
        return datetripid;
    }

    public void setDatetripid(String datetripid) {
        this.datetripid = datetripid == null ? null : datetripid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getXqday() {
        return xqday;
    }

    public void setXqday(String xqday) {
        this.xqday = xqday == null ? null : xqday.trim();
    }

    public Integer getDatetriptype() {
        return datetriptype;
    }

    public void setDatetriptype(Integer datetriptype) {
        this.datetriptype = datetriptype;
    }

    public String getDatetripcontent() {
        return datetripcontent;
    }

    public void setDatetripcontent(String datetripcontent) {
        this.datetripcontent = datetripcontent == null ? null : datetripcontent.trim();
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants == null ? null : participants.trim();
    }

    public String getHostdepartment() {
        return hostdepartment;
    }

    public void setHostdepartment(String hostdepartment) {
        this.hostdepartment = hostdepartment == null ? null : hostdepartment.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getTripstatus() {
        return tripstatus;
    }

    public void setTripstatus(String tripstatus) {
        this.tripstatus = tripstatus == null ? null : tripstatus.trim();
    }
}