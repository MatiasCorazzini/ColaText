package edicion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;


public class Acciones {    
    public String contenido = "", ruta = "";
    File archivo;
    
    public void Seleccionar(){
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION){            
           File archivo = fileChooser.getSelectedFile();
           ruta = archivo.getAbsolutePath();
        }
    }

    public void Leer(){ 
        try{
            FileReader fr = new FileReader(ruta);

            int valor = fr.read();
            while(valor!=-1){
                contenido = contenido + (char)valor;
                valor = fr.read();
            }
           
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
    public void Escribir(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione archivo a guardar");

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            ruta = archivo.getAbsolutePath();
        }
        
        try{
            FileWriter fw = new FileWriter(ruta);
            fw.write(contenido);
            fw.close();	

        }catch(IOException e){
		System.out.println("Error E/S: "+e);
        }
    }
}

