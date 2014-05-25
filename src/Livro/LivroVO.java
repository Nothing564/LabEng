/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Livro;

/**
 *
 * @author David
 */
public class LivroVO {
//    private double precoCusto;
    private double precoVenda;
    private String isbn;    
//    private String dataPublicacao;
    private String editora;
//    private String resumo;
//    private String indice;
//    private String formato;
    private String categoria,
                   autor, 
                   titulo;
//    private int codautor;
//    private int codtitulo;
    private int cod;
    private int quantidade;

    /**
     *
     * @return
     */
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     *
     * @param precoVenda
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String getEditora() {
        return editora;
    }

    /**
     *
     * @param editora
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     *
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     *
     */
    public LivroVO(){
        
    }

    /**
     *
     * @return
     */
    public int getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return quantidade de livros em estoque
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade quantidade de livros em estoque
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
