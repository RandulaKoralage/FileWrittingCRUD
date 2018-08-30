/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

/**
 *
 * @author Randula
 */
public class PrimaryKeyDuplicatedException extends Exception{
    
    public PrimaryKeyDuplicatedException() {
        // TODO Auto-generated constructor stub
    }

    public PrimaryKeyDuplicatedException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public PrimaryKeyDuplicatedException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public PrimaryKeyDuplicatedException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
