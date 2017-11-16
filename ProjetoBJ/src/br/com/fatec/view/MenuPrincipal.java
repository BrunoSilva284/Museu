/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

/**
 *
 * @author aluno
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        painelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        CadastroVisitante = new javax.swing.JMenuItem();
        CadastroAcervo = new javax.swing.JMenuItem();
        menuGerenciar = new javax.swing.JMenu();
        GerenciarVisita = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - Museu");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setName("Menu Principal - Museu"); // NOI18N
        getContentPane().setLayout(null);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(painelPrincipal);
        painelPrincipal.setBounds(0, 0, 680, 420);

        menuCadastro.setText("Cadastrar");

        CadastroVisitante.setText("Visitante");
        CadastroVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroVisitanteActionPerformed(evt);
            }
        });
        menuCadastro.add(CadastroVisitante);

        CadastroAcervo.setText("Acervo");
        CadastroAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroAcervoActionPerformed(evt);
            }
        });
        menuCadastro.add(CadastroAcervo);

        jMenuBar1.add(menuCadastro);

        menuGerenciar.setText("Gerenciar");

        GerenciarVisita.setText("Visita");
        GerenciarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerenciarVisitaActionPerformed(evt);
            }
        });
        menuGerenciar.add(GerenciarVisita);

        jMenuBar1.add(menuGerenciar);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 703, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroVisitanteActionPerformed
        // TODO add your handling code here:
        CadastroVisitante visit = new CadastroVisitante();
        painelPrincipal.add(visit);
        visit.setVisible(true);
    }//GEN-LAST:event_CadastroVisitanteActionPerformed

    private void GerenciarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerenciarVisitaActionPerformed
        // TODO add your handling code here:
        GerenciarVisita visit = new GerenciarVisita();
        painelPrincipal.add(visit);
        visit.setVisible(true);
    }//GEN-LAST:event_GerenciarVisitaActionPerformed

    private void CadastroAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroAcervoActionPerformed
        // TODO add your handling code here:
        CadastroAcervo acervo = new CadastroAcervo();
        painelPrincipal.add(acervo);
        acervo.setVisible(true);
    }//GEN-LAST:event_CadastroAcervoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastroAcervo;
    private javax.swing.JMenuItem CadastroVisitante;
    private javax.swing.JMenuItem GerenciarVisita;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuGerenciar;
    private javax.swing.JDesktopPane painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
