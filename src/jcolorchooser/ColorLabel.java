/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;

import javax.swing.JLabel;

/**
 *
 * @author 00220682
 */
public class ColorLabel extends JLabel implements ColorListener {
    
    public ColorLabel(){
        super();
        setText("Red: 0 Green: 0 Blue: 0");
    }

    @Override
    public void changeColor(ColorEvent ce) {
        setText("Red: " + ce.getColor().getRed() + " Green: " + ce.getColor().getGreen() + " Blue: " + ce.getColor().getBlue());
    }
    
}
