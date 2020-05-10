import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        //Todo Fazer Métodos da Assistencia
        //Todo Consertar a pesquisa do Tipo

        Dados.getInstance().addTipo("AUTOMOVEL");
        Dados.getInstance().addTipo("RESIDENCIA");
        Dados.getInstance().addTipo("EMPRESA");

        Dados.getInstance().addCobertura("AUTOMOVEL", "DANOS MATERIAS");
        Dados.getInstance().addCobertura("AUTOMOVEL", "DANOS MORAIS");
        Dados.getInstance().addCobertura("AUTOMOVEL", "VIDROS");

        Dados.getInstance().addCobertura("RESIDENCIA", "QUEBRA DE VIDROS");
        Dados.getInstance().addCobertura("RESIDENCIA", "DANOS MORAIS");
        Dados.getInstance().addCobertura("RESIDENCIA", "VIDROS MORAIS");

        Dados.getInstance().addSegurado(
                new Segurado("BRENNER", "117", "27", "SERRANO", "30220"));
        Dados.getInstance().addSegurado(
                new Segurado("BRENO", "222", "13", "SERRA", "20330"));
        Dados.getInstance().addSegurado(
                new Segurado("JOAO", "110", "23", "SERRADO", "33030"));

        menuPrincipal();
    }

    /**
     * Opção 1
     * Criar um novo segurado e salva na listaSegurado
     */
    private static void novoSegurado() {

        System.out.println("\n-- Novo Segurado --");

        System.out.println("Nome: ");
        String nome = s.nextLine();

        System.out.println("CPF/CNPJ: ");
        String pf_pj = s.nextLine();

        System.out.println("Data de nascimento: ");
        String dataNascimento = s.nextLine();

        System.out.println("Endereço: ");
        String endereco = s.nextLine();

        System.out.println("CEP");
        String cep = s.nextLine();

        System.out.println("Salvar? s/n");
        String salvar = s.nextLine();

        if(salvar.equalsIgnoreCase("s")){
            if (Dados.getInstance().addSegurado(new Segurado(nome, pf_pj, dataNascimento, endereco, cep))){
                System.out.println("Novo segurado salvo.");
            }
        }else{
            System.out.println("Nada foi salvo.");
        }
        System.out.println("--------");
    }

    /**
     * Opção 2
     * Editar segurado existente
     */
    private static void editarSegurado() {
        System.out.println("\n-- Editar Segurado --");

        ArrayList<Segurado> lista = new ArrayList<>();

        System.out.println("Pesquisa: ");
        String pesquisa = s.nextLine();
        String nome, pf_pj, dataNasc, ender, cep;

        lista = Dados.getInstance().pesquisaStringSegurado(pesquisa.toUpperCase().trim());
        if(lista == null){
            System.out.println("Nenhum segurado encontrado");
        }else{
            System.out.println("Resultado de pesquisa: ");
            for (int i = 0; i < lista.size(); i++){
                System.out.println(i + " - " +lista.get(i).toString());
            }
            System.out.println("Escolha um segurado: \n(-1 para sair)");
            int e = s.nextInt();
            s.nextLine();
            System.out.println("\n(Mantenha o campo em branco para ");
            if(e > -1 && e < lista.size()){
                lista.get(e).toString();
                //Nome
                System.out.println("Nome atual: " + lista.get(e).getNome());
                System.out.print("Nome: (Mantenha o campo para não mudar) ");
                nome = s.nextLine();
                if(nome.equalsIgnoreCase("")){
                    nome = lista.get(e).getNome();
                }
                //pf_pj
                System.out.println("CPF/CNPJ atual: " + lista.get(e).getPf_pj());
                System.out.print("CPF/CNPJ: (Mantenha o campo para não mudar) ");
                pf_pj = s.nextLine();
                if(pf_pj.equalsIgnoreCase("")){
                    pf_pj = lista.get(e).getNome();
                }
                //dataNasc
                System.out.println("Data de Nascimento atual: " + lista.get(e).getDataNascimento());
                System.out.print("Data de Nascimento: (Mantenha o campo para não mudar) ");
                dataNasc = s.nextLine();
                if(dataNasc.equalsIgnoreCase("")){
                    dataNasc = lista.get(e).getNome();
                }
                //ender
                System.out.println("Endereço atual: " + lista.get(e).getEndereco());
                System.out.print("Endereço: (Mantenha o campo para não mudar) ");
                ender = s.nextLine();
                if(ender.equalsIgnoreCase("")){
                    ender = lista.get(e).getNome();
                }
                //cep
                System.out.println("CEP atual: " + lista.get(e).getCep());
                System.out.print("CEP: (Mantenha o campo para não mudar) ");
                cep = s.nextLine();
                if(cep.equalsIgnoreCase("")){
                    cep = lista.get(e).getNome();
                }

                System.out.print("Confirmar? s/n");
                if(s.nextLine().equalsIgnoreCase("s")){
                    lista.get(e).setNome(nome);
                    lista.get(e).setPf_pj(pf_pj);
                    lista.get(e).setDataNascimento(dataNasc);
                    lista.get(e).setEndereco(ender);
                    lista.get(e).setCep(cep);
                    System.out.println("Segurado editado.");
                }
            }
        }
    }

    /**
     * Opção 3
     * Excluir segurado de listaSegurado
     */
    private static void excluirSegurado() {
        System.out.println("\n-- Excluir Segurado --");
        System.out.print("Pesquisa: ");
        ArrayList<Segurado> segurados = Dados.getInstance().pesquisaStringSegurado(s.nextLine().toUpperCase().trim());System.out.println("Resultado de pesquisa: ");
        for (int i = 0; i < segurados.size(); i++){
            System.out.println(i + " - " +segurados.get(i).toString());
        }
        System.out.println("Escolha um segurado para ser excluido: \n(-1 para cancelar)");
        int e = s.nextInt();
        s.nextLine();

        if(e > -1 && e < segurados.size()){
            segurados.get(e).toString();
            System.out.println(segurados.toString());
            System.out.println("Confirmar? (s/n)");
            if(s.nextLine().equalsIgnoreCase("s")){
                Dados.getInstance().excluirSegurado(segurados.get(e));
                System.out.println("Segurado excluido");
            }else{
                System.out.println("Nada foi feito");
            }
        }
    }

    /**
     * Opção 4
     * Pesquisar e exibir informações de segurado
     */
    private static void pesquisarSegurado() {
        System.out.println("\n-- Pesquisar Segurado --");
        ArrayList<Segurado> segurados = buscarSegurado();
        if(!segurados.isEmpty()){
            for (Segurado segurado : segurados){
                System.out.println(segurado.toString());
            }
        }else{
            System.out.println("Nenhum segurado encontrado");
        }

    }

    private static void novoSeguro() {
        System.out.println("-- Novo Seguro --");
    }

    private static void editarSeguro() {
    }

    private static void excluirSeguro() {
    }

    private static void pesquisarSeguro() {
    }

    private static void adicionarResultadoCotacao() {
    }

    private static void editarResultadoCotacao() {
    }

    private static void excluirResultadoCotacao() {
    }

    /**
     * Opção 32
     * Adicionar novo Tipo
     */
    private static void adicionarTipo() {
        System.out.println("\n-- Adicionar novo Tipo --");
        System.out.print("Nome: ");
        String novoTipoNome = s.nextLine();
        if(Dados.getInstance().pesquisarTipo(novoTipoNome) == null){
            System.out.print("Confirmar novo Tipo? s/n ");
            if(s.nextLine().equalsIgnoreCase("s")){
                Dados.getInstance().addTipo(novoTipoNome.toUpperCase().trim());
            }else{
                System.out.println("Nada foi salvo.");
            }
        }

    }

    public static void editarTipo(){
        System.out.println("\n-- Editar Tipo --\n");
        Dados.getInstance().printTodosTipos();
        System.out.println("\nEscolha um Tipo para ser editado.");
        int escolha = inputIntOpcao(Dados.getInstance().getTiposCopy().size());
        Tipo tipoParaEditar = Dados.getInstance().pesquisarTipo(escolha);
        String novoNome = inputString("Novo Nome:");
        if(inputString("Confirmar? s/n").equalsIgnoreCase("s")){
            if(Dados.getInstance().editarTipo(novoNome, tipoParaEditar)){
                System.out.println("Tipo editado com Sucesso.");
            }else{
                System.out.println("Ocorreu um erro.");
            }
        }else{
            System.out.println("Nada foi feito.");
        }
    }

    public static void excluirTipo(){
        System.out.println("\n-- Excluir Tipo --");
        Dados.getInstance().printTodosTipos();
        System.out.println("\nEscolha um Tipo para ser excluido.");
        int escolha = inputIntOpcao(Dados.getInstance().getTiposCopy().size());
        Tipo tipoParaExcluir = Dados.getInstance().pesquisarTipo(escolha);
        if(inputString("Confirmar? s/n").equalsIgnoreCase("s")){
            Dados.getInstance().excluirTipo(tipoParaExcluir);
            System.out.println("Tipo excluido com sucesso");
        }else{
            System.out.println("Nada foi feito.");
        }
    }

    public static void pesquisarTipo(){
        System.out.println("\n-- Pesquisar Tipo --");
        String pesquisa = inputString("Pesquisa: ");
        ArrayList<Tipo> resultado = Dados.getInstance().pesquisarTipoLista(pesquisa.toUpperCase().trim());
        System.out.println("Resultado da pesquisa: \n");
        if(resultado != null){
            for(Tipo obj : resultado){
                System.out.println(" - " + obj.toString());
            }
        }else{
            System.out.println("Nenhum Tipo encontrado.");
        }

    }
    public static void listarTipo(){
        Dados.getInstance().printTodosTipos();
    }

    /**
     * Opção 31
     * Adicionar nova cobertura
     */
    private static void adicionarCobertura() {
        System.out.println("\n-- Adicionar Cobertura --");
        Dados.getInstance().printTodosTipos();
        System.out.print("Digite o número do tipo de cobertura: ");
        int i;
        while(true){
            try {
                i = s.nextInt();
                s.nextLine();
                break;
            } catch (NumberFormatException e){
                System.out.println("Apenas números!");
            }
        }
        Tipo tipo = Dados.getInstance().pesquisarTipo(i);
        System.out.print("Nome da cobertura: (0 para sair) ");
        while(true){
            String nomeCobertura = s.nextLine();
            if(Dados.getInstance().pesquisaCobertura(tipo.getNome(), nomeCobertura.toUpperCase().trim()) == null){
                Dados.getInstance().addCobertura(tipo.getNome(), nomeCobertura.toUpperCase().trim());
                System.out.println("Cobertura adicionada.");
                break;
            }else if(nomeCobertura.equals("99")){
                System.out.println("Nada foi salvo.");
                break;
            }
        }
    }

    /**
     * Opção 33
     * Editar cobertura existente
     */
    private static void editarCobertura() {
        System.out.println("\n-- Editar Cobertura --");
        Cobertura cobertura = buscarCobertura();
        String novoNome;
        while(true){
            System.out.print("Novo Nome: (deixe em branco para manter)");
            novoNome = s.nextLine();
            novoNome = novoNome.toUpperCase().trim();
            if(novoNome.equals("")){
                System.out.println("Nome não foi editado");
                break;
            }
            break;
        }
        int i;
        Dados.getInstance().printTodosTipos();
        System.out.print("Digite o número do tipo de cobertura: (99 para sair) ");
        while(true){
            try {
                i = s.nextInt();
                s.nextLine();
                break;
            } catch (NumberFormatException e){
                System.out.println("Apenas números!");
            }
        }
        Tipo novoTipo = Dados.getInstance().pesquisarTipo(i);
        if (cobertura != null && !novoNome.equals("")) {
            cobertura.setNomeCobertura(novoNome);
            System.out.println("Nome editado");
        }else{
            System.out.println("Nome não foi alterado");
        }
        if (cobertura != null) {
            cobertura.setTipoCobertura(novoTipo.getNome());
            System.out.println("Tipo de cobertura alterado");
        }
    }

    /**
     * Opção 34
     * Excluir cobertura existente
     */
    private static void excluirCobertura() {
        System.out.println("\n-- Excluir cobertura --");
        Cobertura cobertura = buscarCobertura();
        if(cobertura != null){
            System.out.print("Confirmar? s/n ");
            String confimar = s.nextLine();
            if(confimar.equalsIgnoreCase("s")){
                Dados.getInstance().removeCobertura(cobertura);
                System.out.println("Cobertura removida.");
            }else{
                System.out.println("Nada foi feito.");
            }
        }
    }

    /**
     * Opção 35
     * Excluir tipo de cobertura existente
     */
    public static void excluirTipoCobertura(){
        System.out.println("\n-- Excluir tipo de cobertura --");
        Tipo tipo = Dados.getInstance().pesquisarTipo(s.nextLine().toUpperCase().trim());
        if(tipo != null){
            System.out.println("Tipo de combertura encontrado. ");
            System.out.println("ATENÇÃO! AO REMOVER UM TIPO DE COBERTURA, TODAS AS COBERTURAS ASSOCIADAS A ESSE\n" +
                                    "TIPO TAMBÉM SERÃO EXCLUIDAS.");
            System.out.print("Confirmar exclusão? s/n ");
            String confimar = s.nextLine();
            if(confimar.equalsIgnoreCase("s")){
                Dados.getInstance().excluirTipo(tipo);
                System.out.println("Cobertura removida.");
            }else{
                System.out.println("Nada foi feito.");
            }
        }else{
            System.out.println("Tipo de cobertura não encontrado");
        }
    }

    /**
     * Opção 36
     * Pesquisar e mostrar informações de cobertura
     */
    private static void pesquisarCobertura() {
        System.out.println("\n-- Pesquisa de Cobertura --");
        while (true){
            System.out.print("(Digite 'sair' para sair)\nPesquisa de Cobertura: ");
            String pesquisa = s.nextLine();
            if(pesquisa.equalsIgnoreCase("sair")){
                break;
            }
            ArrayList<Cobertura> resultado = Dados.getInstance().pesquisaCobertura(pesquisa.toUpperCase().trim());
            if(resultado.size() == 0){
                System.out.println("Nenhuma cobertura encontrada");
            }else {
                System.out.println("Mais de um resultado encontrado, escolha um: ");
                for (int i = 0; i < resultado.size(); i++) {
                    System.out.println(i + " - Tipo: " + resultado.get(i).getTipoCobertura() +
                            " | Nome: " + resultado.get(i).getNomeCobertura());
                }
            }
        }
    }

    /**
     * Opção 37
     * Listar coberturas existentes
     */
    private static void listarCoberturas() {
        System.out.println("\n1 - Listar Coberturas");
        System.out.println("2 - Listar Tipos de coberturas");
        System.out.print("Opção: (0 para cancelar) ");
        while(true){
            String choice = s.nextLine();
            if(choice.equals("1")){
                Dados.getInstance().printTodasCoberturas();
                break;
            }
            if(choice.equals("2")){
                Dados.getInstance().printTodosTipos();
                break;
            }
            if(choice.equals("0")){
                System.out.println("Nada foi feito");
                break;
            }
            System.out.println("Opção inválida. Escolha 1, 2 ou 0");
            System.out.print("Opção: ");
        }

    }

    /**
     * Criar nova Assistencia
     */
    public static void novaAssistencia(){
        System.out.println("\n-- Nova Assistencia --");

        System.out.print("Nome: ");
        while(true){
            String nome = s.nextLine().toUpperCase().trim();
            if(nome.isEmpty()){
                System.out.println("Nome não pode ser vazio");
            }else{
                break;
            }
        }
        Dados.getInstance().printTodosTipos();
        System.out.println("Escolha o tipo da Assistência.");
        int escolha = s.nextInt();
        s.nextLine();
    }

    /**
     * Editar Assistencia existente
     */
    public static void editarAssistencia(){
        System.out.println("\n-- Editar Assistência --");

        String pesquisa = inputString("Pesquisa: ");
        ArrayList<Assistencia> resultado = Dados.getInstance().pesquisarAssistenciaPeloNome(pesquisa);

        if(resultado != null){
            for (int i = 0; i < resultado.size(); i++) {
                
            }
        }

        System.out.println("Deixe o campo em branco para não altera-lo");
        String novoNome = inputString("Novo nome: ");

    }

    /**
     * Excluir Assistencia
     */
    public static void excluirAssistencia(){

    }

    /**
     * Pesquisar Assistencia, se existir mais de um resultado, mostrará todos os resultados obtidos que o usuário
     *      deverá escolher um. As informações do resultado escolhido serão mostradas.
     */
    public static void pesquisarAssistencia(){

    }

    /**
     * Pergutará ao usuário se deseja mostrar todas as assistencia de um Tipo ou mostrar todas as assistencias
     *      existentes e separadas por tipo.
     */
    public static void listarAssistencia(){

    }

    private static ArrayList<Segurado> buscarSegurado(){
        System.out.print("\nPesquisa: ");
        return Dados.getInstance().pesquisaStringSegurado(s.nextLine().toUpperCase().trim());
    }

    private static Cobertura buscarCobertura(){
        System.out.print("\nPesquisa de Cobertura: ");
        int escolha;
        String pesquisa = s.nextLine();
        ArrayList<Cobertura> resultado = Dados.getInstance().pesquisaCobertura(pesquisa.toUpperCase().trim());
        if(resultado.size() == 0){
            System.out.println("Nenhuma cobertura encontrada");
            return null;
        }else if(resultado.size() == 1){
            return resultado.get(0);
        }else{
            System.out.println("Mais de um resultado encontrado, escolha um: ");
            for (int i = 0; i < resultado.size(); i++) {
                    System.out.println(i + " - Tipo: " + resultado.get(i).getTipoCobertura()+
                                            " | Nome: " + resultado.get(i).getNomeCobertura());
            }
            System.out.print("Opção: ");
            escolha = s.nextInt();
            s.nextLine();
            return resultado.get(escolha);
        }
    }

    private static String inputString(String pergunta){
        System.out.print(pergunta);
        return s.nextLine();
    }

    private static int inputIntOpcao(int maiorNumbero){
        System.out.print("Opção: ");
        int escolha;
        while(true){
            escolha = s.nextInt();
            s.nextLine();
            if(escolha >= 0 && escolha <= maiorNumbero){
                return escolha;
            }else{
                System.out.println("Somente números de 0 à " + maiorNumbero);
            }
        }
    }

    /**
     * //-------------------------- MENU PRINCIPAL E SUBMENUS --------------------------//
     */

    /**
     * Menu Principal da aplicação
     *      - Lista todos os Submenus
     */
    public static void menuPrincipal(){
        boolean sair = false;
        int choice;

        while(!sair) {
            System.out.println("--------------------------");
            System.out.println("\n----- Menu Principal -----");

            System.out.println("1 - Segurado");
            System.out.println("2 - Seguro");
            System.out.println("3 - Cotação");
            System.out.println("4 - Tipo");
            System.out.println("5 - Cobertura");
            System.out.println("6 - Assistencia");
            System.out.println("0 - Fechar Aplicação");

            System.out.print("Opção: ");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    subMenuSegurado();
                    break;
                case 2:
                    subMenuSeguro();
                    break;
                case 3:
                    subMenuCotacao();
                    break;
                case 4:
                    subMenuTipo();
                    break;
                case 5:
                    subMenuCobertura();
                    break;
                case 6:
                    subMenuAssistencia();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuSegurado(){
        boolean voltar = false;
        int choice;

        while(!voltar){
            System.out.println("\n-- Segurado --");
            System.out.println("1 - Novo segurado");
            System.out.println("2 - Editar segurado");
            System.out.println("3 - Excluir segurado");
            System.out.println("4 - Pesquisar segurado");
            System.out.println("0 - Voltar");
            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    novoSegurado();
                    break;
                case 2:
                    editarSegurado();
                    break;
                case 3:
                    excluirSegurado();
                    break;
                case 4:
                    pesquisarSegurado();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuSeguro(){
        boolean voltar = false;
        int choice;

        while(!voltar){
            System.out.println("\n-- Seguro --");

            System.out.println("1 - Novo seguro");
            System.out.println("2 - Editar seguro");
            System.out.println("3 - Excluir seguro");
            System.out.println("4 - Pesquisar seguro");
            choice = s.nextInt();
            s.nextLine();

            switch(choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    novoSeguro();
                    break;
                case 2:
                    editarSeguro();
                    break;
                case 3:
                    excluirSeguro();
                    break;
                case 4:
                    pesquisarSeguro();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuCotacao(){
        boolean voltar = false;
        int choice;

        while (!voltar){
            System.out.println("\n-- Cotação --");

            System.out.println("1 - Adicionar resultados de cotação");
            System.out.println("2 - Editar resultado de cotação");
            System.out.println("3 - Excluir resultado de cotação");
            System.out.println("0 - Voltar");
            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    adicionarResultadoCotacao();
                    break;
                case 2:
                    editarResultadoCotacao();
                    break;
                case 3:
                    excluirResultadoCotacao();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuTipo(){
        boolean voltar = false;
        int choice;

        while(!voltar){
            System.out.println("\n-- Tipo --");

            System.out.println("1 - Adicionar Tipo");
            System.out.println("2 - Editar Tipo");
            System.out.println("3 - Excluir Tipo");
            System.out.println("4 - Pesquisar Tipo");
            System.out.println("5 - Listar Tipo");
            System.out.println("0 - Voltar");
            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    adicionarTipo();
                case 2:
                    editarTipo();
                    break;
                case 3:
                    excluirTipo();
                    break;
                case 4:
                    pesquisarTipo();
                    break;
                case 5:
                    listarTipo();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuCobertura(){
        boolean voltar = false;
        int choice;

        while(!voltar){
            System.out.println("\n-- Cobertura --");

            System.out.println("1 - Adicionar Cobertura");
            System.out.println("2 - Editar Cobertura");
            System.out.println("3 - Excluir Cobertura");
            System.out.println("4 - Pesquisar Cobertura");
            System.out.println("5 - Listar Coberturas");
            System.out.println("0 - Voltar");
            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    adicionarCobertura();
                    break;
                case 3:
                    editarCobertura();
                    break;
                case 4:
                    excluirCobertura();
                    break;
                case 5:
                    pesquisarCobertura();
                    break;
                case 6:
                    listarCoberturas();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    public static void subMenuAssistencia(){
        boolean voltar = false;
        int choice;

        while (!voltar){
            System.out.println("\n-- Assistência --");
            System.out.println("1 - Nova Assistencia");
            System.out.println("2 - Editar Assistência");
            System.out.println("3 - Excluir Assistência");
            System.out.println("4 - Pesquisar Assistência");
            System.out.println("5 - Lista Assistências");
            System.out.println("0 - Voltar");

            choice = s.nextInt();
            s.nextLine();

            switch (choice){
                case 0:
                    voltar = true;
                    break;
                case 1:
                    novaAssistencia();
                    break;
                case 2:
                    editarAssistencia();
                    break;
                case 3:
                    excluirAssistencia();
                    break;
                case 4:
                    pesquisarAssistencia();
                    break;
                case 5:
                    listarAssistencia();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}
