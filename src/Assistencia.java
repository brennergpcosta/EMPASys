public class Assistencia {

    private String nome;
    private Tipo Tipo;

    public Assistencia(String nome, Tipo tipo) {
        this.nome = nome;
        Tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return Tipo;
    }

    public void setTipo(Tipo tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
