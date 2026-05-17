package Persistencia;

import classes.Medico;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVMedico {

    public String toCSV(List<Medico> medicos) {

        String csv = "Nome;CRM;Especialidade;Horario;\n";

        for (Medico m : medicos) {

            csv += m.getNome() + ";"
                    + m.getCRM() + ";"
                    + m.getEspecialidade() + ";"
                    + m.getHorario() + ";\n";
        }

        return csv;
    }

    public List<Medico> fromCSV(String dados) {

        List<Medico> medicos = new ArrayList<>();

        String[] linhas = dados.split("\n");

        for (int i = 1; i < linhas.length; i++) {

            String[] colunas = linhas[i].split(";");

            if (colunas.length >= 4) {

                Medico m = new Medico();

                m.setNome(colunas[0]);
                m.setCRM(colunas[1]);
                m.setEspecialidade(colunas[2]);
                m.setHorario(colunas[3]);

                medicos.add(m);
            }
        }

        return medicos;
    }
}