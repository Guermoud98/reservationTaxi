package DAO;

import java.sql.*;

public class Test {
    public static void main (String [] args){
        Connection conn = ConnectionDB.getConnexion();
        Conducteur c1 = new Conducteur("guer","dd","098","dd@");
        Conducteur c2 = new Conducteur("d","dyy","093338","dd@33");
        Client c3 = new Client("ssd","dssyy","09223338","dd@323");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
