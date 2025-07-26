// Create StudentManager class that:
// - Maintains array of Student objects
// - Methods: addStudent(), removeStudent(), findStudent(), displayAll()
// - Handles cases when array is full or student not found
// - Implement search by name and by student ID

package basics2;

import basics.Student;

class StudentManager {
    private Student[] students;
    private int count;
    private final static int MAX_SIZE = 100;

    StudentManager() {
        this.students = new Student[MAX_SIZE];
        this.count = 0;
    }

    public boolean addStudent(Student student) {
        if (count >= MAX_SIZE)
            return false;

        this.students[count++] = student;
        return true;
    }

    public boolean removeStudent(String rollNumber) {
        int targetIndex = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber().equalsIgnoreCase(rollNumber)) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex > -1) {
            for (int i = targetIndex + 1; i < count; i++) {
                students[i - 1] = students[i];
            }
            --count; // the Student at index count can be considered as garbage;
            return true;
        }
        return false;
    }

    public Student findStudent(String rollNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber().equalsIgnoreCase(rollNumber))
                return students[i];
        }
        return null;
    }

    public void displayAll() {
        for (int i = 0; i<count; i++) {
            students[i].displayInfo();
        }
    }

}

class Main {
    public static void main(String[] args) {
        testAddingAndDisplayingStudents();
        testFindingStudents();
        testRemovingStudents();
        testArrayFullScenario();
        testEmptyArrayOperations();
        testDuplicateIds();
        testNullEmptyValues();
        testCaseSensitivity();
    }

    public static void testAddingAndDisplayingStudents() {
        System.out.println("=== Testing Adding and Displaying Students ===");
        StudentManager sm = new StudentManager();
        sm.addStudent(new Student("John", 20, "S001"));
        sm.addStudent(new Student("Alice", 19, "S002"));
        sm.displayAll(); // Should show both students
    }

    public static void testFindingStudents() {
        System.out.println("=== Testing Finding Students ===");
        StudentManager sm = new StudentManager();
        sm.addStudent(new Student("John", 20, "S001"));

        // Test finding existing student by roll number
        Student found = sm.findStudent("S001");
        System.out.println("Found student: " + (found != null ? found.getName() : "Not found"));

        // Test finding non-existing student
        Student notFound = sm.findStudent("S999");
        System.out.println("Non-existing student: " + (notFound != null ? notFound.getName() : "Not found"));
    }

    public static void testRemovingStudents() {
        System.out.println("=== Testing Removing Students ===");
        StudentManager sm = new StudentManager();
        sm.addStudent(new Student("John", 20, "S001"));
        sm.addStudent(new Student("Alice", 19, "S002"));

        // Test removing existing student
        boolean removed = sm.removeStudent("S001");
        System.out.println("Removed S001: " + removed);
        sm.displayAll(); // Should show only Alice now

        // Test removing student that doesn't exist
        boolean removedNonExisting = sm.removeStudent("S999");
        System.out.println("Removed non-existing S999: " + removedNonExisting);
    }

    public static void testArrayFullScenario() {
        System.out.println("=== Testing Array Full Scenario ===");
        StudentManager sm = new StudentManager();

        // Add students up to capacity
        for (int i = 1; i <= 5; i++) {
            boolean added = sm.addStudent(new Student("Student" + i, 20, "S00" + i));
            System.out.println("Added Student" + i + ": " + added);
        }

        // Try to add one more
        boolean added = sm.addStudent(new Student("Extra", 21, "S006"));
        System.out.println("Added extra student when full: " + added);
    }

    public static void testEmptyArrayOperations() {
        System.out.println("=== Testing Empty Array Operations ===");
        StudentManager sm = new StudentManager();

        sm.displayAll(); // Should handle empty array gracefully

        Student found = sm.findStudent("Anyone");
        System.out.println("Found in empty array: " + (found != null ? found.getName() : "Not found"));

        boolean removed = sm.removeStudent("S001");
        System.out.println("Removed from empty array: " + removed);
    }

    public static void testDuplicateIds() {
        System.out.println("=== Testing Duplicate IDs ===");
        StudentManager sm = new StudentManager();

        sm.addStudent(new Student("John", 20, "S001"));
        boolean added = sm.addStudent(new Student("Jane", 19, "S001")); // Same ID
        System.out.println("Added duplicate ID: " + added);
        sm.displayAll();
    }

    public static void testNullEmptyValues() {
        System.out.println("=== Testing Null/Empty Values ===");
        StudentManager sm = new StudentManager();

        boolean added1 = sm.addStudent(new Student("", 20, "S003")); // Empty name
        System.out.println("Added student with empty name: " + added1);

        boolean added2 = sm.addStudent(new Student("Test", 20, "")); // Empty ID
        System.out.println("Added student with empty ID: " + added2);
    }

    public static void testCaseSensitivity() {
        System.out.println("=== Testing Case Sensitivity ===");
        StudentManager sm = new StudentManager();
        
        sm.addStudent(new Student("John", 20, "S001"));
        
        Student found1 = sm.findStudent("s001"); // lowercase
        System.out.println("Found with lowercase: " + (found1 != null ? found1.getName() : "Not found"));
        
        Student found2 = sm.findStudent("S001"); // uppercase
        System.out.println("Found with uppercase: " + (found2 != null ? found2.getName() : "Not found"));

    }
}