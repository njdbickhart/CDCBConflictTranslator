/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdcbconflicttranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author njdbi
 */
public class CodeConverter {
    private static final Logger log = Logger.getLogger(CodeConverter.class.getName());
    private final Map<String, String> converter = new HashMap<>();
    private final String[] keys = {"K9", "L5", "L7", "M3", "M4", "M8", "N0", "N1", "N2", "N3", "N4",
                            "N5", "N6", "N7", "N8", "N9", "O0", "O1", "O2", "O3", "O4", "O5",
                            "O6", "O7", "O8", "O9", "P0", "P2", "Q0", "Q1", "Q2", "Q3", "Q4"};
    private final String[] values = {"Fee code P has been changed to N",
                                "Two different genotypes for input animal",
                                "New genotype does not match existing genotype; the existing genotype is used",
                                "Genotype is low call on autosomal chromosomes",
                                "Genotype is low call on X-chromosome",
                                "New genotype does not match existing genotype; the new genotype is used",
                                "Animal is unknown or is not identical to exsisting genotype",
                                "Sex conflict for male",
                                "Sex conflict for female",
                                "Sire conflict",
                                "Dam conflict",
                                "Progeny conflict",
                                "Clone conflict",
                                "Clone's progeny conflict",
                                "Parent's clone conflict",
                                "Discovered clone",
                                "Discovered missing sire",
                                "Discovered missing dam",
                                "Duplicate genotype identified",
                                "Discovered parent",
                                "Discovered progeny",
                                "Breed conflict",
                                "Maternal grandsire conflict",
                                "Paternal grandsire conflict",
                                "Unreliable genotype due to high parent progeny conflicts",
                                "Discovered parent with high parent progeny conflicts",
                                "Suggested grandsires provided",
                                "Possible full sib, parents missing or different",
                                "Unreliable genotype due to high parent progeny conflicts when both sire and dam are considered",
                                "Unreliable genotype due to female with a Y SNP-count of 2, 3, or 4",
                                "New genotype on live animal does not match embryo genotype",
                                "Probable XXY abnormality",
                                "Bull genotype has more heterozygous X-specific SNP than explainable as genotyping errors. (Notification only, genotype still usable)"};
    
    public CodeConverter(){
        // Instantiate the converter map
        for(int x = 0; x < this.keys.length; x++){
            this.converter.put(this.keys[x], this.values[x]);
        }
    }
    
    public String ConvertCode(String key){
        if(this.converter.containsKey(key))
            return this.converter.get(key);
        else{
            if(key.equals("")){
                return "";
            }
            log.log(Level.WARNING, "Code: " + key + " was an unexpected value! Could not convert!");
            return "Error! Code not identified!";
        }
    }
}
