package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    public List<Student> getStudents() {
        //creating course filehandler
        File studentFile = new File("students.csv");
        //creating scanner refrence to read the file
        Scanner in = null;
        // handling the  exception
        try {
            // giving filehandler to scanner for reading the file
             in = new Scanner(studentFile);
        }
       catch (IOException e){
           System.out.println("problem with reading the file");
       }
       //creating a student list object
        ArrayList<Student> studentList = new ArrayList<>();
        //reading lines of the file with the while loop
        while (in.hasNextLine()) {
            String value = in.nextLine();
            //spliting the value by comma
            String[] results = value.split(",");
            Student obj = new Student();
            // set everything to obj

            obj.setEmail(results[0]);
            obj.setName(results[1]);
            obj.setPass(results[2]);

//set these obj to student list
            studentList.add(obj);

        }//end of while loope
        //returning student list
        return studentList;
    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail) {
        // to get student detail by student id
        Student student = null; // if you dont find data assign in to null

        for (Student student1 : studentList) {
            if (student1.getEmail().equals(studentEmail)) {
                student = student1;

            }
        }
        return student;
    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass) {
        // to validate if the user entered password and email matching with the student data in the file
        boolean foundStudent = false;

        for (Student sFound : studentList){
            if (sFound.getEmail().equals(studentEmail) && sFound.getPass().equals(studentPass)){
                foundStudent = true;
            }

        } return foundStudent;

    }
}

