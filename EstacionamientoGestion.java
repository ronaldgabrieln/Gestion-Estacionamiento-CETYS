/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.estacionamientogestion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Ingrese la marca del vehiculo:");
        String marca = sc.nextLine().trim();

        System.out.println("Ingrese las placas:");
        String placas = sc.nextLine().trim().toUpperCase();
        if (placas.isEmpty()) {
            System.out.println("Las placas no pueden estar vacias.");
            return;
        }

        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPlacas().equalsIgnoreCase(placas)) {
                System.out.println("Ya existe un vehiculo registrado con esas placas.");
                return;
            }
        }

        System.out.println("Ingrese el token del vehiculo:");
        String token = sc.nextLine().trim();

        System.out.println("Ingrese el color del vehiculo:");
        String color = sc.nextLine().trim();

        int anioFabricacion;
        while (true) {
            System.out.println("Ingrese el anio de fabricacion:");
            try {
                anioFabricacion = Integer.parseInt(sc.nextLine().trim());
                if (anioFabricacion < 1900 || anioFabricacion > LocalDateTime.now().getYear() + 1) {
                    throw new FueraDeRangoException("Anio fuera de rango permitido.");
                }
                break;
            } catch (FueraDeRangoException | NumberFormatException e) {
                System.out.println("Anio no valido. Intente de nuevo.");
            }
        }

        boolean esAutomatico;
        while (true) {
            System.out.println("Tipo de transmision ([1] Automatico, [2] Estandar):");
            String opcion = sc.nextLine().trim();
            if ("1".equals(opcion)) {
                esAutomatico = true;
                break;
            } else if ("2".equals(opcion)) {
                esAutomatico = false;
                break;
            } else {
                System.out.println("Opcion no valida.");
            }
        }

        Motor motor = new Motor(esAutomatico);
        Vehiculo nuevoVehiculo = new Vehiculo(motor, marca, placas, token, color, anioFabricacion);
        lista.add(nuevoVehiculo);
        System.out.println("Vehiculo registrado correctamente.");
    }

    public static void mostrarVehiculos(ArrayList<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("Vehiculos registrados:");
        for (Vehiculo vehiculo : lista) {
            System.out.println("-----------------------------------");
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Placas: " + vehiculo.getPlacas());
            System.out.println("Token: " + vehiculo.getToken());
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Anio: " + vehiculo.getAnioFabricacion());
        }
    }

    public static void registrarEntrada(ArrayList<Visita> listaVisitas, ArrayList<Vehiculo> listaVehiculos) {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados para registrar acceso.");
            return;
        }

        System.out.println("Ingrese las placas del vehiculo que entra:");
        String placas = sc.nextLine().trim();
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlacas().equalsIgnoreCase(placas)) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }

        if (vehiculoEncontrado == null) {
            System.out.println("Vehiculo no encontrado. Registrelo primero.");
            return;
        }

        Visita nuevaVisita = new Visita(vehiculoEncontrado, LocalDateTime.now());
        listaVisitas.add(nuevaVisita);
        System.out.println("Entrada registrada para " + vehiculoEncontrado.getPlacas() + ".");
    }

    public static void mostrarHistorial(ArrayList<Visita> listaVisitas) {
        if (listaVisitas.isEmpty()) {
            System.out.println("No hay accesos registrados.");
            return;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Historial de accesos:");
        for (Visita visita : listaVisitas) {
            System.out.println("-----------------------------------");
            System.out.println("Placas: " + visita.getVehiculo().getPlacas());
            System.out.println("Marca: " + visita.getVehiculo().getMarca());
            System.out.println("Fecha y hora: " + visita.getFechaYHora().format(formato));
        }
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
                    registrarVehiculo(vehiculosRegistrados);
                    break;
                case 2:
                    mostrarVehiculos(vehiculosRegistrados);
                    break;
                case 3:
                    registrarEntrada(visitas, vehiculosRegistrados);
                    break;
                case 4:
                    mostrarHistorial(visitas);
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
