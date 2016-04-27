/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package guessNumber;

import java.sql.Timestamp;

/**
 *
 * @author Kurt Nikaitani
 */
public class Attempts {
    public Timestamp ATIME;
    public Integer USERNUM;
    public Integer ACTUALNUM;

    public Timestamp getATIME() {
        return ATIME;
    }

    public void setATIME(Timestamp ATIME) {
        this.ATIME = ATIME;
    }

    public Integer getUSERNUM() {
        return USERNUM;
    }

    public void setUSERNUM(Integer USERNUM) {
        this.USERNUM = USERNUM;
    }

    public Integer getACTUALNUM() {
        return ACTUALNUM;
    }

    public void setACTUALNUM(Integer ACTUALNUM) {
        this.ACTUALNUM = ACTUALNUM;
    }
    
    
}
