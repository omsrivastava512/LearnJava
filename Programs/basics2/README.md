# Java Basics 2 Programs

This folder contains intermediate Java programming exercises focusing on advanced OOP concepts, method overloading, and constructor chaining.

## 📁 Programs Overview

### 1. **AreaCalculator.java**
- **Purpose**: Calculate areas of different geometric shapes using method overloading
- **Key Features**:
  - Method overloading with different parameter types
  - Shape-specific area calculations (square, rectangle, circle, triangle)
  - Comprehensive testing framework with edge cases
  - Performance testing for large values
- **Methods**:
  - `area(int side)` - Square area calculation
  - `area(int length, int width)` - Rectangle area calculation  
  - `area(double radius)` - Circle area calculation
  - `area(double base, double height)` - Triangle area calculation

### 2. **Rectangle.java**
- **Purpose**: Rectangle/Square class with constructor chaining demonstration
- **Key Features**:
  - Constructor chaining using `this()` keyword
  - Multiple constructors for different initialization scenarios
  - Utility methods for shape identification
  - Comprehensive getter methods and toString() implementation
- **Constructors**:
  - `Rectangle()` - Creates unit square (1x1)
  - `Rectangle(double n)` - Creates square (n×n)
  - `Rectangle(double l, double w)` - Creates rectangle (l×w)
- **Learning**: Learned about Constructor chaining using `this()` and `super()`


### 3. **Employee.java**
- **Purpose**: Employee management system with multiple constructor scenarios
- **Key Features**:
  - Three different constructors for flexible object creation
  - Default values assignment for missing parameters
  - Employee data management and utility methods
  - Comprehensive testing with edge cases and performance metrics
- **Constructors**:
  - `Employee()` - Default constructor with preset values
  - `Employee(String name, String id)` - Partial initialization
  - `Employee(String name, String id, String department, double salary)` - Full initialization
- **Utility Methods**: `updateSalary()`, `updateDepartment()`, `isAssignedToDepartment()`, `hasSalary()`

### 4. **StudentManager.java**
- **Purpose**: Array-based student management system with CRUD operations
- **Key Features**:
  - Fixed-size array management with dynamic count tracking
  - Student addition, removal, and search functionality
  - Array bounds checking and edge case handling
  - Case-insensitive search operations
- **Core Methods**:
  - `addStudent(Student student)` - Adds student to array
  - `removeStudent(String rollNumber)` - Removes student by roll number
  - `findStudent(String rollNumber)` - Searches for student
  - `displayAll()` - Shows all students in the system
- **Edge Cases**: Array full scenarios, empty array operations, duplicate handling


## 🎯 Key Concepts Covered

### Method Overloading
- **Same method name, different parameters**
- **Type-based method resolution** (int vs double)
- **Parameter count variations**
- **Return type considerations** in overloaded methods

### Constructor Chaining
- **Using `this()` to call other constructors**
- **Reducing code duplication**
- **Proper initialization sequences**
- **Default parameter handling**

### Constructor Chaining Pattern
```java
public Rectangle() {
    this(1);           // Calls single parameter constructor
}

public Rectangle(double n) {
    this(n, n);        // Calls two parameter constructor
}

public Rectangle(double l, double w) {
    this.length = l;   // Base constructor
    this.width = w;
}
```

## 🚀 Running the Programs

Each Java file contains a comprehensive test suite. To run:

```bash
# Compile the Java file
javac filename.java

# Run the main class
java Main
```

## 🔗 Dependencies
- **StudentManager.java** imports `basics.Student` class from the basics package
- Ensure the Student class from basics folder is compiled and accessible
