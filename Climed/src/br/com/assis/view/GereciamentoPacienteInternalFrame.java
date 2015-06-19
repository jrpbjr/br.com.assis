/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.view;


import br.com.assis.Controller.PacienteController;
import br.com.assis.dao.PacienteDaoImpl;
import br.com.assis.model.Paciente;
import br.com.assis.table.PacienteTableModel;
import br.com.assis.table.PacienteCellRenderer;
import br.com.assis.util.ClimedException;
import static br.com.assis.view.ClimedMDIApplication.desktopPaneMdi;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class GereciamentoPacienteInternalFrame extends javax.swing.JInternalFrame {

    
    private List<Paciente> pacienteList;
    private int idPaciente;
    
    private PacienteTableModel pacientetablemodel;
    /**
     * Creates new form PacienteFrame
     */
    CadastroPacienteJInternalFrame CadastroPaciente = null;    
    CadastroUsuarioJInternalFrame CadastroUsuario = null;
    
    public GereciamentoPacienteInternalFrame() throws ClimedException {
        initComponents();
        preencherTabelaPaciente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Gerenciamento de Paciente");

        jButton1.setText("Incluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");

        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        jButton5.setText("Pesquisar");

        jButton4.setText("Alterar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
        );

        jButton3.setText("Visualizar");

        javax.swing.GroupLayout botaoPanelLayout = new javax.swing.GroupLayout(botaoPanel);
        botaoPanel.setLayout(botaoPanelLayout);
        botaoPanelLayout.setHorizontalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botaoPanelLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        botaoPanelLayout.setVerticalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botaoPanelLayout.createSequentialGroup()
                .addGroup(botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(botaoPanelLayout.createSequentialGroup()
                        .addGroup(botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(botaoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Display"));

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome ", "Telefone", "Último Atendimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void preencherTabelaPaciente() throws ClimedException{
    /*
        PacienteDaoImpl dao = new PacienteDaoImpl();
        pacienteList =  dao.getAllPaciente();
    */
    pacienteList = new PacienteController().getAllPaciente();
        
        if (pacienteList != null) {
            jTablePaciente.setModel(new PacienteTableModel(pacienteList));
            jTablePaciente.setDefaultRenderer(Object.class, new PacienteCellRenderer());
    
        }
    /*
    if (pacienteList != null){
        this.pacientetablemodel = new PacienteTableModel(pacienteList);
        this.jTablePaciente.setModel(pacientetablemodel);
        jTablePaciente.setDefaultRenderer(Object.class, new PacienteCellRenderer());
    } 
    */
    /*
    if (dao.getAllPaciente() != null){
        this.pacientetablemodel = new PacienteTableModel(dao.getAllPaciente());
        this.jTablePaciente.setModel(pacientetablemodel);
        jTablePaciente.setDefaultRenderer(Object.class, new PacienteCellRenderer());
    } 
    */
            
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       //PacienteInternalFrame obj = new PacienteInternalFrame();
        //desktopPaneMdi.add(obj);
        //obj.setVisible(true);
        
      /*
        if (evt.getSource() == jButton1) {
            
            if (CadastroUsuario == null){
            CadastroUsuario = new CadastroUsuarioJInternalFrame();
            desktopPaneMdi.add(CadastroUsuario);
            CadastroUsuario.setVisible(true);
            }
            
            desktopPaneMdi.moveToFront(CadastroUsuario);
            
            if(CadastroUsuario.isClosed()){
            CadastroUsuario = new CadastroUsuarioJInternalFrame();
            desktopPaneMdi.add(CadastroPaciente);
            CadastroUsuario.setVisible(true);
            desktopPaneMdi.moveToFront(CadastroUsuario);
            }
            
        }
       */
        
        
        if (evt.getSource() == jButton1) {
            
            if (CadastroPaciente == null){
            CadastroPaciente = new CadastroPacienteJInternalFrame();
            desktopPaneMdi.add(CadastroPaciente);
            CadastroPaciente.setVisible(true);
            }
            
            desktopPaneMdi.moveToFront(CadastroPaciente);
            
            if(CadastroPaciente.isClosed()){
            CadastroPaciente = new CadastroPacienteJInternalFrame();
            desktopPaneMdi.add(CadastroPaciente);
            CadastroPaciente.setVisible(true);
            desktopPaneMdi.moveToFront(CadastroPaciente);
            }
            
        }
        
        
        
       //CadastroPacienteJInternalFrame obj = new CadastroPacienteJInternalFrame();
       //desktopPaneMdi.add(obj);
       //obj.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        // TODO add your handling code here:
        
        if (evt.getSource() == jTablePaciente){
            
            if (CadastroPaciente == null){
            CadastroPaciente = new CadastroPacienteJInternalFrame();
            desktopPaneMdi.add(CadastroPaciente);
            CadastroPaciente.setVisible(true);
            }
            
            desktopPaneMdi.moveToFront(CadastroPaciente);
            
            if(CadastroPaciente.isClosed()){
            CadastroPaciente = new CadastroPacienteJInternalFrame();
            desktopPaneMdi.add(CadastroPaciente);
            CadastroPaciente.setVisible(true);
            desktopPaneMdi.moveToFront(CadastroPaciente);
            }
            
        }
        
         
        
        enabledFields(false);
        
       
        int result = 0;
        int rowIndex = jTablePaciente.getSelectedRow();
        
        Paciente paciente = new PacienteTableModel(pacienteList).get(rowIndex);
        idPaciente = paciente.getPac_id();
        
        
        
        try {
            paciente = new PacienteController().getPacienteById(idPaciente);
        } catch (ClimedException ex) {
            Logger.getLogger(GereciamentoPacienteInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CadastroPaciente.jLabelIdPaciente.setText(String.valueOf(paciente.getPac_id()));
        
        CadastroPaciente.jTextFieldNome.setText(paciente.getPac_nome());
        CadastroPaciente.jTextFieldTelCel.setText(paciente.getPac_telcel());
        CadastroPaciente.jTextTelRes.setText(paciente.getPac_telres());
        CadastroPaciente.jTextFieldTelCom.setText(paciente.getPac_telcom());
        CadastroPaciente.jTextFieldTelRec.setText(paciente.getPac_telrec());
        CadastroPaciente.jTextFieldEnd.setText(paciente.getPac_end());
        
        CadastroPaciente.jLabelDataUltimoAtendimento.setText(String.valueOf(paciente.getPac_ultatend()));
        CadastroPaciente.jTextFieldBairro.setText(paciente.getPac_bai());
        
        // convenio
        //CadastroPaciente.jTextFieldCarteira.setText(paciente.);
    }//GEN-LAST:event_jTablePacienteMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botaoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sairButton;
    // End of variables declaration//GEN-END:variables

    private void enabledFields(boolean b) {
        CadastroPaciente.jTextFieldNome.setEditable(b); 
        CadastroPaciente.jTextFieldTelCel.setEditable(b);
        CadastroPaciente.jTextTelRes.setEditable(b);        
        CadastroPaciente.jTextFieldTelCom.setEditable(b);
        CadastroPaciente.jTextFieldTelRec.setEditable(b);
        CadastroPaciente.jTextFieldEnd.setEditable(b);
        CadastroPaciente.jTextFieldBairro.setEditable(b);
        CadastroPaciente.jComboBoxUf.removeAllItems();
        CadastroPaciente.jComboBoxUf.setEditable(b);
       
    }
    
    /*
    private void loadTable(int rowIndex ){
        
        
        
        CadastroPaciente.jTextFieldNome.setText(paciente.getPac_nome());        
        CadastroPaciente.jLabelIdPaciente.setText(String.valueOf(paciente.getPac_id()));
    }*/
}
