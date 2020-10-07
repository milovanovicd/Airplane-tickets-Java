/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domain.DomainObject;
import domain.Korisnik;
import domain.Let;
import domain.Rezervacija;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import operations.Operation;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author dejanmilovanovic
 */
public class KomunikacijaSaServerom {

    private static KomunikacijaSaServerom instanca;
    Socket s;

    private KomunikacijaSaServerom() throws IOException {
        s = new Socket("localhost", 9000);

    }

    public static KomunikacijaSaServerom getInstanca() throws IOException {
        if (instanca == null) {
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(kz);
        oos.flush();

    }

    public ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        return (ServerskiOdgovor) ois.readObject();

    }

    public Korisnik login(Korisnik k) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.LOGIN);
        kz.setData(k);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Korisnik) so.getData();
    }

    public Korisnik register(Korisnik k) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.REGISTER);
        kz.setData(k);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Korisnik) so.getData();
    }

    public LinkedList<DomainObject> vratiDestinacije() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_DESTINACIJE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public LinkedList<DomainObject> vratiAvioprevoznike() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_AVIOPREVOZNIKE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public LinkedList<DomainObject> vratiLetove() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_LETOVE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public LinkedList<DomainObject> vratiAvione() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_AVIONE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public boolean izbrisiLet(Let let) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.OBRISI_LET);
        kz.setData(let);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (boolean) so.getData();
    }

    public Let dodajLet(Let let) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.DODAJ_LET);
        kz.setData(let);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Let) so.getData();
    }

    public Let vratiLet(Let let) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_LET);
        kz.setData(let);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Let) so.getData();
    }

    public Let izmeniLet(Let let) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.IZMENI_LET);
        kz.setData(let);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Let) so.getData();
    }

    public LinkedList<DomainObject> vratiRezervacije() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_REZERVACIJE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public Rezervacija vratiRezervaciju(Rezervacija rezervacija) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.VRATI_REZERVACIJU);
        kz.setData(rezervacija);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Rezervacija) so.getData();
    }

    public Rezervacija potvrdiRezervaciju(Rezervacija rez) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.POTVRDI_REZERVACIJU);
        kz.setData(rez);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Rezervacija) so.getData();
    }

    public boolean izbrisiRezervaciju(Rezervacija rez) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.OBRISI_REZERVACIJU);
        kz.setData(rez);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (boolean) so.getData();
    }

    public Rezervacija dodajRezervaciju(Rezervacija r) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.DODAJ_REZERVACIJU);
        kz.setData(r);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (Rezervacija) so.getData();
    }

    public LinkedList<DomainObject> pronadjiLetove(Let letPretraga) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.PRONADJI_LETOVE);
        kz.setData(letPretraga);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

    public LinkedList<DomainObject> pronadjiRezervacije(Rezervacija rezPretraga) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperation(Operation.PRONADJI_REZERVACIJE);
        kz.setData(rezPretraga);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if (so.getException() != null) {
            throw so.getException();
        }
        return (LinkedList<DomainObject>) so.getData();
    }

}
