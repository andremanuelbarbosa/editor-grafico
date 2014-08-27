package com.andremanuelbarbosa.editorgrafico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

/** Classe que representa as ferramentas que operam sobre a linha
 */
public class LineTool implements AnyTool 
{
    int x0, y0, x1, y1;
    
    /** Constructor da classe LineTool
     */    
    public LineTool()
    {
        x0 = y0 = x1 = y1 = 0;
    }
    
    /** Indica � classe que o rato foi pressionado e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */    
    public void mousePressed(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        x0 = x1 = evt.getX();
        y0 = y1 = evt.getY();
        
        g.drawLine(x0, y0, x1, y1);
    }
    
    /** Indica � classe que o rato foi duplamente clicado e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */  
    public void mouseDoubleClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi arrastado e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */  
    public void mouseDragged(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) {
        x1 = evt.getX();
        y1 = evt.getY();
        
        g.drawLine(x0, y0, x1, y1);
    }
    
    /** Indica � classe que o rato foi movido e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */  
    public void mouseMoved(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi largado e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */  
    public void mouseReleased(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        AnyObject ref = new LineObject(new Point(x0,y0),new Point(x1,y1),c);
        allObjects.addLast(ref);
        ref.paint(g);
        
        resetTool();
    }
       
    /** Indica � classe que o rato foi clicado e opera sobre a linha
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a linha
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da linha
     * @param flag Determina se a linha � preenchida ou n�o
     */  
    public void mouseClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Termina as opera��es sobre a linha e esta desaparece
     */    
    public void resetTool() 
    {
        x0 = y0 = x1 = y1 = 0;
    }
}