package GUI;

import Gerenciadores.GerenciadorConsulta;
import Gerenciadores.GerenciadorMedico;
import Gerenciadores.GerenciadorPaciente;

import classes.AgendamentoConsulta;
import classes.Medico;
import classes.Paciente;

import javax.swing.*;
import java.awt.*;

public class DlgAgendamentoConsulta extends JDialog {


    private JLabel lblPaciente;
    private JLabel lblMedico;

    private JTextField txtData;

    private JButton btnSelecionarPaciente;
    private JButton btnSelecionarMedico;
    private JButton btnConfirmar;


    private Paciente pacienteSelecionado;

    private Medico medicoSelecionado;


    private GerenciadorPaciente gerPacientes;

    private GerenciadorMedico gerMedicos;

    private GerenciadorConsulta gerConsultas;

    public DlgAgendamentoConsulta(
            Frame parent,
            boolean modal,
            GerenciadorPaciente gerPacientes,
            GerenciadorMedico gerMedicos,
            GerenciadorConsulta gerConsultas) {

        super(parent, modal);

        this.gerPacientes = gerPacientes;

        this.gerMedicos = gerMedicos;

        this.gerConsultas = gerConsultas;


        setTitle("Agendamento de Consulta");

        setSize(400, 300);

        setLocationRelativeTo(parent);

        setLayout(new GridLayout(7, 1));


        lblPaciente =
                new JLabel("Paciente: Nenhum");

        btnSelecionarPaciente =
                new JButton("Selecionar Paciente");


        lblMedico =
                new JLabel("Médico: Nenhum");

        btnSelecionarMedico =
                new JButton("Selecionar Médico");


        txtData =
                new JTextField();


        btnConfirmar =
                new JButton("Confirmar Consulta");


        add(lblPaciente);

        add(btnSelecionarPaciente);

        add(lblMedico);

        add(btnSelecionarMedico);

        add(new JLabel("Data da Consulta:"));

        add(txtData);

        add(btnConfirmar);


        configurarEventos();
    }

    private void configurarEventos() {


        btnSelecionarPaciente.addActionListener(e -> {


            if (gerPacientes
                    .getPacientes()
                    .isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum paciente cadastrado!");

                return;
            }


            DlgSelecionarPaciente dlg =
                    new DlgSelecionarPaciente(
                            null,
                            true,
                            gerPacientes.getPacientes());

            dlg.setVisible(true);


            pacienteSelecionado =
                    dlg.getPacienteSelecionado();


            if (pacienteSelecionado != null) {

                lblPaciente.setText(
                        "Paciente: "
                        + pacienteSelecionado.getNome());
            }
        });


        btnSelecionarMedico.addActionListener(e -> {


            if (gerMedicos
                    .getMedicos()
                    .isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum médico cadastrado!");

                return;
            }


            DlgSelecionarMedico dlg =
                    new DlgSelecionarMedico(
                            null,
                            true,
                            gerMedicos.getMedicos());

            dlg.setVisible(true);


            medicoSelecionado = dlg.getMedicoSelecionado();


            if (medicoSelecionado != null) {

                lblMedico.setText(
                        "Médico: "
                        + medicoSelecionado.getNome());
            }
        });


        btnConfirmar.addActionListener(e -> {

           
            if (pacienteSelecionado == null
                    || medicoSelecionado == null
                    || txtData.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha todos os dados!");

                return;
            }


            AgendamentoConsulta consulta =
                    new AgendamentoConsulta(
                            pacienteSelecionado.getCPF(),
                            medicoSelecionado.getCRM(),
                            txtData.getText());


            gerConsultas.adicionarConsulta(
                    consulta);

            JOptionPane.showMessageDialog(
                    this,
                    "Consulta agendada com sucesso!");


            dispose();
        });
    }
}