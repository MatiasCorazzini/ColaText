package edicion;

import java.awt.*;
import javax.swing.JOptionPane;


public class Editor_Fuente {
    
    public int tamaño = 14, tipo;
    public String nombreFuente;
    public Font fuente;
    
    public void cambiarTamaño(){
        try{
            String input = JOptionPane.showInputDialog("Ingrese el tamaño de la fuente");
            tamaño = Integer.parseInt(input);
            fuente = new Font(nombreFuente, tipo, tamaño);
        } catch(Exception e){System.out.println("Error:" + e);}
    }
    
    public void setFuente(){
        fuente = new Font(nombreFuente, tipo, tamaño);
    }
}
