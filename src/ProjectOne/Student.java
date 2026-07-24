package ProjectOne;


public class Student {


    private int studentId;
    private String studentName;
    private String department;
    private String password;



    public Student(int studentId, String studentName,
                   String department, String password) {


        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.password = password;


    }



    public int getStudentId() {

        return studentId;

    }



    public String getStudentName() {

        return studentName;

    }



    public String getDepartment() {

        return department;

    }



    public String getPassword() {

        return password;

    }



    @Override
    public String toString() {


        return "\nStudent ID   : " + studentId +
               "\nStudent Name : " + studentName +
               "\nDepartment   : " + department;


    }


}