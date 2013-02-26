package com.savin.DB.Structure;

import java.io.File;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: BuOs
 * Date: 26.02.13
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class Record {
    public static Record _init=null;
    private Connection conn;
    private Statement st1;
    private Record(){
        try {
            if(!new File("test.h2.db").exists()) {
                this.conn = DriverManager.getConnection("jdbc:h2:test", "sa", "");
                st1 =conn.createStatement();
                st1.execute("CREATE TABLE posts(id int NOT NULL AUTO_INCREMENT," +
                        "postDate long," +
                        "postMessage varchar(255)," +
                        "PRIMARY KEY (id))\n") ;
            }
            System.out.println("ready to start");

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static Record getInit(){
        if(_init==null){
            return new Record();
        }
        else
            return _init;
    }

    public void addRecord(long date,String postMessage) throws SQLException{
        st1.execute("INSERT INTO posts(postDate,postMessage) VALUES ("+date+",'"+postMessage+"')");
    }
    public void getRecords() throws SQLException{
        ResultSet result;
        result=st1.executeQuery("SELECT * FROM posts");
        while (result.next()){
            System.out.println("id: "+result.getString("id")+" postDate: "+result.getString("postDate")+
                    " postMessage: "+result.getString("postMessage"));
        }
    }
    public void delete()throws SQLException{
        st1.execute("DELETE FROM POSTS");
    }
    public void close() throws SQLException{
        conn.close();
    }


}
