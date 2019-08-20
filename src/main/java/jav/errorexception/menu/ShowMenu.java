package jav.errorexception.menu;

import jav.errorexception.dataloader.CreateAllBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

    private int itemMenu = 0;
    boolean exit = false;

    MenuBuilder menu ;
    CreateAllBase allBase;

    public ShowMenu() {
        menu = new MenuBuilder();
        allBase  = new CreateAllBase();
    }

    public void show() {
        do {
            menu.mainManu();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //main menu block
            try {
                switch (Integer.parseInt(in.readLine())) {
                    case 1:
                        allBase.showAllStudents();
                        break;
                    case 2:
                        allBase.showStudentsByGroupe();
                        break;
                    case 3:
                        allBase.showMiddleMarkStuden();
                        break;
                    case 4:
                        allBase.showMiddleMarkGroupe();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Try again...");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e);
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid operation");
                continue;   // go to beginning of loop
            }
        }while (!exit);
    }
}

