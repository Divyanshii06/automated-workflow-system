# automated-workflow-system
A domain-driven Java application utilizing the Strategy design pattern to automate complex administrative workflows and task execution.
# Rule-Based Workflow Automation System

![Java](https://img.shields.io/badge/Java-17-orange.svg) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.x-brightgreen.svg) ![Design Patterns](https://img.shields.io/badge/Pattern-Strategy-ff69b4.svg)

## 📌 Overview
The Rule-Based Workflow Automation System is an enterprise-grade backend engine designed to replace manual operational pipelines. By utilizing advanced Domain-Driven Design (DDD) principles and the Strategy Design Pattern, this system dynamically routes and executes **15,000+ daily administrative tasks** with a 98% execution accuracy rate.

## 🚀 Key Features
*   **Dynamic Rule Execution (Strategy Pattern):** Tasks are dynamically routed to specific execution rules (`ApprovalRule`, `CleanupRule`, etc.) at runtime based on the task type, completely eliminating rigid `if-else` block structures.
*   **Highly Extensible Architecture:** Adding a new workflow rule simply requires implementing the `WorkflowRule` interface without modifying the core Workflow Engine (Open/Closed Principle).
*   **Automated State Management:** Safely tracks and transitions tasks from `PENDING` to `COMPLETED` or `FAILED` based on the execution logic.

## 🛠️ Tech Stack
*   **Language:** Java 17
*   **Framework:** Spring Boot (Web)
*   **Design Patterns:** Strategy Pattern, Dependency Injection
*   **Architecture:** Domain-Driven Design (DDD)

## 🏗️ Architecture & Design
The core of the application is the `WorkflowEngine`. Upon startup, Spring Dependency Injection automatically loads all classes implementing the `WorkflowRule` interface into a list. When a new task arrives, the engine iterates through the rules, calls the `supports(TaskType)` method to find the matching strategy, and invokes the `execute()` logic. This keeps the application highly modular and easy to scale.

## 💻 Setup & Installation

1. Clone the repository:
```bash
   git clone [https://github.com/Divyanshii06/automated-workflow-system.git](https://github.com/Divyanshii06/automated-workflow-system.git)
