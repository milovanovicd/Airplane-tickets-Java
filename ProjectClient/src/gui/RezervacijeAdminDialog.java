/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Destinacija;
import domain.DomainObject;
import domain.Korisnik;
import domain.Let;
import domain.Rezervacija;
import gui.components.RezervacijaTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import threads.OsveziAdminTabeluRezervacijaNit;

/**
 *
 * @author dejanmilovanovic
 */
public class RezervacijeAdminDialog extends javax.swing.JDialog {

    GlavnaAdminForma parent;
    OsveziAdminTabeluRezervacijaNit osveziNit;

    /**
     * Creates new form RezervacijeDialog
     *
     * @param parent
     * @param modal
     */
    public RezervacijeAdminDialog(GlavnaAdminForma parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(parent);
        this.osveziNit = new OsveziAdminTabeluRezervacijaNit(this);

        try {
            fillComboBoxes();
            srediTabelu();
            osveziNit.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(RezervacijeAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                if (osveziNit != null) {
                    osveziNit.terminate();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRezervacije = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbPolaznaDestinacija = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbKrajnjaDestinacija = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtDatumPolaska = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        txtBrojPasosa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDatumRezervacije = new javax.swing.JTextField();
        btnPotvrdi = new javax.swing.JButton();
        btnZatvori = new javax.swing.JButton();
        btnPonistiFiltere = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRezervacije);

        jLabel1.setText("Rezervacije:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraži rezervacije"));

        jLabel2.setText("Polazna destinacija");

        cmbPolaznaDestinacija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Krajnja destinacija");

        cmbKrajnjaDestinacija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Datum polaska");

        txtDatumPolaska.setText("dd/MM/yyyy");

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        jLabel5.setText("Broj pasoša:");

        jLabel6.setText("Datum rezervacije");

        txtDatumRezervacije.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPolaznaDestinacija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbKrajnjaDestinacija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatumPolaska)
                    .addComponent(btnPretrazi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtBrojPasosa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(txtDatumRezervacije, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPolaznaDestinacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbKrajnjaDestinacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatumPolaska, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatumRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBrojPasosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretrazi))
        );

        btnPotvrdi.setText("Potvrdi rezervaciju");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnPonistiFiltere.setText("Poništi filtere");
        btnPonistiFiltere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiFiltereActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnZatvori)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPotvrdi))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPonistiFiltere))))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPotvrdi)
                    .addComponent(btnZatvori)
                    .addComponent(btnPonistiFiltere))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        int row = tblRezervacije.getSelectedRow();
        if (row != -1) {
            try {
                RezervacijaTableModel ltm = (RezervacijaTableModel) tblRezervacije.getModel();
                Rezervacija rez = KomunikacijaSaServerom.getInstanca().vratiRezervaciju((Rezervacija) ltm.getRezervacije().get(row));

                if (!rez.isPotvrdjena()) {
                    rez.setPotvrdjena(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Rezervacija je već potvrđena!","Potvrdjivanje rezervacije",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                PotvrdaRezervacijeDialog prd = new PotvrdaRezervacijeDialog(this, true, rez);
                prd.setVisible(true);
//                rez = KomunikacijaSaServerom.getInstanca().potvrdiRezervaciju(rez);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),"Potvrdjivanje rezervacije",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(RezervacijeAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite rezervaciju koji želite da potvrdite!","Potvrdjivanje rezervacije",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPotvrdiActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {

            Destinacija polaznaDestinacija = (Destinacija) cmbPolaznaDestinacija.getSelectedItem();
            Destinacija krajnjaDestinacija = (Destinacija) cmbKrajnjaDestinacija.getSelectedItem();
            Date datumPolaska = null;
            if (!"dd/MM/yyyy".equals(txtDatumPolaska.getText()) && !"".equals(txtDatumPolaska.getText())) {
                datumPolaska = new SimpleDateFormat("dd/MM/yyyy").parse(txtDatumPolaska.getText());
            }
            Date datumRezervacije = null;
            if (!"dd/MM/yyyy".equals(txtDatumRezervacije.getText()) && !"".equals(txtDatumRezervacije.getText())) {
                datumRezervacije = new SimpleDateFormat("dd/MM/yyyy").parse(txtDatumRezervacije.getText());
            }
            boolean status = false;
//            if (cmbStatus.getSelectedItem().equals("Potvrdjene")) {
//                status = true;
//            }
////            if (cmbStatus.getSelectedItem().equals("Nepotvrdjene")) {
////                status = false;
////            }

            long brPasosa;
            if (txtBrojPasosa.getText().equals("")) {
                brPasosa = -1;
            } else {
                brPasosa = Long.parseLong(txtBrojPasosa.getText());
            }

            Korisnik k = new Korisnik(-1, brPasosa, "", "", null, null, null, false);
            Let l = new Let(-1, datumPolaska, null, -1, BigDecimal.ONE, polaznaDestinacija, krajnjaDestinacija, null);
//            Avioprevoznik avioprevoznik = (Avioprevoznik) cmbAvioprevoznik.getSelectedItem();
//            Avion avion = new Avion(-1, avioprevoznik, "");
            Rezervacija rezPretraga = new Rezervacija(l, k, datumRezervacije, status);

//            if (cmbStatus.getSelectedItem().equals("Svi")) {
//                rezPretraga.setRezervacijaId(-2);
//            }

            LinkedList<DomainObject> rezervacije = KomunikacijaSaServerom.getInstanca().pronadjiRezervacije(rezPretraga);

            RezervacijaTableModel tm = new RezervacijaTableModel();
            tblRezervacije.setModel(tm);

            if (rezervacije.isEmpty()) {
                tm.setRezervacije(rezervacije);
                throw new Exception("Sistem ne može da nađe rezervacije po zadatim vrednostima!");
            }
            tm.setRezervacije(rezervacije);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Neispravan format datuma! (dd/MM/yyyy)","Pretraga rezervacija",JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Neispravan broj pasosa!","Pretraga rezervacija",JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Pretraga rezervacija",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        dispose();
        if (osveziNit != null) {
            osveziNit.terminate();
        }
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnPonistiFiltereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiFiltereActionPerformed
        try {
            osvezi();
            txtDatumPolaska.setText("dd/MM/yyyy");
            txtBrojPasosa.setText("");
        } catch (Exception ex) {
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPonistiFiltereActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPonistiFiltere;
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox cmbKrajnjaDestinacija;
    private javax.swing.JComboBox cmbPolaznaDestinacija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRezervacije;
    private javax.swing.JTextField txtBrojPasosa;
    private javax.swing.JTextField txtDatumPolaska;
    private javax.swing.JTextField txtDatumRezervacije;
    // End of variables declaration//GEN-END:variables

    private void fillComboBoxes() throws Exception {
        LinkedList<DomainObject> destinacije = KomunikacijaSaServerom.getInstanca().vratiDestinacije();
        cmbPolaznaDestinacija.removeAllItems();
        cmbKrajnjaDestinacija.removeAllItems();
//        cmbStatus.removeAllItems();

        cmbPolaznaDestinacija.addItem(new Destinacija(-1, "Sve destinacije"));
        for (DomainObject polaznaDestinacija : destinacije) {
            cmbPolaznaDestinacija.addItem(polaznaDestinacija);
        }
        cmbKrajnjaDestinacija.addItem(new Destinacija(-1, "Sve destinacije"));
        for (DomainObject krajnjaDestinacija : destinacije) {
            cmbKrajnjaDestinacija.addItem(krajnjaDestinacija);
        }

//        cmbStatus.addItem("Svi");
//        cmbStatus.addItem("Potvrdjene");
//        cmbStatus.addItem("Nepotvrdjene");

    }

    public void fillTable() throws Exception {
        LinkedList<DomainObject> rezervacije = KomunikacijaSaServerom.getInstanca().vratiRezervacije();
        RezervacijaTableModel tm = (RezervacijaTableModel) tblRezervacije.getModel();
        tm.setRezervacije(rezervacije);
    }

    public void osvezi() throws Exception {
        fillTable();
        fillComboBoxes();
    }

    private void srediTabelu() {
        RezervacijaTableModel tm = new RezervacijaTableModel();
        tblRezervacije.setModel(tm);
    }
}
