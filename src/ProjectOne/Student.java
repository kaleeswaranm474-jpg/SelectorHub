package ProjectOne;

public class Student {

    private int studentId;
    private String studentName;
    private String department;

    // Constructor
    public Student(int studentId, String studentName, String department) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

    // Getter Methods
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    // Setter Methods
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Display Student Details
    @Override
    public String toString() {

        return "Student ID   : " + studentId +
               "\nStudent Name : " + studentName +
               "\nDepartment   : " + department;
    }
}