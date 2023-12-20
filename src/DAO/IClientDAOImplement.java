package DAO;
import Business.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;

public class IClientDAOImplement implements IClientDAO{
    Connection conn = ConnectionDB.getConnexion();
    public void register(Personne p) {
        isValidEmail(p.getEmail()); // On fait appel à la fonction isValidEmail pour verifier la validité de l'email
        isValidPassword(p.getPassword());

    }
    public void isValidEmail(String email) {
        String regexExpression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(email);
        boolean m = matcher.find();
        if(m == true) {
            System.out.println("Valid Email");
        }
        else {
            System.out.println("Invalid Email");
        }
    }
    public void isValidPassword(String password) {
        String regexExpression = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{1,15})";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(password);
        boolean m = matcher.find();
        if(m == true) {
            System.out.println("Valid Password");
        }
        else {
            System.out.println("Invalid Password");
        }

    }
    public int passwordContainsUpperLetters(String password) {
        int upperCount = 0;
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch)) {
                upperCount++;
            }
        }
        return upperCount;
    }
    public int passwordContainsLowerLetters(String password) {
        int lowerCount = 0;
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(Character.isLowerCase(ch)) {
                lowerCount++;
            }
        }
        return lowerCount;
    }
    public int passwordContainsDigits(String password){
            int digitCount = 0;
            for (int i = 0; i < password.length(); i++){
                /* In general, we used “.*\\d.*” as regex to denote that the string contains at least one digit.
                 Alternatively, we can replace “\\d” with “[0-9]” as they describe the same thing (digit/number).*/
                if(password.matches(".*\\d.*")) {
                    digitCount++;
                }
            }
        return digitCount;
    }
}
