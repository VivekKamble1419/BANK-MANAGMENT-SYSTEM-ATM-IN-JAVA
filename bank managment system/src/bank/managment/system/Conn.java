
package bank.managment.system;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{//for handling excaptions 
          //it is under library mysql java
             c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "142003");
             s = c.createStatement();
           // c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root","142003");// creating connection string
          //  s = c.createStatement();
            //import library mysql connector library java
        }catch (Exception e){
            System.out.print(e);
        }
    }
}
