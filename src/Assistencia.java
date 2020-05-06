public class Assistencia {

    private String nome;
    private Tipo tipo;

    public Assistencia(String nome, Tipo tipo) {
        this.nome = nome;
        tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
