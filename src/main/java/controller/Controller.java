package controller;

import model.NicknameException;
import model.Notepad;
import model.entity.Group;
import model.entity.Note;
import view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller class
 */
public class Controller {
    private Notepad notepad;
    private View view;
    private Scanner scanner;

    /**
     * This constructor creates Controller instance
     *
     * @param notepad Notepad - sets Notepad instance
     * @param view    View - sets View instance
     */
    public Controller(Notepad notepad, View view) {
        this.notepad = notepad;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    /**
     * This method is runner
     */
    public void run() {

//        notepad.addNote(createNoteViaIteration());
//        view.printNotepad(notepad);

        notepad.addNote(createNoteViaBuilder());
        notepad.addNote(createNoteViaBuilder());
        view.printNotepad(notepad);

    }

    /**
     * This method creates Note instance using
     * Reflection API
     * NOTICE: nickname uniqueness check does not work
     * in this method
     *
     * @return Note - new Note instance
     */
    private Note createNoteViaIteration() {
        NoteBuilder noteBuilder = Note.createNotebuilder();
        Class nbClass = noteBuilder.getClass();
        Method[] methods = nbClass.getMethods();
        sortMethodsByMethodOrder(methods);
        Iterator<Method> iMethod = Arrays.asList(methods).iterator();
        Iterator<String> iInput = View.inputWithRegex.keySet().iterator();


        String inputString;
        while (iMethod.hasNext() && iInput.hasNext()) {
            inputString = inputNoteFields(iInput.next());
            try {
                iMethod.next().invoke(noteBuilder, inputString);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return noteBuilder.build();
    }

    /**
     * This method creates Note instance using
     * MoteBuilder
     * NOTICE: nickname uniqueness check work here
     *
     * @return Note - new Note instance
     */
    private Note createNoteViaBuilder() {
        NoteBuilder noteBuilder = Note.createNotebuilder();
        Iterator<String> iterator = View.inputWithRegex.keySet().iterator();

        noteBuilder.addLastName(inputNoteFields(iterator.next()))
                .addName(inputNoteFields(iterator.next()))
                .addPatronymic(inputNoteFields(iterator.next()))
                .addNickname(inputNoteNicknameFields(iterator.next()))
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

    /**
     * This method inputs Note fields using Scanner
     * and validates them
     *
     * @param inputMessage String - label for field input
     * @return String - validated string
     */
    private String inputNoteFields(String inputMessage) {
        String regex = View.inputWithRegex.get(inputMessage);
        if (regex != null) {
            String res;
            view.printInput(inputMessage);
            while (!(scanner.hasNext() && (res = scanner.next()).matches(regex))) {
                view.printWrongInput();
            }
            return res;
        }
        return inputNoteGroupField(inputMessage);
    }

    /**
     * This method inputs nickname Note field using Scanner
     * and validates it for uniqueness
     *
     * @param inputMessage String - label for nickname input
     * @return String - validated nickname
     */
    private String inputNoteNicknameFields(String inputMessage) {
        String nickname = "";

        view.printInput(inputMessage);
        while (true) {
            if (scanner.hasNext() && checkNickname(nickname = scanner.next())) {
                return nickname;
            } else {
                try {
                    throw new NicknameException(nickname);
                } catch (NicknameException e) {
                    e.printStackTrace();
                }
                view.printWrongNicknameInput();
            }
        }
    }

    /**
     * This method validates inputted nickname for uniqueness
     *
     * @param nickname String - inputted nickname
     * @return boolean - true if nickname is free
     * and false if occupied
     */
    private boolean checkNickname(String nickname) {
        for (Note note : notepad.getNotes()) {
            if (nickname.equals(note.getNickname())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method validates inputted group with existing Group
     *
     * @param inputMessage String - label for group name input
     * @return String - regex validated string
     */
    private String inputNoteGroupField(String inputMessage) {
        while (true) {
            view.printInput(inputMessage);
            if (scanner.hasNext()) {
                try {
                    return Group.valueOf(scanner.next()).name();
                } catch (IllegalArgumentException ex) {
                    view.printWrongInput();
                    view.printAllGroup();
                }
            } else {
                view.printWrongInput();
            }
        }
    }

    /**
     * This method sorts Method [] array received from class
     * which methods are annotated with @MethodOrder
     *
     * @param methods Method [] - array to sort
     */
    private void sortMethodsByMethodOrder(Method[] methods) {
        Arrays.sort(methods, (Method m1, Method m2) -> {
            MethodOrder or1 = m1.getAnnotation(MethodOrder.class);
            MethodOrder or2 = m2.getAnnotation(MethodOrder.class);
            // nulls last
            if (or1 != null && or2 != null) {
                return or1.order() - or2.order();
            } else if (or1 != null && or2 == null) {
                return -1;
            } else if (or1 == null && or2 != null) {
                return 1;
            }
            return m1.getName().compareTo(m2.getName());
        });
    }
}
