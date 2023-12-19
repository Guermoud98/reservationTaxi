package DAO;
import Business.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.sql.Connection;

public class IClientDAOImplement implements IClientDAO{
    Connection conn = ConnectionDB.getConnexion();
    public void register(Personne p) {
        String regexExpression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(p.getEmail());
        boolean m = matcher.find();
        if(m == true) {
            System.out.println("Valid Email");
        }
        else {
            System.out.println("Invalid Email");
        }


    }
}
