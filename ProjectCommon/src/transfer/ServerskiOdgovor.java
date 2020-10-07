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
public class ServerskiOdgovor implements Serializable{
    private Object data;
    private Exception exception;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object data, Exception exception) {
        this.data = data;
        this.exception = exception;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    
}
