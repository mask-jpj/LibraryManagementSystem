# Library Management System

## Project Overview
A Java-based Library Management System developed using Java Swing. The application allows users to manage library books through a graphical user interface.

## Features
- Add new books
- View all available books
- Update book information
- Delete books
- Manage book statuses: AVAILABLE, ISSUED, RESERVED
- Validate user input
- Prevent duplicate book IDs

## Technologies Used
- Java
- JDK 17
- Java Swing
- LinkedHashMap
- Git and GitHub

## Project Structure
- `Book.java` — Represents a library book.
- `LibraryManager.java` — Handles book management operations.
- `LibraryGUI.java` — Provides the graphical user interface.
- `docs/` — Generated Javadoc documentation.
- `screenshots/` — Application screenshots.
- `report/` — Project report.

## How to Run

Compile:

```cmd
javac -d out library\*.java
```

Run:

```cmd
java -cp out library.LibraryGUI
```

## Author
Abdullah Shahid

## GitHub Repository
https://github.com/mask-jpj/LibraryManagementSystem