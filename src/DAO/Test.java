package DAO;
import Business.*;

import java.sql.*;

public class Test {
    public static void main (String [] args){
        Connection conn = ConnectionDB.getConnexion();
        Conducteur cond = new Conducteur("amal", "bent", "3453456", "amal.bn@gmail.com", "Am12#");

        IConducteurDAO c = new IConducteurDAOimplement();
        //c.register(cond);
        System.out.println(c.getRandomConducteur());
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
