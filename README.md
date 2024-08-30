# Library-Management-System-Console-Application-using-Java-
 # Library Management System

## Overview
This Library Management System is a Java-based application designed to manage library operations such as book management, patron management, borrowing and returning books, reservations, and event management. It uses a layered architecture to promote modularity, maintainability, and scalability.

## System Architecture
The system is built using a layered architecture:
1. Presentation Layer: Handles user interaction (UserInterface class)
2. Business Logic Layer: Contains core functionality (Library, Book, Patron, Reservation, Fine, LibraryEvent classes)
3. Data Access Layer: Manages data storage and retrieval (Inventory class)

## Key Components
- **Library**: Central component managing all operations
- **Book**: Represents a book in the library
- **Patron**: Represents a library patron
- **Inventory**: Manages book quantities
- **Reservation**: Represents a book reservation
- **Fine**: Represents fines imposed on patrons
- **LibraryEvent**: Represents library events

## Data Management
- In-memory storage using Java collections
- Basic search and sorting capabilities
- Events management

## User Interface
- Command-Line Interface (CLI) implemented in the UserInterface class
- Interaction flow managed by the LibraryManager class

## Technologies Used
- Java SE 8 or later
- JUnit 5 for unit testing

## Development Practices
- Modular design
- Test-Driven Development (TDD)

## Running the Application
The application can be run as a standalone Java program. The entry point is the `LibraryManager` class:

```java
public static void main(String[] args) {
    LibraryManager manager = new LibraryManager();
    manager.run();
}
```

## System Requirements
- Java Version: Java SE 8 or later
- Memory: At least 512 MB of RAM

## Future Enhancements
- Persistent storage (database implementation)
- Graphical User Interface (GUI)
- Advanced search features
- Notification system

## Contributing
We welcome contributions to this project. Please feel free to submit pull requests or open issues for any bugs or feature requests.

