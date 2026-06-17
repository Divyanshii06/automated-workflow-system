package com.example.workflow.controller;

import com.example.workflow.model.Task;
import com.example.workflow.repository.TaskRepository;
import com.example.workflow.service.WorkflowEngine;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    private final WorkflowEngine engine;
    private final TaskRepository repository;

    public WorkflowController(WorkflowEngine engine, TaskRepository repository) {
        this.engine = engine;
        this.repository = repository;
    }

    @PostMapping("/execute")
    public ResponseEntity<Task> execute(@Valid @RequestBody Task task) {
        // Save initial state
        Task saved = repository.save(task);
        Task executed = engine.process(saved);
        // Persist updated status
        Task finalTask = repository.save(executed);
        return ResponseEntity.ok(finalTask);
    }
}
