package org.example;

import java.security.SecureRandom;

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
    public static boolean containsSpecialCharacter(String password, String allowedContent){
        if(isEmptyPassword(password)){
            return false;
        }
        char[] allowed = allowedContent.toCharArray();
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

    private static String getSpecialCharacters(){
        char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?'};
        return new String(specialCharacters);
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

    public static String generateSecurePassword(int length, String allowedSpecials){

        SecureRandom random = new SecureRandom();

        // Alle verfügbaren Zeichen definieren
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = lowerCase.toUpperCase();
        String digits = "0123456789";
        String allChars = upperCase + lowerCase + digits + allowedSpecials;

        // Erste zufällige Zeichenkette erstellen
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Solange das Passwort nicht valid ist, zufällige Zeichen ändern
        int maxAttempts = 1000; // Schutz vor Endlosschleife
        int attempts = 0;

        while (!isValid(password.toString()) && attempts < maxAttempts) {
            // Zufällige Position im Passwort wählen
            int randomPosition = random.nextInt(length);

            // Zufälliges neues Zeichen wählen
            char newChar = allChars.charAt(random.nextInt(allChars.length()));

            // Zeichen an zufälliger Position ändern
            password.setCharAt(randomPosition, newChar);

            attempts++;
        }

        // Falls nach maxAttempts immer noch nicht valid, Exception werfen
        if (!isValid(password.toString())) {
            System.out.println("Problem mit der Generirung des Passworts.");
        }

        return password.toString();
    }

}
