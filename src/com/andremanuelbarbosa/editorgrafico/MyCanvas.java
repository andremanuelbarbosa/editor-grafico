package com.andremanuelbarbosa.editorgrafico;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/** Classe que gere os eventos sobre a �rea de desenho
 */
public class MyCanvas extends JPanel 
{
    String paintRequest;
    MouseEvent mouseEvent;
    DrawArea drawArea;
    
    private Color c;
    private LinkedList objectos = new LinkedList();
  
    /** Constructor da classe MyCanvas
     * @param d �rea de desenho correspondente
     */    
    public MyCanvas(DrawArea d) 
    {
        drawArea = d;
        c = Color.black;
        paintRequest = null;
        
        drawArea.drawProg.myCanvas = this;
    
        addMouseListener(new java.awt.event.MouseAdapter () 
        {
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
                myCanvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
                myCanvasMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                myCanvasMouseClicked(evt);
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter () 
        {
            public void mouseMoved(java.awt.event.MouseEvent evt) 
            {
                myCanvasMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) 
            {
                myCanvasMouseDragged(evt);
            }
        });
    }
  
    private void myCanvasMousePressed(java.awt.event.MouseEvent evt) 
    {
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            mouseEvent = evt;
            paintRequest = "MousePressed";
            repaint();
        }
    }
  
    private void myCanvasMouseReleased(java.awt.event.MouseEvent evt) 
    {
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            mouseEvent = evt;
            paintRequest = "MouseReleased";
            repaint();
        }
    }
  
    private void myCanvasMouseMoved(java.awt.event.MouseEvent evt) 
    {
        drawArea.drawProg.setXY(evt.getX(),evt.getY());
        mouseEvent = evt;
        paintRequest = "MouseMoved";
        repaint();
    }
  
    private void myCanvasMouseDragged(java.awt.event.MouseEvent evt) 
    {
        drawArea.drawProg.setXY(evt.getX(),evt.getY());
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            mouseEvent = evt;
            paintRequest = "MouseDragged";
            repaint();
        }
    }
    
    private void myCanvasMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            mouseEvent = evt;
            if(evt.getClickCount() == 1 ) paintRequest = "MouseClicked";
            if(evt.getClickCount() == 2) paintRequest = "MouseDoubleClicked";
            repaint();
        }
    }
  
    /** Actualiza a �rea de desenho
     * @param g Graphics onde ir�o ser feitas as altera��es
     */    
    public void update(Graphics g)
    {
        paint(g);
    }
    
    /** Pinta os objectos na �rea de desenho
     * @param g Graphics onde ir�o ser pintados os objectos
     */    
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth()-1, this.getHeight()-1);
        
        for(ListIterator listITR = objectos.listIterator() ; listITR.hasNext() ; )
        {
            ((AnyObject) listITR.next()).paint(g);
        }
        
        g.setColor(c);
        g.setPaintMode();
        
        if(paintRequest == "MousePressed")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mousePressed(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        else if(paintRequest == "MouseReleased")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mouseReleased(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        else if(paintRequest == "MouseDragged")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mouseDragged(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        else if(paintRequest == "MouseDoubleClicked")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mouseDoubleClicked(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        else if(paintRequest == "MouseMoved")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mouseMoved(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        else if(paintRequest == "MouseClicked")
        {
            if (drawArea.drawProg.getToolSelected() != null) drawArea.drawProg.getToolSelected().mouseClicked(g, mouseEvent,objectos,c,drawArea.drawProg.flag);
        }
        
        paintRequest = null;
    }
    
    /** Retorna a cor seleccionada
     * @return Cor seleccionada
     */    
    public Color getColor ()
    {
        return this.c;
    }
    
    /** Muda a cor
     * @param c Nova cor
     */    
    public void changeColor (Color c)
    {
        this.c = c;
    }
    
    /** Limpa a �rea de desenho
     */    
    public void clearObjectos ()
    {
        this.objectos.clear();
    }
}