package DAO;

import java.sql.*;

public class Test {
    public static void main (String [] args){
        Connection conn = ConnectionDB.getConnexion();
        System.out.println(conn);
    }
}
