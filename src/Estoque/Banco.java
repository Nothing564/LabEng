/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Banco {
    
    private String usuario, senha,servidor, banco;
    private int porta;
    private Connection conexao = null;
    private Statement stm;
    private ResultSet rs;
    
    
    
    
    
    
    
    
    
    /*********************CONSTRUTORES*********************/

    public Banco(String usuario, String senha, String servidor, String banco, int porta) {
        this.usuario = usuario;
        this.senha = senha;
        this.servidor = servidor;
        this.banco = banco;
        this.porta = porta;
    }
    
    
    /*************FUNÇÕES  GERAIS DA CLASSE********************/
    
    
    public void abrir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conexao =  DriverManager.getConnection("jdbc:mysql://"+getServidor()+":"+getPorta()+"/"+getBanco(),
                        getUsuario(),getSenha());
            } catch (SQLException ex) {
                ex.printStackTrace();
                conexao = null;
            }
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
           conexao=null;
        }
    }
    
    
    public int atualizar(String sql){
        try {
            Statement stm = getConexao().createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    
    public void fechar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void executaSQL(String sql) {
        try {       
            stm = conexao.createStatement();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Erro no BancoFactory \nERRO: " + ex );
        }
        try {
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no BancoFactory \nERRO: " + ex );
        }
    }
    
    /****************GETTER E SETTER *************************/

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
