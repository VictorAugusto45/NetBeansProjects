package GUI;

import classes.Medico;

import javax.swing.*;
import java.awt.*;

public class DlgCadastroMedico extends JDialog {

    private JTextField txtNome;
    private JTextField txtCRM;
    private JTextField txtEspecialidade;
    private JTextField txtHorario;

    private JButton btnSalvar;
    private JButton btnCancelar;

    private Medico medicoCriado;

    public DlgCadastroMedico(
            Frame parent,
            boolean modal) {

        super(parent, modal);

        setTitle("Cadastrar Médico");

        setSize(400,300);

        setLocationRelativeTo(parent);

        setLayout(new GridLayout(10,1));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CRM:"));
        txtCRM = new JTextField();
        add(txtCRM);

        add(new JLabel("Especialidade:"));
        txtEspecialidade = new JTextField();
        add(txtEspecialidade);

        add(new JLabel("Horário:"));
        txtHorario = new JTextField();
        add(txtHorario);

        btnSalvar = new JButton("Salvar");

        btnCancelar = new JButton("Cancelar");

        add(btnSalvar);

        add(btnCancelar);

        configurarEventos();
    }

    private void configurarEventos() {

        btnSalvar.addActionListener(e -> {

            String nome =
                    txtNome.getText();

            String crm =
                    txtCRM.getText();

            String especialidade =
                    txtEspecialidade.getText();

            String horario =
                    txtHorario.getText();

            medicoCriado =
                    new Medico(
                            nome,
                            crm,
                            especialidade,
                            horario);

            dispose();
        });

        btnCancelar.addActionListener(e -> {

            medicoCriado = null;

            dispose();
        });
    }

    public Medico getMedicoCriado() {

        return medicoCriado;
    }
}