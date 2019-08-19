package jav.errorexception.datacreator;

import java.util.Random;

public class RandDataCreator {

    Random random = new Random(47);

    private String[] facultys = {"Geographical", "Historical", "Mathematical",
                                 "Information Technology", "Computer Science", "Physical"};
    private String[] subject = {"QQQQQQQQ", "EEEEEEEEE", "KKKKKKKKK", "DDDDDDDD", "MMMMMMMM", "VVVVVVVV", "ZZZZZZZZ",
                                "IIIIIIII", "YYYYYYYY", "BBBBBBBB", "RRRRRRRRRR"};

    public int idCreator(){
        int max = 9000;
        int min = 3000;
        return random.nextInt((max - min) + 1) + min;
    }

    public int groupeNumberCreator(){
        int max = 15;
        int min = 1;
        return random.nextInt((max - min) + 1) + min;
    }

    public int marksCreator(){
        int max = 45;
        int min = 15;
        return random.nextInt((max - min) + 1) + min;
    }

    public String facultyCreator(){
        return String.valueOf(facultys[random.nextInt(facultys.length-1)]);
    }

    public String subjectCreator(){
        return String.valueOf(subject[random.nextInt(subject.length-1)]);
    }




}
