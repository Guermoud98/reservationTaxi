package DAO;
import Business.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;

public class IClientDAOImplement implements IClientDAO{
    Connection conn = ConnectionDB.getConnexion();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public void register(Personne p) {
        //isValidEmail(p.getEmail());  On fait appel à la fonction isValidEmail pour verifier la validité de l'email
        if(isValidEmail(p.getEmail()) && isValidPassword(p.getPassword()) && isExistEmail(p.getEmail()) == false){
            try {
                stmt = conn.prepareStatement("INSERT INTO client(nom, prenom, telephone, email, password)"
                        + "VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, p.getNom());
                stmt.setString(2, p.getPrenom());
                stmt.setString(3, p.getTelephone());
                stmt.setString(4, p.getEmail().toLowerCase());
                stmt.setString(5, p.getPassword());
                stmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(isExistEmail(p.getEmail()) == true){
            System.out.println("The email is already exists!!");
        }

    }
    public boolean isValidEmail(String email) {
        String regexExpression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(email);
        boolean m = matcher.find();
        return m;
    }
    public boolean isExistEmail(String email) {
        boolean flag = false;
        try {
            stmt = conn.prepareStatement("SELECT * FROM client");
            rs = stmt.executeQuery();
            while(rs.next()) {
                if(rs.getString("email").equals(email)) {
                    flag = true;
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }
    public boolean isValidPassword(String password) {
        String regexExpression = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{1,15})";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(password);
        boolean ma = matcher.find();
      return ma;

    }

}
