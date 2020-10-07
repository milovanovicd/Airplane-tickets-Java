/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.DomainObject;
import domain.Let;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import logic.SystemOperation;

/**
 *
 * @author dejanmilovanovic
 */
public class PronadjiLetoveSO extends SystemOperation {

    public PronadjiLetoveSO(Let letPretraga) {
        super();
        odo = letPretraga;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList sviLetovi = dbbr.getAll(Let.class, "", "");
        LinkedList<DomainObject> letoviRezultat = new LinkedList<>();
        Let letPretraga = (Let) odo;

        for (Object object : sviLetovi) {
            Let l = (Let) object;

            if (letPretraga.getLetOd().getId() != -1 && !l.getLetOd().equals(letPretraga.getLetOd())) {
                continue;
            }
            if (letPretraga.getLetDo().getId() != -1 && !l.getLetDo().equals(letPretraga.getLetDo())) {
                continue;
            }
            if (letPretraga.getDatumPolaska() != null && l.getDatumPolaska().before(letPretraga.getDatumPolaska())) {
                continue;
            }
            if (letPretraga.getDatumPovratka()!= null) {
                Date danNakondatumaPovratka = new Date(letPretraga.getDatumPovratka().getTime()+86400000);
                if(!l.getDatumPovratka().before(danNakondatumaPovratka)){
                 continue;   
                }
            }
            if(letPretraga.getAvion().getAvioprevoznik().getAvioprevoznikID()!=-1 && !l.getAvion().getAvioprevoznik().equals(letPretraga.getAvion().getAvioprevoznik())){
                continue;
            }

            letoviRezultat.add(l);

        }

        this.setLista(letoviRezultat);
    }

}
