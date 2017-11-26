/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;
import java.util.EventListener;

/**
 *
 * @author 00220682
 */
public interface ColorListener extends EventListener {
    public void changeColor(ColorEvent ce);
}
