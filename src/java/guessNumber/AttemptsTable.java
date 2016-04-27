/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessNumber;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author Kurt Nikaitani
 */
@ManagedBean (name="AttemptsTable")
@RequestScoped
public class AttemptsTable implements Serializable{
        @Resource(name="jdbc:derby://localhost:1527/ics321")
        private DataSource source;
public List<Attempts> getAttemptsList() throws SQLException{
        String dbURL = "jdbc:derby://localhost:1527/ics321";
        String user = "DBUSER";
        String password = "ics321";
        
        if(source == null){
            throw new SQLException("Database unavailable");
        }
        Connection connect = DriverManager.getConnection(dbURL, user, password); 
              // Move this to AttemptBean
      //  : Connections select statement
        
        List<Attempts> list=new ArrayList<Attempts>(); 
        PreparedStatement ps;
        ResultSet res = null;
        String sql="select ATIME,USERNUM, ACTUALNUM from ATTEMPTS ORDER BY ATIME DESC FETCH FIRST 20 ROWS ONLY";
        ps = connect.prepareStatement(sql);
        res = ps.executeQuery();
        while (res.next()) 
	{
            Attempts att2 = new Attempts();
            att2.setATIME(res.getTimestamp("ATIME"));
            att2.setACTUALNUM(res.getInt("ACTUALNUM"));
            att2.setUSERNUM(res.getInt("USERNUM"));
            list.add(att2);
        }			

        return list;
    
}
    /**
     * Creates a new instance of AttemptsBean
     */
    public AttemptsTable() {
    }
    
}
