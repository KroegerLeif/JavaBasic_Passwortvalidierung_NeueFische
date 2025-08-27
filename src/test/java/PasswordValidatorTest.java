import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorTest {

    //3.1 Mindestlänge
    @Test
    void testMinLength_checksCorrectLength_givenCorrectLength() {
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

        boolean[] expected = {
                true,
                true,
                true
        };

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
    void testMinLength_checksCorrectLength_givenIncorrectLength() {
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

        boolean[] expected = {
                false,
                false,
                false
        };

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
    void tesMinLength_checksForNull_givenANullString(){
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
    void testMinLength_cheksEmptyString_givenEmptyString(){
        //Given
        String password = "";
        int minLength = 0;
        boolean expected = false;
        //When
        boolean actual = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertEquals(expected, actual);
    }
}
