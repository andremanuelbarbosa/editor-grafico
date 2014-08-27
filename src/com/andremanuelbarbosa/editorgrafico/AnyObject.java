package com.andremanuelbarbosa.editorgrafico;

import java.awt.*;

/** Classe abstracta que representa qualquer objecto
 */
public abstract class AnyObject
{
    /** M�todo que permite a cada objecto se pintar
     * @param g Graphics onde o objecto se vai pintar
     */    
    public abstract void paint(Graphics g);
}