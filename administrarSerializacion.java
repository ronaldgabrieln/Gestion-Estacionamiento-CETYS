import java.util.ArrayList;
import java.io.*;
public class administrarSerializacion {

    //Guardar vehiculo dentro de un ArrayList
    public static void guardarObjetos(ArrayList</* clase vehiculo */> lista, String nombreArchivo) {
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {

            escritorObjetos.writeObject(lista);
            System.out.println("la lista de Vehiculos fue escrito en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //Lee el ArrayList de Vehiculo
    public static Arraylist</* clase vehiculo */> leerObjetos(String nombreArchivo) {
        try (ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            Arraylist</* clase vehiculo */> listaRecuperada = (ArrayList</* clase vehiculo */>) lectorObjetos.readObject();
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