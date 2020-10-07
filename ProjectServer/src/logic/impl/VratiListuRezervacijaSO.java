/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Rezervacija;
import java.util.LinkedList;
import logic.SystemOperation;


/**
 *
 * @author dejanmilovanovic
 */
public class VratiListuRezervacijaSO extends SystemOperation{

    public VratiListuRezervacijaSO() {
        super();
    }
    
    
    @Override
    protected void operation() throws Exception {
        LinkedList rezervacije = dbbr.getAll(Rezervacija.class, "", "");
        this.setLista(rezervacije);
    }
    
}
