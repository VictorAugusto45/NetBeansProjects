package GUI;

import classes.Paciente;

import javax.swing.*;
import java.awt.*;

public class DlgCadastroPaciente extends JDialog {

    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtNascimento;

    private JTextArea txtHistorico;

    private JButton btnSalvar;
    private JButton btnCancelar;

    private Paciente pacienteCriado;

    public DlgCadastroPaciente(
            Frame parent,
            boolean modal) {

        super(parent, modal);

        setTitle("Cadastrar Paciente");

        setSize(400, 350);

        setLocationRelativeTo(parent);

        setLayout(new GridLayout(9,1));

        // CAMPOS
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CPF:"));
        txtCPF = new JTextField();
        add(txtCPF);

        add(new JLabel("Data Nascimento:"));
        txtNascimento = new JTextField();
        add(txtNascimento);

        add(new JLabel("Histórico Médico:"));

        txtHistorico = new JTextArea();

        add(new JScrollPane(txtHistorico));

        // BOTÕES
        btnSalvar = new JButton("Salvar");

        btnCancelar = new JButton("Cancelar");

        add(btnSalvar);

        add(btnCancelar);

        configurarEventos();
    }

    private void configurarEventos() {

        btnSalvar.addActionListener(e -> {

            try {

                String nome =
                        txtNome.getText();

                int cpf =
                        Integer.parseInt(
                                txtCPF.getText());

                String nascimento =
                        txtNascimento.getText();

                String historico =
                        txtHistorico.getText();

                pacienteCriado =
                        new Paciente(
                                nome,
                                cpf,
                                nascimento,
                                historico);

                dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dados inválidos!");
            }
        });

        btnCancelar.addActionListener(e -> {

            pacienteCriado = null;

            dispose();
        });
    }

    public Paciente getPacienteCriado() {

        return pacienteCriado;
    }
}