/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components;

import domain.DomainObject;
import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dejanmilovanovic
 */
public class MojeRezervacijeTableModel extends AbstractTableModel{
   
    LinkedList<DomainObject> rezervacije;
    String[] columns = {"Let","Cena leta","Datum polaska","Aviokompanija","Datum rezervacije","Potvrđena"};

    public MojeRezervacijeTableModel() {
        this.rezervacije = new LinkedList<>();
    }

    public MojeRezervacijeTableModel(LinkedList<DomainObject> rezervacije) {
        this.rezervacije = rezervacije;
    }
    
    
    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija rez = (Rezervacija) rezervacije.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        switch(columnIndex){
            case 0: return rez.getLet();
            case 1: return rez.getLet().getCenaLeta()+" RSD";
            case 2: return format.format(rez.getLet().getDatumPolaska());
            case 3: return rez.getLet().getAvion().getAvioprevoznik().getNazivAvioprevoznika();
            case 4: return format.format(rez.getDatumRezervacije());
            case 5: return rez.isPotvrdjena()? "Potvrđena":"U obradi";
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public LinkedList<DomainObject> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(LinkedList<DomainObject> rezervacije) {
        this.rezervacije = rezervacije;
        fireTableDataChanged();
    }
    
    public void izbrisiRezervaciju(Rezervacija rez){
        rezervacije.remove(rez);
        fireTableDataChanged();
    }
    
    
    
     
}
