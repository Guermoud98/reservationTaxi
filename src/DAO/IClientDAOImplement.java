package DAO;
import Business.*;

import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;

public class IClientDAOImplement implements IClientDAO{
    Connection conn = ConnectionDB.getConnexion();
    PreparedStatement stmt = null;
    public void register(Personne p) {
        //isValidEmail(p.getEmail());  On fait appel à la fonction isValidEmail pour verifier la validité de l'email
        if(isValidEmail(p.getEmail()) && isValidPassword(p.getPassword())) {
            try {
                stmt = conn.prepareStatement("INSERT INTO client(nom, prenom, telephone, email, password)"
                        + "VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, p.getNom());
                stmt.setString(2, p.getPrenom());
                stmt.setString(3, p.getTelephone());
                stmt.setString(4, p.getEmail());
                stmt.setString(5, p.getPassword());
                stmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    public boolean isValidEmail(String email) {
        String regexExpression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(email);
        boolean m = matcher.find();
        return m;
    }
    public boolean isValidPassword(String password) {
        String regexExpression = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{1,15})";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(password);
        boolean m = matcher.find();
      return m;

    }

}
