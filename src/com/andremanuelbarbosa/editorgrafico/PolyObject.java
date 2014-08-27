package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;
import java.util.*;

/** Classe que representa os objectos do tipo poligono
 */
public class PolyObject extends AnyObject
{
    private Polygon poly;
    
    private Color c;
    private boolean flag;
    
    /** Constructor da classe PolyObject
     * @param points LinkedList que cont�m os pontos do poligono
     * @param flag Determina se o poligono � preenchido ou n�o
     * @param c Cor
     */ 
    public PolyObject(LinkedList points,Color c,boolean flag)
    {
        poly = new Polygon();
        
        for (ListIterator listITR = points.listIterator(); listITR.hasNext(); )
        {
            Point p = (Point) listITR.next();
            
            poly.addPoint(p.x,p.y);
        }
        
        this.c = new Color(c.getRed(),c.getGreen(),c.getBlue());
        this.flag = flag;
    }
    
    /** M�todo que permite ao poligono se pintar
     * @param g Graphics onde o poligono vai ser pintado
     */ 
    public void paint(Graphics g)
    {
        g.setColor(c);
        g.setPaintMode();
        
        if(flag)
            g.fillPolygon(poly);
        else
            g.drawPolygon(poly);
    }
}