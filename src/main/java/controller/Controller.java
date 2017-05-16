package controller;

import model.Notepad;
import model.entity.Group;
import model.entity.Note;
import model.entity.NoteBuilder;
import view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Администратор on 15.05.2017.
 */
public class Controller {
    private Notepad notepad;
    private View view;
    private Scanner scanner;

    public Controller(Notepad notepad, View view) {
        this.notepad = notepad;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void run(){

        notepad.addNote(createNoteViaIteration());
        view.printNotepad(notepad);

        notepad.addNote(createNoteViaBuilder());
        view.printNotepad(notepad);

    }

    private Note createNoteViaIteration(){
        NoteBuilder noteBuilder = Note.createNotebuilder();
        Class nbClass = noteBuilder.getClass();
        Method [] methods =  nbClass.getMethods();
        sortMethodsByMethodOrder(methods);
        int methodIndex = 0;
        String inputString;
        for (String inputMessage: View.inputWithRegex.keySet()) {
            inputString = inputNoteFields(inputMessage);
            try {
                methods[methodIndex].invoke(noteBuilder, inputString);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            methodIndex++;
        }
       return noteBuilder.build();
    }
    private Note createNoteViaBuilder(){
        NoteBuilder noteBuilder = Note.createNotebuilder();
        Iterator<String> iterator = View.inputWithRegex.keySet().iterator();

        noteBuilder.addLastName(inputNoteFields(iterator.next()))
                .addName(inputNoteFields(iterator.next()))
                .addPatronymic(inputNoteFields(iterator.next()))
                .addNickname(inputNoteFields(iterator.next()))
                .addComment(inputNoteFields(iterator.next()))
                .addGroup(inputNoteFields(iterator.next()))
                .addPhoneNumberHome(inputNoteFields(iterator.next()))
                .addPhoneNumberMobile(inputNoteFields(iterator.next()))
                .addPhoneNumberMobileExtra(inputNoteFields(iterator.next()))
                .addEmail(inputNoteFields(iterator.next()))
                .addSkype(inputNoteFields(iterator.next()))
                .addIndex(inputNoteFields(iterator.next()))
                .addCity(inputNoteFields(iterator.next()))
                .addStreet(inputNoteFields(iterator.next()))
                .addBuildingNumber(inputNoteFields(iterator.next()))
                .addApartmentNumber(inputNoteFields(iterator.next()));
       return noteBuilder.build();
    }

    private String inputNoteFields(String inputMessage) {
        String regex = View.inputWithRegex.get(inputMessage);
        if(regex != null){
            String res;
            view.printInput(inputMessage);
            while (!(scanner.hasNext()&&(res = scanner.next()).matches(regex))){
                view.printWrongInput();
            }
            return res;
        }
        return inputNoteGroupField(inputMessage);
    }

    private String inputNoteGroupField(String inputMessage) {
        while (true){
            view.printInput(inputMessage);
            if(scanner.hasNext()){
                try {
                    return Group.valueOf(scanner.next()).name();
                } catch (IllegalArgumentException ex){
                    view.printWrongInput();
                    view.printAllGroup();
                }
            } else {
                view.printWrongInput();
            }
        }
    }
    private void sortMethodsByMethodOrder (Method [] methods ){
        Arrays.sort(methods, (Method m1, Method m2) -> {
                MethodOrder or1 = m1.getAnnotation(MethodOrder.class);
                MethodOrder or2 = m2.getAnnotation(MethodOrder.class);
                // nulls last
                if (or1 != null && or2 != null) {
                    return or1.order() - or2.order();
                } else
                if (or1 != null && or2 == null) {
                    return -1;
                } else
                if (or1 == null && or2 != null) {
                    return 1;
                }
                return m1.getName().compareTo(m2.getName());
        });
    }


}
