package GUI;

import classes.Medico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DlgSelecionarMedico extends JDialog {

    private JList<Medico> listaMedicos;

    private JButton btnConfirmar;
    private JButton btnCancelar;

    private Medico medicoSelecionado;

    public DlgSelecionarMedico(
            Frame parent,
            boolean modal,
            List<Medico> medicos) {

        super(parent, modal);

        setTitle("Selecionar Médico");

        setSize(300, 300);

        setLocationRelativeTo(parent);

        setLayout(new BorderLayout());

        // LISTA
        DefaultListModel<Medico> model =
                new DefaultListModel<>();

        for (Medico m : medicos) {
            model.addElement(m);
        }

        listaMedicos = new JList<>(model);

        JScrollPane scroll =
                new JScrollPane(listaMedicos);

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

            medicoSelecionado =
                    listaMedicos.getSelectedValue();

            dispose();
        });

        btnCancelar.addActionListener(e -> {

            medicoSelecionado = null;

            dispose();
        });
    }

    public Medico getMedicoSelecionado() {

        return medicoSelecionado;
    }
}