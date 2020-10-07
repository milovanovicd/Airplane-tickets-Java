/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import gui.GlavnaAdminForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dejanmilovanovic
 */
public class OsveziAdminTabeluLetovaNit extends Thread {

    GlavnaAdminForma adminForma;
    private volatile boolean running;

    public OsveziAdminTabeluLetovaNit(GlavnaAdminForma gaf) {
        this.adminForma = gaf;
        running = true;
    }
    
    public void terminate() {
        running = false;
        System.out.println("Nit adminForme je prekinuta!");
    }

    @Override
    public void run() {
        while (running) {
            try {
                adminForma.fillTable();
                System.out.println("Osvezio adminFormu...");
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
