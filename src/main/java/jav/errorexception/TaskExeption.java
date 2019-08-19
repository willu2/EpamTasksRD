package jav.errorexception;

import jav.errorexception.dataloader.CreateAllBase;

public class TaskExeption {

    public void showResults(){

        CreateAllBase allBase  = new CreateAllBase();
        allBase.showAllStudents();
        allBase.showStudentsByGroupe();
        allBase.showMiddleMarkStuden();
       // allBase.showMiddleMarkGroupe();

    }


}
