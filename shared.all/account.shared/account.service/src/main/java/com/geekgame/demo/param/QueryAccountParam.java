package com.geekgame.demo.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geekgame.demo.model.Paging;

import java.time.LocalDateTime;

public class QueryAccountParam extends Paging {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
