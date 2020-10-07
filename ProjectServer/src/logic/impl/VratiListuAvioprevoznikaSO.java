/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;


import domain.Avioprevoznik;
import domain.Destinacija;
import java.util.LinkedList;
import logic.SystemOperation;


/**
 *
 * @author dejanmilovanovic
 */
public class VratiListuAvioprevoznikaSO extends SystemOperation{

    public VratiListuAvioprevoznikaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        LinkedList avioprevoznici = dbbr.getAll(Avioprevoznik.class, "", "");
        this.setLista(avioprevoznici);
    }
    
}
