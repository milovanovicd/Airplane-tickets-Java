/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.DomainObject;
import domain.Let;
import java.util.LinkedList;
import logic.SystemOperation;


/**
 *
 * @author dejanmilovanovic
 */
public class VratiLetSO extends SystemOperation{

    public VratiLetSO(Let let) {
        super();
        odo=let;
    }
    

    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> letovi = dbbr.getAll(Let.class, "", "");
        for (DomainObject domain : letovi) {
            Let l = (Let)domain;
            if (this.odo.equals(l)) {
                this.odo = l;
                return;
            }
        }
        this.odo = null;
    }

    
}
