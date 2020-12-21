package com.mikehenry.springbootjpabeginner.response;

import com.mikehenry.springbootjpabeginner.model.Tasks;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private long taskID;
    private String taskName;

    public TaskResponse(Tasks tasks) {
        this.taskID = tasks.getTaskID();
        this.taskName = tasks.getTaskName();
    }
}
