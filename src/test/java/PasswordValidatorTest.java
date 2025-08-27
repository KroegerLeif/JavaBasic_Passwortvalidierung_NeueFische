import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorTest {

    //3.1 Mindestlänge
    @Test
    void minLength_checksCorrectLength_givenCorrectLength() {
        //Given
        String[] passwords = {
                "1234567",
                "12345678",
                "123456789"
        };

        int[] minLength = {
                7,
                8,
                9
        };

        boolean[] expected = new boolean[passwords.length];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = true;
        }

        //When
        boolean[] actual = new boolean[passwords.length];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = PasswordValidator.hasMinLength(passwords[i], minLength[i]);
        }

        //Then
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void minLength_checksCorrectLength_givenIncorrectLength() {
        //Given
        String[] passwords = {
                "1234567",
                "12345678",
                "123456789"
        };

        int[] minLength = {
                9,
                10,
                11
        };

        boolean[] expected = new boolean[passwords.length];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = false;
        }

        //When
        boolean[] actual = new boolean[passwords.length];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = PasswordValidator.hasMinLength(passwords[i], minLength[i]);
        }

        //Then
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void minLength_checksForNull_givenANullString(){
        //Given
        String password = null;
        int minLength = 10;
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void minLength_cheksEmptyString_givenEmptyString(){
        //Given
        String password = "";
        int minLength = 0;
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertEquals(expected, actual);
    }

    //3.2 Ziffern enthalten
    @Test
    void containsDigit_checksForNull_givenANullString(){
        //Given
        String password = null;
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.containsDigit(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_checksForDigit_givenADigit(){
        //Given
        String[] passwords = {
                "1",
                "12",
                "abc1",
                "absce3sdf",
                "123456789"
        };

        boolean[] expected = new boolean[passwords.length];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = true;
        }

        //When
        boolean[] actual = new boolean[passwords.length];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = PasswordValidator.containsDigit(passwords[i]);
        }

        //Then
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void containsDigit_checksForNoDigit_givenNoDigit(){
        //Given
        String password = "Password";
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.containsDigit(password);
        //Then
        assertEquals(expected, actual);
    }

    //3.3 Groß und Kleinbuchstaben
    @Test
    void containsUpperCaseAndLowerCase_checksForNull_givenANullString(){
        //Given
        String password = null;
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.containsUpperCaseAndLowerCase(password);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void containsUpperCaseAndLowerCase_returnTrue_cheksWithValidText(){
        //Given
        String[] passwords = {
                "Ab",
                "bA",
                "Hallo",
                "ooooH",
                "1aaaB",
                "1AAAb"
        };

        boolean[] expected = new boolean[passwords.length];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = true;
        }


        //When
        boolean[] actual = new boolean[passwords.length];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = PasswordValidator.containsUpperCaseAndLowerCase(passwords[i]);
        }

        //Then
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void containsUpperCaseAndLowerCase_returnFalse_cheksWithInvalidText(){
        //Given
        String[] passwords = {
                "AAAA",
                "bbbbb",
                "A",
                "a",
                "11",
                "1y",
                "1Y"
        };

        boolean[] expected = new boolean[passwords.length];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = false;
        }


        //When
        boolean[] actual = new boolean[passwords.length];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = PasswordValidator.containsUpperCaseAndLowerCase(passwords[i]);
        }

        //Then
        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
