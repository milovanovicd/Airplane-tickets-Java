/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.DomainObject;
import domain.Korisnik;
import domain.Let;
import domain.Rezervacija;
import java.util.LinkedList;
import logic.SystemOperation;
import logic.impl.IzmeniLetSO;
import logic.impl.KreirajLetSO;
import logic.impl.KreirajRezervacijuSO;
import logic.impl.LoginSO;
import logic.impl.ObrisiLetSO;
import logic.impl.ObrisiRezervacijuSO;
import logic.impl.PotvrdiRezervacijuSO;
import logic.impl.PronadjiLetoveSO;
import logic.impl.PronadjiRezervacijeSO;
import logic.impl.RegistracijaSO;
import logic.impl.VratiLetSO;
import logic.impl.VratiListuAvionaSO;
import logic.impl.VratiListuAvioprevoznikaSO;
import logic.impl.VratiListuDestinacijaSO;
import logic.impl.VratiListuLetovaSO;
import logic.impl.VratiListuRezervacijaSO;
import logic.impl.VratiRezervacijuSO;

/**
 *
 * @author dejanmilovanovic
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public DomainObject login(Korisnik k) throws Exception {
        SystemOperation so = new LoginSO(k);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject register(Korisnik k) throws Exception {
        SystemOperation so = new RegistracijaSO(k);
        so.execute();
        return so.getDomainObject();
    }

    public LinkedList<DomainObject> vratiDestinacije() throws Exception {
        SystemOperation so = new VratiListuDestinacijaSO();
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> vratiAvioprevoznike() throws Exception {
        SystemOperation so = new VratiListuAvioprevoznikaSO();
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> vratiLetove() throws Exception {
        SystemOperation so = new VratiListuLetovaSO();
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> vratiAvione() throws Exception {
        SystemOperation so = new VratiListuAvionaSO();
        so.execute();
        return so.getLista();
    }

    public boolean obrisiLet(Let let) throws Exception {
        SystemOperation so = new ObrisiLetSO(let);
        so.execute();
        return so.isRet();
    }

    public DomainObject dodajLet(Let let) throws Exception {
        SystemOperation so = new KreirajLetSO(let);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject vratiLet(Let let) throws Exception {
        SystemOperation so = new VratiLetSO(let);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject izmeniLet(Let let) throws Exception {
        SystemOperation so = new IzmeniLetSO(let);
        so.execute();
        return so.getDomainObject();
    }

    public LinkedList<DomainObject> vratiRezervacije() throws Exception {
        SystemOperation so = new VratiListuRezervacijaSO();
        so.execute();
        return so.getLista();
    }

    public DomainObject vratiRezervaciju(Rezervacija rez) throws Exception {
        SystemOperation so = new VratiRezervacijuSO(rez);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject potvrdiRezervaciju(Rezervacija rez) throws Exception {
        SystemOperation so = new PotvrdiRezervacijuSO(rez);
        so.execute();
        return so.getDomainObject();
    }

    public boolean obrisiRezervaciju(Rezervacija rez) throws Exception {
        SystemOperation so = new ObrisiRezervacijuSO(rez);
        so.execute();
        return so.isRet();
    }

    public DomainObject dodajRezervaciju(Rezervacija rez) throws Exception {
        SystemOperation so = new KreirajRezervacijuSO(rez);
        so.execute();
        return so.getDomainObject();
    }

    public LinkedList<DomainObject> pronadjiLetove(Let letPretraga) throws Exception {
        SystemOperation so = new PronadjiLetoveSO(letPretraga);
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> pronadjiRezervacije(Rezervacija rezPretraga) throws Exception {
        SystemOperation so = new PronadjiRezervacijeSO(rezPretraga);
        so.execute();
        return so.getLista();
    }

}
