/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Paciente extends Persona {
    private String seguro;

    public Paciente(int id, String nombres, String apellidos, String dni, String telefono, String correo, String seguro) {
        super(id, nombres, apellidos, dni, telefono, correo);
        this.seguro = seguro;
    }

    public String getSeguro() { return seguro; }
    public void setSeguro(String seguro) { this.seguro = seguro; }

    @Override
    public void mostrarDatos() {
        System.out.println("Paciente: " + nombres + " " + apellidos + " | DNI: " + dni + " | Seguro: " + seguro);
    }
}
