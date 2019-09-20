package com.wxplatform.pojo;

public class DateTripType {
    private Integer datetriptypeid;

    private String datetripname;

    public Integer getDatetriptypeid() {
        return datetriptypeid;
    }

    public void setDatetriptypeid(Integer datetriptypeid) {
        this.datetriptypeid = datetriptypeid;
    }

    public String getDatetripname() {
        return datetripname;
    }

    public void setDatetripname(String datetripname) {
        this.datetripname = datetripname == null ? null : datetripname.trim();
    }
}