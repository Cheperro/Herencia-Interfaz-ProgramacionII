
package models;

import java.io.Serializable;


public class Alumno extends Persona implements Serializable{ //Aplicamos herencia e implementamos Serializable para que se muestre en la tabla
    String direccion;
    String telefono;

    public Alumno() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
