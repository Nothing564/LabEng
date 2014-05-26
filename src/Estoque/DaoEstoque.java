/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estoque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Victor
 */
public class DaoEstoque implements DAO {
    
    PreparedStatement pstm = null;
    Statement stm = null;
    Banco banco =null;
    ResultSet rs = null;
    String sql = null;
    


    @Override
    public boolean inserir(Object obj) throws SQLException {
         
    Estoque estoque = new Estoque();
    if(obj instanceof Estoque)
        estoque=(Estoque) obj;
    else{
            System.out.println("Objetos Incompativeis");
            return false;
    }
        String sql="INSERT INTO estoque (Codigo, Quantidade, Valor, Fornecedor, data)"+
                "VALUES (?,?,?,?,?)";
     
        banco.abrir();
        pstm=banco.getConexao().prepareStatement(sql);
        pstm.setInt(1,estoque.getCodigo());
        pstm.setInt(2, estoque.getQuantidade());
        pstm.setFloat(3, estoque.getValor());
        pstm.setString(4, estoque.getFornecedor());
        pstm.setString(5, estoque.getData());
        if(pstm.executeUpdate()==0){
            banco.fechar();
            return false;
            
        }
        else{
            banco.fechar();
            return true;
            
        }
    }

    @Override
    public boolean alterar(Object obj) throws SQLException {
        Estoque estoque;
        
        if(obj instanceof Estoque)
            estoque =(Estoque)obj;
        else
        return false;
        
        sql= " UPDATE estoque  SET codigo = "+estoque.getCodigo()+ ", Quantidade = "+ estoque.getQuantidade()+ ", Valor = "+
                estoque.getValor()+", Fornecedor ='"+ estoque.getFornecedor() +"', data='"+estoque.getData()+"' WHERE codigo="+
                estoque.getCodigo()+"";
        banco.abrir();
        stm = banco.getConexao().prepareStatement(sql);
         if(stm.executeUpdate(sql)>0){
            banco.fechar();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Estoque estoque;
        
        if(obj instanceof Estoque)
            estoque =(Estoque)obj;
        else{ System.out.println("Objetos Incompativeis");
            return false;
        }
        
        sql = "DELETE FROM estoque WHERE Codigo = "+estoque.getCodigo();
        banco.abrir();
        stm=banco.getConexao().prepareStatement(sql);
         if(stm.executeUpdate(sql)>0){
            banco.fechar();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object pesquisar(int pk) throws SQLException {
        Estoque cli = null;                
        sql= "SELECT * FROM estoque WHERE Codigo =" + pk; // ow fazer por id sql= "select * from cliente where id="+id;
        banco.abrir();
        stm = banco.getConexao().createStatement();
        rs = stm.executeQuery(sql);
        if(rs.next()){
            cli = new Estoque();
            cli.setCodigo(rs.getInt("codigo"));
            cli.setQuantidade(rs.getInt("Quantidade"));
            cli.setValor(rs.getFloat("Valor"));
            cli.setFornecedor(rs.getString("Fornecedor"));
            cli.setData(rs.getString("data"));      
        }
        rs.close();
        banco.fechar();
        return cli;    
    }
    

    @Override
    public List listar(String criterio) throws SQLException {
        Estoque cli = null;
        Vector lista = new Vector <Estoque>();
        if(criterio == null){
            sql= "SELECT * FROM estoque";
            } else{
            sql= "SELECT * FROM estoque WHERE = " + criterio;
            }
            banco.abrir();
            stm = banco.getConexao().createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
            cli = new Estoque();
            cli.setCodigo(rs.getInt("Codigo"));
            cli.setQuantidade(rs.getInt("Quantidade"));
            cli.setValor(rs.getFloat("Valor"));
            cli.setFornecedor(rs.getString("Fornecedor"));
            cli.setData(rs.getString("Data"));
            lista.add(cli);
            }
            rs.close();
            banco.fechar();
            return lista;
        
//      return null; 
    }
    
    
    
}
