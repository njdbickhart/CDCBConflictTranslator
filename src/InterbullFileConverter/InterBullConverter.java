/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterbullFileConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author njdbi
 */
public class InterBullConverter {
    private final String inputFile;
    private String outputFile;
    private boolean PrintOut;
    
    public InterBullConverter(String inputFile){
        this.inputFile = inputFile;
        this.PrintOut = false;
    }
    
    public InterBullConverter(String inputFile, String outputFile){
        this(inputFile);
        this.outputFile = outputFile;
        this.PrintOut = true;
    }
    
    public int PrintToOutFile(final String value, final IndexableFields filter) throws IOException{
        BufferedReader input = Files.newBufferedReader(Paths.get(this.inputFile), StandardCharsets.ISO_8859_1);
        BufferedWriter output = Files.newBufferedWriter(Paths.get(this.outputFile), Charset.defaultCharset());
        
        // Get file column headers
        try{
            InterbullRecord head = new InterbullRecord("empty");
            output.write(String.join(",", head.getNames()));
            output.write(System.lineSeparator());
        }catch(IOException ex){
            Logger.getLogger(InterBullConverter.class.getName())
                .log(Level.SEVERE, "Could not write to output file!", ex);
        }
        
        final AtomicInteger counter = new AtomicInteger();
        
        // Process each line and write to output!
        input.lines()
                .map(p -> new InterbullRecord(p))
                .filter(p -> p.Filter(value, filter))
                .forEach(p -> {
                    try {
                        output.write(String.join(",", p.deCodeAll()));
                        output.write(System.lineSeparator());
                        counter.addAndGet(1);
                    } catch (IOException ex) {
                        Logger.getLogger(InterBullConverter.class.getName())
                                .log(Level.SEVERE, "Could not write to output file!", ex);
                    }
                });
        
        output.close();
        return counter.get();
    }
}
