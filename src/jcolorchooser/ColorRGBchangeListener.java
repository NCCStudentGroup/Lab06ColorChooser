/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author alex.henkin
 */
public class ColorRGBchangeListener implements DocumentListener{

    @Override
    public void insertUpdate(DocumentEvent de) {
        System.out.println("RGB insert");
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        System.out.println("RGB remove");
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        System.out.println("RGB change");
    }
    
}
