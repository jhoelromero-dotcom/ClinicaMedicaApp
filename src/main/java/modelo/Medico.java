/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Medico extends Persona {
    private String cmp;
    private String horario;
    private int idEspecialidad;

    public Medico(int id, String nombres, String apellidos, String dni, String telefono, String correo, String cmp, String horario, int idEspecialidad) {
        super(id, nombres, apellidos, dni, telefono, correo);
        this.cmp = cmp;
        this.horario = horario;
        this.idEspecialidad = idEspecialidad;
    }

    public String getCmp() { return cmp; }
    public String getHorario() { return horario; }
    public int getIdEspecialidad() { return idEspecialidad; }

    @Override
    public void mostrarDatos() {
        System.out.println("Médico: " + nombres + " " + apellidos + " | CMP: " + cmp);
    }
}
