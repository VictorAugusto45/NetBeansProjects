
package Gerenciadores;

import Persistencia.FilePersistence;
import Persistencia.SerializacaoCSVMedico;
import classes.Medico;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class GerenciadorMedico {
    private List<Medico> medicos;
    
    public GerenciadorMedico(){
        this.medicos = new ArrayList<>();
    }

    public GerenciadorMedico(List<Medico> pacientes) {
        this.medicos = pacientes;
    }
    
    public void adicionarMedico(Medico medico){
        medicos.add(medico);
    }
    public boolean removeMedico(String CRM){
        for(Medico medicoAtual: medicos){
            if(CRM.equals(medicoAtual.getCRM())){
                medicos.remove(medicoAtual);
                return true;
            }
        }
        return false;
    }
    public Medico buscarCRMMedico(String CRM){
        for(Medico medicoAtual: medicos){
            if(CRM.equals(medicoAtual.getCRM())){
                return medicoAtual;
            }
        }
        return null;
    }
    
    public void atualizarMedico(Medico medicoAtualizado, String CRM){
        for (Medico medicoAtual: medicos){
            if(CRM.equals(medicoAtual.getCRM())){
               medicos.remove(medicoAtual);
               medicos.add(medicoAtualizado);
            }
        }
    }

   
    public void salvarNoArquivo(String caminho) {

    try {

        SerializacaoCSVMedico serializador =
                new SerializacaoCSVMedico();

        String textoCSV =
                serializador.toCSV(medicos);

        FilePersistence file =
                new FilePersistence();

        file.saveToFile(textoCSV, caminho);

        System.out.println("Medicos salvos!");

    } catch (Exception e) {

        System.out.println(
                "Erro ao salvar medicos: "
                + e.getMessage());
    }
}

    public void carregarDoArquivo(String caminho) {

    try {

        FilePersistence file =
                new FilePersistence();

        String conteudo =
                file.loadFromFile(caminho);

        SerializacaoCSVMedico serializador =
                new SerializacaoCSVMedico();

        medicos =
                serializador.fromCSV(conteudo);

        System.out.println("Medicos carregados!");

    } catch (Exception e) {

        System.out.println(
                "Erro ao carregar medicos: "
                + e.getMessage());
    }
}
    
    
    
    
    
    
    
    
    public List<Medico> getMedicos() {
        return this.medicos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.medicos);
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
        final GerenciadorMedico other = (GerenciadorMedico) obj;
        return Objects.equals(this.medicos, other.medicos);
    }
    


    
}
