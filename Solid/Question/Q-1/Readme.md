# LLD Practice: Design a Document Editor

## Problem Statement

Design a basic Document Editor in **plain Java**, applying OOP principles and SOLID design principles.

The editor should allow users to create documents containing different types of elements and save them to different storage systems.

### 1. Functional Requirements

Your design must support the following:

1. **Add elements:** Users can add text and images to a document in any order.
2. **Render document:** The editor should render all elements in their original order.
3. **Save document:** Users should be able to save a document to a file or a database.
4. **Extend elements:** The system should support adding new element types without modifying existing core classes.

### 2. Future Requirements

Your design should be extensible enough to support:

- Newline and tab elements.
- Tables and videos.
- Additional rendering behavior in the future.
- New persistence mechanisms beyond files and databases.

You do not need to implement all future features. Your architecture should make adding them straightforward.

### 3. Design Constraints

- Use Java and no frameworks.
- Avoid putting all functionality into one giant class.
- Avoid storing every element as a `String` and identifying its type by checking its contents or file extension.
- Avoid forcing every element type to implement unrelated behavior.
- Avoid tightly coupling document management to a specific storage implementation.
- Do not use `UnsupportedOperationException` as a substitute for a proper design.
- Keep the design as simple as possible without sacrificing extensibility.

### 4. Your Tasks

**Task A — Build the initial design**

Identify the required classes, fields, and methods. You may first sketch a single-class implementation to understand the problem.

**Task B — Identify design problems**

Explain which SOLID principles the initial design violates and why.

**Task C — Refactor the architecture**

Design appropriate abstractions for:

- Document elements.
- Document management.
- Rendering.
- Persistence.

Decide which responsibilities belong in each class. You must justify your decisions rather than create classes mechanically.

**Task D — Apply SOLID**

Explain how your final design addresses:

- SRP — Single Responsibility Principle.
- OCP — Open/Closed Principle.
- LSP — Liskov Substitution Principle.
- ISP — Interface Segregation Principle.
- DIP — Dependency Inversion Principle.

If you believe a principle is not fully satisfied, explain the trade-off.

**Task E — Implement in Java**

Implement the core functionality for:
- `TextElement`
- `ImageElement`
- `Document`
- Rendering
- File persistence
- Database persistence (a mock implementation is acceptable; no real database is required)

Write a small `main` method to demonstrate adding elements, rendering them, and saving the document.

**Task F — Handle change requests**

After your initial implementation, consider these changes:

1. Add a `NewLineElement`. Which existing classes must change?
2. Add a `TableElement`. Can you do so without modifying existing element implementations?
3. Introduce a new storage mechanism. How much existing code must change?
4. Separate document rendering from document management. What improves, and what additional complexity does this introduce?
5. Consider the Principle of Least Knowledge. Does your design create unnecessary chains of object interactions?

### 5. What You Must Submit

1. A class diagram or a written list of classes and relationships.
2. Java code for the core design.
3. A short explanation of each SOLID principle.
4. Your answers to the five change requests.
5. At least two trade-offs or weaknesses in your final design.

### Rules

- Solve this independently before asking for hints.
- Start with the responsibilities and relationships, not the code.
- Don't create abstractions just to claim that you used SOLID.
- Be ready to explain why each class and interface exists.
- You are allowed to make reasonable assumptions, but state them explicitly.

**Goal:** Produce a design you can explain confidently in an LLD interview, not merely code that compiles.