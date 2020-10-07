/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.Let;
import logic.SystemOperation;
import validation.impl.ValidateLet;

/**
 *
 * @author dejanmilovanovic
 */
public class IzmeniLetSO extends SystemOperation{

    public IzmeniLetSO(Let let) {
        super();
        odo=let;
        validator = new ValidateLet();
    }

    @Override
    protected void operation() throws Exception {
        dbbr.update(odo);
    } 
}
