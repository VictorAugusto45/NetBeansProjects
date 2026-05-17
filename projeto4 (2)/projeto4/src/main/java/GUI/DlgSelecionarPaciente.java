package GUI;

import classes.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DlgSelecionarPaciente extends JDialog {

    private JList<Paciente> listaPacientes;

    private JButton btnConfirmar;
    private JButton btnCancelar;

    private Paciente pacienteSelecionado;

    public DlgSelecionarPaciente(
            Frame parent,
            boolean modal,
            List<Paciente> pacientes) {

        super(parent, modal);

        setTitle("Selecionar Paciente");

        setSize(300, 300);

        setLocationRelativeTo(parent);

        setLayout(new BorderLayout());

        // LISTA
        DefaultListModel<Paciente> model =
                new DefaultListModel<>();

        for (Paciente p : pacientes) {
            model.addElement(p);
        }

        listaPacientes = new JList<>(model);

        JScrollPane scroll =
                new JScrollPane(listaPacientes);

        add(scroll, BorderLayout.CENTER);

        // BOTÕES
        JPanel painelBotoes =
                new JPanel();

        btnConfirmar =
                new JButton("Confirmar");

        btnCancelar =
                new JButton("Cancelar");

        painelBotoes.add(btnConfirmar);

        painelBotoes.add(btnCancelar);

        add(painelBotoes,
                BorderLayout.SOUTH);

        configurarEventos();
    }

    private void configurarEventos() {

        btnConfirmar.addActionListener(e -> {

            pacienteSelecionado =
                    listaPacientes.getSelectedValue();

            dispose();
        });

        btnCancelar.addActionListener(e -> {

            pacienteSelecionado = null;

            dispose();
        });
    }

    public Paciente getPacienteSelecionado() {

        return pacienteSelecionado;
    }
}