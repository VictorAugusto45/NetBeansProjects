package Persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilePersistence {

    
    public void saveToFile(String texto, String caminho)
            throws IOException {

        FileWriter arquivo = new FileWriter(caminho);

        PrintWriter gravar = new PrintWriter(arquivo);

        gravar.print(texto);

        gravar.close();
        arquivo.close();
    }

    
    public String loadFromFile(String caminho)
            throws FileNotFoundException {

        String conteudo = "";

        File arquivo = new File(caminho);

        Scanner leitor = new Scanner(arquivo);

        leitor.useDelimiter("\\Z");

        while (leitor.hasNext()) {
            conteudo += leitor.next();
        }

        leitor.close();

        return conteudo;
    }
}