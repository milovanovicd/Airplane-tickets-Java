/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author dejanmilovanovic
 */
public class Rezervacija implements DomainObject {

    private Let let;
    private Korisnik korisnik;
    private Date datumRezervacije;
    private boolean potvrdjena;

    public Rezervacija() {
        potvrdjena = false;
    }

    public Rezervacija(Let let, Korisnik korisnik, Date datumRezervacije, boolean potvrdjena) {
        this.let = let;
        this.korisnik = korisnik;
        this.datumRezervacije = datumRezervacije;
        this.potvrdjena = potvrdjena;
    }
    
    public Let getLet() {
        return let;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public boolean isPotvrdjena() {
        return potvrdjena;
    }

    public void setPotvrdjena(boolean potvrdjena) {
        this.potvrdjena = potvrdjena;
    }

    //Izmeniti
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervacija other = (Rezervacija) obj;
        if (!Objects.equals(this.let, other.let)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String getTableName() {
        return "rezervacija";
    }

    @Override
    public boolean isAutoincrement() {
        return false;
    }

    @Override
    public void setObjectId(long id) {
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "let_id";
        s += ",korisnik_id";
        s += ",datum_rezervacije";
        s += ",potvrdjena";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return +this.let.getLetID() + ","
                + this.korisnik.getKorisnikID()
                + ", '" + new java.sql.Date(this.datumRezervacije.getTime()).toString() + "' ,"
                + this.potvrdjena;
    }

    @Override
    public long getId() {
        return -1;
    }

    @Override
    public String getIdName() {
        return "";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long korisnikid = rs.getLong("k.korisnik_id");
            long brojPasosa = rs.getLong("k.br_pasosa");
            String imeKorisnika = rs.getString("k.ime");
            String prezimeKorisnika = rs.getString("k.prezime");
            String brojTelefona = rs.getString("k.br_telefona");
            String user = rs.getString("k.username");
            String pass = rs.getString("k.password");
            boolean adminKorisnik = rs.getBoolean("k.admin");

            long letid = rs.getLong("l.let_id");
            Date datumOd = new java.util.Date(rs.getDate("l.datum_polaska").getTime());
            Date datumDo = new java.util.Date(rs.getDate("l.datum_povratka").getTime());
            int duzina = rs.getInt("l.duzina_leta");
            BigDecimal cena = rs.getBigDecimal("l.cena_leta");
            long idOd = rs.getLong("dod.destinacija_id");
            String nazivOd = rs.getString("dod.naziv_destinacije");
            long idDo = rs.getLong("ddo.destinacija_id");
            String nazivDo = rs.getString("ddo.naziv_destinacije");
            long avionId = rs.getLong("a.avion_id");
            long avioprevoznikId = rs.getLong("ap.avioprevoznik_id");
            String nazivAvioprevoznika = rs.getString("ap.naziv_avioprevoznika");
            String avionTip = rs.getString("a.tip_aviona");

            Date datumRez = new java.util.Date(rs.getDate("r.datum_rezervacije").getTime());
            boolean potvrdjenaRez = rs.getBoolean("r.potvrdjena");

            Destinacija dod = new Destinacija(idOd, nazivOd);
            Destinacija ddo = new Destinacija(idDo, nazivDo);
            Avioprevoznik ap = new Avioprevoznik(avioprevoznikId, nazivAvioprevoznika);
            Avion a = new Avion(avionId, ap, avionTip);
            Let l = new Let(letid, datumOd, datumDo, duzina, cena, dod, ddo, a);
            Korisnik k = new Korisnik(korisnikid, brojPasosa, imeKorisnika, prezimeKorisnika, brojTelefona, user, pass, adminKorisnik);

            Rezervacija rez = new Rezervacija(l, k, datumRez, potvrdjenaRez);
            list.add(rez);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE rezervacija SET datum_rezervacije = '" + new java.sql.Date(this.datumRezervacije.getTime()).toString() + "',"
                + "potvrdjena= " + this.potvrdjena
                + " WHERE let_id = " + this.let.getLetID()+" AND korisnik_id = "+ this.korisnik.getKorisnikID();
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM rezervacija r\n"
                + "JOIN korisnik k ON (r.korisnik_id = k.korisnik_id)\n"
                + "JOIN let l ON (r.let_id = l.let_id)\n"
                + "JOIN destinacija dod ON (l.let_od = dod.destinacija_id)\n"
                + "JOIN destinacija ddo ON (l.let_do = ddo.destinacija_id)\n"
                + "JOIN avion a ON (l.avion_id = a.avion_id)\n"
                + "JOIN avioprevoznik ap ON (a.avioprevoznik_id = ap.avioprevoznik_id)";
    }

    @Override
    public String setQueryForDelete() {
        return "DELETE FROM rezervacija WHERE let_id = "+let.getLetID()+" AND korisnik_id = "+korisnik.getKorisnikID();
    }

}
