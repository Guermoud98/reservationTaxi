 package DAO;
import Business.*;

import java.sql.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
 public static void main (String [] args) {
     LocalDate date = LocalDate.now();
     LocalTime time = LocalTime.now();
     Connection conn = ConnectionDB.getConnexion();
     IReservationDAO res = new IReservationDAOImplement();
     Conducteur cond = new Conducteur("Souhail", "Sahhim", "0688776655", "sa.Sahhim@gmail.com", "Q12#sd");

     Client cl = new Client("guerra", "dalal", "1233", "guerra.dal@gmail.com", "T1a@A");
     //IConducteurDAO c = new IConducteurDAOimplement();
     //c.register(cond);
     Reservation r = new Reservation("Sidi Abbad", "Targa", "Carte Bancaire", 30.0f, date, time, cl);
     res.insertReservation(r);
     //c.login("jacki.f@gmail.com", "Ja@18");

     //IClientDAO i = new IClientDAOImplement();
     //ITaxiDAO taxi = new ITaxiDAOImplementation();
     //IReservationDAO res = new IReservationDAOImplement();
     //res.getAllReservations();
     //taxi.getAllTaxis();
     //System.out.println(i.getIdFromDB(c1));

     //i.register(c2);
     //i.login("neha.et@gmail.com", "Neh2003@");
     //i.updateInfo("nehaa",null,"03435");
     //Conducteur c2 = new Conducteur("d","dyy","093338","dd@33");
     //Client c3 = new Client("ssd","dssyy","09223338","dd@323");
     //System.out.println(c1);S
     //System.out.println(c2);
     //System.out.println(c3);
     //i.logout();
     //System.out.println("hello");
     //i.updateTelephone(c2,  "0753684");

 }
   
}
