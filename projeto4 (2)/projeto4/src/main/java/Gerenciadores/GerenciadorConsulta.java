package Gerenciadores;

import classes.AgendamentoConsulta;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorConsulta {

    private List<AgendamentoConsulta> consultas;

    public GerenciadorConsulta() {
        consultas = new ArrayList<>();
    }

    public void adicionarConsulta(AgendamentoConsulta consulta) {
        consultas.add(consulta);
    }

    public boolean removerConsulta(AgendamentoConsulta consulta) {
        return consultas.remove(consulta);
    }

    public List<AgendamentoConsulta> getConsultas() {
        return consultas;
    }
}