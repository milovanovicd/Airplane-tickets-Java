/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Let;
import logic.SystemOperation;


/**
 *
 * @author dejanmilovanovic
 */
public class ObrisiLetSO extends SystemOperation{

    public ObrisiLetSO(Let let) {
        super();
        odo = let;
    }

    @Override
    protected void operation() throws Exception {
        ret = dbbr.remove(odo);
    }
    
}
