/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;
import java.util.EventObject;
import java.awt.Color;

/**
 *
 * @author 00220682
 */
public class ColorEvent extends EventObject {
    private Color color;
    
    public ColorEvent(Object source, Color color){
        super(source);
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
}
