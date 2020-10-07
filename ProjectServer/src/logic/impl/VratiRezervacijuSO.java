/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.DomainObject;
import domain.Rezervacija;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class VratiRezervacijuSO extends SystemOperation{

    public VratiRezervacijuSO(Rezervacija rez) {
        super();
        odo = rez;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> letovi = dbbr.getAll(Rezervacija.class, "", "");
        for (DomainObject domain : letovi) {
            Rezervacija r = (Rezervacija)domain;
            if (this.odo.equals(r)) {
                this.odo = r;
                return;
            }
        }
        this.odo = null;
    }

    
}
