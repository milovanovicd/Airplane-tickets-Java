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
 *Ï
 * @author dejanmilovanovic
 */
public class Destinacija implements DomainObject {

    private long destinacijaID;
    private String nazivDestinacije;

    public Destinacija() {
    }

    public Destinacija(long destinacijaID, String nazivDestinacije) {
        this.destinacijaID = destinacijaID;
        this.nazivDestinacije = nazivDestinacije;
    }

    public String getNazivDestinacije() {
        return nazivDestinacije;
    }

    public void setNazivDestinacije(String nazivDestinacije) {
        this.nazivDestinacije = nazivDestinacije;
    }

    public long getDestinacijaID() {
        return destinacijaID;
    }

    public void setDestinacijaID(long destinacijaID) {
        this.destinacijaID = destinacijaID;
    }

    @Override
    public String toString() {
        return nazivDestinacije;
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
        final Destinacija other = (Destinacija) obj;
        if (this.destinacijaID != other.destinacijaID) {
            return false;
        }
        if (!Objects.equals(this.nazivDestinacije, other.nazivDestinacije)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String getTableName() {
        return "destinacija";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        this.destinacijaID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "naziv_destinacije";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + this.nazivDestinacije + "'";
    }

    @Override
    public long getId() {
        return this.destinacijaID;
    }

    @Override
    public String getIdName() {
        return "destinacija_id";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long id = rs.getLong("destinacija_id");
            String naziv = rs.getString("naziv_destinacije");

            Destinacija d = new Destinacija(id, naziv);

            list.add(d);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE destinacija SET naziv_destinacije = '" + this.nazivDestinacije 
                + "' WHERE destinacija_id = "+ this.destinacijaID;
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM destinacija";
    }

    @Override
    public String setQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
