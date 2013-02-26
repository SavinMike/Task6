package com.savin.DB.Controller;

import com.savin.DB.Structure.Record;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: BuOs
 * Date: 26.02.13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class DBController implements GuestBookController {
    private Record record = Record.getInit();
    public void addRecord(String message) throws SQLException{
        record.addRecord(System.currentTimeMillis(),message);
    }
    public void getRecords() throws SQLException{ //Record {id, postDate, message}{
        record.getRecords();

    }
    public void delete() throws  SQLException{
        record.delete();
    }

    public void close() throws SQLException{
        record.close();
    }
}
