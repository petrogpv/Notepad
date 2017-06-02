package controller;

import model.entity.Address;
import model.entity.Group;
import model.entity.Note;
import java.util.Date;

/**
 * Created by Администратор on 16.05.2017.
 */
public class NoteBuilder {

    public static final String SPACE_SIGN = "\u0020";
    public static final String DOT_SIGN = ".";
    public static final String EMPTY_STRING = "";
    public static final int ZERO = 0;
    private Note note;
    private Address address = new Address();

    public NoteBuilder(Note note) {
        this.note = note;
    }


    @MethodOrder(order = 1)
    public NoteBuilder addLastName(String lastName) {
        note.setLastName(lastName);
        return this;
    }
    @MethodOrder(order = 2)
    public NoteBuilder addName(String name) {
        note.setName(name);
        return this;
    }
    @MethodOrder(order = 3)
    public NoteBuilder addPatronymic(String patronymic) {
        note.setPatronymic(patronymic);
        return this;
    }
    @MethodOrder(order = 4)
    public NoteBuilder addNickname(String nickname) {
        note.setNickname(nickname);
        return this;
    }
    @MethodOrder(order = 5)
    public NoteBuilder addComment(String comment) {
        note.setComment(comment);
        return this;
    }
    @MethodOrder(order = 6)
    public NoteBuilder addGroup(String group) {
        Group gr= Group.valueOf(group);
        note.setGroup(gr);
        return this;

    }
    @MethodOrder(order = 7)
    public NoteBuilder addPhoneNumberHome(String phoneNumberHome) {
        note.setPhoneNumberHome(phoneNumberHome);
        return this;
    }
    @MethodOrder(order = 8)
    public NoteBuilder addPhoneNumberMobile(String phoneNumberMobile) {
        note.setPhoneNumberMobile(phoneNumberMobile);
        return this;
    }
    @MethodOrder(order = 9)
    public NoteBuilder addPhoneNumberMobileExtra(String phoneNumberMobileExtra) {
        if(phoneNumberMobileExtra.equals(String.valueOf(ZERO))){
            phoneNumberMobileExtra = EMPTY_STRING;
        }
        note.setPhoneNumberMobileExtra(phoneNumberMobileExtra);
        return this;
    }
    @MethodOrder(order = 10)
    public NoteBuilder addEmail(String email) {
        note.setEmail(email);
        return this;
    }
    @MethodOrder(order = 11)
    public NoteBuilder addSkype(String skype) {
        note.setSkype(skype);
        return this;
    }
    @MethodOrder(order = 12)
    public NoteBuilder addIndex(String index) {
        address.setIndex(index);
        return this;
    }
    @MethodOrder(order = 13)
    public NoteBuilder addCity(String city) {
        address.setCity(city);
        return this;
    }
    @MethodOrder(order = 14)
    public NoteBuilder addStreet(String street) {
        address.setStreet(street);
        return this;
    }
    @MethodOrder(order = 15)
    public NoteBuilder addBuildingNumber(String building) {
        address.setBuildingNumber(building);
        return this;
    }
    @MethodOrder(order = 16)
    public NoteBuilder addApartmentNumber(String apartment) {
        address.setAppartmentNumber(apartment);
        return this;
    }


    public Note build(){
        note.setAddress(address);
        createShortName();

        Date now = new Date();
        note.setDateCreated(now);
        note.setDateChanged(now);

        return note;
    }

    public void createShortName(){
        StringBuilder sb = new StringBuilder();
        sb.append(note.getLastName())
                .append(SPACE_SIGN)
                .append(note.getName().charAt(ZERO))
                .append(DOT_SIGN);
        note.setShortName(sb.toString());
    }
}
