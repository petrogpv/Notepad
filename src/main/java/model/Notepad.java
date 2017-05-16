package model;

import model.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.05.2017.
 */
public class Notepad {
    private List<Note> notes;
    private static Notepad notepad;
    private int nextID = 1;

    private Notepad() {
        notes = new ArrayList<>();
    }

    public static Notepad getNotepad(){
        if(notepad == null){
            return new Notepad();
        }
        return notepad;
    }


    public void addNote (Note note){
        note.setNoteId(nextID);
        nextID++;
        notes.add(note);
    }

    public List<Note> getNotes(){
        return notes;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        notes.stream().forEach(x-> sb.append(x));
        return sb.toString();
    }
}
