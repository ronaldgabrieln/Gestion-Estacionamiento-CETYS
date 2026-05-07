package oop.estacionamientogestion;
import java.util.ArrayList;
import java.io.*;
public class administrarSerializacion {

    //Guardar vehiculo dentro de un ArrayList
    public static void guardarObjetos(ArrayList<Vehiculo> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetos.writeObject(lista);
            System.out.println("la lista de Vehiculos fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }
    public static void guardarObjetosVisitas(ArrayList<Visita> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetos.writeObject(lista);
            System.out.println("la lista de Visitas fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }
    //Lee el ArrayList de Vehiculo
    public static ArrayList<Vehiculo> leerObjetos(String nombreArchivo) {
        try (ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            ArrayList<Vehiculo> listaRecuperada = (ArrayList<Vehiculo>) lectorObjetos.readObject();
            System.out.println("La lista de " + listaRecuperada.size() + "vehiculos recuperada de " + nombreArchivo);
            return listaRecuperada;

        } catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("La clase del objeto no fue encontrado: " + e.getMessage());
        }
        return null;
    }
}