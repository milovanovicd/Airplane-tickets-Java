/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.impl;

import domain.DomainObject;
import domain.Korisnik;
import validation.Validator;

/**
 *
 * @author dejanmilovanovic
 */
public class ValidateLogin implements Validator {

    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Korisnik k = (Korisnik) value;

            if (k.getUsername().equals("")) {
                throw new Exception("Username polje ne sme biti prazno!");
            } else if (k.getPassword().equals("")) {
                throw new Exception("Password polje ne sme biti prazno!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
