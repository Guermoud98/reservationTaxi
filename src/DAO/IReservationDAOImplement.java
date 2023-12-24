package DAO;

import Business.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IReservationDAOImplement implements IReservationDAO{
    Connection conn = ConnectionDB.getConnexion();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public void getAllReservations() {
        try {
            stmt = conn.prepareStatement("SELECT * FROM reservation");
            rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println("[idReservation: " +rs.getInt("idReservation")
                + ", lieuSource: " + rs.getString("lieuSource") + ", lieuDestination; " +
                        rs.getString("lieuDestination") + ", typePaiement: " +
                        rs.getString("typePaiement") + ", tarif" + rs.getFloat("tarif")
                + ", date: " + rs.getDate("date") + ", heure: " + rs.getTime("heure")
                + ", idClient: " + rs.getInt("idClient") + ", idConducteur: " + rs.getInt("idConducteur")
                 + ", matricule du taxi: " + rs.getString("matricule") + "]");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void insertReservation(Reservation r) {
        IPersonneDAO i = new IClientDAOImplement();
        int idClient = i.getIdFromDB(r.getClient()); // l'argument est un client
        try {
            stmt = conn.prepareStatement("INSERT INTO reservation(lieuSource, lieuDestination, typePaiement" +
                    " tarif, date, heure, idClient, idConducteur, matricule) VALUES (?,?,?,?,?,?,?,?,?");
            stmt.setString(1, r.getLieuSource());
            stmt.setString(2, r.getLieuDestination());
            stmt.setString(3, r.getTypePaiement());
            stmt.setFloat(4, r.getTarif());
            stmt.setDate(5, r.getD());
            stmt.setTime(6, r.getHeure());
            stmt.setInt(7, idClient);





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
