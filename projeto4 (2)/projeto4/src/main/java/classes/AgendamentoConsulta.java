
package classes;

import java.util.Objects;


public class AgendamentoConsulta {
   private int CPFPaciente;
   private String CRMMedico;
   private String dataHora;
   
   
   public AgendamentoConsulta(){
       this.CPFPaciente = 0;
       this.CRMMedico = "";
       this.dataHora = "";
   }
   public AgendamentoConsulta(int CPFPaciente, String CRMMedico, String dataHora){
       this.CPFPaciente = CPFPaciente;
       this.CRMMedico = CRMMedico;
       this.dataHora= dataHora;
   }

    
   
   
   
   
   
   
   
   public int getCPFPaciente() {
        return this.CPFPaciente;
    }

    public String getCRMMedico() {
        return this.CRMMedico;
    }

    public String getDataHora() {
        return this.dataHora;
    }

    public void setCPFPaciente(int CPFPaciente) {
        this.CPFPaciente = CPFPaciente;
    }

    public void setCRMMedico(String CRMMedico) {
        this.CRMMedico = CRMMedico;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.CPFPaciente;
        hash = 13 * hash + Objects.hashCode(this.CRMMedico);
        hash = 13 * hash + Objects.hashCode(this.dataHora);
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
        final AgendamentoConsulta other = (AgendamentoConsulta) obj;
        if (this.CPFPaciente != other.CPFPaciente) {
            return false;
        }
        if (!Objects.equals(this.CRMMedico, other.CRMMedico)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }
   
          
}
