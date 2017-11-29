/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcolorchooser;

import java.awt.Color;
import static java.lang.Integer.parseInt;
import java.util.Vector;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alex.henkin
 */
public class ColorRGBpanel extends javax.swing.JPanel implements ColorListener, ChangeListener {

    private Vector changeColorListeners; // To register changeColorListeners of this event    
    ColorRGBchangeListener changeRGBlistener; // My object to process changes in RGB fields

    /**
     * Creates new form ColorRGBpanel
     */
    public ColorRGBpanel() {
        initComponents();

        // Set reg expressions for RGB fields to accept values from 0 to 255
        jIntegerFieldRed.setExp("[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]");
        jIntegerFieldGreen.setExp("[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]");
        jIntegerFieldBlue.setExp("[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]");

/*
        // Register to listen to changes in RGB fields using my ColorRGBchangeListener
        // See comments on use of external listener class in ColorRGBchangeListener
        changeRGBlistener = new ColorRGBchangeListener();

        jIntegerFieldRed.getDocument().addDocumentListener(changeRGBlistener);
        jIntegerFieldGreen.getDocument().addDocumentListener(changeRGBlistener);
        jIntegerFieldBlue.getDocument().addDocumentListener(changeRGBlistener);
*/        
        // Register to listen to changes in RGB fields using anonymous listener
        jIntegerFieldRed.getDocument().addDocumentListener(new DocumentListener (){

            @Override
            public void insertUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this)); // Don't really care what Change Event it is
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this)); 
            }
        });        
        
        jIntegerFieldGreen.getDocument().addDocumentListener(new DocumentListener (){

            @Override
            public void insertUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }
        });

        jIntegerFieldBlue.getDocument().addDocumentListener(new DocumentListener (){

            @Override
            public void insertUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                stateChanged(new ChangeEvent(this));
            }
        });

        // Vector for storing external components registering for event from RGB panel
        changeColorListeners = new Vector();

    }
    
    // Methods to manage event subscription
    public void addColorListener(ColorListener colorListener){
        changeColorListeners.addElement(colorListener);
    }
    
    public void removeColorListener(ColorListener colorListener){
        changeColorListeners.removeElement(colorListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRed = new javax.swing.JLabel();
        jIntegerFieldRed = new regexfields.JIntegerField();
        jLabelGreen = new javax.swing.JLabel();
        jIntegerFieldGreen = new regexfields.JIntegerField();
        jLabelBlue = new javax.swing.JLabel();
        jIntegerFieldBlue = new regexfields.JIntegerField();

        setPreferredSize(new java.awt.Dimension(120, 156));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.GridLayout(3, 2, 5, 25));

        jLabelRed.setText("RED");
        add(jLabelRed);
        add(jIntegerFieldRed);

        jLabelGreen.setText("GREEN");
        add(jLabelGreen);
        add(jIntegerFieldGreen);

        jLabelBlue.setText("BLUE");
        add(jLabelBlue);
        add(jIntegerFieldBlue);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private regexfields.JIntegerField jIntegerFieldBlue;
    private regexfields.JIntegerField jIntegerFieldGreen;
    private regexfields.JIntegerField jIntegerFieldRed;
    private javax.swing.JLabel jLabelBlue;
    private javax.swing.JLabel jLabelGreen;
    private javax.swing.JLabel jLabelRed;
    // End of variables declaration//GEN-END:variables

    @Override
    // Implementation of ColorListener interface
    public void changeColor(ColorEvent ce) {
        // Get color associated with ColorEvent
        Color newColor = ce.getColor();

        // Get event Color RGB components
        Integer red = newColor.getRed();
        Integer green = newColor.getGreen();
        Integer blue = newColor.getBlue();
        // Set each of the fields to appropriate R, G, or B value
        updateRGB(red, green, blue);
    }


    
//    private void updateRGB (final Integer red, final Integer green, final Integer blue){ // final was in the example, but does not help
    private void updateRGB (Integer red, Integer green, Integer blue){
        SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                jIntegerFieldRed.setText(red.toString());        
                jIntegerFieldGreen.setText(green.toString());        
                jIntegerFieldBlue.setText(blue.toString());       
            }
        });
    }

    @Override
    // Implementation of ChangeListener interface
    public void stateChanged(ChangeEvent ce) {
        int r, g, b;
        try {
            r = parseInt(jIntegerFieldRed.getText());
        }
        catch (NumberFormatException ex){
            r = 0;
        }
        try {
            g = parseInt(jIntegerFieldGreen.getText());
        } 
        catch (NumberFormatException ex){
            g = 0;
        }
        try {
            b = parseInt(jIntegerFieldBlue.getText());
        }
        catch (NumberFormatException ex){
            b = 0;
        }    
    
        Color color = new Color(r,g,b);
        fireColorEvent(new ColorEvent(this,color));
    }
    
    private void fireColorEvent(ColorEvent ce){
        Vector v;
        synchronized(changeColorListeners){
            v = (Vector)changeColorListeners.clone();
        }
        int size = v.size();
        for(int i=0; i<size; i++){
            ColorListener colorListener = (ColorListener)v.elementAt(i);
            colorListener.changeColor(ce);
        }
    }
}
