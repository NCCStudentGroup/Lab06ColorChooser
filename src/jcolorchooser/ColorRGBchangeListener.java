/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author alex.henkin
 */
public class ColorRGBchangeListener implements DocumentListener{

    @Override
    public void insertUpdate(DocumentEvent de) {
        JOptionPane.showMessageDialog(null,
          "RGB Value changed", "Warning Massage",
          JOptionPane.WARNING_MESSAGE);  
        // Need to call stateChanged() of RGB panel, but how do I get to it? 
        // It is Event > Document > Field > Form?
        // stateChanged(new ChangeEvent(this));
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        JOptionPane.showMessageDialog(null,
          "RGB Value changed", "Warning Massage",
          JOptionPane.WARNING_MESSAGE);    
        // Need to call stateChanged() of RGB panel, but how do I get to it? 
        // It is Event > Document > Field > Form?
        // stateChanged(new ChangeEvent(this));    
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        JOptionPane.showMessageDialog(null,
          "RGB Value changed", "Warning Massage",
          JOptionPane.WARNING_MESSAGE);    
        // Need to call stateChanged() of RGB panel, but how do I get to it? 
        // It is Event > Document > Field > Form?
        // stateChanged(new ChangeEvent(this));    
    }
    
}
