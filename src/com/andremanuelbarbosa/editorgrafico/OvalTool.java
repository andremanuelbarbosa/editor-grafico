package com.andremanuelbarbosa.editorgrafico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

/** Classe que representa as ferramentas que operam sobre a oval
    */
public class OvalTool implements AnyTool
{
    int x0, y0, x1, y1;
    
    /** Constructor da classe OvalTool
     */ 
    public OvalTool()
    {
        x0 = y0 = x1 = y1 = 0;
    }
    
    /** Indica � classe que o rato foi pressionado e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */ 
    public void mousePressed(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        x0 = x1 = evt.getX();
        y0 = y1 = evt.getY();
    }
    
    /** Indica � classe que o rato foi duplamente clicado e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */ 
    public void mouseDoubleClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi arrastado e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */ 
    public void mouseDragged(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        x1 = evt.getX();
        y1 = evt.getY();
        
        if(x1 >= x0 && y1 >= y0)
            g.drawOval(x0,y0,x1 - x0,y1 - y0);
        else if(x1 < x0 && y1 < y0)
            g.drawOval(x1,y1,x0 - x1,y0 - y1);
        else if(x1 > x0 && y1 < y0)
            g.drawOval(x0,y1,x1 - x0,y0 - y1);
        else
            g.drawOval(x1,y0,x0 - x1,y1 - y0);
    }
    
    /** Indica � classe que o rato foi movido e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */
    public void mouseMoved(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Indica � classe que o rato foi largado e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */
    public void mouseReleased(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        AnyObject anyObject;
        
        if(x1 >= x0 && y1 >= y0)
            anyObject = new OvalObject(new Point(x0,y0),x1 - x0,y1 - y0,c,flag);
        else if(x1 < x0 && y1 < y0)
            anyObject = new OvalObject(new Point(x1,y1),x0 - x1,y0 - y1,c,flag);
        else if(x1 > x0 && y1 < y0)
            anyObject = new OvalObject(new Point(x0,y1),x1 - x0,y0 - y1,c,flag);
        else
            anyObject = new OvalObject(new Point(x1,y0),x0 - x1,y1 - y0,c,flag);
        
        allObjects.addLast(anyObject);
        anyObject.paint(g);
        
        resetTool();
    }
    
    /** Indica � classe que o rato foi clicado e opera sobre a oval
     * @param g Graphics onde as ferramentas ir�o operar operar sobre a oval
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor da oval
     * @param flag Determina se a oval � preenchida ou n�o
     */
    public void mouseClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        
    }
    
    /** Termina as opera��es sobre a oval e esta desaparece
     */
    public void resetTool() 
    {
        x0 = y0 = x1 = y1 = 0;
    }    
}