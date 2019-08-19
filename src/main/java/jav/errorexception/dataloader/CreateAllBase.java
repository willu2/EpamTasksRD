package jav.errorexception.dataloader;

import jav.errorexception.datacreator.RandDataCreator;
import jav.errorexception.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreateAllBase {

    RandDataCreator dataCreator;
    ArrayList<Student> studentsBase;

    private int studentsCount = 150;

    public CreateAllBase() {
        dataCreator = new RandDataCreator();
        studentsBase = new ArrayList<>();
        createStudentGroups();
    }

    private void createStudentGroups(){

        for (int i = 0; i < studentsCount; i++) {
            Student student = new Student();
            student.setStudentId(dataCreator.idCreator());
            student.setFaculty(dataCreator.facultyCreator());
            student.setGroupeNumber(dataCreator.groupeNumberCreator());
            student.setSchoolMarks(marksPusher());
            studentsBase.add(student);
        }
    }

    private Map<String,Integer> marksPusher(){

        Map<String,Integer> marks = new HashMap<>();
        for (int i = 0; i < dataCreator.marksCreator() ; i++) {
            marks.put(dataCreator.subjectCreator(), dataCreator.marksCreator());
        }
        return marks;
    }

    public void showAllStudents() {
        for(Student student : getStudentsBase()){
            System.out.println(" ***************** ");
            System.out.println("Student ID   >> " + student.getStudentId());
            System.out.println("Faculty      >> " + student.getFaculty());
            System.out.println("GroupeNumber >> " + student.getGroupeNumber());

            for (String key : student.getSchoolMarks().keySet()) {
                System.out.print("Subject  >> " + key);
                System.out.print("  -----  ");
                System.out.println(student.getSchoolMarks().get(key));
            }
            System.out.println(" ***************** ");
        }
    }

    public ArrayList<Student> getStudentsBase() {
        return studentsBase;
    }
}
