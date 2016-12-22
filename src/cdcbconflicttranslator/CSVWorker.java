/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdcbconflicttranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author njdbi
 */
public class CSVWorker {
    private static final Logger log = Logger.getLogger(CSVWorker.class.getName());
    private final Path inputFile;
    private final Path outputExcel;
    private final CodeConverter converter = new CodeConverter();
    
    public CSVWorker(Path input, Path output){
        this.inputFile = input;
        this.outputExcel = output;
    }
    
    public int run() throws IOException, WriteException{
        // read the input file and process it into an excel table
        WritableWorkbook w = Workbook.createWorkbook(this.outputExcel.toFile());
        WritableSheet s = w.createSheet("CDCB", 0);
        
        BufferedReader input = Files.newBufferedReader(inputFile, Charset.defaultCharset());
        // Get header line
        String line = input.readLine();
        String[] segs = line.split(",");
        int curRow = 0;
        try {
            writeHeaderRow(segs, curRow, s);
        } catch (WriteException ex) {
            log.log(Level.SEVERE, "Error! Could not write to excel header!", ex);
            return 0;
        }
        curRow++;
        
        while((line = input.readLine()) != null){
            segs = line.split(",");
            try {
                writeExcelRow(segs, curRow, s);
            } catch (WriteException ex) {
                log.log(Level.SEVERE, "Error! Could not write to excel sheet body!", ex);
                return 0;
            }
            curRow++;
        }
        
        w.write();
        w.close();
        input.close();
        return 1;
    }
    
    private void writeExcelRow(String[] segs, int curRow, WritableSheet s) throws WriteException{
        for(int x = 0; x < segs.length; x++){
            String temp = segs[x];
            if(x >= 5 && x % 2 != 0){
                // Any odd number after 5
                temp = converter.ConvertCode(segs[x]);
            }
            s.addCell(new Label(x, curRow, temp));
        }
    }
    
    private void writeHeaderRow(String[] segs, int curRow, WritableSheet s) throws WriteException{
        for(int x = 0; x < segs.length; x++){
            s.addCell(new Label(x, curRow, segs[x]));
        }
    }
}
