/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Avion;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class VratiListuAvionaSO extends SystemOperation {

    public VratiListuAvionaSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        LinkedList avioni = dbbr.getAll(Avion.class, "", "");
        this.setLista(avioni);
    }
    
}
