/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;


import domain.Rezervacija;
import logic.SystemOperation;


/**
 *
 * @author dejanmilovanovic
 */
public class ObrisiRezervacijuSO extends SystemOperation{

    public ObrisiRezervacijuSO(Rezervacija rez) {
        super();
        odo = rez;
    }

    
    @Override
    protected void operation() throws Exception {
        ret = dbbr.removeComplex(odo);
    }
    
}
