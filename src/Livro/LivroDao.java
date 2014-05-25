/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Livro;

import Livro.LivroVO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

/**
 * DAO para a tabela de livros.
 * @author Guilherme
 */
public class LivroDao implements DAO<LivroVO>{
    SessionFactory sessionFactory;
    
    /**
     * Construtora para iniciar a sessão no hibernarte
     */
    public LivroDao(){
        sessionFactory = new Configuration().addClass(LivroVO.class)
                                            .buildSessionFactory();
    }

/**
 * Pesquisa livro por critério. Se o critério for null, o método retorna uma lista com a tabela toda.
 * @param criterio
 * @return lista de livros no estoque.
 * @throws SQLException 
 */
    @Override
    public List listar(String criterio) throws SQLException {
        List list = null;
        try{
        Session session = sessionFactory.openSession();
        if(criterio != null)
        list = session.createQuery("FROM livro WHERE "+criterio).list();//  find(criterio);
        else
            list = session.createQuery("FROM livro").list();
        session.flush();
        session.close();
        }catch(Throwable  e){
       throw new SQLException("Erro na listagem de livro: "+e.getCause());
        }
        return list;
    }
/**
 * Insere livro na tabela livro. Serve também para alterar o livro já existente
 * @param obj
 * @return
 * @throws SQLException 
 */
    @Override
    public boolean inserir(LivroVO obj) throws SQLException {
       try{
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(obj);
        session.flush();
        session.close();
        return true;
        }catch(Throwable  e){
       throw new SQLException("Erro na classe EstoqueDao: "+e.getCause());
        }
    }
    
    /**
     * Altera um campo da tabela livro 
     * @param obj
     * @return true, caso a operação seja bem sucessedida
     * @throws SQLException 
     */
    @Override
    public boolean alterar(LivroVO obj) throws SQLException {
        try{
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(obj);
        session.flush();
        session.close();
        return true;
        }catch(Throwable  e){
       throw new SQLException("Erro na classe EstoqueDao: "+e.getCause());
        }
    }
/**
 * Exclui um livro da tabela livro
 * @param obj
 * @return
 * @throws SQLException 
 */
    @Override
    public boolean excluir(LivroVO obj) throws SQLException {
        try{
        Session session = sessionFactory.openSession();
        session.delete(obj);
        session.flush();
        session.close();
        return true;
        }catch(Throwable  e){
       throw new SQLException("Erro na classe EstoqueDao: "+e.getCause());
        }
    }
    
    /**
     * Pesquisa o livro no estoque.
     * @param pk
     * @return livro . Retorna null se o livro não esta listado.
     * @throws SQLException 
     */
    @Override
    public LivroVO pesquisar(int pk) throws SQLException {
        try{
        Session session = sessionFactory.openSession();
        LivroVO livroVO = (LivroVO)session.get(LivroVO.class, pk);
        session.flush();
        session.close();
        return livroVO;
        }catch(Throwable  e){
       throw new SQLException("Erro na classe EstoqueDao: " + e.getCause());
        }
    }
    
}
