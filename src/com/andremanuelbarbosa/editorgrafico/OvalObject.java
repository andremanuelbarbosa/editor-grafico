package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;

/** Classe que representa os objectos do tipo oval
 */
public class OvalObject extends AnyObject
{
    private Point initialPoint;
    
    private int width;
    private int height;
    
    private Color c;
    private boolean flag;
    
    /** Constructor da classe OvalObject
     * @param initialPoint Ponto inicial
     * @param width Comprimento da oval
     * @param height Largura da oval
     * @param flag Determina se a oval � preenchida ou n�o
     * @param c Cor
     */ 
    public OvalObject(Point initialPoint,int width,int height,Color c,boolean flag)
    {
        this.initialPoint = initialPoint;
        
        this.width = width;
        this.height = height;
        
        this.c = new Color(c.getRed(),c.getGreen(),c.getBlue());
        this.flag = flag;
    }
    
    /** M�todo que permite � oval se pintar
     * @param g Graphics onde a oval vai ser pintada
     */ 
    public void paint(Graphics g) 
    {
        g.setColor(c);
        g.setPaintMode();
        if (flag)
            g.fillOval(initialPoint.x, initialPoint.y,width,height);
        else    
            g.drawOval(initialPoint.x, initialPoint.y,width,height);
    }
}