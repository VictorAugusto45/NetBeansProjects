
package classes;

import java.util.Objects;
import java.util.Scanner;


public class Medico {
    private String nome;
    private String CRM;
    private String especialidade;
    private String horario;
    
    public Medico(){
        this.nome = "";
        this.CRM = "";
        this.especialidade = "";
        this.horario = "";
        
    }
    public Medico(String nome, String CRM, String especialidade, String horario){
        this.nome = nome;
        this.CRM = CRM;
        this.especialidade = especialidade;
        this.horario = horario;
    }
    
    /**
     *
     * @return
     */
    public void fill(){
        Scanner s = new Scanner(System.in);
        System.out.println("Dados do medico:");
        this.nome = s.next();
        System.out.println("Nome do medico:");
        this.nome = s.next();
        System.out.println("CRM do medico:");
        this.CRM = s.next();
        System.out.println("Especialidade do medico:");
        this.especialidade = s.next();
        System.out.println("Horario:");
        this.horario = s.next(); }
    
    public String toString(){
        String transf = "Dados do paciente:" + "Nome do paciente:"
            + this.nome + "CRM do medico:" + this.CRM +
            "Especialidade do medico:" + this.especialidade
            + "Horario:" + this.horario;    
        
                return transf;
    }
    
   
    
    
    
    
    
    
    
    
    
    public String getNome() {
        return this.nome;
    }

    public String getCRM() {
        return this.CRM;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.CRM);
        hash = 47 * hash + Objects.hashCode(this.especialidade);
        hash = 47 * hash + Objects.hashCode(this.horario);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.CRM, other.CRM)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        return Objects.equals(this.horario, other.horario);
    }
    
    
    
}
