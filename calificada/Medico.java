/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calificada;

import java.util.ArrayList;

public class Medico {
    private String numeroColegiatura;
    private String nombre;
    private String especialidad;

    public Medico(String numeroColegiatura, String nombre, String especialidad) {
        this.numeroColegiatura = numeroColegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Métodos getter y setter

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public static void mostrarLista(ArrayList<Medico> medicos) {
        System.out.println("\nLista de Médicos:");
        System.out.println("+-----------------+----------------------+---------------+");
        System.out.printf("| %-15s | %-20s | %-13s |\n", "Número Colegiatura", "Nombre", "Especialidad");
        System.out.println("+-----------------+----------------------+---------------+");

        for (Medico medico : medicos) {
            System.out.printf("| %-15s | %-20s | %-13s |\n",
                    medico.getNumeroColegiatura(),
                    medico.getNombre(),
                    medico.getEspecialidad());
        }

        System.out.println("+-----------------+----------------------+---------------+");
    }
    
    
   
    
}