/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Jose
 */
public class ClimedMDIApplication extends javax.swing.JFrame {

    /**
     * Creates new form ClimedMDIApplication
     */
    PacienteInternalFrame Paciente = null;
    
    public ClimedMDIApplication() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPaneMdi = new javax.swing.JSplitPane();
        desktopPaneMdi = new javax.swing.JDesktopPane();
        jPanelInformacao = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        agendaMenu = new javax.swing.JMenu();
        agendamentoMenuItem = new javax.swing.JMenuItem();
        horarioMedicoMenuItem = new javax.swing.JMenuItem();
        sairMenuItem = new javax.swing.JMenuItem();
        CadastroMenu = new javax.swing.JMenu();
        cadpacienteMenuItem = new javax.swing.JMenuItem();
        cadmedicoMenuItem = new javax.swing.JMenuItem();
        cadconvenioMenuItem = new javax.swing.JMenuItem();
        cadespecialidadeMenuItem = new javax.swing.JMenuItem();
        financeiroMenu = new javax.swing.JMenu();
        grpdespesaMenuItem = new javax.swing.JMenuItem();
        despesaMenuItem = new javax.swing.JMenuItem();
        grtdespesaMenuItem = new javax.swing.JMenuItem();
        ctapagarMenuItem = new javax.swing.JMenuItem();
        relatorioMenu = new javax.swing.JMenu();
        relconvenioMenuItem = new javax.swing.JMenuItem();
        relatendimentomedMenuItem = new javax.swing.JMenuItem();
        relatendimentoconvpacmedicMenuItem = new javax.swing.JMenuItem();
        relacompanhamentoMenuItem = new javax.swing.JMenuItem();
        relaniverMenuItem = new javax.swing.JMenuItem();
        ManutencaoMenu = new javax.swing.JMenu();
        sairMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPaneMdi.setResizeWeight(0.1);
        jSplitPaneMdi.setOneTouchExpandable(true);
        jSplitPaneMdi.setPreferredSize(new java.awt.Dimension(107, 403));
        jSplitPaneMdi.setRightComponent(desktopPaneMdi);

        javax.swing.GroupLayout jPanelInformacaoLayout = new javax.swing.GroupLayout(jPanelInformacao);
        jPanelInformacao.setLayout(jPanelInformacaoLayout);
        jPanelInformacaoLayout.setHorizontalGroup(
            jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelInformacaoLayout.setVerticalGroup(
            jPanelInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        jSplitPaneMdi.setLeftComponent(jPanelInformacao);

        agendaMenu.setMnemonic('f');
        agendaMenu.setText("Agenda");

        agendamentoMenuItem.setMnemonic('o');
        agendamentoMenuItem.setText("Agendamento");
        agendaMenu.add(agendamentoMenuItem);

        horarioMedicoMenuItem.setMnemonic('s');
        horarioMedicoMenuItem.setText("Horário do Médico");
        agendaMenu.add(horarioMedicoMenuItem);

        sairMenuItem.setMnemonic('x');
        sairMenuItem.setText("Sair");
        sairMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuItemActionPerformed(evt);
            }
        });
        agendaMenu.add(sairMenuItem);

        menuBar.add(agendaMenu);

        CadastroMenu.setMnemonic('e');
        CadastroMenu.setText("Cadastro");
        CadastroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroMenuActionPerformed(evt);
            }
        });

        cadpacienteMenuItem.setMnemonic('t');
        cadpacienteMenuItem.setText("Paciente");
        cadpacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadpacienteMenuItemActionPerformed(evt);
            }
        });
        CadastroMenu.add(cadpacienteMenuItem);

        cadmedicoMenuItem.setMnemonic('y');
        cadmedicoMenuItem.setText("Médico");
        CadastroMenu.add(cadmedicoMenuItem);

        cadconvenioMenuItem.setMnemonic('p');
        cadconvenioMenuItem.setText("Convênio");
        CadastroMenu.add(cadconvenioMenuItem);

        cadespecialidadeMenuItem.setMnemonic('d');
        cadespecialidadeMenuItem.setText("Especialidade");
        CadastroMenu.add(cadespecialidadeMenuItem);

        menuBar.add(CadastroMenu);

        financeiroMenu.setMnemonic('h');
        financeiroMenu.setText("Financeiro");

        grpdespesaMenuItem.setMnemonic('c');
        grpdespesaMenuItem.setText("Grupo de Despesa");
        financeiroMenu.add(grpdespesaMenuItem);

        despesaMenuItem.setMnemonic('a');
        despesaMenuItem.setText("Despesa");
        financeiroMenu.add(despesaMenuItem);

        grtdespesaMenuItem.setText("Gerenciamento de Despesa");
        financeiroMenu.add(grtdespesaMenuItem);

        ctapagarMenuItem.setText("Contas a Pagar");
        financeiroMenu.add(ctapagarMenuItem);

        menuBar.add(financeiroMenu);

        relatorioMenu.setText("Relatório");

        relconvenioMenuItem.setText("Convênio");
        relatorioMenu.add(relconvenioMenuItem);

        relatendimentomedMenuItem.setText("Atendimento p/ Médico");
        relatorioMenu.add(relatendimentomedMenuItem);

        relatendimentoconvpacmedicMenuItem.setText("Atendimento Conve x Paciente x  Médico");
        relatorioMenu.add(relatendimentoconvpacmedicMenuItem);

        relacompanhamentoMenuItem.setText("Acompanhamento");
        relatorioMenu.add(relacompanhamentoMenuItem);

        relaniverMenuItem.setText("Aniversariante");
        relatorioMenu.add(relaniverMenuItem);

        menuBar.add(relatorioMenu);

        ManutencaoMenu.setText("Manutenção");
        menuBar.add(ManutencaoMenu);

        sairMenu.setText("Sair");
        menuBar.add(sairMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPaneMdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPaneMdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairMenuItemActionPerformed

    private void cadpacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadpacienteMenuItemActionPerformed
        // TODO add your handling code here:
        //PacienteInternalFrame obj = new PacienteInternalFrame();
        //desktopPaneMdi.add(obj);
        //obj.setVisible(true);
       
       
       if (evt.getSource() == cadpacienteMenuItem) {
            
                if (Paciente == null) {
                Paciente = new PacienteInternalFrame();
                desktopPaneMdi.add(Paciente);
                Paciente.setVisible(true);
                }
                
                desktopPaneMdi.moveToFront(Paciente);
                
               if (Paciente.isClosed()) {
                    Paciente = new PacienteInternalFrame();
                    desktopPaneMdi.add(Paciente);
                    Paciente.setVisible(true);
                    desktopPaneMdi.moveToFront(Paciente);
                }
        }
       
    }//GEN-LAST:event_cadpacienteMenuItemActionPerformed

    private void CadastroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroMenuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CadastroMenuActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CadastroMenu;
    private javax.swing.JMenu ManutencaoMenu;
    private javax.swing.JMenu agendaMenu;
    private javax.swing.JMenuItem agendamentoMenuItem;
    private javax.swing.JMenuItem cadconvenioMenuItem;
    private javax.swing.JMenuItem cadespecialidadeMenuItem;
    private javax.swing.JMenuItem cadmedicoMenuItem;
    private javax.swing.JMenuItem cadpacienteMenuItem;
    private javax.swing.JMenuItem ctapagarMenuItem;
    public static javax.swing.JDesktopPane desktopPaneMdi;
    private javax.swing.JMenuItem despesaMenuItem;
    private javax.swing.JMenu financeiroMenu;
    private javax.swing.JMenuItem grpdespesaMenuItem;
    private javax.swing.JMenuItem grtdespesaMenuItem;
    private javax.swing.JMenuItem horarioMedicoMenuItem;
    private javax.swing.JPanel jPanelInformacao;
    private javax.swing.JSplitPane jSplitPaneMdi;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem relacompanhamentoMenuItem;
    private javax.swing.JMenuItem relaniverMenuItem;
    private javax.swing.JMenuItem relatendimentoconvpacmedicMenuItem;
    private javax.swing.JMenuItem relatendimentomedMenuItem;
    private javax.swing.JMenu relatorioMenu;
    private javax.swing.JMenuItem relconvenioMenuItem;
    private javax.swing.JMenu sairMenu;
    private javax.swing.JMenuItem sairMenuItem;
    // End of variables declaration//GEN-END:variables

}
