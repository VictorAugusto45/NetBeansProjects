package com.mycompany.atividade_2_semana_5_3;

public class ProcessadorPagamentoBoleto
        implements IProcessadorPagamento {

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento realizado com boleto.");
    }
}