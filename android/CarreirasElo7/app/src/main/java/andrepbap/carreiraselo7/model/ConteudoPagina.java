package andrepbap.carreiraselo7.model;

import java.io.Serializable;

public class ConteudoPagina implements Serializable{
    private String tituloCulturas;
    private String textoCulturas;
    private String tituloAreas;
    private String tituloRodape;

    public ConteudoPagina(String tituloCulturas, String textoCulturas, String tituloAreas, String tituloRodape) {
        this.tituloCulturas = tituloCulturas;
        this.textoCulturas = textoCulturas;
        this.tituloAreas = tituloAreas;
        this.tituloRodape = tituloRodape;
    }

    public String getTituloCulturas() {
        return tituloCulturas;
    }

    public void setTituloCulturas(String tituloCulturas) {
        this.tituloCulturas = tituloCulturas;
    }

    public String getTextoCulturas() {
        return textoCulturas;
    }

    public void setTextoCulturas(String textoCulturas) {
        this.textoCulturas = textoCulturas;
    }

    public String getTituloAreas() {
        return tituloAreas;
    }

    public void setTituloAreas(String tituloAreas) {
        this.tituloAreas = tituloAreas;
    }

    public String getTituloRodape() {
        return tituloRodape;
    }

    public void setTituloRodape(String tituloRodape) {
        this.tituloRodape = tituloRodape;
    }
}
