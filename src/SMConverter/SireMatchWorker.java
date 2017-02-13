/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author njdbi
 */
public class SireMatchWorker {
    private static final Logger log = Logger.getLogger(SireMatchWorker.class.getName());
    private final RegIDConverter converter = new RegIDConverter();
    private final Pattern bDate = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\/\\d{4}");
    
    public int ProcessData(Path input, Path output){
        BufferedWriter out = null;
        try{
            out = Files.newBufferedWriter(output, Charset.defaultCharset());
            out.write("Cow Barn Name\\#,Registration \\#,Computer \\#,Sire NAAB,Sire Reg. \\#,Dam Reg. \\# or Barn \\#,MGS NAAB,MGS Reg. \\#,Calving Date,Lactation \\#,DNB Code,Birth Date,Breed,Pen/String" 
                + System.lineSeparator());
        }catch(IOException ex){
            log.log(Level.SEVERE, "Error opening output CSV file! Please check if you have permissions to the folder!", ex);
        }
        
        
        
        try(BufferedReader in = Files.newBufferedReader(input, Charset.defaultCharset())){
            String line = null;
            String head = in.readLine(); // remove header
            while((line = in.readLine()) != null){
                line = line.trim();
                String[] segs = line.split("[,\t]");
                if(segs.length < 6)
                    throw new IOException("Number of columns for line: " + line + " is less than 6! File may be malformed!");
                
                String regid = converter.Converter(segs[1]);
                String sireReg = converter.Converter(segs[2]);
                String damReg = converter.Converter(segs[3]);
                
                Matcher m = bDate.matcher(segs[6]);
                if(!m.find())
                    log.log(Level.WARNING, "Error with birthdate for animal: " + regid + ". Please double check entry!");
                
                StringBuilder str = new StringBuilder();
                str.append(segs[0]).append(",").append(regid).append(",,").append(sireReg).append(",");
                str.append(damReg).append(",").append(segs[4]).append(",").append(segs[5]).append(",,");
                str.append(segs[6]).append(",").append(segs[7]).append(System.lineSeparator());
                
                out.write(str.toString());
            }
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Error reading input CSV file! Was the file in the right format?", ex);
            return 0;
        }
        return 1;
    }
}
