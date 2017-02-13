/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import SMConverter.RegIDConverter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author njdbi
 */
public class SMTester {
    @Test
    public void checkRegIDConverter(){
        RegIDConverter tester = new RegIDConverter();
              
        try {
            assertEquals("USA000012345678", tester.Converter("USA000012345678"));
            assertEquals("USA000012345678", tester.Converter("12345678"));
            assertEquals("USA000012345678", tester.Converter("USA12345678"));
        } catch (Exception ex) {
            Logger.getLogger(SMTester.class.getName()).log(Level.SEVERE, "Error testing value!", ex);
        }
    }
}
