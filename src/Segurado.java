import java.util.ArrayList;

public class Segurado {
    private String nome;
    private String pf_pj;
    private String dataNascimento;
    private String endereco;
    private String cep;
    private ArrayList<Seguro> listaDeSeguros;

    public Segurado(String nome, String pf_pj, String dataNascimento, String endereco, String cep) {
        this.nome = nome;
        this.pf_pj = pf_pj;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.listaDeSeguros = new ArrayList<Seguro>();
    }

    public void novoSeguro(Seguro novoSeguro){
        listaDeSeguros.add(novoSeguro);
    }

    public void excluirSeguro(Seguro seguro){
        listaDeSeguros.remove(seguro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPf_pj() {
        return pf_pj;
    }

    public void setPf_pj(String pf_pj) {
        this.pf_pj = pf_pj;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String printSeguros(){
        if(listaDeSeguros.isEmpty()){
            return "Nenhum seguro vigente.";
        }else{
            String string = "Seguros: \n";
            for (int i = 0; i < listaDeSeguros.size(); i++) {
                string += i + " - " + listaDeSeguros.get(i).getTipo() +
                        "\nVencimento: " + listaDeSeguros.get(i).getDataFinalVigencia() + "\n";
            }
            return string;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "CPF/CNPJ: " + pf_pj + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "Endereço: " + endereco + "\n" +
                "CEP: " + cep + "\n" + printSeguros() + "\n";


    }
}
