/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Controller;
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
public class ObradaKlijentskogZahtevaNit extends Thread {

    private final Socket klijentskiSocket;

    public ObradaKlijentskogZahtevaNit(Socket klijentskiSocket) {
        this.klijentskiSocket = klijentskiSocket;
    }

    @Override
    public void run() {
        KlijentskiZahtev kz = null;
        ServerskiOdgovor so = null;

        while (!klijentskiSocket.isClosed()) {
            try {
                kz = primiZahtev();
                so = new ServerskiOdgovor();

                switch (kz.getOperation()) {
                    case Operation.LOGIN:
                        so = login(kz);
                        break;
                    case Operation.REGISTER:
                        so = register(kz);
                        break;
                    case Operation.VRATI_DESTINACIJE:
                        so = vratiDestinacije(kz);
                        break;
                    case Operation.VRATI_AVIOPREVOZNIKE:
                        so = vratiAvioprevoznike(kz);
                        break;
                    case Operation.VRATI_LETOVE:
                        so = vratiLetove(kz);
                        break;
                    case Operation.VRATI_AVIONE:
                        so = vratiAvione(kz);
                        break;
                    case Operation.OBRISI_LET:
                        so = obrisiLet(kz);
                        break;
                    case Operation.DODAJ_LET:
                        so = dodajLet(kz);
                        break;
                    case Operation.VRATI_LET:
                        so = vratLet(kz);
                        break;
                    case Operation.IZMENI_LET:
                        so = izmeniLet(kz);
                        break;
                    case Operation.VRATI_REZERVACIJE:
                        so = vratiRezervacije(kz);
                        break;
                    case Operation.VRATI_REZERVACIJU:
                        so = vratiRezervaciju(kz);
                        break;
                    case Operation.POTVRDI_REZERVACIJU:
                        so = potvrdiRezervaciju(kz);
                        break;
                    case Operation.OBRISI_REZERVACIJU:
                        so = obrisiRezervaciju(kz);
                        break;
                    case Operation.DODAJ_REZERVACIJU:
                        so = dodajRezervaciju(kz);
                        break;
                    case Operation.PRONADJI_LETOVE:
                        so = pronadjiLetove(kz);
                        break;
                    case Operation.PRONADJI_REZERVACIJE:
                        so = pronadjiRezervacije(kz);
                        break;
                }

                posaljiOdgovor(so);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(klijentskiSocket.getInputStream());
        return (KlijentskiZahtev) in.readObject();
    }

    private void posaljiOdgovor(ServerskiOdgovor so) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(klijentskiSocket.getOutputStream());
        out.writeObject(so);
        out.flush();
    }

    public Socket getKlijentskiSocket() {
        return klijentskiSocket;
    }

    private ServerskiOdgovor login(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Korisnik k = (Korisnik) kz.getData();
            DomainObject odo = Controller.getInstance().login(k);
            so.setData(odo);
        } catch (Exception e) {
            so.setData(null);
            so.setException(e);
        }
        return so;
    }

    private ServerskiOdgovor register(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Korisnik k = (Korisnik) kz.getData();
            DomainObject odo = Controller.getInstance().register(k);
            so.setData(odo);
        } catch (Exception e) {
            so.setData(null);
            so.setException(e);
        }
        return so;
    }

    private ServerskiOdgovor vratiDestinacije(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> destinacije;
        try {
            destinacije = Controller.getInstance().vratiDestinacije();
            so.setData(destinacije);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor vratiAvioprevoznike(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> avioprevoznici;
        try {
            avioprevoznici = Controller.getInstance().vratiAvioprevoznike();
            so.setData(avioprevoznici);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor vratiLetove(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> letovi;
        try {
            letovi = Controller.getInstance().vratiLetove();
            so.setData(letovi);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor vratiAvione(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> avioni;
        try {
            avioni = Controller.getInstance().vratiAvione();
            so.setData(avioni);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor obrisiLet(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Let let = (Let) kz.getData();
        try {
            boolean ret = Controller.getInstance().obrisiLet(let);
            so.setData(ret);
        } catch (Exception e) {
            so.setException(e);
            so.setData(false);
        }
        return so;
    }

    private ServerskiOdgovor dodajLet(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Let let = (Let) kz.getData();
        try {
            DomainObject odo = Controller.getInstance().dodajLet(let);
            so.setData(odo);
        } catch (Exception e) {
            so.setException(e);
//            so.setData(false);
        }
        return so;
    }

    private ServerskiOdgovor vratLet(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Let let = (Let) kz.getData();
            DomainObject odo = Controller.getInstance().vratiLet(let);
            so.setData(odo);
        } catch (Exception e) {
            so.setData(null);
            so.setException(new Exception("Sistem ne može da prikaže podatke o letu"));
        }
        return so;
    }

    private ServerskiOdgovor izmeniLet(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Let let = (Let) kz.getData();
        try {
            DomainObject odo = Controller.getInstance().izmeniLet(let);
            so.setData(odo);
        } catch (Exception e) {
            so.setException( new Exception("Sistem ne može da izmeni let"));
//            so.setData(false);
        }
        return so;
    }

    private ServerskiOdgovor vratiRezervacije(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> rezervacije;
        try {
            rezervacije = Controller.getInstance().vratiRezervacije();
            so.setData(rezervacije);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor vratiRezervaciju(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Rezervacija rez = (Rezervacija) kz.getData();
            DomainObject odo = Controller.getInstance().vratiRezervaciju(rez);
            so.setData(odo);
        } catch (Exception e) {
            so.setData(null);
            so.setException(e);
        }
        return so;
    }

    private ServerskiOdgovor potvrdiRezervaciju(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Rezervacija rez = (Rezervacija) kz.getData();
        try {
            DomainObject odo = Controller.getInstance().potvrdiRezervaciju(rez);
            so.setData(odo);
        } catch (Exception e) {
            so.setException(new Exception("Sistem ne može da potvrdi rezervaciju"));
//            so.setData(false);
        }
        return so;
    }

    private ServerskiOdgovor obrisiRezervaciju(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Rezervacija rez = (Rezervacija) kz.getData();
        try {
            boolean ret = Controller.getInstance().obrisiRezervaciju(rez);
            so.setData(ret);
        } catch (Exception e) {
            so.setException(e);
            so.setData(false);
        }
        return so;
    }

    private ServerskiOdgovor dodajRezervaciju(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Rezervacija rez = (Rezervacija) kz.getData();
        try {
            DomainObject odo = Controller.getInstance().dodajRezervaciju(rez);
            so.setData(odo);
        } catch (Exception e) {
            so.setException(e);
        }
        return so;
    }

    private ServerskiOdgovor pronadjiLetove(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> result;
        Let letPretraga = (Let) kz.getData();
        try {
            result = Controller.getInstance().pronadjiLetove(letPretraga);
            so.setData(result);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

    private ServerskiOdgovor pronadjiRezervacije(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        LinkedList<DomainObject> result;
        Rezervacija rezPretraga = (Rezervacija) kz.getData();
        try {
            result = Controller.getInstance().pronadjiRezervacije(rezPretraga);
            so.setData(result);
        } catch (Exception e) {
            so.setException(e);
            e.printStackTrace();
        }
        return so;
    }

}
