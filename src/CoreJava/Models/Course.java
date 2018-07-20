package CoreJava.Models;

public class Course {

    private String ID;
    private String name;
    private String Instructor;
   //creating default constructor
    public Course() {
    }

    //creating overloaded constructor with 2 parameters
    public Course(String id, String name, String instructor) {
        this.ID = id;
        this.name = name;
        Instructor = instructor;
    }
    // creatting getter and setter for all of the variables
    public String getID() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }
}
