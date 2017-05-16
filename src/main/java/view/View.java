package view;

import model.Notepad;
import model.entity.Group;
import model.entity.Note;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * Created by Администратор on 15.05.2017.
 */
public class View implements ViewConstants {

    public  void printMessage(String string){
        System.out.println(string);
    }
    public  void printWrongInput(){
       printMessage(WRONG_INPUT);
    }
    public void printInput(String string){
        System.out.println(INPUT + string);
    }
    public void printAllGroup(){
        Arrays.stream(Group.values()).forEach(x -> System.out.println(x + " "));
    }
    public void printNotepad(Notepad notepad){
        printMessage(notepad.toString());
    }
}
