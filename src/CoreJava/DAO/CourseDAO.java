package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
    public List<Course> getAllCourses()  {
        // creating a course list
        ArrayList<Course> courselist = new ArrayList<>();
        //creating course  Filehandler
        File courseFile = new File("courses.csv");
        //creating scanner refrence to read the file
        Scanner in = null;
        // handling the  exception
        try {
            // giving filehandler to scanner for reading the file
            in= new Scanner(courseFile);
        }
        catch (IOException e){
            System.out.println("there is a problem with reading this file");
        }
        //reading lines of the file with the while loop
        while (in.hasNextLine()){
            String value = in.nextLine();
            //spliting the value by comma
            String[] results = value.split(",");
            //creating a course object
            Course obj = new Course();
            // set everything to obj
            obj.setId(results[0]);
            obj.setName(results[1]);
            obj.setInstructor(results[2]);
            //set this obj to Courselist
            courselist.add(obj);

        }
        //returnng the course list
        return courselist;
    }

}
