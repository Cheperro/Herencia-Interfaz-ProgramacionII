/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Alumno;

/**
 *
 * @author chepe
 */
public class archivoAlumno {
    private Alumno datos;
    private ArrayList<Alumno> lista;
    private final String Nombre_Archivo = "Alumnos.dan";

    
    public archivoAlumno(){
        datos = new Alumno();
        lista = new ArrayList();
    }
    
    public void iniciar(){
        File fichero = new File(Nombre_Archivo);
        
        if(fichero.exists()){
            LeerArchivo();
        }
    }
    
    
    
     //metodo para guardar La Lista 
    public void GuardarArchivo() {
        File fichero = new File(Nombre_Archivo);
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        try{
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            
            oos.close();
        
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        
        }catch(IOException e){
        }
    }
    
    //metodo para ingresar Datos
        public void IngresarDatos(String codigo, String nombres, String apellidos, String genero, String direccion, String telefono){
        datos = new Alumno();
        datos.setCodigo(codigo);
        datos.setNombres(nombres);
        datos.setApellidos(apellidos);
        datos.setGenero(genero);
        datos.setDireccion(direccion);
        datos.setTelefono(telefono);
    }
    
     public void Nuevodato(String codigo, String nombres, String apellidos, String genero, String direccion, String telefono){
         IngresarDatos(codigo, nombres, apellidos, genero, direccion, telefono);//llamamos el metodo de ingresar
        lista.add(datos);//agregamos una nueva lista
        GuardarArchivo();//guardamos en el archivo
    }
    
    //metodo que leera la lista
    public void LeerArchivo(){
        FileInputStream fis;
        ObjectInputStream ois;
        lista = new ArrayList();
        
        try{
            fis = new FileInputStream(Nombre_Archivo);
            ois = new ObjectInputStream(fis);
            lista = (ArrayList<Alumno>) ois.readObject();
            
        }catch(FileNotFoundException e){
            
        }
        catch(IOException e){
            
        } catch (ClassNotFoundException ex) {   
        }
    }
    
    
     public  ArrayList<Alumno> MiListaAlumnos(){
       FileInputStream fis;
        ObjectInputStream ois;
        lista = new ArrayList();
        
        try{
            fis = new FileInputStream(Nombre_Archivo);
            ois = new ObjectInputStream(fis);
            lista = (ArrayList<Alumno>) ois.readObject();
            
        }catch(FileNotFoundException e){    
        }
        
        catch(IOException e){    
        }
        
        catch(ClassNotFoundException ex){
        }
        
        return lista;
    }
     
}
