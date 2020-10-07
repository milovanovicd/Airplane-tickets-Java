/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Destinacija;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class VratiListuDestinacijaSO extends SystemOperation{

    public VratiListuDestinacijaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        LinkedList destinacije = dbbr.getAll(Destinacija.class, "", "");
        this.setLista(destinacije);
    }

    
}
