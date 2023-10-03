//This class connects java with my sql database

package university.managment.system;

import java.sql.*;

public class Conn {
    
    Connection c; //interface
    Statement s;//interface
    
    Conn(){
        try{
            //JDBC connectivity in 5 steps
            // 1. Register the Driver Class
            // 2. Creating Connection String
            // 3. Creating Statement
            // 4. Executing MySQL Queries
            // 5. Closing the Connection
            
            
            // 1.Register the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj is package and Driver is Class
            
            // 2. Creating Connection String
            
            //jis database se connect krni hai us databse ki information mention krni hoti hai
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagmentsystem","root","Simmi@12345");
            
            // 3. Creating Statement
            s = c.createStatement();// helps in executing the my sql queries
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
