public class Cobertura {
    private String tipoCobertura;
    private String nomeCobertura;
    private double valor;

    public Cobertura(String tipoCobertura, String nomeCobertura) {
        this.tipoCobertura = tipoCobertura;
        this.nomeCobertura = nomeCobertura;
        this.valor = 0;
    }

    public String getNomeCobertura() {
        return nomeCobertura;
    }

    public void setNomeCobertura(String nomeCobertura) {
        this.nomeCobertura = nomeCobertura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public String toString(Segurado segurado){
        return tipoCobertura + ":\n" +
                " - Nome: " + nomeCobertura +
                " - Valor: " + valor;
    }

    @Override
    public String toString() {
        return tipoCobertura + ":\n" +
                " - Nome: " + nomeCobertura;
//                " - Valor: " + valor;
    }
}
