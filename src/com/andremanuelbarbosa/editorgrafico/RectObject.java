package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;

/** Classe que representa os objectos do tipo rectangulo
 */
public class RectObject extends AnyObject
{
    private Rectangle rect;
    
    private Color c;
    private boolean flag;
    
    /** Constructor da classe RectObject
     * @param initialPoint Ponto inicial
     * @param finalPoint Ponto final
     * @param flag Determina se o rectangulo � preenchido ou n�o
     * @param c Cor
     */ 
    public RectObject(Point initialPoint,Point finalPoint,Color c,boolean flag)
    {
        int aux;
        
        if (initialPoint.x > finalPoint.x)
        {
            aux = initialPoint.x;
            initialPoint.x = finalPoint.x;
            finalPoint.x = aux;
        }
        if (initialPoint.y > finalPoint.y)
        {
            aux = initialPoint.y;
            initialPoint.y = finalPoint.y;
            finalPoint.y = aux;
        }
        rect = new Rectangle(initialPoint.x,initialPoint.y,(int) (Math.abs(initialPoint.x - finalPoint.x)),(int) (Math.abs(initialPoint.y - finalPoint.y)));
        
        this.c = new Color(c.getRed(),c.getGreen(),c.getBlue());
        this.flag = flag;
    }
    
    /** M�todo que permite ao rectangulo se pintar
     * @param g Graphics onde o rectangulo vai ser pintado
     */ 
    public void paint(Graphics g)
    {
        g.setColor(c);
        g.setPaintMode();
        
        if(flag)
            g.fillRect(rect.x,rect.y,rect.width,rect.height);
        else
            g.drawRect(rect.x,rect.y,rect.width,rect.height);
    }
}
