package com.example.workflow.rules;

import com.example.workflow.model.Task;
import com.example.workflow.model.TaskType;

public interface WorkflowRule {
    boolean supports(TaskType type);
    void execute(Task task);
}
