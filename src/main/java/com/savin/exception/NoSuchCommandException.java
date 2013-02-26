package com.savin.exception;

/**
 * Created with IntelliJ IDEA.
 * User: BuOs
 * Date: 26.02.13
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class NoSuchCommandException extends ConsoleDBException {
    public String toString(){
        return "Такой комманды нет.";
    }
}
