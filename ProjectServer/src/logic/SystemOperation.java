/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import db.DBBroker;
import domain.DomainObject;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;
import validation.Validator;

/**
 *
 * @author dejanmilovanovic
 */
public abstract class SystemOperation {
    protected Validator validator;
    protected DBBroker dbbr;
    protected DomainObject odo;
    protected LinkedList<DomainObject> lista;
    protected boolean ret;
    protected Map<String,Object> mapa;

    public SystemOperation() {
        dbbr= new DBBroker();
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }
    
    
    
    protected void checkPreconditions() throws Exception{
        if(validator!=null){
            validator.validate(odo);
        }
    }
    
    protected void connectStorage() throws Exception{
        getDbbr().connect();
    }
    
    protected void disconnectStorage() throws Exception{
        getDbbr().disconnect();
    }
    
    protected abstract void operation()throws Exception;
    
    public void execute() throws Exception{
        connectStorage();
        checkPreconditions();
        try {
            operation();
            getDbbr().commit();
        } catch (Exception ex) {
            getDbbr().rollback();
            throw ex;
        }finally{
            disconnectStorage();
        }
    }

    public DomainObject getDomainObject() {
        return getOdo();
    }

    /**
     * @return the dbbr
     */
    public DBBroker getDbbr() {
        return dbbr;
    }
    
    
    /**
     * @param dbbr the dbbr to set
     */
    public void setDbbr(DBBroker dbbr) {
        this.dbbr = dbbr;
    }

    /**
     * @return the odo
     */
    public DomainObject getOdo() {
        return odo;
    }

    /**
     * @param odo the odo to set
     */
    public void setOdo(DomainObject odo) {
        this.odo = odo;
    }

    public LinkedList<DomainObject> getLista() {
        return lista;
    }

    public void setLista(LinkedList<DomainObject> lista) {
        this.lista = lista;
    }
}
