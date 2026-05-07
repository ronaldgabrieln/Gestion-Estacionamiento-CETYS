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

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
        ArrayList<Visita> visitas = new ArrayList<>();

        System.out.println("Bienvenido al sistema de gestión de estacionamiento CETYS");
        while (true) { 
            System.out.println("Seleccione una opción:");
            System.out.println("[1] Registrar un nuevo vehículo");
            System.out.println("[2] Mostrar vehículos registrados");
            System.out.println("[3] Registrar la entrada de un vehículo");
            System.out.println("[4] Mostrar historial de acceso");
            System.out.println("[5] Salir");
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
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    sc.nextLine(); // Limpiar el buffer de entrada
                }
            }
            sc.nextLine(); // Limpiar el buffer de entrada después de leer el número
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
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    return;
                default: //no deberia entrar aqui por el validador, pero por si acaso
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
