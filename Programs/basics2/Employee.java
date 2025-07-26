// Create Employee class with:
// - Fields: name, id, salary, department
// - Default constructor (sets default values)
// - Parameterized constructor (takes all fields)
// - Constructor with only name and id (salary=0, department="Not Assigned")
// - Method displayEmployee()
// Test all three constructors in main method

package basics2;

 class Employee {
    String name, id, department;
    double salary;

    public Employee(){
        this.name = "Unavailable";
        this.id = "Not Assigned";
        this.department = "Not Assigned";
        this.salary = 0;
    }
    
    public Employee(String name, String id){
        this.name = name;
        this.id = id;
        this.department = "Not Assigned";
        this.salary = 0;
    }

    public Employee(String name, String id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
    
    public void displayEmployee(){
        System.out.println("-".repeat(20));
        System.out.println("Employee Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Current Salary: " + this.salary);
        System.out.println("Department: " + this.department);
        System.out.println("-".repeat(20));
    }

    // Getter methods for testing
    public String getName() { return name; }
    public String getId() { return id; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    // Additional utility methods for comprehensive testing
    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void updateDepartment(String newDepartment) {
        this.department = newDepartment;
    }

    public boolean isAssignedToDepartment() {
        return !department.equals("Not Assigned");
    }

    public boolean hasSalary() {
        return salary > 0;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', id='%s', department='%s', salary=%.2f}", 
                           name, id, department, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 &&
               name.equals(employee.name) &&
               id.equals(employee.id) &&
               department.equals(employee.department);
    }
}

class Main {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    private static final double DELTA = 0.0001; // For double comparison

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("         EMPLOYEE CLASS - COMPREHENSIVE TEST SUITE");
        System.out.println("============================================================\n");

        // Test all constructor scenarios
        testDefaultConstructor();
        testTwoParameterConstructor();
        testFullParameterConstructor();
        testConstructorEdgeCases();
        testDisplayMethod();
        testUtilityMethods();
        testEmployeeOperations();
        testDataValidation();
        testPerformance();
        testEqualsAndToString();

        // Print final results
        printTestSummary();
    }

    // Test default constructor
    private static void testDefaultConstructor() {
        System.out.println("1. TESTING DEFAULT CONSTRUCTOR");
        System.out.println("--------------------------------------------------");

        Employee defaultEmp = new Employee();
        
        testString("Default constructor - name", defaultEmp.getName(), "Unavailable");
        testString("Default constructor - id", defaultEmp.getId(), "Not Assigned");
        testString("Default constructor - department", defaultEmp.getDepartment(), "Not Assigned");
        testDouble("Default constructor - salary", defaultEmp.getSalary(), 0.0);
        
        testBoolean("Default employee - not assigned to department", 
                   defaultEmp.isAssignedToDepartment(), false);
        testBoolean("Default employee - has no salary", defaultEmp.hasSalary(), false);

        System.out.println("✓ Default constructor tests completed\n");
    }

    // Test two parameter constructor (name and id only)
    private static void testTwoParameterConstructor() {
        System.out.println("2. TESTING TWO PARAMETER CONSTRUCTOR");
        System.out.println("--------------------------------------------------");

        Employee emp1 = new Employee("John Doe", "EMP001");
        
        testString("Two param constructor - name", emp1.getName(), "John Doe");
        testString("Two param constructor - id", emp1.getId(), "EMP001");
        testString("Two param constructor - department", emp1.getDepartment(), "Not Assigned");
        testDouble("Two param constructor - salary", emp1.getSalary(), 0.0);

        Employee emp2 = new Employee("Jane Smith", "EMP002");
        testString("Two param constructor - name (test 2)", emp2.getName(), "Jane Smith");
        testString("Two param constructor - id (test 2)", emp2.getId(), "EMP002");

        Employee emp3 = new Employee("", "");
        testString("Two param constructor - empty name", emp3.getName(), "");
        testString("Two param constructor - empty id", emp3.getId(), "");

        testBoolean("Two param employee - not assigned to department", 
                   emp1.isAssignedToDepartment(), false);
        testBoolean("Two param employee - has no salary", emp1.hasSalary(), false);

        System.out.println("✓ Two parameter constructor tests completed\n");
    }

    // Test full parameter constructor
    private static void testFullParameterConstructor() {
        System.out.println("3. TESTING FULL PARAMETER CONSTRUCTOR");
        System.out.println("--------------------------------------------------");

        Employee emp1 = new Employee("Alice Johnson", "EMP003", "Engineering", 75000.0);
        
        testString("Full constructor - name", emp1.getName(), "Alice Johnson");
        testString("Full constructor - id", emp1.getId(), "EMP003");
        testString("Full constructor - department", emp1.getDepartment(), "Engineering");
        testDouble("Full constructor - salary", emp1.getSalary(), 75000.0);

        Employee emp2 = new Employee("Bob Wilson", "EMP004", "Marketing", 65000.50);
        testString("Full constructor - name (test 2)", emp2.getName(), "Bob Wilson");
        testString("Full constructor - id (test 2)", emp2.getId(), "EMP004");
        testString("Full constructor - department (test 2)", emp2.getDepartment(), "Marketing");
        testDouble("Full constructor - salary (test 2)", emp2.getSalary(), 65000.50);

        Employee emp3 = new Employee("Charlie Brown", "EMP005", "HR", 0.0);
        testDouble("Full constructor - zero salary", emp3.getSalary(), 0.0);

        testBoolean("Full param employee - assigned to department", 
                   emp1.isAssignedToDepartment(), true);
        testBoolean("Full param employee - has salary", emp1.hasSalary(), true);

        System.out.println("✓ Full parameter constructor tests completed\n");
    }

    // Test constructor edge cases
    private static void testConstructorEdgeCases() {
        System.out.println("4. TESTING CONSTRUCTOR EDGE CASES");
        System.out.println("--------------------------------------------------");

        // Test with null values (if your implementation handles them)
        Employee emp1 = new Employee("Test", null);
        testString("Constructor with null id", emp1.getId(), null);

        Employee emp2 = new Employee(null, "EMP006");
        testString("Constructor with null name", emp2.getName(), null);

        Employee emp3 = new Employee("Test Employee", "EMP007", null, 50000.0);
        testString("Constructor with null department", emp3.getDepartment(), null);

        // Test with very long strings
        String longName = "A".repeat(100);
        String longId = "1".repeat(50);
        String longDept = "Department".repeat(10);
        
        Employee emp4 = new Employee(longName, longId, longDept, 100000.0);
        testString("Constructor with long name", emp4.getName(), longName);
        testString("Constructor with long id", emp4.getId(), longId);
        testString("Constructor with long department", emp4.getDepartment(), longDept);

        // Test with negative salary
        Employee emp5 = new Employee("Test", "EMP008", "Finance", -1000.0);
        testDouble("Constructor with negative salary", emp5.getSalary(), -1000.0);

        // Test with very large salary
        Employee emp6 = new Employee("CEO", "EMP009", "Executive", 1000000.0);
        testDouble("Constructor with large salary", emp6.getSalary(), 1000000.0);

        System.out.println("✓ Constructor edge case tests completed\n");
    }

    // Test display method functionality
    private static void testDisplayMethod() {
        System.out.println("5. TESTING DISPLAY METHOD");
        System.out.println("--------------------------------------------------");

        System.out.println("Testing display method output:");
        
        Employee emp1 = new Employee();
        System.out.println("Default Employee Display:");
        emp1.displayEmployee();

        Employee emp2 = new Employee("John Smith", "EMP010");
        System.out.println("Two Parameter Employee Display:");
        emp2.displayEmployee();

        Employee emp3 = new Employee("Sarah Connor", "EMP011", "Security", 80000.0);
        System.out.println("Full Parameter Employee Display:");
        emp3.displayEmployee();

        // Note: Since displayEmployee() prints to console, we can't easily test output
        // In a real testing framework, you'd capture stdout or use dependency injection
        System.out.println("✓ Display method tests completed (visual verification required)\n");
    }

    // Test utility methods
    private static void testUtilityMethods() {
        System.out.println("6. TESTING UTILITY METHODS");
        System.out.println("--------------------------------------------------");

        Employee emp1 = new Employee("Test Employee", "EMP012", "IT", 60000.0);
        
        // Test updateSalary
        emp1.updateSalary(70000.0);
        testDouble("Update salary method", emp1.getSalary(), 70000.0);

        // Test updateDepartment
        emp1.updateDepartment("Software Development");
        testString("Update department method", emp1.getDepartment(), "Software Development");

        // Test isAssignedToDepartment
        Employee unassignedEmp = new Employee("Unassigned", "EMP013");
        testBoolean("Unassigned employee department check", 
                   unassignedEmp.isAssignedToDepartment(), false);

        emp1.updateDepartment("Not Assigned");
        testBoolean("Employee set to 'Not Assigned' department", 
                   emp1.isAssignedToDepartment(), false);

        // Test hasSalary
        Employee noSalaryEmp = new Employee("No Salary", "EMP014");
        testBoolean("Employee with no salary", noSalaryEmp.hasSalary(), false);

        noSalaryEmp.updateSalary(1.0);
        testBoolean("Employee with minimal salary", noSalaryEmp.hasSalary(), true);

        System.out.println("✓ Utility method tests completed\n");
    }

    // Test various employee operations
    private static void testEmployeeOperations() {
        System.out.println("7. TESTING EMPLOYEE OPERATIONS");
        System.out.println("--------------------------------------------------");

        // Create employees using all constructors
        Employee[] employees = {
            new Employee(),
            new Employee("Manager", "MGR001"),
            new Employee("Developer", "DEV001", "Engineering", 85000.0),
            new Employee("Analyst", "ANL001", "Business", 70000.0),
            new Employee("Intern", "INT001", "Various", 0.0)
        };

        // Test employee count
        testInt("Created employee count", employees.length, 5);

        // Test salary operations
        double totalSalary = 0;
        int employeesWithSalary = 0;
        
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
            if (emp.hasSalary()) {
                employeesWithSalary++;
            }
        }

        testDouble("Total salary of all employees", totalSalary, 155000.0);
        testInt("Employees with salary count", employeesWithSalary, 2);

        // Test department assignments
        int assignedEmployees = 0;
        for (Employee emp : employees) {
            if (emp.isAssignedToDepartment()) {
                assignedEmployees++;
            }
        }

        testInt("Employees assigned to departments", assignedEmployees, 3);

        System.out.println("✓ Employee operations tests completed\n");
    }

    // Test data validation scenarios
    private static void testDataValidation() {
        System.out.println("8. TESTING DATA VALIDATION SCENARIOS");
        System.out.println("--------------------------------------------------");

        // Test special characters in names
        Employee emp1 = new Employee("O'Connor, Mary-Jane", "EMP015", "HR", 55000.0);
        testString("Name with special characters", emp1.getName(), "O'Connor, Mary-Jane");

        // Test numeric strings in non-numeric fields
        Employee emp2 = new Employee("123456", "789", "Department123", 45000.0);
        testString("Numeric name", emp2.getName(), "123456");
        testString("Numeric ID", emp2.getId(), "789");
        testString("Numeric department", emp2.getDepartment(), "Department123");

        // Test very precise salary values
        Employee emp3 = new Employee("Precise", "EMP016", "Finance", 50000.99);
        testDouble("Precise salary", emp3.getSalary(), 50000.99);

        // Test whitespace handling
        Employee emp4 = new Employee("  Trimmed Name  ", "  EMP017  ", "  Trimmed Dept  ", 60000.0);
        // Note: Your current implementation doesn't trim whitespace, so this tests current behavior
        testString("Name with whitespace", emp4.getName(), "  Trimmed Name  ");
        testString("ID with whitespace", emp4.getId(), "  EMP017  ");

        System.out.println("✓ Data validation tests completed\n");
    }

    // Test performance with multiple employees
    private static void testPerformance() {
        System.out.println("9. TESTING PERFORMANCE");
        System.out.println("--------------------------------------------------");

        long startTime = System.nanoTime();
        
        // Create many employees using different constructors
        Employee[] employees = new Employee[10000];
        for (int i = 0; i < 10000; i++) {
            switch (i % 3) {
                case 0:
                    employees[i] = new Employee();
                    break;
                case 1:
                    employees[i] = new Employee("Employee" + i, "EMP" + i);
                    break;
                case 2:
                    employees[i] = new Employee("Employee" + i, "EMP" + i, "Dept" + (i%10), i * 1000.0);
                    break;
            }
        }
        
        // Perform operations on all employees
        double totalSalary = 0;
        int assignedCount = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
            if (emp.isAssignedToDepartment()) {
                assignedCount++;
            }
        }
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        
        System.out.println("✓ Performance test: Created 10,000 employees");
        System.out.println("✓ Total salary calculated: $" + String.format("%.2f", totalSalary));
        System.out.println("✓ Employees with departments: " + assignedCount);
        System.out.println("✓ Completed in " + String.format("%.2f ms", duration));
        System.out.println("✓ Performance tests completed\n");
    }

    // Test equals and toString methods
    private static void testEqualsAndToString() {
        System.out.println("10. TESTING EQUALS AND TOSTRING METHODS");
        System.out.println("--------------------------------------------------");

        Employee emp1 = new Employee("John Doe", "EMP001", "IT", 50000.0);
        Employee emp2 = new Employee("John Doe", "EMP001", "IT", 50000.0);
        Employee emp3 = new Employee("Jane Doe", "EMP002", "HR", 55000.0);

        testBoolean("Equals method - same employees", emp1.equals(emp2), true);
        testBoolean("Equals method - different employees", emp1.equals(emp3), false);
        testBoolean("Equals method - null comparison", emp1.equals(null), false);

        String toStringResult = emp1.toString();
        testBoolean("ToString contains name", toStringResult.contains("John Doe"), true);
        testBoolean("ToString contains id", toStringResult.contains("EMP001"), true);
        testBoolean("ToString contains department", toStringResult.contains("IT"), true);
        testBoolean("ToString contains salary", toStringResult.contains("50000"), true);

        System.out.println("✓ Sample toString output: " + emp1.toString());
        System.out.println("✓ Equals and toString tests completed\n");
    }

    // Helper methods for testing
    private static void testString(String description, String actual, String expected) {
        totalTests++;
        if ((actual == null && expected == null) || (actual != null && actual.equals(expected))) {
            System.out.println("✓ PASS: " + description + " (Expected: '" + expected + "', Got: '" + actual + "')");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: '" + expected + "', Got: '" + actual + "')");
        }
    }

    private static void testDouble(String description, double actual, double expected) {
        totalTests++;
        if (Math.abs(actual - expected) < DELTA) {
            System.out.println("✓ PASS: " + description + " (Expected: " + 
                             String.format("%.2f", expected) + ", Got: " + 
                             String.format("%.2f", actual) + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + 
                             String.format("%.2f", expected) + ", Got: " + 
                             String.format("%.2f", actual) + ")");
        }
    }

    private static void testBoolean(String description, boolean actual, boolean expected) {
        totalTests++;
        if (actual == expected) {
            System.out.println("✓ PASS: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    private static void testInt(String description, int actual, int expected) {
        totalTests++;
        if (actual == expected) {
            System.out.println("✓ PASS: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    // Print comprehensive test summary
    private static void printTestSummary() {
        System.out.println("============================================================");
        System.out.println("                    TEST SUMMARY");
        System.out.println("============================================================");
        System.out.println("Total Tests Run: " + totalTests);
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + (totalTests - testsPassed));
        
        double successRate = (double) testsPassed / totalTests * 100;
        System.out.println("Success Rate: " + String.format("%.2f%%", successRate));
        
        if (testsPassed == totalTests) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
            System.out.println("Your Employee class with multiple constructors is working perfectly!");
        } else {
            System.out.println("⚠️  Some tests failed. Please review the implementation.");
        }
        
        System.out.println("\n📊 CONSTRUCTOR TESTING COMPLETED:");
        System.out.println("   • Default Constructor: Employee() ✓");
        System.out.println("   • Two Parameter Constructor: Employee(name, id) ✓");
        System.out.println("   • Full Constructor: Employee(name, id, dept, salary) ✓");
        
        System.out.println("\n📋 TEST CATEGORIES COVERED:");
        System.out.println("   • Default constructor behavior");
        System.out.println("   • Two parameter constructor behavior");
        System.out.println("   • Full parameter constructor behavior");
        System.out.println("   • Constructor edge cases");
        System.out.println("   • Display method functionality");
        System.out.println("   • Utility methods (getters, updates, checks)");
        System.out.println("   • Employee operations and calculations");
        System.out.println("   • Data validation scenarios");
        System.out.println("   • Performance testing (10,000 employees)");
        System.out.println("   • Equals and toString methods");
        System.out.println("============================================================");
    }
}