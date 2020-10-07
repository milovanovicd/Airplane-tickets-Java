/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author dejanmilovanovic
 */
public class Korisnik implements DomainObject {

    private long korisnikID;
    private long brPasosa;
    private String ime;
    private String prezime;
    private String brTelefona;
    private String username;
    private String password;
    private boolean admin;

    public Korisnik() {
    }

    public Korisnik(long korisnikID, long brPasosa, String ime, String prezime, String brTelefona, String username, String password, boolean admin) {
        this.korisnikID = korisnikID;
        this.brPasosa = brPasosa;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

//    @Override
//    public String toString() {
//        return "Korisnik{" + "korisnikID=" + korisnikID + ", brPasosa=" + brPasosa + ", ime=" + ime + ", prezime=" + prezime + ", brTelefona=" + brTelefona + ", username=" + username + ", password=" + password + ", admin=" + admin + '}';
//    }
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public long getBrPasosa() {
        return brPasosa;
    }

    public void setBrPasosa(long brPasosa) {
        this.brPasosa = brPasosa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        this.korisnikID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "br_pasosa";
        s += ",ime";
        s += ",prezime";
        s += ",br_telefona";
        s += ",username";
        s += ",password";
        s += ",admin";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return this.brPasosa
                + ", '" + this.ime + "'"
                + ", '" + this.prezime + "'"
                + ", " + this.brTelefona
                + ", '" + this.username + "'"
                + ", '" + this.password + "'"
                + ", " + this.admin;

    }

    @Override
    public long getId() {
        return this.korisnikID;
    }

    @Override
    public String getIdName() {
        return "korisnik_id";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long id = rs.getLong("korisnik_id");
            long brojPasosa = rs.getLong("br_pasosa");
            String imeKorisnika = rs.getString("ime");
            String prezimeKorisnika = rs.getString("prezime");
            String brojTelefona = rs.getString("br_telefona");
            String user = rs.getString("username");
            String pass = rs.getString("password");
            boolean adminKorisnik = rs.getBoolean("admin");

            Korisnik k = new Korisnik(id, brojPasosa, imeKorisnika, prezimeKorisnika, brojTelefona, user, pass, adminKorisnik);

            list.add(k);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE korisnik SET broj_pasosa = " + this.brPasosa
                + ", ime = '" + this.ime + "'"
                + ", prezime = '" + this.prezime + "'"
                + ", br_telefona = '" + this.brTelefona + "'"
                + ", username = '" + this.username + "'"
                + ", password = '" + this.password + "'"
                + ", admin = " + this.admin
                + " WHERE korisnik_id = " + this.korisnikID;
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM korisnik";
    }

    @Override
    public String setQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
