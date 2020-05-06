import java.util.ArrayList;

public class Dados {

    private static Dados dadosInstance;

    private ArrayList<Seguro> listaSeguro = new ArrayList<>();
    private ArrayList<Cobertura> listaCobertura = new ArrayList<>();
    private ArrayList<Assistencia> listaAssistencias = new ArrayList<>();
    private ArrayList<Tipo> listaTipos = new ArrayList<>();
    private ArrayList<Cotacao> listaCotacoes = new ArrayList<>();
    private ArrayList<objetoSegurado> objetoSegurado = new ArrayList<>();
    private ArrayList<Segurado> listaSegurado = new ArrayList<>();
    private ArrayList<Seguradora> listaSeguradora = new ArrayList<>();

    /**
     * Contrutor privado
     */
    private Dados(){}

    /**
     * Segurado
     */

    public boolean addSegurado(Segurado novoSegurado){
        for (Segurado obj : listaSegurado){
            if(obj == novoSegurado){
                return false;
            }
        }
        listaSegurado.add(novoSegurado);
        return true;
    }

    public ArrayList<Segurado> pesquisaStringSegurado(String pesquisa){
        ArrayList<Segurado> listaResult = new ArrayList<>();
        for (Segurado segurado : listaSegurado){
            if (segurado.getCep().contains(pesquisa) ||
                    segurado.getDataNascimento().contains(pesquisa) ||
                    segurado.getEndereco().contains(pesquisa) ||
                    segurado.getNome().contains(pesquisa) ||
                    segurado.getPf_pj().contains(pesquisa)
            ) {
                listaResult.add(segurado);
            }
        }
        if(listaResult.isEmpty()){
            return null;
        }
        return listaResult;
    }

//    public boolean listaEditaSegurado(Segurado seguradoEditado){
//        for (Segurado obj : listaSegurado){
//            if (obj == seguradoEditado){
//                obj.setNome();
//                obj.setPf_pj(pf_pj);
//                obj.setDataNascimento(dataNasc);
//                obj.setEndereco(ender);
//                obj.setCep(cep);
//                return true;
//            }
//        }
//        return false;
//    }

    public void listaSubstituirSegurado(Segurado oldSegurado, Segurado newSegurado){
        for (Segurado obj : listaSegurado){
            if (obj == oldSegurado){
                listaSegurado.set(listaSegurado.indexOf(obj), newSegurado);
                break;
            }
        }
    }

    public void excluirSegurado(Segurado segurado){
        listaSegurado.remove(segurado);
    }

    /**
     * Cobertura
     */

    public boolean addCobertura(String tipo, String nome){
        nome = nome.trim().toUpperCase();
        for (Cobertura obj : listaCobertura){
            if(obj.getNomeCobertura().equals(nome) && obj.getTipoCobertura().equals(tipo)){
                return false;
            }
        }
        listaCobertura.add(new Cobertura(tipo, nome));
        return true;
    }

    public void removeCobertura(Cobertura cobertura){
        listaCobertura.remove(cobertura);
    }

    public void editaCobertura(Cobertura cobertura, String nome, String tipoCobertura){
        if(!nome.trim().equals("")){
            cobertura.setNomeCobertura(nome);
        }
        if(!tipoCobertura.equals("")){
            cobertura.setTipoCobertura(tipoCobertura);
        }
    }

    public Cobertura pesquisaCobertura(String tipo, String nome){
        for (Cobertura obj : listaCobertura){
            if(obj.getNomeCobertura().equals(nome) && obj.getTipoCobertura().equals(tipo)){
                return obj;
            }
        }
        return null;
    }

    public ArrayList<Cobertura> pesquisaCobertura(String pesquisa){
        ArrayList<Cobertura> resultado = new ArrayList<>();
        for (Cobertura obj : listaCobertura){
            if(obj.getNomeCobertura().contains(pesquisa) || obj.getTipoCobertura().contains(pesquisa)){
                resultado.add(obj);
            }
        }
        return resultado;
    }

    public ArrayList<Cobertura> pesquisaCoberturaPorTipo(String tipoCobertura){
        ArrayList<Cobertura> resultado = new ArrayList<>();
        for(Cobertura cobertura : listaCobertura){
            if (cobertura.getTipoCobertura().equalsIgnoreCase(tipoCobertura)) {
                resultado.add(cobertura);
            }
        }
        if(resultado.isEmpty()){
            return null;
        }
        return resultado;
    }

    public void printTodasCoberturas(){
        System.out.println("Todas as Coberturas");
        if(listaTipos.size() == 0){
            System.out.println("Não há nenhuma cobertura cadastrada.");
        }
        for (Tipo tipo : listaTipos){
            System.out.println(tipo.toString() + ":");
            for (int i = 0; i < listaCobertura.size(); i++) {
                if(listaCobertura.get(i).getTipoCobertura().equalsIgnoreCase(tipo.getNome())){
                    System.out.println(i + " - " + listaCobertura.get(i).getNomeCobertura());
                }
            }
        }
    }

    /**
     * Tipo de Cobertura
     */

    public boolean addTipoCobertura(String tipo){
        tipo = tipo.trim().toUpperCase();
        for (Tipo obj : listaTipos){
            if(obj.equals(tipo)){
                return false;
            }
        }
        listaTipos.add(new Tipo(tipo));
        return true;
    }

    public void removeTipoCobertura(String tipoCobertura){
        listaTipos.remove(tipoCobertura);
    }

    public Tipo pesquisarTipoCobertura(String pesquisa){
        for (Tipo tipo : listaTipos){
            if(tipo.getNome().equalsIgnoreCase(pesquisa)){
                return tipo;
            }
        }
        return null;
    }

    public Tipo pesquisarTipoCobertura(int index){
        return listaTipos.get(index);
    }

    public void printTodosTiposCoberturas(){
        System.out.println("Todos os tipos de coberturas: ");
        if(listaTipos.size() == 0){
            System.out.println("Não há nenhum tipo de cobertura cadastrado.");
        }
        for (int i = 0; i < listaTipos.size(); i++) {
            System.out.println(i + " - " + listaTipos.get(i).toString());
        }
    }

    /**
     * Seguro
     */

    /**
     * Objeto Segurado
     */

    /**
     * Cotação
     */

    public static Dados getInstance(){
        if(dadosInstance == null){
            return dadosInstance = new Dados();
        }
        return dadosInstance;
    }

    public ArrayList<Seguro> getListaSeguroCopy() {
        return new ArrayList<>(listaSeguro);
    }

    public ArrayList<Cobertura> getCoberturasCopy() {
        return new ArrayList<>(listaCobertura);
    }

    public ArrayList<Tipo> getTiposCoberturasCopy() {
        return new ArrayList<>(listaTipos);
    }

    public ArrayList<Cotacao> getCotacoesCopy() {
        return new ArrayList<>(listaCotacoes);
    }

    public ArrayList<objetoSegurado> getObjetoSeguradoCopy() {
        return new ArrayList<>(objetoSegurado);
    }

    public ArrayList<Seguradora> getListaSeguradora() {
        return listaSeguradora;
    }
}
