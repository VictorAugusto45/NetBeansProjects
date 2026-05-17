
package Persistencia;

import classes.Paciente;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVPaciente {
    
    public String toCSV(List<Paciente>listaPacientes){
        String csv = "Nome;CPF;DataNascimento;Historico;\n";
        
        for (Paciente p : listaPacientes){
            csv += p.getNome() + ";"
                    + p.getCPF() + ";"
                    + p.getDataNascimento() + ";"
                    + p.getHistoricoMedico() + ";\n";
        }
        return csv;
    }
    
    public List<Paciente> fromCSV(String dados){
        List<Paciente> listaPacientes = new ArrayList<>();
        String[] linhas = dados.split("\n");
        
        for (int i = 1; i < linhas.length; i++){
            String[] colunas = linhas[i].split(";");
            if (colunas.length >= 4){
                Paciente p = new Paciente();
                
                p.setNome(colunas[0]);
                p.setCPF(Integer.parseInt(colunas[1]));
                p.setDataNascimento(colunas[2]);
                p.setHistoricoMedico(colunas[3]);
                
                listaPacientes.add(p);
            }
            
        }
        return listaPacientes;
    }
    
}
