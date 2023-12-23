package DAO;
import Business.*;

import java.sql.*;

public class Test {
    public static void main (String [] args){
        Connection conn = ConnectionDB.getConnexion();
        Conducteur c1 = new Conducteur("hanan","fra","06789","hanane.ad@gmail.com", "Hann@12");
        IClientDAO i = new IClientDAOImplement();
        i.register(c1);
       // i.login("hanane.ad@gmail.com", "Hann@12");
       // i.updateInfo("nehaa",null,"03435");
        //Conducteur c2 = new Conducteur("d","dyy","093338","dd@33");
        //Client c3 = new Client("ssd","dssyy","09223338","dd@323");
        //System.out.println(c1);S
        //System.out.println(c2);
        //System.out.println(c3);
        i.logout();
        System.out.println("hello");
    }
}
