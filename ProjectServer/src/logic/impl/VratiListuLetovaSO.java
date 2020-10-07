/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Let;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class VratiListuLetovaSO extends SystemOperation{

    public VratiListuLetovaSO() {
        super();
    }

    
    @Override
    protected void operation() throws Exception {
        LinkedList letovi = dbbr.getAll(Let.class, "", "");
        this.setLista(letovi);
    }

    
}
