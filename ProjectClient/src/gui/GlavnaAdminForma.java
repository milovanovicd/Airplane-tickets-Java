/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Avion;
import domain.Avioprevoznik;
import domain.Destinacija;
import domain.DomainObject;
import domain.Korisnik;
import domain.Let;
import domain.Rezervacija;
import gui.components.LetTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import threads.OsveziAdminTabeluLetovaNit;

/**
 *
 * @author dejanmilovanovic
 */
public class GlavnaAdminForma extends javax.swing.JFrame {

    private final Korisnik korisnik;

    /**
     * Creates new form GlavnaAdminForma
     *
     * @param k
     */
    public GlavnaAdminForma(Korisnik k) {
        initComponents();
        setLocationRelativeTo(null);
        this.korisnik = k;
        OsveziAdminTabeluLetovaNit osveziNit = new OsveziAdminTabeluLetovaNit(this);
        
        try {
            srediTabelu();
            fillComboBoxes();
            osveziNit.start();
//            fillTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greška prilikom popunjavanja podataka!");
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                if(osveziNit!=null){
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
        tblLetovi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnDodajLet = new javax.swing.JButton();
        btnIzmeniLet = new javax.swing.JButton();
        btnRezervacije = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        cmbPolaznaDestinacija7 = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        cmbKrajnjaDestinacija7 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        txtDatumPolaska7 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtDatumPovratka7 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cmbAvioprevoznik7 = new javax.swing.JComboBox();
        btnPretrazi7 = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPonistiFiltere = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administratorska forma");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblLetovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLetovi);

        jLabel2.setText("Letovi:");

        btnDodajLet.setText("Dodaj Let");
        btnDodajLet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajLetActionPerformed(evt);
            }
        });

        btnIzmeniLet.setText("Izmeni let");
        btnIzmeniLet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniLetActionPerformed(evt);
            }
        });

        btnRezervacije.setText("Rezervacije");
        btnRezervacije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervacijeActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraži letove"));

        jLabel37.setText("Polazna destinacija");

        cmbPolaznaDestinacija7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel38.setText("Krajnja destinacija");

        cmbKrajnjaDestinacija7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setText("Datum polaska");

        txtDatumPolaska7.setText("dd/MM/yyyy");

        jLabel40.setText("Datum povratka");

        txtDatumPovratka7.setText("dd/MM/yyyy");

        jLabel41.setText("Avioprevoznik");

        cmbAvioprevoznik7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPretrazi7.setText("Pretrazi");
        btnPretrazi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretrazi7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPolaznaDestinacija7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbKrajnjaDestinacija7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatumPolaska7)
                    .addComponent(txtDatumPovratka7)
                    .addComponent(cmbAvioprevoznik7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPretrazi7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41))))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPolaznaDestinacija7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbKrajnjaDestinacija7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatumPolaska7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatumPovratka7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAvioprevoznik7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPretrazi7))
        );

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnDodajLet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzmeniLet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRezervacije))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPonistiFiltere)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajLet)
                    .addComponent(btnIzmeniLet)
                    .addComponent(btnRezervacije)
                    .addComponent(btnObrisi)
                    .addComponent(btnPonistiFiltere))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajLetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajLetActionPerformed
        JDialog letDialog = new LetDialog(this, true, null);
        letDialog.setVisible(true);
    }//GEN-LAST:event_btnDodajLetActionPerformed

    private void btnIzmeniLetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniLetActionPerformed
        int row = tblLetovi.getSelectedRow();
        if (row != -1) {
            LetTableModel ltm = (LetTableModel) tblLetovi.getModel();
            Let let = (Let) ltm.getLetovi().get(row);
            System.out.println("Let za izmenu: " + let);
            LetDialog jf = new LetDialog(this, true, let);
            jf.setVisible(true);
//            setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite let koji želite da izmenite!","Izmena leta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmeniLetActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int row = tblLetovi.getSelectedRow();
        if (row != -1) {
            LetTableModel ltm = (LetTableModel) tblLetovi.getModel();
            Let let = (Let) ltm.getLetovi().get(row);
            try {
                boolean ret = KomunikacijaSaServerom.getInstanca().izbrisiLet(let);
                if (ret) {
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao let","Brisanje leta",JOptionPane.INFORMATION_MESSAGE);
                    ltm.izbrisiLet(let);
                    fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne može da obriše let!","Brisanje leta",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),"Brisanje leta",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite let koji želite da obrišete!","Brisanje leta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnRezervacijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervacijeActionPerformed
    int row = tblLetovi.getSelectedRow();
    if (row != -1) {
        try {
            LetTableModel ltm = (LetTableModel) tblLetovi.getModel();
            Let let = (Let) ltm.getLetovi().get(row);
            
            LinkedList<DomainObject> rezervacije = KomunikacijaSaServerom.getInstanca().vratiRezervacije();
            LinkedList<DomainObject> noveRezervacije = new LinkedList<>();
            
            for (DomainObject domainObject : rezervacije) {
                Rezervacija rez = (Rezervacija) domainObject;
                
                if(rez.getLet().equals(let));
                
                noveRezervacije.add(rez);
            }
            
            JDialog rezDialog = new RezervacijeAdminDialog(this, true, noveRezervacije);
//            try {
//                boolean ret = KomunikacijaSaServerom.getInstanca().izbrisiLet(let);
//                if (ret) {
//                    JOptionPane.showMessageDialog(this, "Sistem je obrisao let","Brisanje leta",JOptionPane.INFORMATION_MESSAGE);
//                    ltm.izbrisiLet(let);
//                    fillTable();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Sistem ne može da obriše let!","Brisanje leta",JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, ex.getMessage(),"Brisanje leta",JOptionPane.ERROR_MESSAGE);
//            }
        } catch (IOException ex) {
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite let koji želite da obrišete!","Brisanje leta",JOptionPane.WARNING_MESSAGE);
        }

//        JDialog rezDialog = new RezervacijeAdminDialog(this, true);
//        rezDialog.setVisible(true);
    }//GEN-LAST:event_btnRezervacijeActionPerformed

    private void btnPretrazi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretrazi7ActionPerformed
        try {

            Destinacija polaznaDestinacija = (Destinacija) cmbPolaznaDestinacija7.getSelectedItem();
            Destinacija krajnjaDestinacija = (Destinacija) cmbKrajnjaDestinacija7.getSelectedItem();
            Date datumPolaska = null;
            Date datumPovratka = null;
            if (!"dd/MM/yyyy".equals(txtDatumPolaska7.getText()) && !"".equals(txtDatumPolaska7.getText())) {
                datumPolaska = new SimpleDateFormat("dd/MM/yyyy").parse(txtDatumPolaska7.getText());
            }
            if (!"dd/MM/yyyy".equals(txtDatumPovratka7.getText()) && !"".equals(txtDatumPovratka7.getText())) {
                datumPovratka = new SimpleDateFormat("dd/MM/yyyy").parse(txtDatumPovratka7.getText());
            }

            Avioprevoznik avioprevoznik = (Avioprevoznik) cmbAvioprevoznik7.getSelectedItem();
            Avion avion = new Avion(-1, avioprevoznik, "");

            Let letPretraga = new Let(-1, datumPolaska, datumPovratka, 0, BigDecimal.ONE, polaznaDestinacija, krajnjaDestinacija, avion);

            LinkedList<DomainObject> letovi = KomunikacijaSaServerom.getInstanca().pronadjiLetove(letPretraga);
            LetTableModel tm = new LetTableModel();
            tblLetovi.setModel(tm);

            if (letovi.isEmpty()) {
                tm.setLetovi(letovi);
                throw new Exception("Sistem ne može da nađe letove po zadatoj vrednosti!");
            }

            tm.setLetovi(letovi);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Neispravan format datuma! (dd/MM/yyyy)","Pretraga",JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Pretraga",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretrazi7ActionPerformed

    private void btnPonistiFiltereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiFiltereActionPerformed
        try {
            osvezi();
            txtDatumPolaska7.setText("dd/MM/yyyy");
            txtDatumPovratka7.setText("dd/MM/yyyy");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Poništi filtere",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GlavnaAdminForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPonistiFiltereActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajLet;
    private javax.swing.JButton btnIzmeniLet;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPonistiFiltere;
    private javax.swing.JButton btnPretrazi7;
    private javax.swing.JButton btnRezervacije;
    private javax.swing.JComboBox cmbAvioprevoznik7;
    private javax.swing.JComboBox cmbKrajnjaDestinacija7;
    private javax.swing.JComboBox cmbPolaznaDestinacija7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLetovi;
    private javax.swing.JTextField txtDatumPolaska7;
    private javax.swing.JTextField txtDatumPovratka7;
    // End of variables declaration//GEN-END:variables

    private void fillComboBoxes() throws Exception {
        LinkedList<DomainObject> destinacije = KomunikacijaSaServerom.getInstanca().vratiDestinacije();
        LinkedList<DomainObject> avioprevoznici = KomunikacijaSaServerom.getInstanca().vratiAvioprevoznike();
        cmbPolaznaDestinacija7.removeAllItems();
        cmbKrajnjaDestinacija7.removeAllItems();
        cmbAvioprevoznik7.removeAllItems();

        cmbPolaznaDestinacija7.addItem(new Destinacija(-1, "Sve destinacije"));
        for (DomainObject polaznaDestinacija : destinacije) {
            cmbPolaznaDestinacija7.addItem(polaznaDestinacija);
        }
        cmbKrajnjaDestinacija7.addItem(new Destinacija(-1, "Sve destinacije"));
        for (DomainObject krajnjaDestinacija : destinacije) {
            cmbKrajnjaDestinacija7.addItem(krajnjaDestinacija);
        }
        cmbAvioprevoznik7.addItem(new Avioprevoznik(-1, "Svi"));
        for (DomainObject avioprevoznik : avioprevoznici) {
            cmbAvioprevoznik7.addItem(avioprevoznik);
        }
    }

    public void fillTable() throws Exception {
        LinkedList<DomainObject> letovi = KomunikacijaSaServerom.getInstanca().vratiLetove();
        LetTableModel tm = (LetTableModel) tblLetovi.getModel();
        tm.setLetovi(letovi);
    }

    void osvezi() throws Exception {
        fillTable();
        fillComboBoxes();
    }

    private void srediTabelu() {
        LetTableModel tm = new LetTableModel();
        tblLetovi.setModel(tm);
    }
}