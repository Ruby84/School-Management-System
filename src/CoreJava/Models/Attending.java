package CoreJava.Models;

public class Attending {

    private String courseID;
    private String studentEmail;

    // creatin default constructor
    public Attending() {
    }
    //creating overloaded constructor with 2 parameters

    public Attending(String courseID, String studentEmail) {
        //assigning local variables to instance variable
        this.courseID = courseID;
        this.studentEmail = studentEmail;
    }

    // creatting getter and setter for all of the variables
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}