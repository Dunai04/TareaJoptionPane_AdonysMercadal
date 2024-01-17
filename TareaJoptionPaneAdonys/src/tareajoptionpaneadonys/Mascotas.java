/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareajoptionpaneadonys;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author adony
 */
public class Mascotas {
    String nombre;
    String tipo;
    Color colors;
    int anos;
    Date fechaDeNacimiento;
    double precio;

    public Mascotas(String nombre, String tipo, Color colors, int anos, Date fechaDeNacimiento, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.colors = colors;
        this.anos = anos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.precio = precio;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Color getColors() {
        return colors;
    }

    public void setColors(Color colors) {
        this.colors = colors;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
