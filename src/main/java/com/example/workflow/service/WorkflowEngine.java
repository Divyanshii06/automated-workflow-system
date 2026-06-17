package com.example.workflow.service;

import com.example.workflow.model.Task;
import com.example.workflow.model.TaskType;
import com.example.workflow.rules.WorkflowRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowEngine {

    private final List<WorkflowRule> rules;

    public WorkflowEngine(List<WorkflowRule> rules) {
        this.rules = rules;
    }

    public Task process(Task task) {
        TaskType type = task.getTaskType();
        for (WorkflowRule rule : rules) {
            if (rule.supports(type)) {
                rule.execute(task);
                return task;
            }
        }
        // if no rule found, mark failed
        task.setStatus(com.example.workflow.model.TaskStatus.FAILED);
        return task;
    }
}
