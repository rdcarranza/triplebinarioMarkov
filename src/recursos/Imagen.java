/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author darioc
 */
public class Imagen extends javax.swing.JPanel {
    
    ImageIcon Img;
    
    public Imagen(String dir, int sx, int sy) {
    this.setSize(sx, sy); //se selecciona el tamaño del panel
    Img = new ImageIcon(getClass().getResource(dir));
    }
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
public void paint(Graphics grafico) {
Dimension height = getSize();
 
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
 
//ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/markov1.png")); 
 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}

}

