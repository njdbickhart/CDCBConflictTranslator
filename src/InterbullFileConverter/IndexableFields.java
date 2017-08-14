/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterbullFileConverter;

/**
 *
 * @author njdbi
 */
public enum IndexableFields {
    NONE (0, 0),
    BREED (7, 3),
    COUNTRY (10, 3),
    SEX (13, 1),
    IDNUM (14, 12),
    NAME (26, 30),
    BDATE (56, 8),
    SHORTNAME (64, 15),
    OWNER (79, 4);

    public final int start;
    public final int length;

    IndexableFields(int start, int length){
        this.start = start;
        this.length = length;
    }
}
