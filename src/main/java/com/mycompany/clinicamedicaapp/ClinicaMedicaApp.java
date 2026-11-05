/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clinicamedicaapp;

import java.sql.Connection;

public class ClinicaMedicaApp {
    public static void main(String[] args) {
        Connection cn = ConexionBD.getConexion();
        if (cn != null) {
            System.out.println("----------------------------------------");
            System.out.println("¡CONEXIÓN EXITOSA A LA BASE DE DATOS!");
            System.out.println("Estructura de modelo POO lista.");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Error al conectar. Revisa tu contraseña/usuario en ConexionBD.java.");
        }
    }
}
