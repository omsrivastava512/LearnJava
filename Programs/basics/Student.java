package basics;
// Create a Student class with the following requirements:
// - Properties: name, rollNumber, age, course
// - Constructor to initialize all properties
// - Method displayInfo() to print student details
// - Create main method to create 2 Student objects and display their info



public class Student{
    private String name;
    private String rollNumber;
    private int age;
    private String course;
    
    public Student(){};

    public Student(String name, String rollNumber, int age, String course){
        this.age = age;
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }
    

    public int getAge() {
        return age;
    }
    public String getCourse() {
        return course;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll number: " + rollNumber      );
        System.out.println("Course: " + course);
        System.out.println("------------------------");
    }

    


}

class Main{
    public static void main (String[] args){
        Student s1 = new Student("Mukesh", "ABC555", 21, "MBA");
        Student s2 = new Student("Rakesh", "ABC55s", 22, "MBA");

        s1.displayInfo();
        s2.displayInfo();
    }
}