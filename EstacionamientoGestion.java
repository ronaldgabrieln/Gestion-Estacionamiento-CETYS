/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.estacionamientogestion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gaby2
 */
public class EstacionamientoGestion {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Vehiculo> vehiculosRegistrados;
    public static ArrayList<Visita> visitas = new ArrayList<>();
    public static void registrarVehiculo(ArrayList<Vehiculo> lista) {
        return;
    }
    public static void main(String[] args) {
        //rutas de los archivos para serializacion
        String rutaVehiculos = "inventario.dat";
        String rutaVisitas = "accesos_diarios.txt";
        // Cargar datos existentes
        vehiculosRegistrados = administrarSerializacion.leerObjetos(rutaVehiculos);
        if (vehiculosRegistrados == null) {
            vehiculosRegistrados = new ArrayList<>();
        }
        
        visitas = administrarSerializacion.leerObjetosVisita(rutaVisitas);
        if (visitas == null) {
            visitas = new ArrayList<>();
        }
        // Menu principal
        System.out.println("Bienvenido al sistema de gestión de estacionamiento CETYS");

        while (true) { 
            System.out.println("Seleccione una opción:");
            System.out.println("[1] Registrar un nuevo vehículo");
            System.out.println("[2] Mostrar vehículos registrados");
            System.out.println("[3] Registrar la entrada de un vehículo");
            System.out.println("[4] Mostrar historial de acceso");
            System.out.println("[5] Salir y guardar");
            int opcion = 0;
            while (true) {
                try {
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > 5) {
                        throw new FueraDeRangoException("Opción fuera de rango. Por favor, ingrese un número entre 1 y 5.");
                    } else {
                        break; // salir del bucle
                    }
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número dentro del rango permitido.");
                    sc.nextLine(); // Limpiar el buffer de entrada
                }
            }
            sc.nextLine(); // Limpiar el buffer de entrada después de leer el número
            // **OPCIONES DEL MENU PRINCIPAL** //
            switch(opcion) {
                case 1:
                    //registrarVehiculo(vehiculosRegistrados);
                    break;
                case 2:
                    //mostrarVehiculos(vehiculosRegistrados);
                    break;
                case 3:
                    //registrarEntrada(visitas, vehiculosRegistrados);
                    break;
                case 4:
                    //mostrarHistorial(visitas);
                    break;
                case 5:
                    System.out.println("Guardando datos...");
                    administrarSerializacion.guardarObjetos(vehiculosRegistrados, rutaVehiculos);
                    administrarSerializacion.guardarObjetosVisita(visitas, rutaVisitas);
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    return;
                default: //no deberia entrar aqui por el validador, pero por si acaso
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
