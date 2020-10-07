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
import validation.impl.ValidateLet;

/**
 *
 * @author dejanmilovanovic
 */
public class KreirajLetSO extends SystemOperation{

    public KreirajLetSO(Let let) {
        super();
        odo = let;
        validator = new ValidateLet();
    }

    @Override
    protected void operation() throws Exception {
        SystemOperation soLetovi = new VratiListuLetovaSO();
        soLetovi.execute();
        LinkedList<DomainObject> listaLetova = soLetovi.getLista();
        
        if(!listaLetova.contains(odo)){
            odo = dbbr.insert(odo);
        }
        else throw new Exception("Let ne može biti unet. Uneti let vec postoji u sistemu!");
        
    }

    
}
