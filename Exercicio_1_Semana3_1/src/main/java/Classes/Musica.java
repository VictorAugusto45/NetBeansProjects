
package Classes;
import java.util.Scanner;
public class Musica {
    
    private String titulo;
    private String artista;
    private int duracao;
    private double preco;
    
    public Musica(){
        this.titulo = "";
        this.artista = "";
        this.duracao = 0;
        this.preco = 0.0;
    }
    public Musica(String novoTitulo, String novoArtista, int novoDuracao, double novoPreco){
        this.titulo = novoTitulo;
        this.artista = novoArtista;
        this.duracao = novoDuracao;
        this.preco = novoPreco;
    }
    
    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setArtista(String novoArtista){
        this.artista = novoArtista;
    }
    public String getArtista(){
        return this.artista;
    }
    public void setDuracao(int novoDuracao){
        this.duracao = novoDuracao;
    }
    public int getDuracao(){
        return duracao;
    }
    public void setPreco(double novoPreco){
        this.preco = novoPreco;
    }
    public double getPreco(){
        return preco;
    }
    
    @Override
    public String toString(){
        return "Musica{" +
                "Titulo='" + titulo + '\'' +
                ", Artista='" + artista + '\'' +
                ", Duracao=" + duracao +
                ", Preco=" + preco +
                '}';
    }
    
    public void fill(){
        Scanner S = new Scanner(System.in);
        
        System.out.println("Titulo da musica: ");
        this.titulo = S.next();
        
        System.out.println("Artista da musica: ");
        this.artista = S.next();
        
        System.out.println("Duracao da musica: ");
        this.duracao = S.nextInt();
        
        System.out.println("Preco da musica: ");
        this.preco = S.nextDouble();
    }
}
