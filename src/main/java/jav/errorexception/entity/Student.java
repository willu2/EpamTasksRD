package jav.errorexception.entity;

import java.util.Map;

public class Student {

    public Student() {
    }

    private int studentId;
    private int groupeNumber;
    private String faculty;

    private Map<String, Integer> schoolMarks;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupeNumber() {
        return groupeNumber;
    }

    public void setGroupeNumber(int groupeNumber) {
        this.groupeNumber = groupeNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Map<String, Integer> getSchoolMarks() {
        return schoolMarks;
    }

    public void setSchoolMarks(Map<String, Integer> schoolMarks) {
        this.schoolMarks = schoolMarks;
    }
}


/*В университете есть несколько факультетов , в которых учатся студенты, объединенные в группы. У каждого
  студента есть несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию
  студентов, групп и факультетов. */