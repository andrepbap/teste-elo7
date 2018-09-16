package andrepbap.carreiraselo7.model;

public class Area {

    private String imagem;
    private String titulo;

    public Area(String imagem, String titulo) {
        this.imagem = imagem;
        this.titulo = titulo;
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
}
