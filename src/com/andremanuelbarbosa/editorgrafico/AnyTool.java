package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;
import java.util.*;

/** Classe interface de cada ferramenta
 */
public interface AnyTool 
{
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � presionado
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mousePressed(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � arrastado
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mouseDragged(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � movido
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mouseMoved(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � duplamente clicado
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mouseDoubleClicked(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � largado
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mouseReleased(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    /** Executa as diferentas opera��es, de acordo com o objecto seleccionado, quando o rato � clicado
     * @param g Graphics onde v�o ser executadas as opera��es
     * @param evt Evento que originou a chamada do m�todo
     * @param allObjects LinkedList que cont�m todos os objectos j� criados
     * @param c Cor do objecto
     * @param flag Determina se o objecto est� preenchido ou n�o
     */    
    public void mouseClicked(Graphics g, java.awt.event.MouseEvent evt,LinkedList allObjects,Color c,boolean flag);
    
    /** Para de executar as ferramentas sobre o objecto
     */    
    public void resetTool();
}