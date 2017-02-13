/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMConverter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author njdbi
 */
public class RegIDConverter {
    private static final Logger log = Logger.getLogger(RegIDConverter.class.getName());
    private final Pattern usCorrect = Pattern.compile("^USA0{0,9}.{1,12}");
    private final Pattern usTrim = Pattern.compile("^USA[0O]*(.+$)");
    private final Pattern usAlt = Pattern.compile("^9[83]2");
    private final Pattern altTrim = Pattern.compile("^9[83]2[0O]*(.+$)");
    
    public String Converter(String input){
        Matcher mUsCorrect = usTrim.matcher(input);
        Matcher mAltCorrect = altTrim.matcher(input);
        
        if(mUsCorrect.find()){
            if(input.length() == 15)
                return input;
            else{
                String code = mUsCorrect.group(0);
                code = code.replaceFirst("USA0*", "");
                return this.TurnToUSA(code);
            }
        }else if(mAltCorrect.find()){
            if(input.length() == 15)
                return input;
            else{
                String code = mAltCorrect.group(0);
                
                return this.TurnToUSA(code);
            }
        }else if(input.length() <= 12){
            return this.TurnToUSA(input);
        }else{
            log.log(Level.WARNING, "Could not convert RegID: " + input + " please manually check!");
            return input;
        }
    }
    
    private String TurnToUSA(String input){
        char[] zeros = new char[input.length() - 4];
        Arrays.fill(zeros, '0');
        return "USA" + new String(zeros) + input;
    }
}
