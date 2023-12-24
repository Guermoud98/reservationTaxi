package DAO;

import Business.Personne;
import Business.Taxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IConducteurDAOimplement implements IConducteurDAO {
    Connection conn = ConnectionDB.getConnexion();
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
    PreparedStatement stmt3 = null;
    ResultSet rs = null;
    public void register(Personne p) {
        try {
            //isValidEmail(p.getEmail());  On fait appel à la fonction isValidEmail pour verifier la validité de l'email
            if (isValidEmail(p.getEmail()) && isValidPassword(p.getPassword()) && !isExistEmail(p.getEmail())) {
                stmt = conn.prepareStatement("INSERT INTO conducteur(nom, prenom, telephone, email, password, matricule)"
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                stmt.setString(1, p.getNom());
                stmt.setString(2, p.getPrenom());
                stmt.setString(3, p.getTelephone());
                stmt.setString(4, p.getEmail().toLowerCase());
                stmt.setString(5, p.getPassword());
                stmt.setString(6, selectRandomMatricule() );
                stmt.executeUpdate();
                System.out.println("Inserted!");
                // On doit mettre a jour le status du taxi car il n'est plus dispo


            } else if (isExistEmail(p.getEmail())) {
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
            stmt = conn.prepareStatement("SELECT * FROM conducteur WHERE email = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                flag = true;
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

    public void login(String email, String password) {
        if (conn != null) {
            try {
                stmt = conn.prepareStatement("SELECT idConducteur, nom, password FROM conducteur WHERE email = ?");
                stmt.setString(1, email);
                rs = stmt.executeQuery();
                while (rs.next()) {
                        System.out.println("Welcome " + rs.getString("nom")
                        + ", ur password : " + rs.getString("password"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("you are not connected");
        }
    }
    //On attribue au conducteur inscrit le matricule d'un taxi aleatoirement
    public String selectRandomMatricule() {
        String matricule = "";
        try {
            stmt2 = conn.prepareStatement("SELECT TOP 1 matricule FROM taxi WHERE status = ? ORDER BY NEWID()");
            stmt2.setString(1, "Disponible");
            rs = stmt2.executeQuery();
            while(rs.next()) {
                matricule = rs.getString("matricule");
            }
            //updateTaxiStatus();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return matricule;
    }
    public int getIdFromDB(Personne p) {
        int id = -1;
        try {
            stmt = conn.prepareStatement("SELECT idConducteur FROM conducteur WHERE email = ?");
            stmt.setString(1, p.getEmail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idConducteur");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }

    // La methode qui met à jour le statut du taxi apres avoir ete affecte a un conducteur
    /*public void updateTaxiStatus() {
        String mat = selectRandomMatricule();
        try {
            if (!mat.equals("")) {
                stmt3 = conn.prepareStatement("UPDATE taxi SET status = ? WHERE matricule = ?");
                stmt3.setString(1, "Occupe");
                stmt3.setString(2, mat );
                stmt3.executeUpdate();
                conn.commit();
                System.out.println("done");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    public void conducteurOfATaxi(String matriule) {
        try {

            stmt = conn.prepareStatement("SELECT * FROM conducteur WHERE matricule= ?");
            stmt.setString(1, matriule);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("[idConducteur: " + rs.getString("idConducteur")
                        + ", nom: " + rs.getString("nom") + ", prenom: " + rs.getString("prenom")
                        + ", telephone: " + rs.getString("telephone") + ", email: " + rs.getString("email")
                        + " ]");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int getRandomConducteur() {
        int idCond = 0;
        try {
            stmt2 = conn.prepareStatement("SELECT TOP 1 idConducteur, nom FROM conducteur  ORDER BY NEWID()");
            rs = stmt2.executeQuery();
            while(rs.next()) {
                 idCond = rs.getInt("idConducteur");
                System.out.println("nom: " + rs.getString("nom"));
            }
            //updateTaxiStatus();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCond;
    }
}
