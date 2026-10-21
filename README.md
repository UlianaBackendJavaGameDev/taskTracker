# Console Task Tracker (Java Core Architecture Showcase)

A robust, console-based Task Management System built with pure Java SE. This project is designed to showcase modern object-oriented programming (OOP) principles, clean code architecture, and foundational enterprise design patterns without relying on heavy frameworks like Spring.

## 🚀 Key Architectural Features Implemented

*   **Dependency Injection (DI):** De-coupled business logic (`TaskService`) from data storage (`TaskRepository`) via constructor injection. This makes the architecture flexible, maintainable, and open for future database integration (e.g., Hibernate).
*   **Builder Pattern:** Implemented a custom nested `Builder` class for the `Task` entity to provide a clean, fluent API for object creation, avoiding the "telescoping constructor" anti-pattern.
*   **Singleton Pattern:** Covered the `InMemoryTaskRepository` with a thread-safe-ready Singleton structure (`getInstance()`) to guarantee a single source of truth for in-memory data across the entire application.
*   **Robust Exception Handling & Validation:** Utilized clean input validation with runtime exceptions (`IllegalArgumentException`) to prevent system misbehavior (e.g., handling negative IDs) alongside proper `try-catch` blocks.
*   **Modern Java Features:** Leveraged `java.util.Optional` API (`ifPresentOrElse`) for clean, safe handling of nullable data and preventing the infamous `NullPointerException`.
*   **Java Collections Framework:** Managed in-memory state using heavily optimized core interfaces (`List` / `ArrayList`).

## 🛠️ Technology Stack

*   **Language:** Java 8+ (Pure Java SE)
*   **Build/IDE System:** IntelliJ IDEA native project structure
*   **Version Control:** Git & GitHub

## 🏃 How to Run the Application

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com
   ```
2. Open the project root folder in IntelliJ IDEA.
3. Locate the `Main.java` file inside the package/directory.
4. Run the `main` method. The application will execute a series of simulated lifecycle steps (creating tasks, completing tasks, verifying error boundaries) and print clean logs directly to the system console.
