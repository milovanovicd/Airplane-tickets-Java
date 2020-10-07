/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author dejanmilovanovic
 */
public class Let implements DomainObject {

    private long letID;
    private Date datumPolaska;
    private Date datumPovratka;
    private int duzinaLeta;
    private BigDecimal cenaLeta;
    private Destinacija letOd;
    private Destinacija letDo;
    private Avion avion;

    public Let() {
    }

    public Let(long letID, Date datumPolaska, Date datumPovratka, int duzinaLeta, BigDecimal cenaLeta, Destinacija letOd, Destinacija letDo, Avion avion) {
        this.letID = letID;
        this.datumPolaska = datumPolaska;
        this.datumPovratka = datumPovratka;
        this.duzinaLeta = duzinaLeta;
        this.cenaLeta = cenaLeta;
        this.letOd = letOd;
        this.letDo = letDo;
        this.avion = avion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public long getLetID() {
        return letID;
    }

    public void setLetID(long letID) {
        this.letID = letID;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Date getDatumPovratka() {
        return datumPovratka;
    }

    public void setDatumPovratka(Date datumPovratka) {
        this.datumPovratka = datumPovratka;
    }

    public int getDuzinaLeta() {
        return duzinaLeta;
    }

    public void setDuzinaLeta(int duzinaLeta) {
        this.duzinaLeta = duzinaLeta;
    }

    public BigDecimal getCenaLeta() {
        return cenaLeta;
    }

    public void setCenaLeta(BigDecimal cenaLeta) {
        this.cenaLeta = cenaLeta;
    }

    public Destinacija getLetOd() {
        return letOd;
    }

    public void setLetOd(Destinacija letOd) {
        this.letOd = letOd;
    }

    public Destinacija getLetDo() {
        return letDo;
    }

    public void setLetDo(Destinacija letDo) {
        this.letDo = letDo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Let other = (Let) obj;
        if (this.duzinaLeta != other.duzinaLeta) {
            return false;
        }
        if (!Objects.equals(new SimpleDateFormat("dd/MM/yyyy").format(this.datumPolaska), new SimpleDateFormat("dd/MM/yyyy").format(other.datumPolaska))) {
            return false;
        }
        if (!Objects.equals(new SimpleDateFormat("dd/MM/yyyy").format(this.datumPovratka), new SimpleDateFormat("dd/MM/yyyy").format(other.datumPovratka))) {
            return false;
        }
        if (!Objects.equals(this.cenaLeta, other.cenaLeta)) {
            return false;
        }
        if (!Objects.equals(this.letOd, other.letOd)) {
            return false;
        }
        if (!Objects.equals(this.letDo, other.letDo)) {
            return false;
        }
        if (!Objects.equals(this.avion, other.avion)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return letOd+"-"+letDo+" | "+avion.getAvioprevoznik();
    }
    
    
    
    @Override
    public String getTableName() {
        return "let";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        this.letID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "datum_polaska";
        s += ",datum_povratka";
        s += ",duzina_leta";
        s += ",cena_leta";
        s += ",let_od";
        s += ",let_do";
        s += ",avion_id";

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + new java.sql.Date(this.datumPolaska.getTime()).toString() + "'"
                + ", '" + new java.sql.Date(this.datumPovratka.getTime()).toString() + "' ,"
                + this.duzinaLeta + ","
                + this.cenaLeta + ","
                + this.letOd.getDestinacijaID() + ","
                + this.letDo.getDestinacijaID() + ","
                + this.avion.getAvionID();
                
    }

    @Override
    public long getId() {
        return this.letID;
    }

    @Override
    public String getIdName() {
        return "let_id";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {

            long id = rs.getLong("l.let_id");
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
            
            Destinacija dod = new Destinacija(idOd, nazivOd);
            Destinacija  ddo= new Destinacija(idDo, nazivDo);
            Avioprevoznik ap = new Avioprevoznik(avioprevoznikId, nazivAvioprevoznika);
            Avion a = new Avion(avionId, ap, avionTip);
            Let let = new Let(id, datumOd, datumDo, duzina, cena, dod, ddo, a);
            list.add(let);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {

        return "UPDATE let SET datum_polaska = '" + new java.sql.Date(this.datumPolaska.getTime()).toString()
                + "' , datum_povratka = '" + new java.sql.Date(this.datumPovratka.getTime()).toString() + "',"
                + "duzina_leta = " + this.duzinaLeta + ","
                + "cena_leta= "+ this.cenaLeta + ","
                +"let_od =" + this.letOd.getDestinacijaID() + ","
                +"let_do =" + this.letDo.getDestinacijaID() + ","
                +"avion_id =" + this.avion.getAvionID()
                +" WHERE let_id = "+this.letID;
    }

    @Override
    public String setQueryForSelect() {
        return "SELECT * FROM let l\n"
                + "JOIN destinacija dod ON (l.let_od = dod.destinacija_id)\n"
                + "JOIN destinacija ddo ON (l.let_do = ddo.destinacija_id)\n"
                + "JOIN avion a ON (l.avion_id = a.avion_id)\n"
                + "JOIN avioprevoznik ap ON (a.avioprevoznik_id = ap.avioprevoznik_id)";
    }

    @Override
    public String setQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
