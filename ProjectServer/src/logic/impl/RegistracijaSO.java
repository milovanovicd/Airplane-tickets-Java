/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.DomainObject;
import domain.Korisnik;
import java.util.LinkedList;
import logic.SystemOperation;
import validation.impl.ValidateRegistracija;

/**
 *
 * @author dejanmilovanovic
 */
public class RegistracijaSO extends SystemOperation {

    public RegistracijaSO(Korisnik k) {
        super();
        this.odo = k;
        this.validator = new ValidateRegistracija();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> korisnici = dbbr.getAll(Korisnik.class, "", "");
        Korisnik k = (Korisnik) this.odo;

        for (DomainObject domainObject : korisnici) {
            Korisnik domain = (Korisnik) domainObject;
            if (k.getBrPasosa() == domain.getBrPasosa()) {
                throw new Exception("Registracija neuspešna! Korisnik sa unetim brojem pasosa vec postoji u bazi!");
            }
            if (k.getUsername().equals(domain.getUsername())) {
                throw new Exception("Registracija neuspešna! Korisničko ime je već zauzeto");
            }
            if (k.getBrTelefona().equals(domain.getBrTelefona())) {
                throw new Exception("Registracija neuspešna! Broj telefona već pripada drugom korisniku");
            }

        }

        this.odo = dbbr.insert(this.odo);

    }

}
