package com.mycompany.atividade_1_semana_5_3;


public class EnviadorEmail implements IEnviadorMensagem {

    @Override
    public void enviarMensagem() {
        System.out.println("Enviando Email");
    }
}