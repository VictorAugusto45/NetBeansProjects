package com.mycompany.atividade_2_semana_5_3;

public class Atividade_2_Semana_5_3 {

    public static void main(String[] args) {

        IProcessadorPagamento cartao =
                new ProcessadorPagamentoCartao();

        ServicoPagamento servico1 =
                new ServicoPagamento(cartao);

        servico1.realizarPagamento();

        System.out.println();

        IProcessadorPagamento boleto =
                new ProcessadorPagamentoBoleto();

        ServicoPagamento servico2 =
                new ServicoPagamento(boleto);

        servico2.realizarPagamento();
    }
}