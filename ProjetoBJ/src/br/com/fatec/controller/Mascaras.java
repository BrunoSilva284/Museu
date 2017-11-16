/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author bruno.a.da.silva
 */
public class Mascaras {
    
    public static DefaultFormatterFactory cpf(){
        try {
            return new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##"));
        } catch (ParseException ex) {
            Logger.getLogger(Mascaras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static DefaultFormatterFactory data(){
        try {
            return new DefaultFormatterFactory(
                    new MaskFormatter("####-##-##"));
        } catch (ParseException ex) {
            Logger.getLogger(Mascaras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
