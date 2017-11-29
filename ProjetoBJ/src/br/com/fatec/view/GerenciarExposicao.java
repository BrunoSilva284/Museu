package br.com.fatec.view;

import br.com.fatec.controller.AcervoController;
import br.com.fatec.controller.ExposicaoController;
import br.com.fatec.util.Mascaras;
import br.com.fatec.controller.SalaController;
import br.com.fatec.model.Exposicao;
import br.com.fatec.model.Obra;
import br.com.fatec.model.Sala;
import br.com.fatec.enums.StatusObraEnum;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno.a.da.silva
 */
public class GerenciarExposicao extends javax.swing.JInternalFrame {
    
    private String nomeAntigo;
    private final ExposicaoController ger = new ExposicaoController();
    private final AcervoController acervo = new AcervoController();
    private final SalaController salaGer = new SalaController();
    private Obra obra;
    /**
     * Creates new form GerenciarAcervo
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public GerenciarExposicao() throws SQLException, ClassNotFoundException, NullPointerException {
        initComponents();
        txtAutorObra.setEditable(false);
        txtNomeObra.setEditable(false);
        txtTipoObra.setEditable(false);
        popularCombo("WHERE STATUS ='LIVRE'");
        limparCampos();
    }
    
    private void popularCombo(String where) throws SQLException, ClassNotFoundException, NullPointerException{
        ArrayList<Sala> salas = (ArrayList) salaGer.listarSalas(where);
        ArrayList<Integer> numeros= new ArrayList<>();
        for(Sala sala : salas){
            numeros.add(sala.getNumero());
        }
        Object[] array = numeros.toArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel(array);
        cbSala.setModel(model);
    }
    
    private void limparCampos(){
        txtAutorObra.setText("");
        txtBusca.setText("");
        txtBuscaObra.setText("");
        txtDataFim.setText("");
        txtDataInicial.setText("");
        txtNome.setText("");
        txtNomeObra.setText("");
        txtTipoObra.setText("");
        tbObras.setModel(new DefaultTableModel());
        
        ckPermanente.setSelected(false);
        ckPermanente.setEnabled(true);
        txtDataFim.setVisible(true);
        lbDataFim.setVisible(true);
        
        btAdicionarObra.setEnabled(false);
        btAlterarExpo.setEnabled(false);
        btBuscarObra.setEnabled(true);
        btCadastrarExpo.setEnabled(true);
        btExcluirExpo.setEnabled(false);
        lbLotacao.setText("Lotação:");
        cbSala.setSelectedIndex(0);
        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Nome Obra", "Autor", "Tipo de Obra"},0);
        tbObras.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btBuscarExpo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        lbDataFim = new javax.swing.JLabel();
        txtDataFim = new javax.swing.JFormattedTextField();
        ckPermanente = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtBuscaObra = new javax.swing.JTextField();
        btBuscarObra = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNomeObra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAutorObra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTipoObra = new javax.swing.JTextField();
        btAdicionarObra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbSala = new javax.swing.JComboBox<>();
        lbLotacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbObras = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btCadastrarExpo = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btAlterarExpo = new javax.swing.JButton();
        btExcluirExpo = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(227, 232, 254));
        setClosable(true);
        setTitle("Gerenciar Exposição");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fatec/images/Exposicao.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Buscar por nome:");

        btBuscarExpo.setText("Buscar");
        btBuscarExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarExpoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(206, 209, 216));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Data Inicio:");

        txtDataInicial.setFormatterFactory(Mascaras.data());

        lbDataFim.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbDataFim.setText("Data Fim");

        txtDataFim.setFormatterFactory(Mascaras.data());

        ckPermanente.setText("Permanente");
        ckPermanente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckPermanenteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Selecionar obra");

        btBuscarObra.setText("Buscar");
        btBuscarObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarObraActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(217, 220, 225));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Dados Obra");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Nome:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("Autor:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("Tipo de obra:");

        btAdicionarObra.setText("Adicionar à exposição");
        btAdicionarObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarObraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(286, 286, 286))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtAutorObra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAdicionarObra, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeObra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNomeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionarObra)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtAutorObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Sala:");

        cbSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSalaActionPerformed(evt);
            }
        });

        lbLotacao.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbLotacao.setText("Lotação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbLotacao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lbDataFim)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ckPermanente)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscarObra)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLotacao))
                .addGap(18, 18, 18)
                .addComponent(ckPermanente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataFim)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscaObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarObra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Autor", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbObras.setEnabled(false);
        tbObras.setFocusable(false);
        jScrollPane2.setViewportView(tbObras);
        if (tbObras.getColumnModel().getColumnCount() > 0) {
            tbObras.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Obras na exposição");

        btCadastrarExpo.setText("Cadastrar");
        btCadastrarExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarExpoActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btAlterarExpo.setText("Alterar");
        btAlterarExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarExpoActionPerformed(evt);
            }
        });

        btExcluirExpo.setText("Excluir");
        btExcluirExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirExpoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btBuscarExpo)
                .addGap(199, 199, 199)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btLimpar)
                        .addGap(59, 59, 59)
                        .addComponent(btCadastrarExpo)
                        .addGap(35, 35, 35)
                        .addComponent(btAlterarExpo)
                        .addGap(39, 39, 39)
                        .addComponent(btExcluirExpo)
                        .addGap(8, 8, 8))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscarExpo))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLimpar)
                            .addComponent(btCadastrarExpo)
                            .addComponent(btAlterarExpo)
                            .addComponent(btExcluirExpo))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Exposicao retornarObras(Exposicao expo) throws SQLException, ClassNotFoundException{
        DefaultTableModel model = (DefaultTableModel) tbObras.getModel();
        Set<Obra> obras = new HashSet<>();
        int i = model.getRowCount();
        int j = 0;
        while(j<i){
            Obra obra = acervo.consultarObra((String)model.getValueAt(j, 0));
            obra.setStatus(StatusObraEnum.EXIBICAO);
            obras.add(obra);            
            j++;
        }
        expo.setObras(obras);  
        return expo;
    }
    
    private void btBuscarExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarExpoActionPerformed
        // TODO add your handling code here:
        if(txtBusca.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite o nome da exposição", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try {                
                Exposicao exposicao = ger.consultarExposicao(txtBusca.getText());
                txtNome.setText(exposicao.getNome());      
                nomeAntigo = exposicao.getNome();
                popularCombo("WHERE numero not in (select sala_numero from exposicao where codigo !="+exposicao.getCodigo()+")");
                Calendar data =exposicao.getDataInicio();
                cbSala.setSelectedItem(exposicao.getSala().getNumero());
                lbLotacao.setText("Lotação: "+exposicao.getSala().getQtdVisitantes());
                String formatada =""+data.get(Calendar.YEAR)
                        +"-"+(data.get(Calendar.MONTH)+1)
                        +"-"+data.get(Calendar.DAY_OF_MONTH);
                txtDataInicial.setText(formatada);
                
                if(exposicao.getTipo().equals("PERMANENTE")){
                    lbDataFim.setVisible(false);
                    txtDataFim.setVisible(false);
                    ckPermanente.setSelected(true);
                    ckPermanente.setEnabled(true);
                }
                else{
                    System.out.println("Nao permanente");
                    data =exposicao.getDataFim();                
                    formatada =""+data.get(Calendar.YEAR)
                            +"-"+(data.get(Calendar.MONTH)+1)
                            +"-"+data.get(Calendar.DAY_OF_MONTH);
                    System.out.println(formatada);
                    txtDataFim.setVisible(true);
                    txtDataFim.setText(formatada);                    
                    ckPermanente.setSelected(false);
                    ckPermanente.setEnabled(true);
                    
                }
                
                DefaultTableModel model = new DefaultTableModel(new String[] {"Nome Obra", "Autor", "Tipo de Obra"},0);
                Set<Obra> obras; 
                if(!exposicao.getObras().isEmpty()){                    
                    obras = exposicao.getObras();
                    Iterator<Obra> obrIt = obras.iterator();
                    while(obrIt.hasNext()){
                        Obra obra = obrIt.next();
                        model.addRow(new Object[]{obra.getNome(), obra.getAutor(),obra.getClassificacao().toString()});
                        tbObras.setModel(model);
                    }
                }
                else{
                    tbObras.setModel(model);
                }
                btCadastrarExpo.setEnabled(false);
                btAlterarExpo.setEnabled(true);
                btExcluirExpo.setEnabled(true);
                btBuscarObra.setEnabled(true);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Exposição não encontrada!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro : " + ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btBuscarExpoActionPerformed

    private void btCadastrarExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarExpoActionPerformed
        // TODO add your handling code here:
        if(txtNome.getText().equals("") || txtDataInicial.getText().equals("    -  -  ") 
                || (!ckPermanente.isSelected() && txtDataFim.getText().equals("    -  -  "))){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                Calendar dataCal = Calendar.getInstance();
                Date data = Date.valueOf(txtDataInicial.getText());
                dataCal.setTime(data);
                Exposicao expo = new Exposicao();
                expo.setNome(txtNome.getText());            
                expo.setDataInicio(dataCal);
                if(!ckPermanente.isSelected()){
                    data = Date.valueOf(txtDataFim.getText());
                    dataCal.setTime(data);
                    expo.setDataFim(dataCal);
                    expo.setTipo("TEMPORARIA");
                }
                else{
                    expo.setTipo("PERMANENTE");
                }
                expo = retornarObras(expo);
                expo.setSala(salaGer.consultarSala((int) cbSala.getSelectedItem()));
                ger.registrarExposicao(expo);                
                limparCampos();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
                Logger.getLogger(GerenciarExposicao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCadastrarExpoActionPerformed

    private void btBuscarObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarObraActionPerformed
        // TODO add your handling code here:
        if(txtBuscaObra.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o nome da obra", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                this.obra = acervo.consultarObra(txtBuscaObra.getText());
                switch(this.obra.getStatus()){
                    case EXIBICAO:
                        JOptionPane.showMessageDialog(this, "Obra já esta em exibição!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case RESTAURANDO:
                        JOptionPane.showMessageDialog(this, "Obra esta em restauração!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        txtAutorObra.setText(this.obra.getAutor());
                        txtNomeObra.setText(this.obra.getNome());
                        txtTipoObra.setText(this.obra.getClassificacao().toString());
                        btAdicionarObra.setEnabled(true);
                    break;
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(GerenciarExposicao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Obra não encontrada!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btBuscarObraActionPerformed

    private void btAdicionarObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarObraActionPerformed
        // TODO add your handling code here:        
        DefaultTableModel model = (DefaultTableModel) tbObras.getModel();
        model.addRow(new Object[]{obra.getNome(), obra.getAutor(),obra.getClassificacao().toString()});
        tbObras.setModel(model);
        
    }//GEN-LAST:event_btAdicionarObraActionPerformed

    private void ckPermanenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckPermanenteActionPerformed
        // TODO add your handling code here:
        if(!ckPermanente.isSelected()){
            lbDataFim.setVisible(true);
            txtDataFim.setVisible(true);
        }
        else{
            lbDataFim.setVisible(false);
            txtDataFim.setVisible(false);
        }
    }//GEN-LAST:event_ckPermanenteActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btAlterarExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarExpoActionPerformed
        // TODO add your handling code here:
        if(txtNome.getText().equals("") || txtDataInicial.getText().equals("    -  -  ") 
                || (!ckPermanente.isSelected() && txtDataFim.getText().equals("    -  -  "))){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                Calendar dataCal = Calendar.getInstance();
                Date data = Date.valueOf(txtDataInicial.getText());
                dataCal.setTime(data);
                Exposicao expo = new Exposicao();
                expo.setNome(txtNome.getText());            
                expo.setDataInicio(dataCal);
                if(!ckPermanente.isSelected()){
                    data = Date.valueOf(txtDataFim.getText());
                    dataCal.setTime(data);
                    expo.setDataFim(dataCal);
                    expo.setTipo("TEMPORARIA");
                }
                else{
                    expo.setTipo("PERMANENTE");
                }
                expo = this.retornarObras(expo);
                
                expo.setSala(salaGer.consultarSala((int) cbSala.getSelectedItem()));
                ger.atualizarExposicao(expo, nomeAntigo);
                limparCampos();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
                Logger.getLogger(GerenciarExposicao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btAlterarExpoActionPerformed

    private void btExcluirExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirExpoActionPerformed
        // TODO add your handling code here:
        int opc = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse registro?", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        if(opc==JOptionPane.YES_OPTION){
            try {
                ger.excluirExposicao(nomeAntigo);
                JOptionPane.showMessageDialog(this, "Removido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Exposição não encontrada!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(CadastroAcervo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btExcluirExpoActionPerformed

    private void cbSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSalaActionPerformed
        try {
            // TODO add your handling code here:
            Sala sala = salaGer.consultarSala((int) cbSala.getSelectedItem());
            lbLotacao.setText("Lotação: "+sala.getQtdVisitantes());
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            Logger.getLogger(GerenciarExposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarObra;
    private javax.swing.JButton btAlterarExpo;
    private javax.swing.JButton btBuscarExpo;
    private javax.swing.JButton btBuscarObra;
    private javax.swing.JButton btCadastrarExpo;
    private javax.swing.JButton btExcluirExpo;
    private javax.swing.JButton btLimpar;
    private javax.swing.JComboBox<String> cbSala;
    private javax.swing.JCheckBox ckPermanente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbDataFim;
    private javax.swing.JLabel lbLotacao;
    private javax.swing.JTable tbObras;
    private javax.swing.JTextField txtAutorObra;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtBuscaObra;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeObra;
    private javax.swing.JTextField txtTipoObra;
    // End of variables declaration//GEN-END:variables
}
