package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

public class PacienteDAO {
    private List<Paciente> listaPacientes = new ArrayList<>();

    public boolean registrar(Paciente paciente) {
        if (paciente != null && buscarPorId(paciente.getId()) == null) {
            listaPacientes.add(paciente);
            return true;
        }
        return false;
    }

    public List<Paciente> listar() {
        return listaPacientes;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente p : listaPacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizar(Paciente pacienteActualizado) {
        Paciente p = buscarPorId(pacienteActualizado.getId());
        if (p != null) {
            p.setSeguro(pacienteActualizado.getSeguro());
            return true;
        }
        return false;
    }
}