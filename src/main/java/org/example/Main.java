package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if(PasswordValidator.isValid("password")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }

        String sequrePassword = PasswordValidator.generateSecurePassword(22, "&%$§&");
        System.out.println(sequrePassword);

        String password = PasswordValidator.generateSecurePassword(10, "&§!");
        System.out.println(password);


        System.out.println(PasswordValidator.isValid(sequrePassword));

        System.out.println(PasswordValidator.isValid(password));
    }
}