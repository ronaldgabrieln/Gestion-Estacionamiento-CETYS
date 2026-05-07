import java.util.ArrayList;
import java.io.*;
public class administrarSerializacion {

    //Guardar vehiculo dentro de un ArrayList
    public static void guardarObjetosVehiculo(ArrayList</* clase vehiculo */> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetos.writeObject(lista);
            System.out.println("la lista de Vehiculos fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //Lee el ArrayList de Vehiculo
    public static Arraylist</* clase vehiculo */> leerObjetosVehiculo(String nombreArchivo) {
        try (ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            Arraylist</* clase vehiculo */> listaRecuperada = (ArrayList</* clase vehiculo */>) lectorObjetos.readObject();
            System.out.println("La lista de " + listaRecuperada.size() + "vehiculos fue recuperada de " + nombreArchivo);
            return listaRecuperada;

        } catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("La clase del objeto no fue encontrado: " + e.getMessage());
        }
        return null;
    }

    //Guardar visitas dentro de un ArrayList
    public static void guardarObjetosVisita(ArrayList</* clase visita */> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetosVisita = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetos.writeObject(lista);
            System.out.println("la lista de Vehiculos fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //Lee el ArrayList de visita/historial
    public static Arraylist</* clase visita */> leerObjetosVisita(String nombreArchivo) {
        try (ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            Arraylist</* clase visita */> listaRecuperadaVisita = (ArrayList</* clase visita */>) lectorObjetos.readObject();
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