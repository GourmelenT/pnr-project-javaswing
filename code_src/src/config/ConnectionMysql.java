package config;
import java.sql.*;
import javax.swing.event.*;
import javax.sql.RowSetListener;

public class ConnectionMysql {
    public static void main(String[] args){
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Utilisateur");

            while(res.next()){
                System.out.println(res.getString("pseudo")+"  "+res.getString("mdp"));
            }

            conn.close();
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
}
