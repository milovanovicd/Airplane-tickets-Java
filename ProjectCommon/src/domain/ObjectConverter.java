/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author dejanmilovanovic
 */
public class ObjectConverter {

    public static DomainObject createObject(Class klasa) {

        if (klasa == Korisnik.class) {
            return new Korisnik();
        }
        if (klasa == Destinacija.class) {
            return new Destinacija(-1, null);
        }
        if (klasa == Avioprevoznik.class) {
            return new Avioprevoznik(-1, null);
        }
        if (klasa == Avion.class) {
            return new Avion(-1, null, null);
        }
        if (klasa == Let.class) {
            return new Let(-1, null, null, -1, null, null, null, null);
        }
        if (klasa == Rezervacija.class) {
            return new Rezervacija(null, null, null, false);
        }

        return null;
    }
}
