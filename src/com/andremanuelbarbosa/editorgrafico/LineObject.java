package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;

/** Classe que representa os objectos do tipo linha
 */
public class LineObject extends AnyObject
{
    private Point initialPoint;
    private Point finalPoint;
    private Color c;
    
    /** Constructor da classe LineObject
     * @param initialPoint Ponto inicial
     * @param finalPoint Ponto final
     * @param c Cor
     */    
    public LineObject(Point initialPoint,Point finalPoint,Color c)
    {
        this.initialPoint = initialPoint;
        this.finalPoint = finalPoint;
        this.c = new Color(c.getRed(),c.getGreen(),c.getBlue());
    }
    
    /** M�todo que permite � linha se pintar
     * @param g Graphics onde a linha vai ser pintada
     */    
    public void paint(Graphics g)
    {
        g.setColor(c);
        g.setPaintMode();
        g.drawLine(initialPoint.x,initialPoint.y,finalPoint.x,finalPoint.y);
    }
}