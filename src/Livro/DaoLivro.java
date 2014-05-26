/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Livro;

import Estoque.Banco;
import Estoque.Estoque;
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
public class DaoLivro implements DAO {
    
    PreparedStatement pstm = null;
    Statement stm = null;
    Banco banco =null;
    ResultSet rs = null;
    String sql = null;


    @Override
    public boolean inserir(Object obj) throws SQLException {
              
    LivroVO livro = new LivroVO();
    if(obj instanceof Estoque)
        livro=(LivroVO) obj;
    else{
            System.out.println("Objetos Incompativeis");
            return false;
    }
        String sql="INSERT INTO livro (Codlivro, isbn , qtd, titulo, autor, categoria, ValorUnit)"+
                "VALUES (?,?,?,?,?,?)";
     
        banco.abrir();
        pstm=banco.getConexao().prepareStatement(sql);
        pstm.setInt(1,livro.getCod());
        pstm.setString(2, livro.getIsbn());
        pstm.setFloat(3, livro.getQuantidade());
        pstm.setString(4, livro.getTitulo());
        pstm.setString(5, livro.getAutor());
        pstm.setString(6, livro.getCategoria());
        pstm.setDouble(7, livro.getPrecoVenda());
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
         LivroVO estoque;
        
        if(obj instanceof Estoque)
            estoque =(LivroVO)obj;
        else
        return false;
        
        sql= " UPDATE estoque  SET CodLivro = "+estoque.getCod()+ ", isbn = '"+ estoque.getIsbn()+"' , qtd = "+
                estoque.getQuantidade()+", titulo ='"+ estoque.getTitulo() +"', autor='"+estoque.getAutor()+"',categoria= '"
                +estoque.getCategoria()+"', ValorUnit ="+estoque.getPrecoVenda() +" WHERE codigo="+
                estoque.getCod()+"";
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
        LivroVO estoque;
        
        if(obj instanceof LivroVO)
            estoque =(LivroVO)obj;
        else{ System.out.println("Objetos Incompativeis");
            return false;
        }
        
        sql = "DELETE FROM livro WHERE Codigo = "+estoque.getCod();
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
       LivroVO cli = null;                
        sql= "SELECT * FROM livro WHERE CodLivro =" + pk; // ow fazer por id sql= "select * from cliente where id="+id;
        banco.abrir();
        stm = banco.getConexao().createStatement();
        rs = stm.executeQuery(sql);
        if(rs.next()){
            cli = new LivroVO();
            cli.setCod(rs.getInt("CodLivro"));
            cli.setIsbn(rs.getString("isbn"));
            cli.setQuantidade(rs.getInt("qtd"));
            cli.setTitulo(rs.getString("titulo"));
            cli.setAutor(rs.getString("autor"));   
            cli.setCategoria(rs.getString("categoria"));
            cli.setPrecoVenda(rs.getFloat("ValorUnit"));
        }
        rs.close();
        banco.fechar();
        return cli; 
    }

    @Override
    public List listar(String criterio) throws SQLException {
      LivroVO cli = null;
        Vector lista = new Vector <LivroVO>();
        if(criterio.isEmpty()){
            sql= "SELECT * FROM livro";
            } else{
            sql= "SELECT * FROM estoque WHERE = " + criterio;
            banco.abrir();
            stm = banco.getConexao().createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
            cli = new LivroVO();
            cli.setCod(rs.getInt("CodLivro"));
            cli.setIsbn(rs.getString("isbn"));
            cli.setQuantidade(rs.getInt("qtd"));
            cli.setTitulo(rs.getString("titulo"));
            cli.setAutor(rs.getString("autor"));   
            cli.setCategoria(rs.getString("categoria"));
            cli.setPrecoVenda(rs.getFloat("ValorUnit"));
            lista.add(cli);
            }
            rs.close();
            banco.fechar();
            return lista;
        }
      return null; 
    }
    
}
