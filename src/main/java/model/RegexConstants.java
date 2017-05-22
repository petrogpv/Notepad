package model;

/**
 * Created by Администратор on 15.05.2017.
 */
public interface RegexConstants {
    String NAME_REGEX = "^[A-Z]{1}[a-z]+([-][A-Z]{1}[a-z]+)?$";

    String NICKNAME_REGEX = "^([a-z|A-Z|\\d]){3,12}$";

    String PHONE_REGEX = "^[0][1-9]{2}[-][0-9]{3}([-][0-9]{2}){2}$";

    String PHONE_EXTRA_REGEX = "^$|([0][1-9]{2}[-][0-9]{3}([-][0-9]{2}){2})?|0?";

    String INDEX_REGEX = "^[0-9]{5}$";

    String CITY_REGEX = "^[A-Z]{1}[a-z]+(?:[\\s-][A-Z]{1}[a-z]+)*$";

    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    String BUILDING_REGEX = "^[0-9]+(([-\\s]?[a-zA-Z])|([/][0-9]+([-\\s]?[a-zA-Z])?))?$";

    String APARTMENT_REGEX = "^[0-9]+$";

    String ANYTHING_REGEX = "^.*$";
}
