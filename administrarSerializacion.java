package oop.estacionamientogestion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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

    //Guardar visitas dentro de un ArrayList
    public static void guardarObjetosVisita(ArrayList<Visita> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetosVisita = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetosVisita.writeObject(lista);
            System.out.println("la lista de Visitas fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //Lee el ArrayList de visita/historial
    public static ArrayList<Visita> leerObjetosVisita(String nombreArchivo) {
        try (ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            ArrayList<Visita> listaRecuperadaVisita = (ArrayList<Visita>) lectorObjetos.readObject();
            System.out.println("El historial con " + listaRecuperadaVisita.size() + " vehculos fue recuperada en " + nombreArchivo);
            return listaRecuperadaVisita;

        } catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("La clase del objeto no fue encontrado: " + e.getMessage());
        }
        return null;
    }





}