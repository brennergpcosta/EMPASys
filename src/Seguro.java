import java.util.ArrayList;

public class Seguro {
    private Tipo tipo;
    private Segurado segurado;
    private Segurado utilizador;
    private ArrayList<objetoSegurado> objetoSegurado;
    private int bonus;
    private int sinistro;
    private String dataInicialVigencia;
    private String dataFinalVigencia;
    private ArrayList<Cobertura> coberturas;
    private ArrayList<Cotacao> cotacoes;

    public Seguro(Tipo tipo, Segurado segurado, Segurado utilizador, ArrayList<objetoSegurado> objetoSegurado,
                  int bonus, int sinistro, String dataInicialVigencia, String dataFinalVigencia,
                  ArrayList<Cobertura> coberturas, ArrayList<Cotacao> cotacoes) {
        this.tipo = tipo;
        this.segurado = segurado;
        this.utilizador = utilizador;
        this.objetoSegurado = objetoSegurado;
        this.bonus = bonus;
        this.sinistro = sinistro;
        this.dataInicialVigencia = dataInicialVigencia;
        this.dataFinalVigencia = dataFinalVigencia;
        this.coberturas = coberturas;
        this.cotacoes = cotacoes;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Segurado getSegurado() {
        return segurado;
    }

    public void setSegurado(Segurado segurado) {
        this.segurado = segurado;
    }

    public Segurado getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Segurado utilizador) {
        this.utilizador = utilizador;
    }

    public ArrayList<objetoSegurado> getObjetoSegurado() {
        return objetoSegurado;
    }

    public void setObjetoSegurado(ArrayList<objetoSegurado> objetoSegurado) {
        this.objetoSegurado = objetoSegurado;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSinistro() {
        return sinistro;
    }

    public void setSinistro(int sinistro) {
        this.sinistro = sinistro;
    }

    public String getDataInicialVigencia() {
        return dataInicialVigencia;
    }

    public void setDataInicialVigencia(String dataInicialVigencia) {
        this.dataInicialVigencia = dataInicialVigencia;
    }

    public String getDataFinalVigencia() {
        return dataFinalVigencia;
    }

    public void setDataFinalVigencia(String dataFinalVigencia) {
        this.dataFinalVigencia = dataFinalVigencia;
    }

    public ArrayList<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(ArrayList<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public ArrayList<Cotacao> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(ArrayList<Cotacao> cotacoes) {
        this.cotacoes = cotacoes;
    }
}
