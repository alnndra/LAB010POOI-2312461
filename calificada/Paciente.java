/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calificada;

public class Paciente {

   private String DNI; 
   private String nombre;
   private String direccion;
   private double peso;
   private double temperatura;
   private Medico medico;

   
   public Paciente(String DNI, String nombre, String direccion, double peso, double temperatura) {
       this.DNI = DNI;
       this.nombre = nombre;
       this.direccion = direccion;
       this.peso = peso;
       this.temperatura = temperatura;
   }
   public Paciente(String DNI, String nombre, String direccion, double peso, double temperatura, Medico medico) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
        this.medico = medico;
    }


   public String getDNI() {
       return DNI;
   }

   public void setDNI(String dni) {
       this.DNI = dni;
   }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    

}
   
   


