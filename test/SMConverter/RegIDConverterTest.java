/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMConverter;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author njdbi
 */
public class RegIDConverterTest {
    
    public RegIDConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Converter method, of class RegIDConverter.
     * @throws java.lang.Exception
     */
    @Test
    public void testConverter() throws Exception {
        System.out.println("Converter");
        RegIDConverter tester = new RegIDConverter();
        try {
            assertEquals("USA000012345678", tester.Converter("USA000012345678"));
            assertEquals("USA000012345678", tester.Converter("12345678"));
            assertEquals("USA000012345678", tester.Converter("USA012345678"));
        } catch (Exception ex) {
            Logger.getLogger(RegIDConverterTest.class.getName()).log(Level.SEVERE, "Error testing value!", ex);
        }
        
    }
    
}
