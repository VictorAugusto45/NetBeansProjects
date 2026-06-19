package com.mycompany.atividade_1_semana_5_3;

public class EnviadorSMS implements IEnviadorMensagem {

    @Override
    public void enviarMensagem() {
        System.out.println("Enviando SMS");
    }
}