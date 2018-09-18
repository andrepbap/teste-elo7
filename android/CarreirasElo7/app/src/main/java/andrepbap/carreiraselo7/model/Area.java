package andrepbap.carreiraselo7.model;

import java.io.Serializable;

public class Area implements Serializable{

    private String imagem;
    private String titulo;
    private String link;

    public Area(String imagem, String titulo, String link) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.link = link;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
