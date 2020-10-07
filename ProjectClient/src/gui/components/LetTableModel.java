/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components;

import domain.DomainObject;
import domain.Let;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dejanmilovanovic
 */
public class LetTableModel extends AbstractTableModel {
    
    LinkedList<DomainObject> letovi;
    String[] columns = {"Let od","Let do","Datum polaska","Datum povratka","Aviokompanija","Dužina leta","Cena leta"};

    public LetTableModel(LinkedList<DomainObject> letovi) {
        this.letovi = letovi;
    }

    public LetTableModel() {
        this.letovi = new LinkedList<>();
    }
    
    @Override
    public int getRowCount() {
        return letovi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Let let = (Let) letovi.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        switch(columnIndex){
            case 0: return let.getLetOd().getNazivDestinacije();
            case 1: return let.getLetDo().getNazivDestinacije();
            case 2: return format.format(let.getDatumPolaska());
            case 3: return format.format(let.getDatumPovratka());
            case 4: return let.getAvion().getAvioprevoznik();
            case 5: return let.getDuzinaLeta();
            case 6: return let.getCenaLeta() + " RSD";
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public LinkedList<DomainObject> getLetovi() {
        return letovi;
    }

    public void setLetovi(LinkedList<DomainObject> letovi) {
        this.letovi = letovi;
        fireTableDataChanged();
    }
    
    public void izbrisiLet(Let l){
        letovi.remove(l);
        fireTableDataChanged();
    }
    
    
}
