package GUI;

import Gerenciadores.GerenciadorConsulta;
import classes.AgendamentoConsulta;

import javax.swing.*;
import java.awt.*;

public class DlgListarConsultas extends JDialog {

    private JTextArea txtConsultas;

    private JScrollPane scroll;

    public DlgListarConsultas(
            Frame parent,
            boolean modal,
            GerenciadorConsulta gerConsultas) {

        super(parent, modal);


        setTitle("Lista de Consultas");

        setSize(500, 400);

        setLocationRelativeTo(parent);

        setLayout(new BorderLayout());


        txtConsultas = new JTextArea();

        txtConsultas.setEditable(false);

        scroll = new JScrollPane(txtConsultas);

        add(scroll, BorderLayout.CENTER);


        carregarConsultas(gerConsultas);
    }

    private void carregarConsultas(
            GerenciadorConsulta gerConsultas) {

        String texto = "";

        for (AgendamentoConsulta c :
                gerConsultas.getConsultas()) {

            texto +=
                    "Paciente CPF: "
                    + c.getCPFPaciente()
                    + "\n";

            texto +=
                    "Médico CRM: "
                    + c.getCRMMedico()
                    + "\n";

            texto +=
                    "Data/Hora: "
                    + c.getDataHora()
                    + "\n";

            texto +=
                    "-------------------------\n";
        }

        txtConsultas.setText(texto);
    }
}