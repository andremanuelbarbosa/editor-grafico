package com.andremanuelbarbosa.editorgrafico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

/** Classe que representa as ferramentas que operam sobre o rectangulo
 */
public class RectTool implements AnyTool
{
    int x0, y0, x1, y1;
    
    /** Constructor da classe RectTool
     */
    public RectTool()
    {
        x0 = y0 = x1 = y1 = 0;
    }
    
    /** Indica � classe que o rato foi pressionado e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */
    public void mousePressed(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        x0 = x1 = evt.getX();
        y0 = y1 = evt.getY();
        g.drawLine(x0, y0, x1, y0);
        g.drawLine(x0, y0, x0, y1);
        g.drawLine(x1, y0, x1, y1);
        g.drawLine(x0, y1, x1, y1);
    }
    
    /** Indica � classe que o rato foi duplamente clicado e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */ 
    public void mouseDoubleClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi arrastado e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */
    public void mouseDragged(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        x1 = evt.getX();
        y1 = evt.getY();
        g.drawLine(x0, y0, x1, y0);
        g.drawLine(x0, y0, x0, y1);
        g.drawLine(x1, y0, x1, y1);
        g.drawLine(x0, y1, x1, y1);
    }
    
    /** Indica � classe que o rato foi movido e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */
    public void mouseMoved(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi largado e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */ 
    public void mouseReleased(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        AnyObject ref = new RectObject(new Point(x0,y0),new Point(x1,y1),c,flag);
        allObjects.addLast(ref);
        ref.paint(g);
        
        resetTool();
    }
    
    /** Indica � classe que o rato foi clicado e opera sobre o rectangulo
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o rectangulo
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do rectangulo
     * @param flag Determina se o rectangulo � preenchida ou n�o
     */
    public void mouseClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Termina as opera��es sobre o rectangulo e este desaparece
     */ 
    public void resetTool() 
    {
        x0 = y0 = x1 = y1 = 0;
    }
}
