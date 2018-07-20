package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

public class AttendingDAO {

    public List<Attending> getAttending() {
        //creating attending Filehandler
        File attendingFile = new File("attending.csv");

        //creating an Arraylist
        ArrayList<Attending> attendingList = new ArrayList<>();
        //creating scanner refrence to read the file
        Scanner in = null;
        // handling the  exception
        try {
            // giving filehandler to scanner for reading the file
            in = new Scanner(attendingFile);
        }
        catch (IOException e){
            System.out.println("there is a problem with reading the file");
        }
       //using while loop to read data from the file

        while (in.hasNextLine()) {
            String value = in.nextLine();
            String[] results = value.split(",");
            //creating an attending object
            Attending obj = new Attending();
// assigning value to course Id and Email ID
            obj.setCourseID(results[0]);
            obj.setStudentEmail(results[1]);
// adding value of the object to the attending list
            attendingList.add(obj);
        }
        //returning attending list
        return attendingList;

    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID1) { //modify courseID to CourseID1
// creating boolean and assigning value for it
        boolean studentfound = false;
        //converting int to string
        String courseID = courseID1+"";
        //creating forloop to go to go over the array list
        for (Attending atendingStudent : attending) {
           //checking if given course id and email id matches with the attending student course id and email
            if (atendingStudent.getCourseID().equals(courseID) && atendingStudent.getStudentEmail().equals(studentEmail)) {
                studentfound = true;
            }
        }// end of for loop

        //checking if student is in the list
        if (!studentfound) {
            // creating new Attending class object
            Attending newAttendingStudent = new Attending();
            //assigning value to the new student object
            newAttendingStudent.setStudentEmail(studentEmail);
            newAttendingStudent.setCourseID(courseID);
         // adding value of new student to the attending student list
            attending.add(newAttendingStudent);
        }


    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail) {
        //creating new list
        ArrayList<Course> newList = new ArrayList<>();
        //creating forloop to go to go over the attending array list
        for (Attending attendingStudent : attending) {
            //checking if given student email  matches with the attending student email
            if (attendingStudent.getStudentEmail().equals(studentEmail)) {
                //creating new Course object
                Course obj = new Course();
                //creating the courseid through object id
                obj.setId(attendingStudent.getCourseID());
                newList.add(obj);
            }

        } //end of the loop
        //creating a for loop to check all the id in the list
        for (int i = 0; i < newList.size(); i++) {

            String id = newList.get(i).getID();
            //creating a forloop to check all id in the course list
            for (int j = 0; j < courseList.size(); j++) {
                //checking if an id  matches with the course id, then we put
                //the code in the new list
                if (id.equals(courseList.get(j).getID())) {
                    //traversing newlist using i and courseList using j
                    newList.get(i).setName(courseList.get(j).getName());
                    newList.get(i).setInstructor(courseList.get(j).getInstructor());
                }


            }
        }
        return newList;
    }

    public void saveAttending(List<Attending> attending) {
        try {
            // creating a file writer object
            FileWriter attendingFile = new FileWriter("attending.csv");
            for (Attending student : attending) {
                String temp = student.getCourseID() + "," + student.getStudentEmail()+"\n";
                attendingFile.write(temp); //writing to the file

            }
            //closing the file
            attendingFile.close();

        }
        catch (IOException e){
            System.out.println("Error while writing the file");

        }

    }
}
