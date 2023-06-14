package com.alex.teste.cardview.model;

import android.widget.ImageView;

public class Postagem {

    public String autor;
    public String descricao;
    public int imagem;

    public Postagem(){
    }

    public Postagem(String autor, String descricao, int imagem) {
        this.autor = autor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
