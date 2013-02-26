package com.savin.DB.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: BuOs
 * Date: 26.02.13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public interface GuestBookController extends AutoCloseable{
    void addRecord(String message) throws SQLException;
    void getRecords() throws SQLException; //Record {id, postDate, message}
    void close() throws SQLException;
    void delete() throws SQLException;
}
