package com.example.workflow.rules;

import com.example.workflow.model.Task;
import com.example.workflow.model.TaskType;
import com.example.workflow.model.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class CleanupRule implements WorkflowRule {

    @Override
    public boolean supports(TaskType type) {
        return TaskType.DATA_CLEANUP.equals(type);
    }

    @Override
    public void execute(Task task) {
        // Mock cleanup logic
        System.out.println("CleanupRule executing for task " + task.getTaskId());
        task.setStatus(TaskStatus.COMPLETED);
    }
}
