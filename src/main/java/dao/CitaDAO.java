package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

public class CitaDAO {
    private List<Cita> listaCitas = new ArrayList<>();

    public boolean programarCita(Cita cita) {
        if (cita != null) {
            cita.setEstado("PROGRAMADA");
            listaCitas.add(cita);
            return true;
        }
        return false;
    }

    public List<Cita> listarCitas() {
        return listaCitas;
    }

    public boolean cambiarEstado(int idCita, String nuevoEstado) {
        for (Cita c : listaCitas) {
            if (c.getIdCita() == idCita) {
                if (nuevoEstado.equalsIgnoreCase("PROGRAMADA") ||
                    nuevoEstado.equalsIgnoreCase("ATENDIDA") ||
                    nuevoEstado.equalsIgnoreCase("CANCELADA")) {
                    c.setEstado(nuevoEstado);
                    return true;
                }
            }
        }
        return false;
    }
}