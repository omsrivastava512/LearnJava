// Create Employee class with:
// - Fields: name, id, salary, department
// - Default constructor (sets default values)
// - Parameterized constructor (takes all fields)
// - Constructor with only name and id (salary=0, department="Not Assigned")
// - Method displayEmployee()
// Test all three constructors in main method

package basics2;


public class Employee {
    String name, id,  department;
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

    
}
