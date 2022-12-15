import java.sql.*;

public class ConnectionData { 
    Connection  cn;
    Statement st=null;    
    public ConnectionData() {
          //String user ="user",passwd="password";
                try {
               String Driver ="org.postgresql.Driver";
               Class.forName(Driver);
               String url = "jdbc:postgresql://localhost:5432/Compte";
                 cn = DriverManager.getConnection(url, user,passwd);
                  st= cn.createStatement();
               
                                      
               } catch (Exception e) {
                 
                   System.out.println("Erreur de  Connexion");}
             }  
             public Connection myConnexion() {
                return cn;
             }
             }
            