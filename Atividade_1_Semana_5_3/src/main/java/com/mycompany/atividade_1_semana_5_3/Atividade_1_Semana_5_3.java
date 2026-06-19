
package com.mycompany.atividade_1_semana_5_3;


public class Atividade_1_Semana_5_3 {

    public static void main(String[] args) {
        IEnviadorMensagem sms = new EnviadorSMS();
        ProcessadorMensagem p1 = new ProcessadorMensagem(sms);
        p1.processar();

        IEnviadorMensagem email = new EnviadorEmail();
        ProcessadorMensagem p2 = new ProcessadorMensagem(email);
        p2.processar();

        IEnviadorMensagem telegram = new EnviadorTelegram();
        ProcessadorMensagem p3 = new ProcessadorMensagem(telegram);
        p3.processar();
    }
}
