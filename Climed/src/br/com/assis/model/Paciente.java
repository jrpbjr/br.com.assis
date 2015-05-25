/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.model;

/**
 *
 * @author jr
 */
public class Paciente {
   
  private  int     pac_id;
  private  String  pac_nome;
  private  String  pac_telcel;
  /*
  private  String  pac_telres;
  private  String  pac_telcom;
  private  String  pac_telrec;
  */
  private  String  pac_end;
  /*
  private  String  pac_bai;
  private  String  pac_cid;
  private  String  pac_uf;
  private  String  pac_cep;
  private  String  pac_rg;
  private  String  pac_nasc;
  private  String  pac_prof;
  private  String  pac_estcivil;
  private  String  pac_resp;
  private  String  pac_email;
  private  String  pac_conv;
  private  String  pac_cart;
  private  String  pac_obs;
  private  String  pac_ultatend;
  private  String  pac_Indicacao;
  private  String  pac_PriConsulta;
  private  String  pac_ep;
  private  String  pac_hd;
  private  String  pac_cd;
  private  String  pac_consulta;
  private  String  pac_HPMA;
  private  String  pac_OBSmed;
  private  String  pac_QD;*/

  /***
   * 
   * @param pac_id
   * @param pac_nome
   * @param pac_telcel
   * 
   * 
   * 
   * @param pac_end
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */
public Paciente(int pac_id,String  pac_nome, String  pac_telcel, String  pac_end){
        this(pac_nome, pac_telcel, pac_end);
        this.pac_id = pac_id;
}

/***
     *  Este construtor podera ser utilizado quando o id do Paciente precisar ser
     * atribuido depois, como por exemplo quando e necessario criar o Paciente
     * para salvar no banco de dados, onde o id e gerado automaticamente.
     * @param pac_nome
     * @param pac_telcel     
     * @param pac_end     
 
 */
public Paciente(String  pac_nome, String  pac_telcel, String  pac_end)
    {        
        this.pac_nome       = pac_nome;
        this.pac_telcel     = pac_telcel;        
        this.pac_end        = pac_end;       

    }

    public int getPac_id() {
        return pac_id;
    }

    public void setPac_id(int pac_id) {
        this.pac_id = pac_id;
    }

    public String getPac_nome() {
        return pac_nome;
    }

    public void setPac_nome(String pac_nome) {
        this.pac_nome = pac_nome;
    }

    public String getPac_telcel() {
        return pac_telcel;
    }

    public void setPac_telcel(String pac_telcel) {
        this.pac_telcel = pac_telcel;
    }
    

    public String getPac_end() {
        return pac_end;
    }

    public void setPac_end(String pac_end) {
        this.pac_end = pac_end;
    }
   
    
    @Override
    public String toString(){
        String paciente = " Paciente_id [" + this.pac_id + "]";
        paciente += this.pac_nome + "\t TELCEL (" + this.pac_telcel + " ) \t";
        paciente += "- End: {" + this.pac_end + "}";
        return paciente;        
    }    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pac_telcel == null) ? 0 : pac_telcel.hashCode());
		return result;
	}
     @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (pac_telcel == null) {
			if (other.pac_telcel != null)
				return false;
		} else if (!pac_telcel.equals(other.pac_telcel))
			return false;
		return true;
	}
    

}