/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dejanmilovanovic
 */
public class ServerskaNit extends Thread {

    private ServerSocket serverSocket;
    ArrayList<ObradaKlijentskogZahtevaNit> klijenti;

    public ServerskaNit() throws IOException {
        serverSocket = new ServerSocket(9000);
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            System.out.println("Čekanje na klijenta...");

            try {
                Socket s = serverSocket.accept();
                ObradaKlijentskogZahtevaNit klijent = new ObradaKlijentskogZahtevaNit(s);
                klijent.start();
                klijenti.add(klijent);
                System.out.println("Klijent se povezao!");
                
            } catch (IOException ex) {
                System.out.println("Server je zatvoren!");
            }
        }
    }
    
    public void zaustaviServerskuNit() throws IOException{
        serverSocket.close();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    public void stopClientHandlers(){
        for (ObradaKlijentskogZahtevaNit klijent : klijenti) {
            try {
                klijent.getKlijentskiSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
