// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//
package CONECCIÓN_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQConnect {
    Connection con;
    Statement st;
    ResultSet rs;//resultados de consulta.
    
    String cadConecion="jdbc:postgresql://localhost:5432/PGV_COLIBRI ";
    String pgUser="postgres";
    String pgContra="1234567890";
    
    public SQConnect() {
        
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con=DriverManager.getConnection(cadConecion,pgUser,pgContra);
            System.out.println("Se conecto DB.");
        } catch (SQLException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public SQLException noQuery(String nsql){
        System.out.println(nsql);
        try {
            st=con.createStatement();
            st.execute(nsql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }
    
    public ResultSet query(String sql){
        System.out.println(sql);
        try {
            st=con.createStatement();
            ResultSet rs = st.executeQuery(sql);
          //  st.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
    
    public ResultSet consulta(String sql){

        try {
            st=con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
    ////////////////////////////////////////////////////////////////////////////
    public boolean accion(String sqla){
        try {
            Statement sst=con.createStatement();
            boolean rb=sst.execute(sqla);
            sst.close();
            return rb;
        } catch (SQLException ex) {
            Logger.getLogger(SQConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }
    ////////////////////////////////////////////////////////////////////////////
    public java.sql.Connection getCon() {
        return con;
    }

    public void setCon(java.sql.Connection con) {
        this.con = con;
    }
    
}
// ESPINOZA ALFONSO DAVID, DANNY GUTAMA, JUAN MATUTE, ESTEFANIA MUÑOZ//