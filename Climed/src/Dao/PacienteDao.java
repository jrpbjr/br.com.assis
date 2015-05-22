/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

//import Factory.ConnectionManager;
import Factory.ConnectionFactory;
import Model.Paciente;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author jr
 */
public class PacienteDao {
    
    Long    pac_id;
    String  pac_nome;
    String  pac_telcel;
    String  pac_telres;
    String  pac_telcom;
    String  pac_telrec;
    String  pac_end;
    String  pac_bai;
    String  pac_cid;
    String  pac_uf;
    String  pac_cep;
    String  pac_rg;
    String  pac_nasc;
    String  pac_prof;
    String  pac_estcivil;
    String  pac_resp;
    String  pac_email;
    String  pac_conv;
    String  pac_cart;
    String  pac_obs;
    String  pac_ultatend;
    String  pac_Indicacao;
    String  pac_PriConsulta;
    String  pac_ep;
    String  pac_hd;
    String  pac_cd;
    String  pac_consulta;
    String  pac_HPMA;
    String  pac_OBSmed;
    String  pac_QD;
    private final Connection connection;
    
    public PacienteDao(){
       this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Paciente paciente){
        String sql;
        sql="INSERT INTO tblpaciente (pac_nome, pac_telcel, pac_telres, pac_telcom, pac_telrec, pac_end, pac_bai, pac_cid, pac_uf, pac_cep, pac_rg, pac_nasc, pac_prof, pac_estcivil, pac_resp, pac_email, pac_conv, pac_cart, pac_obs, pac_ultatend, pac_Indicacao, pac_PriConsulta, pac_ep, pac_hd, pac_cd, pac_consulta, pac_HPMA, pac_OBSmed, pac_QD) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, paciente.getPac_nome());
                stmt.setString(2, paciente.getPac_telcel());
                stmt.setString(3, paciente.getPac_telres());
                stmt.setString(4, paciente.getPac_telcom());
                stmt.setString(5, paciente.getPac_telrec());
                stmt.setString(6, paciente.getPac_end());
                stmt.setString(7, paciente.getPac_bai());
                stmt.setString(8, paciente.getPac_cid());
                stmt.setString(9, paciente.getPac_uf());
                stmt.setString(10, paciente.getPac_cep());
                stmt.setString(11, paciente.getPac_rg());
                stmt.setString(12, paciente.getPac_nasc());
                stmt.setString(13, paciente.getPac_prof());
                stmt.setString(14, paciente.getPac_estcivil());
                stmt.setString(15, paciente.getPac_resp());
                stmt.setString(16, paciente.getPac_email());
                stmt.setString(17, paciente.getPac_conv());
                stmt.setString(18, paciente.getPac_cart());
                stmt.setString(19, paciente.getPac_obs());
                stmt.setString(20, paciente.getPac_ultatend());
                stmt.setString(21, paciente.getPac_Indicacao());
                stmt.setString(23, paciente.getPac_PriConsulta());
                stmt.setString(24, paciente.getPac_cep());
                stmt.setString(25, paciente.getPac_hd());
                stmt.setString(26, paciente.getPac_cd());
                stmt.setString(27, paciente.getPac_consulta());
                stmt.setString(28, paciente.getPac_HPMA());
                stmt.setString(29, paciente.getPac_OBSmed()); 
                stmt.setString(30, paciente.getPac_QD()); 
                
                stmt.execute(sql);
            }

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
