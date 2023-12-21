package DAO;
import Business.*;

import java.sql.*;

public class Test {
    public static void main (String [] args){
        Connection conn = ConnectionDB.getConnexion();
        Conducteur c1 = new Conducteur("neha","et","067857","NEHA.ET@gmail.com", "Neh2003@");
        IClientDAO i = new IClientDAOImplement();
        i.register(c1);
        i.login("NEHA.ET@gmail.com", "Neh2003@");
        //Conducteur c2 = new Conducteur("d","dyy","093338","dd@33");
        //Client c3 = new Client("ssd","dssyy","09223338","dd@323");
        //System.out.println(c1);S
        //System.out.println(c2);
        //System.out.println(c3);
    }
}
