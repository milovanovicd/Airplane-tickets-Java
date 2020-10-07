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
public class Avion implements DomainObject {

    private long avionID;
    private Avioprevoznik avioprevoznik;
    private String tipAviona;

    public Avion() {
    }

    public Avion(long avionID, Avioprevoznik avioprevoznik, String tipAviona) {
        this.avionID = avionID;
        this.avioprevoznik = avioprevoznik;
        this.tipAviona = tipAviona;
    }

    public String getTipAviona() {
        return tipAviona;
    }

    public void setTipAviona(String tipAviona) {
        this.tipAviona = tipAviona;
    }

    public long getAvionID() {
        return avionID;
    }

    public void setAvionID(long avionID) {
        this.avionID = avionID;
    }

    public Avioprevoznik getAvioprevoznik() {
        return avioprevoznik;
    }

    public void setAvioprevoznik(Avioprevoznik avioprevoznik) {
        this.avioprevoznik = avioprevoznik;
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
        final Avion other = (Avion) obj;
        if (this.avionID != other.avionID) {
            return false;
        }
        if (!Objects.equals(this.tipAviona, other.tipAviona)) {
            return false;
        }
        if (!Objects.equals(this.avioprevoznik, other.avioprevoznik)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "avion";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        this.avionID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "avioprevoznik_id";
        s += ",tip_aviona";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return avioprevoznik.getAvioprevoznikID()
                + ", '" + tipAviona +"'";
    }

    @Override
    public long getId() {
        return this.avionID;
    }

    @Override
    public String getIdName() {
        return "avion_id";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long avionId = rs.getLong("a.avion_id");
            long avioprevoznikId = rs.getLong("ap.avioprevoznik_id");
            String nazivAvioprevoznika = rs.getString("ap.naziv_avioprevoznika");
            String avionTip = rs.getString("a.tip_aviona");

            Avioprevoznik ap = new Avioprevoznik(avioprevoznikId, nazivAvioprevoznika);
            Avion avion = new Avion(avionId, ap, avionTip);

            list.add(avion);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE avion SET avioprevoznik_id = " + this.avioprevoznik.getAvioprevoznikID()
                + ", tip_aviona = '" + this.tipAviona+ "' WHERE avion_id = "+this.avionID;
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM avion a\n"
                + "JOIN avioprevoznik ap ON (a.avioprevoznik_id = ap.avioprevoznik_id)";
    }

    @Override
    public String toString() {
        return tipAviona;
    }

    @Override
    public String setQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
