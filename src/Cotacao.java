public class Cotacao {

    private String idCotacao;
    private String seguradora;
    private double premio;
    private double franquia;

    public Cotacao(String idCotacao, String seguradora, double premio, double franquia) {
        this.idCotacao = idCotacao;
        this.seguradora = seguradora;
        this.premio = premio;
        this.franquia = franquia;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getFranquia() {
        return franquia;
    }

    public void setFranquia(double franquia) {
        this.franquia = franquia;
    }

    @Override
    public String toString() {
        return seguradora + "\n" +
                "Prêmio: " + premio + " | Fraquia: " + franquia;
    }
}
