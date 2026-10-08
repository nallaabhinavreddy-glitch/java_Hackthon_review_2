import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, int rollNumber, double marks,
                   String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    // Check eligibility
    public boolean checkEligibility() {
        return marks >= 50.0;
    }

    // Calculate scholarship amount
    public double calculateScholarship() {
        double fee = calculateFee();

        if (marks >= 85.0) {
            return fee * 0.20;       // 20% scholarship
        } 
        else if (marks >= 70.0) {
            return fee * 0.10;       // 10% scholarship
        } 
        else {
            return 0.0;              // No scholarship
        }
    }

    // Calculate final fee
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display student details
    public void displayDetails() {

        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);

        System.out.println("Eligibility: "
                + (checkEligibility() ? "Eligible" : "Not Eligible"));

        if (checkEligibility()) {
            System.out.println("Total Fee: Rs. " + calculateFee());
            System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
            System.out.println("Final Fee: Rs. " + calculateFinalFee());
        }
    }
}

    class StudentCourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create Student object using parameterized constructor
        Student student = new Student(
                name,
                rollNumber,
                marks,
                courseName,
                credits
        );

        // Check eligibility
        if (student.checkEligibility()) {
            student.displayDetails();
        } 
        else {
            System.out.println("\nStudent " + name
                    + " is Not Eligible for registration.");
            System.out.println("Reason: Marks are below 50.");
        }

        sc.close();
    }
}