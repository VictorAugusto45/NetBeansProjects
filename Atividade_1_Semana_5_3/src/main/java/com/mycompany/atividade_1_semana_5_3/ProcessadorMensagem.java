package com.mycompany.atividade_1_semana_5_3;


import com.mycompany.atividade_1_semana_5_3.IEnviadorMensagem;



public class ProcessadorMensagem {

    private IEnviadorMensagem enviador;

    public ProcessadorMensagem(IEnviadorMensagem enviador) {
        this.enviador = enviador;
    }

    public void processar() {
        System.out.println("Processando...");
        enviador.enviarMensagem();
    }
}