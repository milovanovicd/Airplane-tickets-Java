/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author dejanmilovanovic
 */
public interface DomainObject extends Serializable{


    public String getTableName();

    public boolean isAutoincrement();

    public void setObjectId(long id);

    public String getAttributeNamesForInsert();

    public String getAttributeValuesForInsert();

    public long getId();

    public String getIdName();

    public LinkedList<DomainObject> getListFromRs(ResultSet rs)throws Exception;

    public String setQueryForUpdate();

    public String setQueryForSelect();
    
    public String setQueryForDelete();

    
    

}
