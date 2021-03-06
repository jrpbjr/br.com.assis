/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.model;

import java.util.Date;

/**
 *
 * @author jr
 */
public class Paciente {
    //(primeiro) label pac_nome, pac_telcel, pac_telres, pac_telcom, pac_telrec, pac_end
  private  int     pac_id;
  private  String  pac_nome;
  private  String  pac_Telefone;
  private  String  pac_telcel;  
  private  String  pac_telres;
  private  String  pac_telcom;
  private  String  pac_telrec;  
  private  String  pac_end;
  
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
  /*
  private  String  pac_ep;
  private  String  pac_hd;
  private  String  pac_cd;
  private  String  pac_consulta;
  private  String  pac_HPMA;
  private  String  pac_OBSmed;
  private  String  pac_QD;
*/
  
  /***
   * 
   * @param pac_id
   * @param pac_nome
   * @param pac_Telefone
   * @param pac_telcel
   * @param pac_telres
   * @param pac_telcom
   * @param pac_telrec
   * 
   * 
   * 
   * @param pac_end
   * @param pac_cep
   * @param pac_uf
   * @param pac_rg
   * @param pac_nasc
   * @param pac_prof
   * @param pac_estcivil
   * @param pac_resp
   * @param pac_email
   * @param pac_conv
   * @param pac_cart
   * @param pac_obs
   * @param pac_Indicacao
   * @param pac_PriConsulta
   * @param pac_bai
   * @param pac_cid
   * @param pac_ultatend
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
  
public Paciente(   int  pac_id,
                String  pac_nome,
                String  pac_Telefone,
                String  pac_telcel,
                String  pac_telres, 
                String  pac_telcom, 
                String  pac_telrec, 
                String  pac_end,                
                String  pac_uf,
                String  pac_cep,
                String  pac_rg,
                String  pac_nasc,
                String  pac_prof,
                String  pac_estcivil,
                String  pac_resp,
                String  pac_email,
                String  pac_conv,
                String  pac_cart,
                String  pac_obs,
                String  pac_Indicacao,
                String  pac_PriConsulta,
                String  pac_bai,
                String  pac_cid,
                String  pac_ultatend){
    
        this(pac_nome,
         pac_Telefone, 
           pac_telcel,
           pac_telres,
           pac_telcom,
           pac_telrec,
              pac_end,
               pac_uf,
              pac_cep,
               pac_rg,
             pac_nasc,
             pac_prof,
         pac_estcivil,
             pac_resp,
            pac_email,
             pac_conv,
             pac_cart,
              pac_obs,
        pac_Indicacao,
      pac_PriConsulta,
              pac_bai,
              pac_cid,
          pac_ultatend);
        this.pac_id = pac_id;
}

/***
     *  Este construtor podera ser utilizado quando o id do Paciente precisar ser
     * atribuido depois, como por exemplo quando e necessario criar o Paciente
     * para salvar no banco de dados, onde o id e gerado automaticamente.
     * @param pac_nome
     * @param pac_Telefone
     * @param pac_telcel     
     * @param pac_telres     
     * @param pac_telcom     
     * @param pac_telrec     
     * @param pac_end  
     * @param pac_uf  
     * @param pac_cep  
     * @param pac_rg  
     * @param pac_nasc  
     * @param pac_prof  
     * @param pac_estcivil  
     * @param pac_resp
     * @param pac_email     
     * @param pac_conv      
     * @param pac_cart  
     * @param pac_obs  
     * @param pac_Indicacao  
     * @param pac_PriConsulta  
     * @param pac_bai  
     * @param pac_cid  
     * @param pac_ultatend
 
 */
public Paciente(String  pac_nome,
                String  pac_Telefone,
                String  pac_telcel,
                String  pac_telres,
                String  pac_telcom,
                String  pac_telrec,
                String  pac_end,
                String  pac_uf,
                String  pac_cep,
                String  pac_rg,
                String  pac_nasc,
                String  pac_prof,
                String  pac_estcivil,
                String  pac_resp,
                String  pac_email,
                String  pac_conv,
                String  pac_cart,
                String  pac_obs,
                String  pac_Indicacao,
                String  pac_PriConsulta,
                String  pac_bai,
                String  pac_cid,
                String  pac_ultatend)
    {        
        this.pac_nome        = pac_nome;
        this.pac_telcel      = pac_telcel;
        this.pac_telres      = pac_telres;
        this.pac_telcom      = pac_telcom;
        this.pac_telrec      = pac_telrec;
        this.pac_end         = pac_end;
        this.pac_uf          = pac_uf;
        this.pac_cep         = pac_cep;
        this.pac_rg          = pac_rg;
        this.pac_nasc        = pac_nasc;
        this.pac_prof        = pac_prof;
        this.pac_estcivil    = pac_estcivil;
        this.pac_resp        = pac_resp;
        this.pac_email       = pac_email;
        this.pac_conv        = pac_conv;
        this.pac_cart        = pac_cart;
        this.pac_obs         = pac_obs;
        this.pac_Indicacao   = pac_Indicacao;
        this.pac_PriConsulta = pac_PriConsulta;
        this.pac_bai         = pac_bai;
        this.pac_cid         = pac_cid;
        this.pac_ultatend    = pac_ultatend;
        this.pac_Telefone    = pac_Telefone;

    }

      

    public String getPac_Telefone() {
        return pac_Telefone;
    }

    public void setPac_Telefone(String pac_Telefone) {
        this.pac_Telefone = pac_Telefone;
    }

    public String getPac_ultatend() {
        return pac_ultatend;
    }

    public void setPac_ultatend(String pac_ultatend) {
        this.pac_ultatend = pac_ultatend;
    }

    public void setPac_telres(String pac_telres) {
        this.pac_telres = pac_telres;
    }

    public void setPac_telrec(String pac_telrec) {
        this.pac_telrec = pac_telrec;
    }

    public void setPac_telcom(String pac_telcom) {
        this.pac_telcom = pac_telcom;
    }

    public String getPac_telres() {
        return pac_telres;
    }

    public String getPac_telrec() {
        return pac_telrec;
    }

    public String getPac_telcom() {
        return pac_telcom;
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

    public String getPac_bai() {
        return pac_bai;
    }

    public void setPac_bai(String pac_bai) {
        this.pac_bai = pac_bai;
    }
    
    
    public String getPac_end() {
        return pac_end;
    }

    public void setPac_end(String pac_end) {
        this.pac_end = pac_end;
    }

    public String getPac_uf() {
        return pac_uf;
    }

    public void setPac_uf(String pac_uf) {
        this.pac_uf = pac_uf;
    }

    public String getPac_cep() {
        return pac_cep;
    }

    public void setPac_cep(String pac_cep) {
        this.pac_cep = pac_cep;
    }

    public String getPac_rg() {
        return pac_rg;
    }

    public void setPac_rg(String pac_rg) {
        this.pac_rg = pac_rg;
    }

    public String getPac_nasc() {
        return pac_nasc;
    }

    public void setPac_nasc(String pac_nasc) {
        this.pac_nasc = pac_nasc;
    }

    public String getPac_prof() {
        return pac_prof;
    }

    public void setPac_prof(String pac_prof) {
        this.pac_prof = pac_prof;
    }

    public String getPac_estcivil() {
        return pac_estcivil;
    }

    public void setPac_estcivil(String pac_estcivil) {
        this.pac_estcivil = pac_estcivil;
    }

    public String getPac_resp() {
        return pac_resp;
    }

    public void setPac_resp(String pac_resp) {
        this.pac_resp = pac_resp;
    }

    public String getPac_email() {
        return pac_email;
    }

    public void setPac_email(String pac_email) {
        this.pac_email = pac_email;
    }

    public String getPac_conv() {
        return pac_conv;
    }

    public void setPac_conv(String pac_conv) {
        this.pac_conv = pac_conv;
    }

    public String getPac_cart() {
        return pac_cart;
    }
   
    public void setPac_cart(String pac_cart) {
        this.pac_cart = pac_cart;
    }

    public String getPac_obs() {
        return pac_obs;
    }

    public void setPac_obs(String pac_obs) {
        this.pac_obs = pac_obs;
    }

    public String getPac_Indicacao() {
        return pac_Indicacao;
    }

    public void setPac_Indicacao(String pac_Indicacao) {
        this.pac_Indicacao = pac_Indicacao;
    }

    public String getPac_PriConsulta() {
        return pac_PriConsulta;
    }

    public void setPac_PriConsulta(String pac_PriConsulta) {
        this.pac_PriConsulta = pac_PriConsulta;
    }

    public String getPac_cid() {
        return pac_cid;
    }

    public void setPac_cid(String pac_cid) {
        this.pac_cid = pac_cid;
    }

      
    
    @Override
    public String toString(){
        String paciente = " Paciente_id [" + this.pac_id + "]";
        paciente += this.pac_nome + "\t TELEFONES (" + this.pac_Telefone + " ) \t";
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