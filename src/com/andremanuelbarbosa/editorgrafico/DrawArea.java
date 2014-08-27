package com.andremanuelbarbosa.editorgrafico;

import java.awt.Dimension;
import javax.swing.*;

/** Classe que representa a �rea de desenho
 */
public class DrawArea extends javax.swing.JInternalFrame 
{  
    static final int desktopWidth = 500;
    static final int desktopHeight = 400;
    static final int desktopMargin = 10;

    DrawProg drawProg;
    MyCanvas myCanvas;

    /** Creates new form DrawArea
     * @param source DrawProg correspondente
     */
    public DrawArea(DrawProg source) 
    {
        initComponents();   
        drawProg = source;
        setDrawAreaSize();
        pack();
        myCanvas = new MyCanvas(this);
        getContentPane().add(myCanvas);
    }

    /** Retorna a margem da �rea de desenho
     * @return Margem da �rea de desenho
     */    
    public int getMargin()
    {
        return(desktopMargin);
    }

    private void setDrawAreaSize()
    {
        setPreferredSize(new Dimension(desktopWidth, desktopHeight));
        setSize(new Dimension(desktopWidth, desktopHeight));
        setLocation(desktopMargin, desktopMargin);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        pack();
    }//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}