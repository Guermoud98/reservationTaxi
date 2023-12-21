package DAO;
import Business.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;

public class IClientDAOImplement implements IClientDAO{
    Connection conn = ConnectionDB.getConnexion();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public void register(Personne p) {

            try {
                //isValidEmail(p.getEmail());  On fait appel à la fonction isValidEmail pour verifier la validité de l'email
                if(isValidEmail(p.getEmail()) && isValidPassword(p.getPassword()) && !isExistEmail(p.getEmail())) {
                    stmt = conn.prepareStatement("INSERT INTO client(nom, prenom, telephone, email, password)"
                            + "VALUES (?, ?, ?, ?, ?)");
                    stmt.setString(1, p.getNom());
                    stmt.setString(2, p.getPrenom());
                    stmt.setString(3, p.getTelephone());
                    stmt.setString(4, p.getEmail().toLowerCase());
                    stmt.setString(5, p.getPassword());
                    stmt.executeUpdate();
                    System.out.println("Inserted!");
                }
                else if(isExistEmail(p.getEmail())){
                    System.out.println("The email is already exists!!");
                }

            } catch (Exception e) {
                e.printStackTrace();
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
            if(rs.next()) {
                    flag = true;
            }
            rs.close();


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
    public void login(String email, String password) {
        try {
            stmt = conn.prepareStatement("SELECT password FROM client WHERE email = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while(rs.next()) {
                if(rs.getString("password").equals(password)) {
                    System.out.println("Welcome");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
