
package Classes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorMusica {
    
    private ArrayList<Musica> listaMusicas;
    
    public GerenciadorMusica(){
        this.listaMusicas = new ArrayList<>();
    }
    public void adicionarMusica(Musica novaMusica){
        listaMusicas.add(novaMusica);
    }
    public void removerMusica(Musica novaMusica){
        listaMusicas.remove(novaMusica);
    }
    public boolean contemMusica(Musica novaMusica){
       return listaMusicas.contains(novaMusica);
    }
    public Musica findMusicaTitulo(String titulo){
        for (Musica m: listaMusicas){
            if (titulo.equals(m.getTitulo())){
                return m;
            }
        }
        return null;
    }
    public Musica findMusicaArtista(String artista){
        for (Musica m: listaMusicas){
            if (artista.equals(m.getArtista())){
                return m;
            }
        }
        return null;
    }
    
    public void salvarNoArquivo(String caminho) {

    try {

        SerializadorJSONMusica serializador =
                new SerializadorJSONMusica();

        String json = serializador.toJSON(listaMusicas);

        FilePersistence file = new FilePersistence();

        file.saveToFile(json, caminho);

        System.out.println("Arquivo JSON salvo!");

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}
    public void carregarDoArquivo(String caminho) {

    try {

        FilePersistence file = new FilePersistence();

        String conteudo = file.loadFromFile(caminho);

        SerializadorJSONMusica serializador =
                new SerializadorJSONMusica();

        listaMusicas.clear();

        listaMusicas.addAll(
                serializador.fromJSON(conteudo)
        );

        System.out.println("Arquivo JSON carregado!");

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}
}
