/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calificada;

import java.util.Scanner;

public class main {

    private static final Scanner cs = new Scanner(System.in);

    public static void main(String[] args) {
        int accion;
        Clinica pacientes = new Clinica();

        System.out.print("\n** BIENVENIDOS AL SISTEMA DE GESTION DE PACIENTES **\n");

        try {
            int contador = 1;

            do {
                if (contador == 1) {
                    System.out.println("\n-------- Menú --------");
                    System.out.println("1. Registrar datos de paciente");
                    System.out.println("2. Eliminar datos de paciente");
                    System.out.println("3. Modificar datos de paciente");
                    System.out.println("4. Mostrar peso que más se repite");
                    System.out.println("5. Mostrar cantidad de pacientes con peso más repetido");
                    System.out.println("6. Mostrar peso mayor y menor");
                    System.out.println("7. Dividir rango de pesos y mostrar cantidad en cada rango");
                    System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
                    System.out.println("9. Indicar qué doctor atendió a un paciente");
                    System.out.println("10. Buscar doctores por especialidad");
                    System.out.println("11. Salir");

                    contador++;
                } else {
                    System.out.println("\n\n¿DESEA INGRESAR OTRA OPCIÓN?\n");
                    System.out.println("\n-------- Menú --------");
                    System.out.println("1. Registrar datos de paciente");
                    System.out.println("2. Eliminar datos de paciente");
                    System.out.println("3. Modificar datos de paciente");
                    System.out.println("4. Mostrar peso que más se repite");
                    System.out.println("5. Mostrar cantidad de pacientes con peso más repetido");
                    System.out.println("6. Mostrar peso mayor y menor");
                    System.out.println("7. Dividir rango de pesos y mostrar cantidad en cada rango");
                    System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
                    System.out.println("9. Indicar qué doctor atendió a un paciente");
                    System.out.println("10. Buscar doctores por especialidad");
                    System.out.println("11. Salir");

                }

                accion = cs.nextInt();
                while (accion <= 0 || accion > 11) {
                    System.out.println("Ingresa nuevamente un valor valido: ");
                    accion = cs.nextInt();
                }

                switch (accion) {

                    case 1:
                        System.out.println("* REGISTRAR A UN NUEVO PACIENTE ***");
                        String dni,
                         nombre,
                         direccion;
                        double peso,
                         temperatura;
                        try {
                            System.out.print("Ingrese DNI del paciente: ");
                            dni = cs.next();

                            System.out.print("Ingrese nombre del paciente: ");
                            nombre = cs.next();

                            System.out.print("Ingrese dirección del paciente: ");
                            direccion = cs.next();

                            System.out.print("Ingrese peso del paciente: ");
                            peso = cs.nextDouble();

                            System.out.print("Ingrese temperatura del paciente: ");
                            temperatura = cs.nextDouble();

                            Paciente nuevoPaciente = new Paciente(dni, nombre, direccion, peso, temperatura);
                            pacientes.adicionar(nuevoPaciente);

                            System.out.println("¡Paciente registrado con éxito!");
                            pacientes.listarPacientes();
                        } catch (Exception e) {
                            System.out.println("Error al ingresar valores. Asegúrese de ingresar valores válidos.");
                        }
                        break;

                    // En la clase Main
                    case 2:
                        pacientes.listarPacientes();
                        System.out.print("Ingrese la posición del paciente que desea eliminar: ");
                        int posicionAEliminar = cs.nextInt();

                        if (posicionAEliminar >= 0 && posicionAEliminar < pacientes.tamano()) {
                            Paciente pacienteAEliminar = pacientes.getPacientePorPosicion(posicionAEliminar);
                            pacientes.eliminar(pacienteAEliminar);
                            System.out.println("Paciente en la posición " + posicionAEliminar + " eliminado exitosamente.");
                        } else {
                            System.out.println("Posición inválida. No se pudo eliminar al paciente.");
                        }
                        pacientes.listarPacientes();
                        break;

                    case 3:
                        pacientes.listarPacientes();

                        System.out.print("Ingrese la posición del paciente que desea modificar: ");
                        int posicionAModificar = cs.nextInt();
                        cs.nextLine();  // Consumir el salto de línea después de leer el número

                        Paciente pacienteAModificar = pacientes.getPacientePorPosicion(posicionAModificar);
                        if (pacienteAModificar != null) {
                            System.out.println("* MODIFICAR DATOS DEL PACIENTE *");
                            System.out.print("Ingrese nuevo DNI del paciente: ");
                            String nuevoDNI = cs.nextLine();

                            System.out.print("Ingrese nuevo nombre del paciente: ");
                            String nuevoNombre = cs.nextLine();

                            System.out.print("Ingrese nueva dirección del paciente: ");
                            String nuevaDireccion = cs.nextLine();

                            System.out.print("Ingrese nuevo peso del paciente: ");
                            double nuevoPeso = cs.nextDouble();

                            System.out.print("Ingrese nueva temperatura del paciente: ");
                            double nuevaTemperatura = cs.nextDouble();

                            Paciente nuevoPaciente = new Paciente(nuevoDNI, nuevoNombre, nuevaDireccion, nuevoPeso, nuevaTemperatura);

                            pacientes.modificarPaciente(posicionAModificar, nuevoPaciente);
                            pacientes.listarPacientes();
                        } else {
                            System.out.println("Posición inválida. No se pudo modificar los datos del paciente.");
                        }
                        break;
                    case 4:
                        pacientes.listarPacientes();
                        pacientes.mostrarPesoMasRepetido();
                        break;

                    case 5:
                        pacientes.listarPacientes();
                        pacientes.mostrarCantidadPacientesConPesoRepetido();
                        break;
                    case 6:
                        pacientes.listarPacientes();
                        pacientes.mostrarPesoMayorYMenor();
                        break;
                    case 7:
                        
                        pacientes.dividirRangoPesos();
                    case 8:
                        pacientes.listarPacientes();
                        pacientes.mostrarListaOrdenadaPorNombres();
                        break;
                    case 9:
                        
                }
            } while (accion != 11);
        } catch (Exception e) {
            System.out.println("ERROR! ");
        }
    }
}