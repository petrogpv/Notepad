package model;

/**
 * Created by Администратор on 22.05.2017.
 */
public class NicknameException extends IllegalArgumentException {
    public NicknameException(String message) {
        super("Nickname " + message +" already exists!");
    }
}
