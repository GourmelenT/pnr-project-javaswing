package config;
import java.sql.*;

/**
 * Class singleton pour recupérer la connection à mysql
 */
public class Config {
    private Config(){

    }
    private static Connection c;

    public static Connection get(){
        if(c == null){
            try{
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", "root", "root");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return c;
    }
}
