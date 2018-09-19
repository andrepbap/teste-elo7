package andrepbap.carreiraselo7.model;

import java.io.Serializable;

public class Social implements Serializable {
    private String nome;
    private String imagem;
    private String link;

    public Social(String nome, String imagem, String link) {
        this.nome = nome;
        this.imagem = imagem;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
