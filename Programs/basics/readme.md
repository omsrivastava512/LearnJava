# Java Basics Programs

This folder contains fundamental Java programming exercises covering core OOP concepts and best practices.

## 📁 Programs Overview

### 1. **BankAccount.java**
- **Purpose**: Banking system simulation with deposit, withdraw, and balance operations
- **Key Features**: 
  - Private fields with encapsulation
  - User input handling with Scanner
  - Confirmation prompts for transactions
> **Learning**: When you close a Scanner that's using System.in, it closes the underlying input stream—meaning you can't use System.in again later in the program. It's recommended to close sc at the end of the main()

### 2. **Calculator.java**
- **Purpose**: Basic arithmetic operations with method overloading
- **Key Features**:
  - Method overloading for different data types (int, double)
  - Exception handling for division by zero
  - Support for both integer and floating-point operations
> **Learning**: Only integer division throws ArithmeticException on division by zero. That is because Java uses two's complement for integers, and there's no bit pattern reserved for special values like Infinity or NaN. In case of floating-point division, Java has dedicated bit patterns for Infinity or NaN:
> - `5.0 / 0` → Infinity
> - `-5 / 0.0` → -Infinity
> - `0.0 / 0` → NaN

### 3. **Library.java**
- **Purpose**: Library management system with book operations
- **Key Features**:
  - Book search functionality (by title, author, ISBN)
  - Comprehensive testing framework
  - Large dataset performance testing
  - Edge case handling
> **Learning**: Scanners must be handled by main() function only and any other method using a scanner needs to be passed via argument

### 4. **Student.java**
- **Purpose**: Student information management
- **Key Features**: Basic student data handling and operations

### 5. **StudentRegistration.java**
- **Purpose**: Student registration system
- **Key Features**: Registration workflow and student data management

## 🎯 Key Concepts Covered

- **Object-Oriented Programming**: Classes, objects, encapsulation
- **Method Overloading**: Multiple methods with same name, different parameters
- **Exception Handling**: Try-catch blocks, proper error management
- **Scanner Management**: Proper resource handling and input stream management
- **Data Types**: Working with integers, doubles, and type casting

## 🔧 Best Practices Demonstrated

1. **Resource Management**: Proper Scanner closing to avoid input stream issues
2. **Exception Handling**: Different approaches for integer vs floating-point division
3. **Code Organization**: Separation of concerns and modular design
4. **Testing**: Comprehensive testing strategies for large datasets

## 🚀 Running the Programs

Each Java file contains a `Main` class with a `main()` method. To run any program:

```bash
javac filename.java
java Main
```
