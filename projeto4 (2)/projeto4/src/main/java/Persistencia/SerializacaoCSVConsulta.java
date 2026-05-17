package Persistencia;

import classes.AgendamentoConsulta;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVConsulta {

    public String toCSV(List<AgendamentoConsulta> consultas) {

        String csv = "CPF;CRM;DataHora;\n";

        for (AgendamentoConsulta c : consultas) {

            csv += c.getCPFPaciente() + ";"
                    + c.getCRMMedico() + ";"
                    + c.getDataHora() + ";\n";
        }

        return csv;
    }

    public List<AgendamentoConsulta> fromCSV(String dados) {

        List<AgendamentoConsulta> consultas = new ArrayList<>();

        String[] linhas = dados.split("\n");

        for (int i = 1; i < linhas.length; i++) {

            String[] colunas = linhas[i].split(";");

            if (colunas.length >= 3) {

                AgendamentoConsulta c =
                        new AgendamentoConsulta();

                c.setCPFPaciente(
                        Integer.parseInt(colunas[0]));

                c.setCRMMedico(colunas[1]);

                c.setDataHora(colunas[2]);

                consultas.add(c);
            }
        }

        return consultas;
    }
}