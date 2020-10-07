/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.DomainObject;
import domain.Let;
import domain.Rezervacija;
import java.util.Date;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class PronadjiRezervacijeSO extends SystemOperation {

    public PronadjiRezervacijeSO(Rezervacija rezPretraga) {
        super();
        odo = rezPretraga;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList sveRezervacije = dbbr.getAll(Rezervacija.class, "", "");
        LinkedList<DomainObject> rezervacijeRezultat = new LinkedList<>();
        Rezervacija rezPretraga = (Rezervacija) odo;

        for (Object object : sveRezervacije) {
            Rezervacija r = (Rezervacija) object;

            if (rezPretraga.getLet().getLetOd().getId() != -1 && !r.getLet().getLetOd().equals(rezPretraga.getLet().getLetOd())) {
                continue;
            }
            if (rezPretraga.getLet().getLetDo().getId() != -1 && !r.getLet().getLetDo().equals(rezPretraga.getLet().getLetDo())) {
                continue;
            }
            if (rezPretraga.getLet().getDatumPolaska() != null && r.getLet().getDatumPolaska().before(rezPretraga.getLet().getDatumPolaska())) {
                continue;
            }
            if (rezPretraga.getDatumRezervacije()!= null && r.getDatumRezervacije().before(rezPretraga.getDatumRezervacije())) {
                continue;
            }
//            if (rezPretraga.getRezervacijaId() != -2 && r.isPotvrdjena() != rezPretraga.isPotvrdjena()) {
//                continue;
//            }

            if (rezPretraga.getKorisnik().getBrPasosa() != -1 && r.getKorisnik().getBrPasosa() != rezPretraga.getKorisnik().getBrPasosa()) {
                continue;
            }

            rezervacijeRezultat.add(r);

        }

        this.setLista(rezervacijeRezultat);
    }

}
