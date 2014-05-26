/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estoque;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class InterfaceEstoque extends javax.swing.JFrame {
    String user, pass,sql;
    ArrayList dados = new ArrayList();
   // List rec = new List ();
    String [] colunas = new String[]{"Codigo","Quantidade","Valor","Fornecedor","Data"};
    Banco banco = new Banco("root","","localhost","livrarialabeng",3306);
    Manipular manipular = new Manipular ();
   DaoEstoque estoque = new DaoEstoque();
   //ModeloTabela modelo = new ModeloTabela(dados, colunas);
     DefaultTableModel modelo = new DefaultTableModel();  
    
    public InterfaceEstoque() {
        initComponents();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btInserir.setEnabled(true);
        btConsultar.setEnabled(true);
        modelo.addColumn("Codigo");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor");
        modelo.addColumn("Fornecedor");
        modelo.addColumn("Data");
        try {

            dados=(ArrayList) estoque.listar(null);
            System.out.println(dados.get(0).toString());
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERRO : " + ex);
       }
       //this.preencheTabela("select * from estoque");
    }
    
    public void preencheTabela(String sql){
        int codigo , qtd;
        int i=0;
        float valor;
        String forn, data;
     banco.abrir();
       banco.executaSQL(sql);
        System.out.println("Aqui1");
        
      
         
        tbDados.setModel(modelo);
        try {
            while(banco.getRs().next()){
                codigo=banco.getRs().getInt("Codigo");
                qtd=banco.getRs().getInt("Quantidade");
                valor=banco.getRs().getFloat("Valor");
                forn=banco.getRs().getString("Fornecedor");
                data=banco.getRs().getString("data");  
                modelo.addRow(new Object[]{codigo, qtd, valor, forn, data});  
                System.out.println("Entrou: " + i);
                i++;
            }
            /*try {
              banco.getRs().first();
              System.out.println("Aqui2");
          } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERRO2 : " + ex);
                System.out.println("Aqui3");
          }
          try {
             do{
                 dados.add(new Object[] {banco.getRs().getInt("Codigo"),banco.getRs().getInt("Quantidade"),banco.getRs().getFloat("Valor"),banco.getRs().getString("Fornecedor"),banco.getRs().getString("data")});
              }while(banco.getRs().next());
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"ERRO3 : " + ex);
          }
           
             
            ModeloTabela modelo = new ModeloTabela(dados,colunas);
            System.out.println("Aqui14");
            tbDados.setModel(modelo);
            System.out.println("Aqui15");
            * 
            */
           /*
           
           tbDados.getColumnModel().getColumn(0).setPreferredWidth(40);
           tbDados.getColumnModel().getColumn(0).setResizable(false);
           tbDados.getColumnModel().getColumn(1).setPreferredWidth(155);
           tbDados.getColumnModel().getColumn(1).setResizable(false);
           tbDados.getColumnModel().getColumn(2).setPreferredWidth(160);
           tbDados.getColumnModel().getColumn(2).setResizable(false);
           
            tbDados.getColumnModel().getColumn(3).setPreferredWidth(100);
           tbDados.getColumnModel().getColumn(3).setResizable(false);
           
            tbDados.getColumnModel().getColumn(4).setPreferredWidth(95);
           tbDados.getColumnModel().getColumn(4).setResizable(false);
           
            tbDados.getColumnModel().getColumn(5).setPreferredWidth(85);
           tbDados.getColumnModel().getColumn(5).setResizable(false);
           
           
           tbDados.getTableHeader().setReorderingAllowed(false);
           tbDados.setAutoResizeMode(tbDados.AUTO_RESIZE_OFF);
           tbDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           * 
           * */
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO : " + ex);
        }
    }
  public void verificaTabela (){
    //  if(tbDados.get)
  }
    
//   teste do teste do git
    public int check (){
        user=JOptionPane.showInputDialog("Usuário: ");
        pass=JOptionPane.showInputDialog("Senha: ");
        if(user==null || pass==null){
            
            return 0;
        }
        if(pass.contentEquals("admin") && user.contentEquals("adm")){
            JOptionPane.showMessageDialog(rootPane, "Acesso Permitido", "Autenticação", 2);
            return 1;
        } else{
          //  JOptionPane.showMessageDialog(rootPane, "Acesso Negado", "Erro Na Autenticação", 1);
            return 2;
        }
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
        tbDados = new javax.swing.JTable();
        btConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btInserir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Quantidade", "Valor", "Fornecedor", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbDados.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbDados);
        tbDados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Controle De Estoque");

        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");

        btExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btConsultar)
                .addGap(61, 61, 61)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsultar)
                    .addComponent(btInserir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        
        int retorno;
        retorno=check();
        if(retorno==1)
        manipular.setVisible(true);
        if(retorno==2)
         JOptionPane.showMessageDialog(rootPane, "Somente Usuários Autorizados", "Acesso Negado", 2); 
        if(retorno==0)
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada", "Acesso Negado", 1);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        preencheTabela("select * from estoque");

    }//GEN-LAST:event_btConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceEstoque().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDados;
    // End of variables declaration//GEN-END:variables
}
