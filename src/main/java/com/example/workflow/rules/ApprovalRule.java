package com.example.workflow.rules;

import com.example.workflow.model.Task;
import com.example.workflow.model.TaskType;
import com.example.workflow.model.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class ApprovalRule implements WorkflowRule {

    @Override
    public boolean supports(TaskType type) {
        return TaskType.APPROVAL.equals(type);
    }

    @Override
    public void execute(Task task) {
        // Mock approval logic
        System.out.println("ApprovalRule executing for task " + task.getTaskId());
        task.setStatus(TaskStatus.COMPLETED);
    }
}
