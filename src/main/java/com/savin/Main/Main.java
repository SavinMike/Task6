package com.savin.Main;

import com.savin.DB.Controller.DBController;
import com.savin.DB.Controller.GuestBookController;
import com.savin.exception.NoSuchCommandException;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: BuOs
 * Date: 26.02.13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        Scanner scanner=new Scanner(System.in);
        String s;
        try (GuestBookController db=new DBController()){
            int start;
            while (true){
                try {
                    s=scanner.nextLine();

                    if(s.contains("add")){
                        start=s.indexOf("add")+3;
                        db.addRecord(s.substring(start).trim());
                    }
                    else if (s.contains("list")){
                        db.getRecords();
                    }
                    else if(s.contains("delete")){
                        db.delete();
                    }
                    else{
                        throw new NoSuchCommandException();

                    }
                }
                catch (NoSuchCommandException e){
                    System.out.println(e);
                }
            }
        }
        catch (Exception e){
            System.out.println("try block in Main class: "+e);
        }

    }
}
