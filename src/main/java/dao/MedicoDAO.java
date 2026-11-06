package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Medico;

public class MedicoDAO {
    private List<Medico> listaMedicos = new ArrayList<>();

    public boolean registrar(Medico medico) {
        if (medico != null && buscarPorId(medico.getId()) == null) {
            listaMedicos.add(medico);
            return true;
        }
        return false;
    }

    public List<Medico> listar() {
        return listaMedicos;
    }

    public Medico buscarPorId(int id) {
        for (Medico m : listaMedicos) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}