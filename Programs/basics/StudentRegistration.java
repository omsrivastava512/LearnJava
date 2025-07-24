package basics;
// Create a program that:
// - Takes student details as input from user (Scanner)
// - Creates Student object with entered data
// - Displays formatted output using System.out.println()
// - Handle at least 3 students

import java.util.Scanner;

class StudentRegistration   {

    StudentRegistration() {
        Scanner sc = new Scanner(System.in); // ❌❌ Not recommended
        System.out.print("Enter number of students to register:");
        int n = sc.nextInt();
        Student[] s = new Student[n];

        for(int i = 0; i<n; i++){
            s[i] = new Student();
            
            System.out.println();
            System.out.println("---- Student #" + i+1 + " ----");

            System.out.print("Enter student name:");
            s[i].setName(sc.nextLine());
            
            System.out.print("Enter student age:");
            s[i].setAge(sc.nextInt()); sc.nextLine();
            
            System.out.print("Enter student course:");
            s[i].setCourse(sc.nextLine());
        }
         System.out.println("\n===== STUDENT REGISTRATION RESULTS =====");
        if(n==0){
            System.out.println("|---- Empty -----|");
        }
        for(int i = 0; i < n; i++) {
            System.out.println("Student #" + (i+1) + ":");
            s[i].displayInfo();
        }


        sc.close();
    }
}
