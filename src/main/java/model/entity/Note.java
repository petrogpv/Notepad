package model.entity;

import controller.NoteBuilder;
import java.util.Date;

/**
 * Created by Администратор on 15.05.2017.
 */
public class Note {
    private int noteId;
    private String lastName;
    private String name;
    private String shortName;
    private String patronymic;
    private String nickname;
    private String comment;
    private Group group;
    private String phoneNumberHome;
    private String phoneNumberMobile;
    private String phoneNumberMobileExtra;
    private String email;
    private String skype;
    private Address address;
    private Date dateCreated;
    private Date dateChanged;

    public static NoteBuilder createNotebuilder (){
        return new NoteBuilder();
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
    }

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    public String getPhoneNumberMobileExtra() {
        return phoneNumberMobileExtra;
    }

    public void setPhoneNumberMobileExtra(String phoneNumberMobileExtra) {
        this.phoneNumberMobileExtra = phoneNumberMobileExtra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID ='" + noteId + '\'' +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", group=" + group +
                ", phoneNumberHome='" + phoneNumberHome + '\'' +
                ", phoneNumberMobile='" + phoneNumberMobile + '\'' +
                ", phoneNumberMobileExtra='" + phoneNumberMobileExtra + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                "}\n";
    }
}
