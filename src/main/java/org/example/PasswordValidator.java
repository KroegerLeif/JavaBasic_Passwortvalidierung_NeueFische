package org.example;

public final class PasswordValidator {

    //Checks MinLength of The Password
    public static boolean hasMinLength(String password, int minLength){
        if(isEmptyPassword(password)){
            return false;
        }
        return  password.length() >= minLength;

    }

    public static boolean containsDigit(String password){
        if(isEmptyPassword(password)){
            return false;
        }
        for(char c : password.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperCaseAndLowerCase(String password){return false;};
    public static boolean isCommonPassword(String password){return false;};

    //TODO Bonus Aufgaben
    public static boolean containsSpecialCharacter(String password){return false;};

    //Hilfsmethoden
    private static boolean isEmptyPassword(String password){

        if(password == null || password.isEmpty()){
            return true;
        }
        return false;
    };

    //Ruft die anderen Methoden auf Schnittstelle nach draußen
    public static boolean isValid(String password){return false;};

}
