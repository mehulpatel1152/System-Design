# SRP Practice: Student Result Management System

## Problem Statement

Build a simple Java application that manages student results while following the **Single Responsibility Principle (SRP)**.

Initially, implement the required functionality and then refactor the design so that each class has a single, well-defined responsibility.

## Requirements

The application must support the following features:

1. **Student Information:** Store a student's name, roll number, and marks in three subjects.
2. **Result Calculation:** Calculate the student's total marks, percentage, and grade.
3. **Data Validation:** Validate student information. Marks must be between 0 and 100.
4. **File Storage:** Save student result details to a text file.
5. **Result Report:** Generate a formatted result report and display it on the console.

## Constraints

- Use core Java only.
- Do not use frameworks, databases, or external libraries.
- Use standard Java file-handling APIs for file operations.
- Apply SRP while designing and refactoring the classes.

## Tasks

1. Identify the responsibilities required to implement the application.
2. Design the initial class structure and define the methods for each class.
3. Implement all the required functionality.
4. Identify classes that have multiple reasons to change.
5. Refactor the design to follow SRP.
6. Test the application with valid and invalid student data.

## Interview Challenge

Consider the following requirement changes:

- The college changes its grading rules.
- The storage format changes from a text file to a different format.
- The result report layout is redesigned.

Determine which classes should change for each requirement and which classes should remain unaffected.

Justify your design decisions using the Single Responsibility Principle.

## Learning Objective

Develop practical skills in object-oriented design, responsibility separation, refactoring, and explaining design decisions in technical interviews.

## Completion Criteria

- [ ] All requirements are implemented.
- [ ] Valid and invalid inputs are handled correctly.
- [ ] Student results are calculated correctly.
- [ ] Results are saved and reports are displayed successfully.
- [ ] Each class has a clearly defined responsibility.
- [ ] Requirement changes affect only the relevant classes where possible.
- [ ] Design decisions can be explained clearly in an interview.