/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private int idCita;
    private int idPaciente;
    private int idMedico;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;

    public Cita(int idCita, int idPaciente, int idMedico, LocalDate fecha, LocalTime hora, String motivo, String estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getIdCita() { return idCita; }
    public int getIdPaciente() { return idPaciente; }
    public int getIdMedico() { return idMedico; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public String getEstado() { return estado; }
}
