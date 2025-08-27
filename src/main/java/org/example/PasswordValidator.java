package org.example;

public final class PasswordValidator {

    //Checks MinLength of The Password
    public static boolean hasMinLength(String password, int minLength){
        if(password == null || password.isEmpty()){
            //TODO Gives a hint to the user that the password enty was wrong
            return false;
        }else {
            return  password.length() >= minLength;
        }
    }

    public static boolean containsDigit(String password){return false;};
    public static boolean containsUpperCaseAndLowerCase(String password){return false;};
    public static boolean isCommonPassword(String password){return false;};

    //TODO Bonus Aufgaben
    public static boolean containsSpecialCharacter(String password){return false;};


    //Ruft die Anderen Methoden auf
    public static boolean isValid(String password){return false;};

}
