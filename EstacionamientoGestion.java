/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.estacionamientogestion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        while(marca.isEmpty()) {
            System.out.println("La marca no puede estar vacio.");
            marca = sc.nextLine().trim();
        }
        System.out.println("Ingrese las placas:");
        String placas = sc.nextLine().trim().toUpperCase();
        while(placas.isEmpty()) {
            System.out.println("Las placas no pueden estar vacias.");
            placas = sc.nextLine().trim().toUpperCase();
        }

        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPlacas().equalsIgnoreCase(placas)) {
                System.out.println("Ya existe un vehiculo registrado con esas placas.");
                return;
            }
        }

        System.out.println("Ingrese el color del vehiculo:");
        String color = sc.nextLine();
        while(color.isEmpty()) {
            System.out.println("El color no puede estar vacio.");
            color = sc.nextLine();
        }

        int anioFabricacion;
        while (true) {
            try {
                System.out.println("Ingrese el anio de fabricacion:");
                anioFabricacion = sc.nextInt();
                int anioMaximo = 2026;
                if (anioFabricacion < 1900 || anioFabricacion > anioMaximo) {
                    throw new IllegalArgumentException("Anio fuera de rango permitido.");
                }
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Anio no valido. Intente de nuevo.");
                sc.nextLine();
            }
        }

        boolean esAutomatico;
        while (true) {
            try {
                System.out.println("Tipo de transmision ([1] Automatico, [2] Estandar):");
                int opcionTransmision = sc.nextInt();
                if (opcionTransmision < 1 || opcionTransmision > 2) {
                    throw new IllegalArgumentException("Opcion no valida.");
                }
                esAutomatico = opcionTransmision == 1; //si es 1, es automatico, si es 2, es estandar por eso se puede hacer una comparacion de booleano bien sigma
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opcion no valida.");
                sc.nextLine();
            }
        }

        Motor motor = new Motor(esAutomatico);
        Vehiculo nuevoVehiculo = new Vehiculo(motor, marca, placas, color, anioFabricacion);
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
        String placas = sc.nextLine();
        while(placas.isEmpty()) {
            System.out.println("Las placas no pueden estar vacias.");
            placas = sc.nextLine();
        }
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlacas().equalsIgnoreCase(placas)) {//por si el usuario ingresa placas pero con mayusculas o minusculas diferentes
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
        for (Visita visita : listaVisitas) { // mostrar cada visita en listaVisitas
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
            int opcion;
            while (true) {
                try {
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > 5) {
                        throw new IllegalArgumentException("Fuera de rango. Por favor, ingrese un número entre 1 y 5.");
                    }
                    sc.nextLine();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 5.");
                    sc.nextLine();
                }
            }
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
