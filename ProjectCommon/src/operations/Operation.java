/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.Serializable;

/**
 *
 * @author dejanmilovanovic
 */
public class Operation implements Serializable {

    public static final int LOGIN = 1;
    public static final int REGISTER = 2;
    public static final int VRATI_DESTINACIJE = 3;
    public static final int VRATI_AVIOPREVOZNIKE = 4;
    public static final int VRATI_LETOVE = 5;
    public static final int VRATI_AVIONE = 6;
    public static final int OBRISI_LET = 7;
    public static final int DODAJ_LET = 8;
    public static final int VRATI_LET = 9;
    public static final int IZMENI_LET = 10;
    public static final int VRATI_REZERVACIJE = 11;
    public static final int VRATI_REZERVACIJU = 12;
    public static final int POTVRDI_REZERVACIJU = 13;
    public static final int OBRISI_REZERVACIJU = 14;
    public static final int DODAJ_REZERVACIJU = 15;
    public static final int PRONADJI_LETOVE = 16;
    public static final int PRONADJI_REZERVACIJE = 17;
    


}
