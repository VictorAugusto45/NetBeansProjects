package GUI;

import Gerenciadores.GerenciadorConsulta;
import Gerenciadores.GerenciadorMedico;
import Gerenciadores.GerenciadorPaciente;

import classes.Medico;
import classes.Paciente;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {


    private GerenciadorPaciente gerPacientes;
    private GerenciadorMedico gerMedicos;
    private GerenciadorConsulta gerConsultas;


    private JButton btnCadastrarPaciente;
    private JButton btnCadastrarMedico;
    private JButton btnAgendarConsulta;
    private JButton btnVerConsultas;

    public TelaPrincipal() {


        gerPacientes = new GerenciadorPaciente();

        gerMedicos = new GerenciadorMedico();

        gerConsultas = new GerenciadorConsulta();


        setTitle("Sistema de Consultas Médicas");

        setSize(500, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());


        btnCadastrarPaciente = new JButton("Cadastrar Paciente");

        btnCadastrarMedico = new JButton("Cadastrar Médico");

        btnAgendarConsulta = new JButton("Agendar Consulta");
        
        btnVerConsultas = new JButton("Ver Consultas");

        add(btnCadastrarPaciente);

        add(btnCadastrarMedico);

        add(btnAgendarConsulta);
        
        add(btnVerConsultas);


        configurarEventos();
    }

    private void configurarEventos() {


        btnCadastrarPaciente.addActionListener(e -> {

            DlgCadastroPaciente dlg =
                    new DlgCadastroPaciente(
                            this,
                            true);

            dlg.setVisible(true);

            Paciente paciente =
                    dlg.getPacienteCriado();

            if (paciente != null) {

                gerPacientes.adicionarPaciente(
                        paciente);

                JOptionPane.showMessageDialog(
                        this,
                        "Paciente cadastrado com sucesso!");
            }
        });


        btnCadastrarMedico.addActionListener(e -> {

            DlgCadastroMedico dlg =
                    new DlgCadastroMedico(
                            this,
                            true);

            dlg.setVisible(true);

            Medico medico =
                    dlg.getMedicoCriado();

            if (medico != null) {

                gerMedicos.adicionarMedico(
                        medico);

                JOptionPane.showMessageDialog(
                        this,
                        "Médico cadastrado com sucesso!");
            }
        });


        btnAgendarConsulta.addActionListener(e -> {


            if (gerPacientes
                    .getPacientes()
                    .isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum paciente cadastrado!");

                return;
            }


            if (gerMedicos
                    .getMedicos()
                    .isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum médico cadastrado!");

                return;
            }

            DlgAgendamentoConsulta dlg =
                    new DlgAgendamentoConsulta(
                            this,
                            true,
                            gerPacientes,
                            gerMedicos,
                            gerConsultas);

            dlg.setVisible(true);
        });
        
        btnVerConsultas.addActionListener(e -> {

            DlgListarConsultas dlg =
                    new DlgListarConsultas(
                            this,
                            true,
                            gerConsultas);

            dlg.setVisible(true);
        });
    }
}