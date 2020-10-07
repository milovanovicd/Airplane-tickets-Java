/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author dejanmilovanovic
 */
public class KlijentskiZahtev implements Serializable{
    private int operation;
    private Object data;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    
}
