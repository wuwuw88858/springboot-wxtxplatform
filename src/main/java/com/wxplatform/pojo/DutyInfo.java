package com.wxplatform.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DutyInfo implements Serializable {
    private String dutyid;

    private String memberid;

    private String dutyxqday;

    private String dutybegintime;

    private String dutyendtime;

    private int week;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    private String other2;

    public String getDutyid() {
        return dutyid;
    }

    public void setDutyid(String dutyid) {
        this.dutyid = dutyid == null ? null : dutyid.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getDutyxqday() {
        return dutyxqday;
    }

    public void setDutyxqday(String dutyxqday) {
        this.dutyxqday = dutyxqday == null ? null : dutyxqday.trim();
    }

    public String getDutybegintime() {
        return dutybegintime;
    }

    public void setDutybegintime(String dutybegintime) {
        this.dutybegintime = dutybegintime == null ? null : dutybegintime.trim();
    }

    public String getDutyendtime() {
        return dutyendtime;
    }

    public void setDutyendtime(String dutyendtime) {
        this.dutyendtime = dutyendtime == null ? null : dutyendtime.trim();
    }


    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }
}