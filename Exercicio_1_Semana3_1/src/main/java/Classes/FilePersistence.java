
package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FilePersistence {
    
    public void saveToFile(String texto, String filePath) throws IOException{
        FileWriter arquivo = new FileWriter(filePath);
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        gravarArquivo.print(texto);
        arquivo.close();
    }
    
    public String loadFromFile(String filePath) throws FileNotFoundException{
        String conteudoLido = "";
        
        File file = new File(filePath);
        
        Scanner S = new Scanner(file);
        
        S.useDelimiter("\\Z");
        while(S.hasNext()){
            conteudoLido += S.next();
        }
        return conteudoLido;
    }
}
