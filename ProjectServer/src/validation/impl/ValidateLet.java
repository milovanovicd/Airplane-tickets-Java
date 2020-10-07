/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.impl;

import domain.DomainObject;
import domain.Let;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import validation.Validator;

/**
 *
 * @author dejanmilovanovic
 */
public class ValidateLet implements Validator{

    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Let l = (Let) value;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            
            System.out.println(sdf.format(l.getDatumPolaska())+" = "+sdf.format(new Date()));
            
            if (l.getLetOd().equals(l.getLetDo())) {
                throw new Exception("Polazna i Krajnja destinacija ne mogu biti iste!");
            } else if (sdf.format(l.getDatumPolaska()).equals(sdf.format(new Date()))) {
                throw new Exception("Datum polaska ne može biti današnji datum!");
            } else if (l.getDatumPolaska().before(new Date())) {
                throw new Exception("Datum polaska ne može biti pre današnjeg datuma!");
            }else if (l.getDatumPovratka().before(l.getDatumPolaska())) {
                throw new Exception("Datum povratka ne može biti pre datuma polaska!");
            } else if (!(l.getDuzinaLeta()> 0)) {
                throw new Exception("Duzina leta ne može biti negativna ili nula");
            }else if (!(l.getCenaLeta().compareTo(BigDecimal.ZERO) > 0)) {
                throw new Exception("Cena leta ne može biti negativna ili nula");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
