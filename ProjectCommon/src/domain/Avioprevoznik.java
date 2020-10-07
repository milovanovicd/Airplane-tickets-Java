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
public class Avioprevoznik implements DomainObject {

    private long avioprevoznikID;
    private String nazivAvioprevoznika;

    public Avioprevoznik() {
    }

    public Avioprevoznik(long avioprevoznikID, String nazivAvioprevoznika) {
        this.avioprevoznikID = avioprevoznikID;
        this.nazivAvioprevoznika = nazivAvioprevoznika;
    }

    public String getNazivAvioprevoznika() {
        return nazivAvioprevoznika;
    }

    public void setNazivAvioprevoznika(String nazivAvioprevoznika) {
        this.nazivAvioprevoznika = nazivAvioprevoznika;
    }

    public long getAvioprevoznikID() {
        return avioprevoznikID;
    }

    public void setAvioprevoznikID(long avioprevoznikID) {
        this.avioprevoznikID = avioprevoznikID;
    }

    @Override
    public String toString() {
        return nazivAvioprevoznika;
    }

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
        final Avioprevoznik other = (Avioprevoznik) obj;
        if (this.avioprevoznikID != other.avioprevoznikID) {
            return false;
        }
        if (!Objects.equals(this.nazivAvioprevoznika, other.nazivAvioprevoznika)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "avioprevoznik";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        this.avioprevoznikID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "naziv_avioprevoznika";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + this.nazivAvioprevoznika + "'";
    }

    @Override
    public long getId() {
        return this.avioprevoznikID;
    }

    @Override
    public String getIdName() {
        return "avioprevoznik_id";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long avioprevoznikId = rs.getLong("avioprevoznik_id");
            String naziv = rs.getString("naziv_avioprevoznika");

            Avioprevoznik ap = new Avioprevoznik(avioprevoznikId, naziv);

            list.add(ap);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE avioprevoznik SET naziv_avioprevoznika = '" + this.nazivAvioprevoznika 
                + "' WHERE avioprevoznik_id = " + this.avioprevoznikID;
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM avioprevoznik";
    }

    @Override
    public String setQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
