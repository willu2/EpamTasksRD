package jav.errorexception.dataloader;

import jav.errorexception.datacreator.RandDataCreator;
import jav.errorexception.entity.Student;
import jav.errorexception.exeptions.AbsenceStdentExeption;
import jav.errorexception.exeptions.WrongMarkExeption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateAllBase {

    RandDataCreator dataCreator;
    ArrayList<Student> studentsBase;

    private int studentsCount = 100;

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
            try {
                checkMarksStudent(student);
                System.out.println(" ***************** ");
                System.out.println("Student ID   >> " + student.getStudentId());
                System.out.println("Faculty      >> " + student.getFaculty());
                try {
                    System.out.println("GroupeNumber >> " + student.getGroupeNumber());
                    for (String key : student.getSchoolMarks().keySet()) {
                        System.out.print("Subject  >> " + key);
                        System.out.print("  -----  ");
                        System.out.println(student.getSchoolMarks().get(key));
                    }
                } catch (AbsenceStdentExeption e) {
                    System.out.println(e.getMessage());
                }
            } catch (WrongMarkExeption ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(" ***************** ");
        }
    }

    public void showStudentsByGroupe() {
        int groupeNumber = dataCreator.groupeNumberCreator();
        for(Student student : getStudentsBase()){
            try {
                checkMarksStudent(student);
            } catch (WrongMarkExeption ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if(student.getGroupeNumber() == groupeNumber){
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
            } catch (AbsenceStdentExeption ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void showMiddleMarkStuden() {
        for(Student student : getStudentsBase()){
            int middleMark = 0;
            System.out.println(" ***************** ");
            System.out.println("Student ID   >> " + student.getStudentId());
            System.out.println("Faculty      >> " + student.getFaculty());
            try {
                System.out.println("GroupeNumber >> " + student.getGroupeNumber());
                for (String key : student.getSchoolMarks().keySet()) {
                    middleMark += student.getSchoolMarks().get(key);
                }
                System.out.println("MiddleMark >> " + middleMark/student.getSchoolMarks().size());
                System.out.println(" ***************** ");
            } catch (AbsenceStdentExeption e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void showMiddleMarkGroupe() {
        String randFaculty = dataCreator.facultyCreator();
        String subject = dataCreator.subjectCreator();
        int randGroupe = dataCreator.groupeNumberCreator();
        int middleMark = 0;
        int count = 0;

        for(Student student : getStudentsBase()){
            if(student.getFaculty().equals(randFaculty)){
                if(getStudentSubject(student).equals(subject)){
                    try {
                        if(student.getGroupeNumber() == randGroupe){
                            System.out.println(" ------------------------ ");
                            System.out.println("Student ID   >> " + student.getStudentId());
                            System.out.println("Faculty      >> " + student.getFaculty());

                            middleMark += student.getSchoolMarks().get(subject);
                            count++;
                        }
                    } catch (AbsenceStdentExeption ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        System.out.println("MiddleMark >> " + middleMark/count);
        System.out.println(" ***************** ");

    }

    public void checkMarksStudent(Student student) throws WrongMarkExeption {
            for (String key : student.getSchoolMarks().keySet()) {
                if(student.getSchoolMarks().get(key) <= 0 || student.getSchoolMarks().get(key) > 10){
                    throw new WrongMarkExeption("Mark must be in [1-10]");
                }
            }
    }

    public String getStudentSubject(Student student) {
        String subject = "";
        for (String key : student.getSchoolMarks().keySet()) {
            subject = key;
        }
        return subject;
    }

    public ArrayList<Student> getStudentsBase() {
        return studentsBase;
    }
}
