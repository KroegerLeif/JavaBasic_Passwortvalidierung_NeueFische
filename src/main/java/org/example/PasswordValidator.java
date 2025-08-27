package org.example;

public final class PasswordValidator {

    //Checks MinLength of The Password
    public static boolean hasMinLength(String password, int minLength){
        if(isEmptyPassword(password)){
            return false;
        }
        return  password.length() >= minLength;

    }

    //Checks if the Password contains a Digit
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

    //Checks if the Password contains both Upper and Lower Case Characters
    public static boolean containsUpperCaseAndLowerCase(String password){
        //Checks if the Password is Empty or has less than 2 Characters
        if(isEmptyPassword(password) || password.length() < 2 ){
            return false;
        }
        //Checks if the Password contains both Upper and Lower Case Characters
        return (isUpperCase(password) && isLowerCase(password));

    }


    //Checks if the Password is a Common Password
    public static boolean isCommonPassword(String password){
        if(isEmptyPassword(password)){
            return false;
        }
        String[] commonPasswords = getCommenPasswords();
        for(String commonPassword : commonPasswords){
            if(commonPassword.equals(password)){
                return true;
            }
        }return false;
    }

    //Cheks if the Password contains a Special Character
    public static boolean containsSpecialCharacter(String password, char[] allowed){
        if(isEmptyPassword(password)){
            return false;
        }
        for(char c : password.toCharArray()){
            for(char allowedChar : allowed){
                if(c == allowedChar){
                    return true;
                }
            }
        }
        return false;
    }

    //Hilfsmethoden
    private static boolean isEmptyPassword(String password){

        if(password == null || password.isEmpty()){
            return true;
        }
        return false;
    };

    private static boolean isUpperCase(String password){
        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)){
                return true;
            }
        }return false;
    }

    private static boolean isLowerCase(String password){
        for(char c : password.toCharArray()){
            if(Character.isLowerCase(c)){
                return true;
            }
        }return false;
    }

    private static String[] getCommenPasswords(){
        //TODO Get A List from an External File
        String[] commonPasswords = {
                "123456",
                "admin",
                "Password",
                "password1",
                "password123",
                "geheim",
                "Geheim"
        };
        return commonPasswords;
    };

    private static char[] getSpecialCharacters(){
        char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?'};
        return specialCharacters;
    }


    //Ruft die anderen Methoden auf Schnittstelle nach draußen
    public static boolean isValid(String password){
        if(isCommonPassword(password)){
            return false;
        }
        int minLeng = 8;
        return containsDigit(password) &&
                containsUpperCaseAndLowerCase(password) &&
                containsSpecialCharacter(password, getSpecialCharacters()) &&
                hasMinLength(password, minLeng);

    }

}
