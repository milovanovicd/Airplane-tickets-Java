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
import validation.impl.ValidateLogin;

/**
 *
 * @author dejanmilovanovic
 */
public class LoginSO extends SystemOperation{

    public LoginSO(Korisnik k) {
        super();
        this.odo = k;
        this.validator = new ValidateLogin();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> korisnici = dbbr.getAll(Korisnik.class, "", "");
        for (DomainObject domain : korisnici) {
            Korisnik k = (Korisnik)domain;
            if (this.odo.equals(k)) {
                this.odo = k;
                return;
            }
        }
        this.odo = null;
    }
    
}
