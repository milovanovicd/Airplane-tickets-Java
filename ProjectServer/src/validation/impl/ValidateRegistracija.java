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
public class ValidateRegistracija implements Validator{

    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Korisnik k = (Korisnik) value;
            
//            private long korisnikID;
//    private long brPasosa;
//    private String ime;
//    private String prezime;
//    private String brTelefona;
//    private String username;
//    private String password;
//    private boolean admin;
            
            if (k.getBrPasosa() < 0) {
                throw new Exception("Neispravan format broja pasoša");
                //DODATI DODATNE USLOVE ZA PROVERU
            }else if (k.getIme().equals("")) {
                throw new Exception("Polje 'Ime' ne sme biti prazno!");
            }else if (k.getPrezime().equals("")) {
                throw new Exception("Polje 'Prezime' ne sme biti prazno!");
            }else if (k.getBrTelefona().equals("")) {
                throw new Exception("Polje 'Broj Telefona' polje ne sme biti prazno!");
            } else if (k.getUsername().equals("")) {
                throw new Exception("Username polje ne sme biti prazno!");
            } else if (k.getPassword().equals("")) {
                throw new Exception("Password polje ne sme biti prazno!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
