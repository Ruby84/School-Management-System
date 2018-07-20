package CoreJava.Models;

public class Student {

    private String email;
    private String name;
    private String pass;

    //creating default constructor
    public Student() {

    }

    //creating overloaded constructor with 2 parameters
    public Student(String email, String name, String pass) {
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    // creatting getter and setter for all of the variables
    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {

        return pass;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }
}

