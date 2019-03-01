package com.yy.base.config.logger;

/**
 * 用于记录具体的每个方法的执行时间的功能
 */
public class TimeEntity {

    private Long startTime;
    private Long endTime;


    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
