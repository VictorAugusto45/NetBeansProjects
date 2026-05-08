package com.mycompany.exercicio_1_semana3_3;

import Classes.GerenciadorMusica;
import Classes.Musica;
import java.io.IOException;


public class Exercicio_1_Semana3_3 {

    public static void main(String[] args) throws IOException {
        testeSerializacaoJSON();
    }
    public static void testeSerializacaoJSON() throws IOException {
        // Criando o gerenciador de músicas
        GerenciadorMusica gerenciadorMusica = new GerenciadorMusica();

        // Criando músicas
        Musica musica1 = new Musica("Menino da porteira", "Sergio Reis", 245, 1.15);
        Musica musica2 = new Musica("Amigo", "Milton Nascimento", 270, 0.99);

        // Adicionando músicas ao gerenciador
        gerenciadorMusica.adicionarMusica(musica1);
        gerenciadorMusica.adicionarMusica(musica2);

        // Salvando a lista de músicas no arquivo .csv através do gerenciador
        String caminhoDoArquivo = "musicas.json";
        gerenciadorMusica.salvarNoArquivo(caminhoDoArquivo);

        // Carregando a lista de músicas do arquivo .csv através do gerenciador
        gerenciadorMusica.carregarDoArquivo(caminhoDoArquivo);

        // Supondo que o método toString do GerenciadorMusica esteja implementado para mostrar as músicas
        System.out.println(gerenciadorMusica.toString());
}
}
