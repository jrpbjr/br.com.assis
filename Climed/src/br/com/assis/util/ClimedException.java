/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.util;

/**
 *
 * @author Jose
 */
public class ClimedException extends Exception {

    /**
     * Creates a new instance of <code>ClimedException</code> without detail
     * message.
     */
    public ClimedException() {
    }

    /**
     * Constructs an instance of <code>ClimedException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     * @param e
     */
    
    public ClimedException(String msg, Exception e) {
        super(msg, e);
    }
    
    public ClimedException(String msg) {
        super(msg);
    }
}
