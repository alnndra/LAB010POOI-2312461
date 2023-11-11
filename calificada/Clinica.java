/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calificada;


import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Clinica {
    private ArrayList<Paciente> pacientes;

    public Clinica() {
        pacientes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
        guardarArchivo();
    }

    

 
    public Paciente buscar(int peso) {
        for (Paciente paciente : pacientes) {
            if (paciente.getPeso() == peso) {
                return paciente;
            }
        }
        return null;
    }


    public int tamano() {
        return pacientes.size();
    }

   
public void listarPacientes() {
    System.out.println("\nLista de Pacientes:");
    System.out.println("+-----------------+----------------------+---------------+------------+------------+");
    System.out.printf("| %-15s | %-20s | %-13s | %-10s | %-10s |\n", "DNI", "Nombre", "Dirección", "Peso", "Temperatura");
    System.out.println("+-----------------+----------------------+---------------+------------+------------+");

    for (Paciente paciente : pacientes) {
        System.out.printf("| %-15s | %-20s | %-13s | %-10.2f | %-10.2f |\n",
                paciente.getDNI(),
                paciente.getNombre(),
                paciente.getDireccion(),
                paciente.getPeso(),
                paciente.getTemperatura());
    }

    System.out.println("+-----------------+----------------------+---------------+------------+------------+");
}

public void eliminar(Paciente paciente) {
        pacientes.remove(paciente);
        guardarArchivo();  // Asegúrate de llamar a los métodos necesarios después de eliminar
    }


public Paciente getPacientePorPosicion(int posicion) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            return pacientes.get(posicion);
        } else {
            return null;
        }
    }
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createPaciente(st);
        }
        br.close();
    }

    private void createPaciente(StringTokenizer st) {
        String dni = st.nextToken().trim();
        String nombre = st.nextToken().trim();
        String direccion = st.nextToken().trim();
        double peso = Double.parseDouble(st.nextToken().trim());
        double temperatura = Double.parseDouble(st.nextToken().trim());
        Paciente paciente = new Paciente(dni, nombre, direccion, peso, temperatura);
        adicionar(paciente);
    }

    private void cargarArchivo() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("pacientes.txt");
            if (inputStream != null) {
                readFromInputStream(inputStream);
            } else {
                JOptionPane.showMessageDialog(null, "El archivo pacientes.txt no existe");
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + x.getMessage());
        }
    }

    public void dividirRangoPesos() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        
        
        double pesoMaximo = Collections.max(pacientes, Comparator.comparingDouble(Paciente::getPeso)).getPeso();
        double pesoMinimo = Collections.min(pacientes, Comparator.comparingDouble(Paciente::getPeso)).getPeso();

        
        double rango = (pesoMaximo - pesoMinimo) / 4;

        
        int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();

            if (peso >= pesoMinimo && peso < pesoMinimo + rango) {
                rango1++;
            } else if (peso >= pesoMinimo + rango && peso < pesoMinimo + 2 * rango) {
                rango2++;
            } else if (peso >= pesoMinimo + 2 * rango && peso < pesoMinimo + 3 * rango) {
                rango3++;
            } else {
                rango4++;
            }
        }

        System.out.println("Cantidad de pacientes en el rango " + pesoMinimo + " - " + (pesoMinimo + rango) + ": " + rango1);
        System.out.println("Cantidad de pacientes en el rango " + (pesoMinimo + rango) + " - " + (pesoMinimo + 2 * rango) + ": " + rango2);
        System.out.println("Cantidad de pacientes en el rango " + (pesoMinimo + 2 * rango) + " - " + (pesoMinimo + 3 * rango) + ": " + rango3);
        System.out.println("Cantidad de pacientes en el rango " + (pesoMinimo + 3 * rango) + " - " + pesoMaximo + ": " + rango4);
    }

  


    public void mostrarListaOrdenadaPorNombres() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

       
        Collections.sort(pacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("\nLista de Pacientes:");
        System.out.println("+-----------------+----------------------+---------------+------------+------------+");
        System.out.printf("| %-15s | %-20s | %-13s | %-10s | %-10s |\n", "DNI", "Nombre", "Dirección", "Peso", "Temperatura");
        System.out.println("+-----------------+----------------------+---------------+------------+------------+");

        for (Paciente paciente : pacientes) {
            System.out.printf("| %-15s | %-20s | %-13s | %-10.2f | %-10.2f |\n",
                    paciente.getDNI(),
                    paciente.getNombre(),
                    paciente.getDireccion(),
                    paciente.getPeso(),
                    paciente.getTemperatura());
        }

        System.out.println("+-----------------+----------------------+---------------+------------+------------+");
    }


    public void mostrarPesoMayorYMenor() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        // Obtener el peso mayor y menor usando la función Collections.max y Collections.min
        double pesoMayor = Collections.max(pacientes, (p1, p2) -> Double.compare(p1.getPeso(), p2.getPeso())).getPeso();
        double pesoMenor = Collections.min(pacientes, (p1, p2) -> Double.compare(p1.getPeso(), p2.getPeso())).getPeso();

        System.out.println("Peso mayor en la lista: " + pesoMayor);
        System.out.println("Peso menor en la lista: " + pesoMenor);
    }

    
    
    public void modificarPaciente(int posicion, Paciente nuevoPaciente) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            pacientes.set(posicion, nuevoPaciente);
            guardarArchivo();  // Asegúrate de llamar a los métodos necesarios después de modificar
            System.out.println("Datos del paciente en la posición " + posicion + " modificados exitosamente.");
        } else {
            System.out.println("Posición inválida. No se pudo modificar los datos del paciente.");
        }
    }

    public void mostrarPesoMasRepetido() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
            double peso = entry.getKey();
            int frecuencia = entry.getValue();

            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                pesoMasRepetido = peso;
            }
        }

        if (maxFrecuencia > 1) {
            System.out.println("El peso que más se repite es: " + pesoMasRepetido + " con una frecuencia de " + maxFrecuencia + " pacientes.");
        } else {
            System.out.println("No hay pesos repetidos en la lista.");
        }
}


    public void mostrarCantidadPacientesConPesoRepetido() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
            double peso = entry.getKey();
            int frecuencia = entry.getValue();

            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                pesoMasRepetido = peso;
            }
        }

        if (maxFrecuencia > 1) {
            System.out.println("El peso que más se repite es: " + pesoMasRepetido + " con una frecuencia de " + maxFrecuencia + " pacientes.");

            // Mostrar la cantidad de pacientes con el peso que más se repite
            int cantidadPacientes = 0;
            for (Paciente paciente : pacientes) {
                if (paciente.getPeso() == pesoMasRepetido) {
                    cantidadPacientes++;
                }
            }
            System.out.println("La cantidad de pacientes con ese peso es: " + cantidadPacientes);
        } else {
            System.out.println("No hay pesos repetidos en la lista.");
        }
    }


    private void guardarArchivo() {
        try {
            FileWriter fileWriter = new FileWriter("pacientes.txt", false); // "false" para sobrescribir
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Paciente paciente : pacientes) {
                String linea = paciente.getDNI() + "," + paciente.getNombre() + "," + paciente.getDireccion() + "," + paciente.getPeso() + "," + paciente.getTemperatura();
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo pacientes.txt: " + e.getMessage());
        }
    }
}