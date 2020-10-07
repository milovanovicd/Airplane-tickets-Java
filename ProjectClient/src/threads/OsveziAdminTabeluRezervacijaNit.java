/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import gui.RezervacijeAdminDialog;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dejanmilovanovic
 */
public class OsveziAdminTabeluRezervacijaNit extends Thread {

    RezervacijeAdminDialog rezervacijeDialog;
    private volatile boolean running;

    public OsveziAdminTabeluRezervacijaNit(RezervacijeAdminDialog rezervacijeDialog) {
        this.rezervacijeDialog = rezervacijeDialog;
        running = true;
    }

    public void terminate() {
        running = false;
        System.out.println("Nit rezervacijeDialog je prekinuta");
    }

    @Override
    public void run() {
        while (running) {
            try {
                this.rezervacijeDialog.fillTable();
                System.out.println("Osvezio rezervacijeDialog...");
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
