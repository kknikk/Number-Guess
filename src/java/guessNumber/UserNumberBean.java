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
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
        
 /**
 *
 * @author Masako
 */
@ManagedBean(name="UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable{
    Integer randomInt;
    Integer userNumber;
    String response;
    public Timestamp currentTime;
  //  List<Attempts> list=new ArrayList<Attempts>();
    
    
    public String getResponse() throws SQLException {
        
        
        String dbURL = "jdbc:derby://localhost:1527/ics321";
        String user = "DBUSER";
        String password = "ics321";
       
        Connection con = DriverManager.getConnection(dbURL, user, password); 
        
        
        PreparedStatement ps = con.prepareStatement("insert into ATTEMPTS VALUES (?,?,?)");
        currentTime = new Timestamp(new Date().getTime());
        ps.setTimestamp(1, currentTime);
        ps.setInt(2, userNumber);
        ps.setInt(3,randomInt);
        boolean execute = ps.execute(); 
        
    if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {

        //invalidate user session
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();

        return "Yay! You got it!";
    } else {


        
        return "<p>Sorry, " + userNumber + " isn't it.</p>"
                + "<p>Guess again...</p>";
    }
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }
    /**
     * Creates a new instance of UserNumberBean
     */
    public UserNumberBean() {
        Random randomGR = new Random();
        randomInt = new Integer(randomGR.nextInt(10));
        System.out.println("Duke's number: " + randomInt);
    }
    
    
    

}
