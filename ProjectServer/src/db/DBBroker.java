/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.DomainObject;
import domain.ObjectConverter;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author dejanmilovanovic
 */
public class DBBroker {
    
    private Connection connection;

       
    public void connect() throws Exception {
        try {
            FileInputStream in=new FileInputStream("db.properties");
            Properties props=new Properties();
            props.load(in);
//            String driver=props.getProperty("driver");
            String address = props.getProperty("address");
            String port = props.getProperty("port");
            String database = props.getProperty("database");
            String user=props.getProperty("user");
            String password=props.getProperty("password");
            String url = "jdbc:mysql://"+address+":"+port+"/"+database;
            
//            Class.forName(driver);

            connection = DriverManager.getConnection(url+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
            connection.setAutoCommit(false);
            System.out.println("Uspesno uspostavljena konekcija sa bazom!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom uspostavljanja konekcije sa bazom!\n" + ex.getMessage());
        }
    }
    
        public void disconnect() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom raskidanja konekcije sa bazom!\n" + ex.getMessage());
            }
        }
    }

    public void commit() throws Exception {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom potvrdjivanja transakcije!\n" + ex.getMessage());
            }
        }
    }

    public void rollback() throws Exception {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom ponistavanja transakcije!\n" + ex.getMessage());
            }
        }
    }
    
    public LinkedList<DomainObject> getAll(Class klasa, String where, String orderBy) throws Exception {

        Statement statement = connection.createStatement();

        LinkedList<DomainObject> list = new LinkedList<>();

        DomainObject domain = ObjectConverter.createObject(klasa);

        String query = domain.setQueryForSelect();

        if (!where.equals("")) {
            query += " where " + where;
        }

        if (!orderBy.equals("")) {
            query += " order by " + orderBy;
        }

        ResultSet rs = statement.executeQuery(query);

        return domain.getListFromRs(rs);

    }

    public DomainObject update(DomainObject odo) throws Exception {
        try {
            String upit = odo.setQueryForUpdate();

            System.out.println(upit);

            Statement statement = connection.createStatement();

            statement.executeUpdate(upit);
            System.out.println("Uspesno izmenjen " + odo.getTableName() + " u bazi!");
            return odo;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage() + "Greska prilikom kreiranja " + odo.getTableName() + " u bazi!\n");
        }
    }

    public boolean remove(DomainObject odo) {
        try {
            String upit = "DELETE FROM " + odo.getTableName() + " WHERE " + odo.getIdName() + "= " + odo.getId();
            System.out.println(upit);
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            System.out.println("Uspesno obrisan " + odo.getTableName() + " iz baze!");
            return true;
        } catch (Exception ex) {
            System.out.println("Neuspesno obrisan " + odo.getTableName() + " iz baze!");
            ex.printStackTrace();
            return false;
        }
    }
    
        public boolean removeComplex(DomainObject odo) {
        try {
            String upit = odo.setQueryForDelete();
            System.out.println(upit);
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            System.out.println("Uspesno obrisan " + odo.getTableName() + " iz baze!");
            return true;
        } catch (Exception ex) {
            System.out.println("Neuspesno obrisan " + odo.getTableName() + " iz baze!");
            ex.printStackTrace();
            return false;
        }
    }

    public DomainObject insert(DomainObject odo) throws Exception {
        try {
            String upit = "INSERT INTO " + odo.getTableName() + " (" + odo.getAttributeNamesForInsert() + ") VALUES (" + odo.getAttributeValuesForInsert() + ")";
            System.out.println(upit);
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);

            if (odo.isAutoincrement()) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    odo.setObjectId(rs.getLong(1));
                }
            }

            System.out.println("Uspesno kreiran " + odo.getTableName() + " u bazi!");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage() + " Greska prilikom kreiranja " + odo.getTableName() + " u bazi!\n");
        }
        return odo;
    }

}