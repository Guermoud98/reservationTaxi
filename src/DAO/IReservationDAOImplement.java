package DAO;

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
}
