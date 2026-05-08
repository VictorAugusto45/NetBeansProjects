
package Classes;
import java.util.ArrayList;
import java.util.List;


public class SerializadorCSVMusica {
    
    public String toCSV(List<Musica> listaMusicas){
        String csv = "Titulo;Artista;Duracao;Preco;\n";
        for (Musica m: listaMusicas){
            csv += m.getTitulo() + ";"
                + m.getArtista() + ";"
                + m.getDuracao() + ";"
                + m.getPreco() + ";\n";
        }
        return csv;
        
    }
    public List<Musica> fromCSV(String data){
        List<Musica> listaMusicas = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        for(int i = 1; i < linhas.length; i++){
            String[] coluna = linhas[i].split(";");
            if (coluna.length >= 4){
                Musica m = new Musica();
                m.setTitulo(coluna[0]);
                m.setArtista(coluna[1]);
                m.setDuracao(Integer.parseInt(coluna[2]));
                m.setPreco(Double.parseDouble(coluna[3]));
             
                listaMusicas.add(m);
            }
        }
        return listaMusicas;
    }  
}
