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
public class KreirajRezervacijuSO extends SystemOperation {

    public KreirajRezervacijuSO(Rezervacija rez) {
        super();
        odo = rez;
        //VALIDATOR
    }

    @Override
    protected void operation() throws Exception {
        SystemOperation soRezervacije = new VratiListuRezervacijaSO();
        soRezervacije.execute();
        LinkedList<DomainObject> listaRezervacija = soRezervacije.getLista();

        for (DomainObject domainObject : listaRezervacija) {
            Rezervacija r = (Rezervacija) domainObject;
            if (r.equals(odo)) {
                throw new Exception("Uneta rezervacija vec postoji u sistemu!");
            }
        }
        odo = dbbr.insert(odo);
    }

}
