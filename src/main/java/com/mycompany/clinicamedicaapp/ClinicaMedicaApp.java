package com.mycompany.clinicamedicaapp;

import dao.PacienteDAO;
import dao.MedicoDAO;
import dao.CitaDAO;
import modelo.Paciente;
import modelo.Medico;
import modelo.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ClinicaMedicaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        CitaDAO citaDAO = new CitaDAO();

        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA CLINICA MEDICA ---");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Registrar Medico");
            System.out.println("4. Listar Medicos");
            System.out.println("5. Programar Cita");
            System.out.println("6. Listar Citas");
            System.out.println("7. Cambiar Estado de Cita");
            System.out.println("8. Salir");
            System.out.print("Elija una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } else {
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int idp = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombres: ");
                    String nomp = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apep = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dnip = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telp = scanner.nextLine();
                    System.out.print("Correo: ");
                    String corp = scanner.nextLine();
                    System.out.print("Seguro: ");
                    String segp = scanner.nextLine();

                    // Usa el constructor exacto de Paciente
                    Paciente pNuevo = new Paciente(idp, nomp, apep, dnip, telp, corp, segp);
                    if (pacienteDAO.registrar(pNuevo)) {
                        System.out.println("Paciente registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el paciente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PACIENTES ---");
                    for (Paciente p : pacienteDAO.listar()) {
                        System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombres() + " " + p.getApellidos() + " | Seguro: " + p.getSeguro());
                    }
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idm = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombres: ");
                    String nomm = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apem = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dnim = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telm = scanner.nextLine();
                    System.out.print("Correo: ");
                    String corm = scanner.nextLine();
                    System.out.print("CMP: ");
                    String cmp = scanner.nextLine();
                    System.out.print("Horario: ");
                    String hor = scanner.nextLine();
                    System.out.print("ID Especialidad: ");
                    int idEsp = scanner.nextInt(); scanner.nextLine();

                    // Usa el constructor exacto de Medico
                    Medico mNuevo = new Medico(idm, nomm, apem, dnim, telm, corm, cmp, hor, idEsp);
                    if (medicoDAO.registrar(mNuevo)) {
                        System.out.println("Medico registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el medico.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- LISTA DE MEDICOS ---");
                    for (Medico m : medicoDAO.listar()) {
                        System.out.println("ID: " + m.getId() + " | Nombre: " + m.getNombres() + " " + m.getApellidos() + " | CMP: " + m.getCmp());
                    }
                    break;

                case 5:
                    System.out.print("ID Cita: ");
                    int idc = scanner.nextInt();
                    System.out.print("ID Paciente: ");
                    int idPac = scanner.nextInt();
                    System.out.print("ID Medico: ");
                    int idMed = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Motivo: ");
                    String mot = scanner.nextLine();

                    // Usa el constructor exacto de Cita
                    Cita cNueva = new Cita(idc, idPac, idMed, LocalDate.now(), LocalTime.of(9, 0), mot, "PROGRAMADA");
                    if (citaDAO.programarCita(cNueva)) {
                        System.out.println("Cita programada con exito.");
                    } else {
                        System.out.println("No se pudo programar la cita.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE CITAS ---");
                    for (Cita c : citaDAO.listarCitas()) {
                        System.out.println("Cita ID: " + c.getIdCita() + " | Paciente ID: " + c.getIdPaciente() + " | Medico ID: " + c.getIdMedico() + " | Estado: " + c.getEstado());
                    }
                    break;

                case 7:
                    System.out.print("ID Cita a modificar: ");
                    int idCambio = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nuevo Estado (PROGRAMADA, ATENDIDA, CANCELADA): ");
                    String nest = scanner.nextLine();
                    if (citaDAO.cambiarEstado(idCambio, nest)) {
                        System.out.println("Estado actualizado.");
                    } else {
                        System.out.println("No se pudo actualizar el estado.");
                    }
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}