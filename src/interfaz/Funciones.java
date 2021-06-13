package interfaz;

import edicion.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Funciones extends JFrame implements ActionListener {
    
    private JMenuBar mb;
    private JMenu archivo, editar , iCFuente, iTipo, iFuente;
    private JMenuItem iAbrir, iNuevo, iGuardar, iTamaño;
    private JMenuItem tpBold, tpItalic, tpNormal;
    private JMenuItem fArial, fTimesNewRoman, fCalibri, fBookmanOldStyle;
    public JTextArea area;
    private JScrollPane scrollArea;
    
    Acciones mensajero_Acciones = new Acciones();
    Editor_Fuente mensajero_Fuente = new Editor_Fuente();
    
    public void abrirArchivo(){
        mensajero_Acciones.contenido = "";
        area.setText(mensajero_Acciones.contenido);
        mensajero_Acciones.Seleccionar();
        mensajero_Acciones.Leer();
        Imprimir();
    }
    
    public void nuevoArchivo(){
        mensajero_Acciones.ruta = "";
        mensajero_Acciones.contenido = "";
        area.setText(mensajero_Acciones.contenido);
    }
    
    public void guardarArchivo(){
        Leer();
        mensajero_Acciones.Escribir();
    }
    
    public void Imprimir(){
        area.setText(mensajero_Acciones.contenido);
    }
    
    public void Leer(){
        mensajero_Acciones.contenido = area.getText();
    }
    
    public Funciones(){
        setLayout(new java.awt.BorderLayout());
        setTitle("ColaText");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Objeto MenuBar
        mb = new JMenuBar();
        setJMenuBar(mb);

        //Objetos Menus
        archivo = new JMenu("Archivo");
        mb.add(archivo);        
        editar = new JMenu("Editar");
        mb.add(editar);

        //Items "Archivo"
        iAbrir = new JMenuItem("Abrir");
        archivo.add(iAbrir);
        iAbrir.addActionListener(this);
        iNuevo = new JMenuItem("Nuevo");
        archivo.add(iNuevo);
        iNuevo.addActionListener(this);
        iGuardar = new JMenuItem("Guardar");
        archivo.add(iGuardar);
        iGuardar.addActionListener(this);
        
        //Items "Editar"
        iCFuente = new JMenu("Cambiar fuente");
        editar.add(iCFuente);
        iCFuente.addActionListener(this);
        
        //Items "Cambiar fuente"
        iTamaño = new JMenuItem("Tamaño");
        iCFuente.add(iTamaño);
        iTamaño.addActionListener(this);
        iTipo = new JMenu("Estilo");
        iCFuente.add(iTipo);
        iTipo.addActionListener(this);
        
        //Items "Estilo"
        tpBold = new JMenuItem("Negrita");
        iTipo.add(tpBold);
        tpBold.addActionListener(this);
        tpItalic = new JMenuItem("Italica");
        iTipo.add(tpItalic);
        tpItalic.addActionListener(this);
        tpNormal = new JMenuItem("Normal");
        iTipo.add(tpNormal);
        tpNormal.addActionListener(this);
        
        //Items "Funtes"
        iFuente = new JMenu("Fuentes");
        iCFuente.add(iFuente);
        
        fArial = new JMenuItem("Arial");
        fArial.setFont(new Font("Arial", 0, 14));
        iFuente.add(fArial);
        fArial.addActionListener(this);
        fCalibri = new JMenuItem("Calibri");
        fCalibri.setFont(new Font("Calibri", 0, 14));
        iFuente.add(fCalibri);
        fCalibri.addActionListener(this);
        fTimesNewRoman = new JMenuItem("Times New Roman");
        fTimesNewRoman.setFont(new Font("Times New Roman", 0, 14));
        iFuente.add(fTimesNewRoman);
        fTimesNewRoman.addActionListener(this);
        fBookmanOldStyle = new JMenuItem("Bookman Old Style");
        fBookmanOldStyle.setFont(new Font("Bookman Old Style", 0, 14));
        iFuente.add(fBookmanOldStyle);
        fBookmanOldStyle.addActionListener(this);
        
        //Scrollpane
        scrollArea = new JScrollPane();
        area = new JTextArea();
        scrollArea.setViewportView(area);
        add(scrollArea, java.awt.BorderLayout.CENTER);
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == iAbrir){
            abrirArchivo();
        }
        if(event.getSource() == iNuevo){
            nuevoArchivo();
        }
        if(event.getSource() == iGuardar){
            guardarArchivo();
        }
        
        if(event.getSource() == iTamaño){
            mensajero_Fuente.cambiarTamaño();
            area.setFont(mensajero_Fuente.fuente);
            
        }
        if(event.getSource() == tpBold){
            mensajero_Fuente.tipo = 1;
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
            
        }
        if(event.getSource() == tpItalic){
            mensajero_Fuente.tipo = 2;
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
            
        }
        if(event.getSource() == tpNormal){
            mensajero_Fuente.tipo = 0;
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
        }
        if(event.getSource() == fArial){
            mensajero_Fuente.nombreFuente = "Arial";
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
        }
        if(event.getSource() == fCalibri){
            mensajero_Fuente.nombreFuente = "Calibri";
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
        }
        if(event.getSource() == fTimesNewRoman){
            mensajero_Fuente.nombreFuente = "Times New Roman";
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
        }
        if(event.getSource() == fBookmanOldStyle){
            mensajero_Fuente.nombreFuente = "Bookman OldStyle";
            mensajero_Fuente.setFuente();
            area.setFont(mensajero_Fuente.fuente);
        }
    }
    public static void main(String args[]) {
        Funciones ventana = new Funciones();
        ventana.setBounds(0,0,490,545);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }   
}