/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import gui.GlavnaKlijentskaForma;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dejanmilovanovic
 */
public class OsveziKorisnikTabeluLetovaNit extends Thread {

    GlavnaKlijentskaForma klijentskaForma;
    private volatile boolean running;

    public OsveziKorisnikTabeluLetovaNit(GlavnaKlijentskaForma klijentskaForma) {
        this.klijentskaForma = klijentskaForma;
        running = true;
    }

    public void terminate() {
        running = false;
        System.out.println("Nit klijentskeForme je prekinuta!");
    }

    @Override
    public void run() {
        while (running) {
            try {
                this.klijentskaForma.fillTable();
                System.out.println("Osvezio klijentskuFormu...");
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                    running = false;
                    Logger.getLogger(OsveziAdminTabeluLetovaNit.class.getName()).log(Level.SEVERE, null, ex);

                }
            } catch (Exception ex) {
                Logger.getLogger(OsveziAdminTabeluLetovaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
