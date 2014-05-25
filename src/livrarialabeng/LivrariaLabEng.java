/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package livrarialabeng;

import Estoque.InterfaceEstoque;
import Vendas.FormVenda;

/**
 *
 * @author David
 */
public class LivrariaLabEng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FormVenda venda = new FormVenda();
        //venda.setVisible(true);
        InterfaceEstoque in = new InterfaceEstoque();
        in.setVisible(true);
    }
    
}
