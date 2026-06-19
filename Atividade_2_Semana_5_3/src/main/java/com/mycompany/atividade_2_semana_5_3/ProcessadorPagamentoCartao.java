package com.mycompany.atividade_2_semana_5_3;

public class ProcessadorPagamentoCartao
        implements IProcessadorPagamento {

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento realizado com cartão.");
    }
}