import controller.Controller;
import model.Notepad;
import model.entity.Note;
import view.View;

import java.util.List;

/**
 * Created by Администратор on 15.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Notepad notepad= Notepad.getNotepad();
        View view = new View();
        new Controller(notepad, view).run();

    }
}
