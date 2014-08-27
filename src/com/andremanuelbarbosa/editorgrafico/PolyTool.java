package com.andremanuelbarbosa.editorgrafico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

/** Classe que representa as ferramentas que operam sobre o poligono
 */
public class PolyTool implements AnyTool 
{
    LinkedList points = new LinkedList();
    Point initialPoint, finalPoint;
    int pressed = 0;
    
    /** Constructor da classe PolyTool
     */   
    public PolyTool()
    {
        initialPoint = new Point (0,0);
        finalPoint = new Point (0,0);
    }
    
    /** Indica � classe que o rato foi pressionado e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */
    public void mousePressed(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        if (pressed != 0)
        {
            points.addLast (new Point(initialPoint));
            points.addLast (new Point(finalPoint));
            
            for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
            {
                Point initialPointAux = (Point) listITR.next();
                Point finalPointAux = (Point) listITR.next();
                g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
            }
        }
        initialPoint.x = finalPoint.x = evt.getX();
        initialPoint.y = finalPoint.y = evt.getY();
        g.drawLine(initialPoint.x, initialPoint.y, finalPoint.x, finalPoint.y);
        pressed = 1;
    }
    
    /** Indica � classe que o rato foi duplamente clicado e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */ 
    public void mouseDoubleClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        if (points.size() == 4)
        {
            resetTool();
            for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
            {
                Point initialPointAux = (Point) listITR.next();
                Point finalPointAux = (Point) listITR.next();
                g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
            }
        }
        else
        {
            initialPoint.x = evt.getX();
            initialPoint.y = evt.getY();
            finalPoint = (Point) points.get(0);
            g.drawLine(initialPoint.x, initialPoint.y, finalPoint.x, finalPoint.y);
            points.addLast (new Point(initialPoint));
            points.addLast (new Point(finalPoint));
            
            AnyObject ref = new PolyObject(points,c,flag);
            allObjects.addLast(ref);
            ref.paint(g);
            
            resetTool();
        }
    }
    
    /** Indica � classe que o rato foi arrastado e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */
    public void mouseDragged(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        if (pressed != 0)
        {
            for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
            {
                Point initialPointAux = (Point) listITR.next();
                Point finalPointAux = (Point) listITR.next();
                g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
            }
            finalPoint.x = evt.getX();
            finalPoint.y = evt.getY();
            g.drawLine(initialPoint.x, initialPoint.y, finalPoint.x, finalPoint.y);
        }
    }
    
    /** Indica � classe que o rato foi movido e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */
    public void mouseMoved(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        if (pressed != 0)
        {
            for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
            {
                Point initialPointAux = (Point) listITR.next();
                Point finalPointAux = (Point) listITR.next();
                g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
            }
            finalPoint.x = evt.getX();
            finalPoint.y = evt.getY();
            g.drawLine(initialPoint.x, initialPoint.y, finalPoint.x, finalPoint.y);
        }
    }
    
    /** Indica � classe que o rato foi largado e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */ 
    public void mouseReleased(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        points.addLast (new Point(initialPoint));
        points.addLast (new Point(finalPoint));

        initialPoint.x = evt.getX();
        initialPoint.y = evt.getY();

        for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
        {
            Point initialPointAux = (Point) listITR.next();
            Point finalPointAux = (Point) listITR.next();
            g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
        }
    }

    /** Indica � classe que o rato foi clicado e opera sobre o poligono
     * @param g Graphics onde as ferramentas ir�o operar operar sobre o poligono
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList com todos os objectos j� criados
     * @param c Cor do poligono
     * @param flag Determina se o poligono � preenchida ou n�o
     */ 
    public void mouseClicked(Graphics g, java.awt.event.MouseEvent evt, LinkedList allObjects, Color c, boolean flag) 
    {
        for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
        {
            Point initialPointAux = (Point) listITR.next();
            Point finalPointAux = (Point) listITR.next();
            g.drawLine(initialPointAux.x, initialPointAux.y, finalPointAux.x, finalPointAux.y);
        }
    }
    
    /** Termina as opera��es sobre o poligono e este desaparece
     */ 
    public void resetTool() 
    {
        points.clear();
        
        initialPoint = new Point (0,0);
        finalPoint = new Point (0,0);
        
        pressed = 0;
    }
}