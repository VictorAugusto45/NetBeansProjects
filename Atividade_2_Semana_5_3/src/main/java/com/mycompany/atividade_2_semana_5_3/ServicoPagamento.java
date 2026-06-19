package com.mycompany.atividade_2_semana_5_3;

public class ServicoPagamento {

    private IProcessadorPagamento processadorPag;

    public ServicoPagamento(IProcessadorPagamento processadorPag) {
        this.processadorPag = processadorPag;
    }

    public void realizarPagamento() {
        System.out.println("Iniciando pagamento...");
        processadorPag.processarPagamento();
    }
}