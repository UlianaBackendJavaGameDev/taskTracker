# Console tasktracker.model.Task Tracker (Java Core Architecture Showcase)

A robust, console-based tasktracker.model.Task Management System built with pure Java SE. This project is designed to showcase modern object-oriented programming (OOP) principles, clean code architecture, foundational enterprise design patterns, persistent state management, and functional programming concepts without relying on heavy frameworks like Spring.

## 🚀 Key Architectural Features Implemented

*   **Functional Programming & Stream API:** Heavily utilized Java 8+ Functional Programming paradigms. Implemented declarative data pipelines using Stream API and custom lambda expressions (`->`). Showcased functional transformations using `Function` mappers (transforming `tasktracker.model.Task` entities into `String` titles via `.map()`) and `Predicate` filters for clean, side-effect-free data processing.
*   **Generics (Generics Framework):** Created a custom generic container (`Box<T>`) to demonstrate compile-time type safety and code reusability. Showcased how Java enforces strict type checking for distinct models (handling both `String` and `tasktracker.model.Task` types) without runtime type casting.
*   **Java I/O Streams (Persistent Storage):** Migrated from temporary RAM storage to hard drive persistence. Implemented `tasktracker.repository.FileTaskRepository` using `BufferedReader`, `PrintWriter`, and `FileWriter` with clean string parsing (`split("\\|")`) to store tasks securely inside a local `task.txt` file. State is preserved perfectly across application restarts.
*   **Dependency Injection (DI):** Demonstrated loose coupling by binding the business logic (`tasktracker.service.TaskService`) to the data layer via the `tasktracker.repository.TaskRepository` interface using constructor injection. Switching from in-memory arrays to local files required changing exactly one line of code in the `Main` launcher.
*   **Builder Pattern:** Implemented a custom static nested `Builder` class inside the `tasktracker.model.Task` entity to provide a clean, fluent API for object generation. This prevents the "telescoping constructor" anti-pattern and handles multi-field parameters beautifully.
*   **Singleton Pattern:** Secured the data repository structure using a classic thread-safe-ready Singleton setup (`getInstance()`) ensuring a single source of truth for repository components where required.
*   **Robust Exception Handling & Validation:** Utilized precise data input validation at the service boundary. The application actively checks for semantic errors (like negative IDs) and throws an un-checked `IllegalArgumentException`, which is caught via structured `try-catch` blocks to ensure fault tolerance.
*   **Modern Java Safety:** Extensively utilized `java.util.Optional` API (`ifPresentOrElse`) to handle query misses safely, eliminating the risk of `NullPointerException`.

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
3. Locate the `Main.java` file and click **Run**.
4. The system will read existing data from `task.txt`, simulate a standard backend workflow (creating tasks, completing tasks, running custom Stream API functional queries, executing Generic tests, and verifying error handling with `try-catch`), and safely update the file back on your disk.
