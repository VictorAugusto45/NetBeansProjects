
package Gerenciadores;

import Persistencia.FilePersistence;
import Persistencia.SerializacaoCSVPaciente;
import classes.Paciente;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


 
public class GerenciadorPaciente {
    private List<Paciente> pacientes;

      public GerenciadorPaciente(){
       this.pacientes = new ArrayList<>();
      }
      
      public GerenciadorPaciente(List<Paciente> pacientes){
          this.pacientes = pacientes;
          
      }
      
    
      public void adicionarPaciente(Paciente paciente){
          pacientes.add(paciente);
      }
      
      public boolean removePaciente(int CPFPaciente){
          for(Paciente pacienteAtual: pacientes){
          if(CPFPaciente ==(pacienteAtual.getCPF())){
              pacientes.remove(pacienteAtual);
              return true;
          }
      } return false;
      }
    public Paciente buscarPaciente(int CPFPaciente){
        for(Paciente pacienteAtual: pacientes){
            if(CPFPaciente == pacienteAtual.getCPF()){
                return pacienteAtual;
            }
        }
        return null;
    }
    public void atualizarPaciente(Paciente pacienteAtualizado, int CPFPaciente){
        for(Paciente pacienteAtual: pacientes){
            if(pacienteAtual.getCPF() == CPFPaciente){
                pacientes.remove(pacienteAtual);
                pacientes.add(pacienteAtualizado);
            }
        }
        
    }
    
    public void salvarNoArquivo(String caminho) {

    try {

        
        SerializacaoCSVPaciente serializador =
                new SerializacaoCSVPaciente();

        String textoCSV =
                serializador.toCSV(pacientes);

        
        FilePersistence file =
                new FilePersistence();

        file.saveToFile(textoCSV, caminho);

        System.out.println("Pacientes salvos com sucesso!");

    } catch (Exception e) {

        System.out.println(
                "Erro ao salvar pacientes: "
                + e.getMessage());
    }
}
    
    public void carregarDoArquivo(String caminho) {

    try {

        // LÊ arquivo
        FilePersistence file =
                new FilePersistence();

        String conteudo =
                file.loadFromFile(caminho);

        // DESSERIALIZA CSV -> objetos
        SerializacaoCSVPaciente serializador =
                new SerializacaoCSVPaciente();

        pacientes =
                serializador.fromCSV(conteudo);

        System.out.println(
                "Pacientes carregados com sucesso!");

    } catch (Exception e) {

        System.out.println(
                "Erro ao carregar pacientes: "
                + e.getMessage());
    }
}
    
    
    
    
    
    
       public List<Paciente> getPacientes(){
          return this.pacientes;
      }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pacientes);
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
        final GerenciadorPaciente other = (GerenciadorPaciente) obj;
        return Objects.equals(this.pacientes, other.pacientes);
    }
               
              
              

}