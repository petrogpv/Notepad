package view;

import model.RegexConstants;

import java.util.*;

/**
 * Created by Администратор on 15.05.2017.
 */
public interface ViewConstants extends RegexConstants {
    String MESSAGES_BUNDLE_NAME = "messages";
    ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
//            new Locale("ua"));
            new Locale("en"));

    String WRONG_INPUT = resourceBundle.getString("input.wrong");
    String WRONG_INPUT_NICKNAME = resourceBundle.getString("input.wrong.nickname");
    String INPUT = resourceBundle.getString("input.input");
    String SURNAME = resourceBundle.getString("input.surname");
    String NAME = resourceBundle.getString("input.name");
    String PATRONYMIC = resourceBundle.getString("input.patronymic");
    String NICKNAME = resourceBundle.getString("input.nickname");
    String COMMENT = resourceBundle.getString("input.comment");
    String GROUP = resourceBundle.getString("input.group");
    String PHONE_HOME = resourceBundle.getString("input.phone.home");
    String PHONE_MOBILE = resourceBundle.getString("input.phone.mobile");
    String PHONE_EXTRA = resourceBundle.getString("input.phone.mobile.extra");
    String EMAIL = resourceBundle.getString("input.email");
    String SKYPE = resourceBundle.getString("input.skype");
    String INDEX = resourceBundle.getString("input.address.index");
    String CITY = resourceBundle.getString("input.address.city");
    String STREET = resourceBundle.getString("input.address.street");
    String BUILDING = resourceBundle.getString("input.address.building");
    String APARTMENT =resourceBundle.getString("input.address.apartment");

    Map<String,String> inputWithRegex = new LinkedHashMap<String, String>(){{
        put(SURNAME,NAME_REGEX);
        put(NAME,NAME_REGEX);
        put(PATRONYMIC,NAME_REGEX);
        put(NICKNAME,NICKNAME_REGEX);
        put(NICKNAME,NICKNAME_REGEX);
        put(COMMENT,ANYTHING_REGEX);
        put(GROUP,null);
        put(PHONE_HOME,PHONE_REGEX);
        put(PHONE_MOBILE,PHONE_REGEX);
        put(PHONE_EXTRA,PHONE_EXTRA_REGEX);
        put(EMAIL,EMAIL_REGEX);
        put(SKYPE,ANYTHING_REGEX);
        put(INDEX,INDEX_REGEX);
        put(CITY,CITY_REGEX);
        put(STREET,CITY_REGEX);
        put(BUILDING,BUILDING_REGEX);
        put(APARTMENT,APARTMENT_REGEX);
    }};

}
