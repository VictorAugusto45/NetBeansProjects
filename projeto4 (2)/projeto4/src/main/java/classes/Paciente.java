package classes;


import java.util.Objects;
import java.util.Scanner;




public class Paciente {
    
     private String nome;
   private int CPF;
   private String dataNascimento;
   private String historicoMedico;
   
   public Paciente(){
      this.nome = "";
      this.CPF = 0;
      this.dataNascimento = "";
      this.historicoMedico = "";
        
   }
    public Paciente(String nome, int CPF, String dataNascimento, String historicoMedico){
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = historicoMedico;
    }
    
   @Override
    public String toString(){
        String transf = "Dados do Paciente:" + 
        "Nome:" + this.nome + "CPF:" + this.CPF
        + "Data de Nascimento:" + this.dataNascimento
        + "Historico Medico" + this.historicoMedico;        
        return transf;
    } 
    
    public void fill(){
        Scanner s = new Scanner(System.in);
        System.out.println("Preencha Dados:");
        System.out.println("Nome do paciente:");
        this.nome = s.next();
        System.out.println("CPF dos paciente:");
        this.CPF = s.nextInt();
        System.out.println("Data de Nascimento do paciente");
        this.dataNascimento = s.next();
        System.out.println("Historico de Medico:");
        this.historicoMedico = s.next();
        
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCPF(int CPF){
        this.CPF = CPF;
        
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public void setHistoricoMedico(String historicoMedico){
        this.historicoMedico = historicoMedico;
    }
    public String getNome(){
        return this.nome;
    }
    public int getCPF(){
        return this.CPF;
    }
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    public String getHistoricoMedico(){
        return this.historicoMedico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + this.CPF;
        hash = 59 * hash + Objects.hashCode(this.dataNascimento);
        hash = 59 * hash + Objects.hashCode(this.historicoMedico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente  other = (Paciente) obj;
        if (this.CPF != other.CPF) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        return Objects.equals(this.historicoMedico, other.historicoMedico);
    }
    
}
