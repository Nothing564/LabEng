/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estoque;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public interface DAO<tipo> {
    public boolean inserir(tipo obj)throws SQLException;
    public boolean alterar(tipo obj)throws SQLException;
    public boolean excluir(tipo obj)throws SQLException;
    public tipo pesquisar(int pk)throws SQLException;
    public List listar(String criterio)throws SQLException;
}
