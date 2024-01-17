/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareajoptionpaneadonys;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author adony
 */
public class TareaJoptionPaneAdonys {

    public static Calendar calendar = new GregorianCalendar();
    public static ArrayList<Mascotas> inventario = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entrar = 1;
        int opcion = 0;
        String op;
        while (entrar == 1) {
            op = JOptionPane.showInputDialog("Inventario de Mascotas:\n"
                    + "1.Agregar Mascota\n"
                    + "2.Listar\n"
                    + "3.Modificar\n"
                    + "4.Eliminar\n"
                    + "5.Mascotas mas antigua\n"
                    + "6.Mascotas negras\n"
                    + "7.Diferencia de edades\n"
                    + "8.Salir");
            if (op == null) {
                JOptionPane.showMessageDialog(null, "Usuario cancelo el programa");
                entrar += 1;
                break;
            }
            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1:
                    agregarMascotas(inventario);
                    break;
                case 2:
                    String mascotas = "";
                    for (int i = 0; i < inventario.size(); i++) {
                        mascotas += "Nombre: " + inventario.get(i).getNombre() + "\n";
                        mascotas += "Tipo: " + inventario.get(i).getTipo() + "\n";
                        mascotas += "Color: " + inventario.get(i).getColors() + "\n";
                        mascotas += "Fecha de nacimiento: " + inventario.get(i).getFechaDeNacimiento() + "\n";
                        mascotas += "Precio: Lps." + inventario.get(i).getPrecio() + "\n\n";
                    }
                    JOptionPane.showMessageDialog(null, "Lista de mascotas\n"
                            + mascotas);
                    break;
                case 3:
                    modificaranimal();
                    break;
                case 4:
                    eliminarMascota();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    compararAnos();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Cerro el programa");
                    entrar += 1;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
                    break;
            }
        }
    }

    public static void agregarMascotas(ArrayList<Mascotas> inventario) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de la mascota:");
        Color color = JColorChooser.showDialog(null, "Seleccione el color de la mascota", Color.WHITE);
        String diastr = JOptionPane.showInputDialog(null, "Ingrese el dia que nacio la mascota");
        int dia = Integer.parseInt(diastr);
        String messtr = JOptionPane.showInputDialog(null, "Ingrese el mes que nacio la mascota");
        int mes = Integer.parseInt(messtr);
        String anostr = JOptionPane.showInputDialog(null, "Ingrese el año que nacio la mascota");
        int ano = Integer.parseInt(anostr);
        int anos = Integer.parseInt(anostr);
        armarFecha(dia, mes, ano);
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la mascota:"));
        Date fechaNacimiento = obtenerDate();
        Mascotas nuevaMascota = new Mascotas(nombre, tipo, color,anos, fechaNacimiento, precio);
        inventario.add(nuevaMascota);
        JOptionPane.showMessageDialog(null, "Mascota agregada exitosamente.");
    }

    public static void armarFecha(int dia, int mes, int ano) {
        calendar.set(ano, mes - 1, dia);
    }

    public static Date obtenerDate() {
        return calendar.getTime();
    }

    public static void modificaranimal() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nada registrado");
            return;
        }

        String mascotaSeleccionada = JOptionPane.showInputDialog(null, "Ingresar el nombre de mascota que quiera modificar");
        int indiceMascota = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equalsIgnoreCase(mascotaSeleccionada)) {
                indiceMascota = i;
                break;
            }
        }

        if (indiceMascota == -1) {
            JOptionPane.showMessageDialog(null, "No esta la mascota registrada aun");
            return;
        }
        Mascotas mascota = inventario.get(indiceMascota);
        String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la mascota:", mascota.getNombre());
        String nuevoTipo = JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de la mascota:", mascota.getTipo());
        Color nuevoColor = JColorChooser.showDialog(null, "Seleccione el nuevo color de la mascota", mascota.getColors());
        String nuevoDia = JOptionPane.showInputDialog(null, "Ingrese el nuevo dia que nacio la mascota");
        int dia = Integer.parseInt(nuevoDia);
        String nuevoMes = JOptionPane.showInputDialog(null, "Ingrese el nuevo mes que nacio la mascota");
        int mes = Integer.parseInt(nuevoMes);
        String nuevoAno = JOptionPane.showInputDialog(null, "Ingrese el nuevo año que nacio la mascota");
        int ano = Integer.parseInt(nuevoAno);
        int anos = Integer.parseInt(nuevoAno);
        armarFecha(dia, mes, ano);
        Date nuevafechaNacimiento = obtenerDate();
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo precio de la mascota:", mascota.getPrecio()));
        mascota.setNombre(nuevoNombre);
        mascota.setTipo(nuevoTipo);
        mascota.setColors(nuevoColor);
        mascota.setAnos(anos);
        mascota.setFechaDeNacimiento(nuevafechaNacimiento);
        mascota.setPrecio(nuevoPrecio);
        JOptionPane.showMessageDialog(null, "Mascota actualizada exitosamente.");
    }

    public static void eliminarMascota() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nada registrado");
            return;
        }

        String mascotaSeleccionada = JOptionPane.showInputDialog(null, "Ingresar el nombre de mascota que quiera modificar");
        int indiceMascota = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equalsIgnoreCase(mascotaSeleccionada)) {
                indiceMascota = i;
                break;
            }
        }

        if (indiceMascota == -1) {
            JOptionPane.showMessageDialog(null, "No esta la mascota registrada aun");
            return;
        }
        inventario.remove(indiceMascota);
        JOptionPane.showMessageDialog(null, "La mascota fue eliminada");
    }
    public static void compararAnos(){
        if (inventario.size() <=1) {
            JOptionPane.showMessageDialog(null, "No hay suficientes mascotas registradas");
            return;
        }

        String mascotaSeleccionada = JOptionPane.showInputDialog(null, "Ingresar el nombre de la primera mascota que quiera comparar de edad");
        int indiceMascota1 = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equalsIgnoreCase(mascotaSeleccionada)) {
                indiceMascota1 = i;
                break;
            }
        }

        if (indiceMascota1 == -1) {
            JOptionPane.showMessageDialog(null, "No esta la mascota registrada aun");
            return;
        }
        String mascotaSeleccionada2 = JOptionPane.showInputDialog(null, "Ingresar el nombre de la segunda mascota que quiera comparar de edad");
         int indiceMascota2 = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equalsIgnoreCase(mascotaSeleccionada2)) {
                indiceMascota2 = i;
                break;
            }
        }

        if (indiceMascota2 == -1) {
            JOptionPane.showMessageDialog(null, "No esta la mascota registrada aun");
            return;
        }
      Mascotas mascota1 = inventario.get(indiceMascota1);
      Mascotas mascota2 = inventario.get(indiceMascota2);
      int anos1 = mascota1.getAnos();
      int anos2 = mascota2.getAnos();
      int diferencia = anos1 - anos2;
      if (diferencia<0){
          diferencia = diferencia* -1;
      }
      JOptionPane.showMessageDialog(null, "La diferencia de años es "+diferencia);
    }
}
