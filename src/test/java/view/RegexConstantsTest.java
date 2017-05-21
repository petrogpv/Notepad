package view;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.Target;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 21.05.2017.
 */
public class RegexConstantsTest {


    @Test
    public void testNameWrong() {
        assertFalse("AAnton".matches(RegexConstants.NAME_REGEX));
        assertFalse("AntoN".matches(RegexConstants.NAME_REGEX));
        assertFalse("anton".matches(RegexConstants.NAME_REGEX));
        assertFalse("A8nton".matches(RegexConstants.NAME_REGEX));
        assertFalse("A-ton".matches(RegexConstants.NAME_REGEX));
    }

    @Test
    public void testNicknameWrong() {
        assertFalse("on".matches(RegexConstants.NICKNAME_REGEX));
        assertFalse("o n".matches(RegexConstants.NICKNAME_REGEX));
        assertFalse("wfqfwerqgfwergerwgerw".matches(RegexConstants.NICKNAME_REGEX));
        assertFalse("wfqf#erw".matches(RegexConstants.NICKNAME_REGEX));
    }

    @Test
    public void testPhoneNumberWrong() {
        assertFalse("8-067-555-66-77".matches(RegexConstants.PHONE_REGEX));
        assertFalse("867-555-66-77".matches(RegexConstants.PHONE_REGEX));
        assertFalse("067 555 66 77".matches(RegexConstants.PHONE_REGEX));
        assertFalse("067-55-66-77".matches(RegexConstants.PHONE_REGEX));
    }
    @Test
    public void testEmailWrong() {
        assertFalse("_ grg@mail.com".matches(RegexConstants.EMAIL_REGEX));
        assertFalse("grgh.mail.com".matches(RegexConstants.EMAIL_REGEX));
        assertFalse("grgh@com".matches(RegexConstants.EMAIL_REGEX));
    }

    @Test
    public void testBuildingNumberCorrect(){
        assertTrue("6-b".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6-B".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6f".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6 f".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6F".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6/4".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6/4h".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6/4-h".matches(RegexConstants.BUILDING_REGEX));
        assertTrue("6/4 h".matches(RegexConstants.BUILDING_REGEX));
    }


}