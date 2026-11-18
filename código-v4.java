import java.util.Scanner;
import java.util.ArrayList;
import java.util. Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        --------------------------------------------------
        Array Lists
        --------------------------------------------------
        */

        // Parte de Cadastro das Substâncias:
        ArrayList<String> cadastroSubstanciaNome = new ArrayList<>();
        ArrayList<Double> cadastroSubstanciaQuantidade = new ArrayList<>();
        ArrayList<Double> cadastroSubstanciaPrecoMin = new ArrayList<>();
        ArrayList<Integer> cadastroSubstanciaPorcentagemLucro = new ArrayList<>();

        // Parte de Cadastro do cliente:
        ArrayList<String> cadastroClienteNome = new ArrayList<>();
        ArrayList<String> cadastroClienteCpf = new ArrayList<>();
        ArrayList<String> cadastroClienteBairro = new ArrayList<>();
        ArrayList<String> cadastroClienteRua = new ArrayList<>();
        ArrayList<String> cadastroClienteNumero = new ArrayList<>();

        // Cadastro dos pedidos para gerar a nota fiscal:
        ArrayList<String> pedidoClienteCpf = new ArrayList<>();
        ArrayList<String> pedidoMedicoCrm = new ArrayList<>();
        ArrayList<String> pedidoEmbalagemQuatidade = new ArrayList<>();
        ArrayList<String> pedidoSubstancias = new ArrayList<>();
        ArrayList<String> pedidoSubstanciasDosagem = new ArrayList<>();
        ArrayList<String> pedidoeSubstanciasIndex = new ArrayList<>();
        ArrayList<String> pedidoData = new ArrayList<>();

        /*
        --------------------------------------------------
        Variáveis
        --------------------------------------------------
        */

        int tempQuantidadeCapsulas = 0;
        int tempEscolhaSubstancia = 0;
        int tempListar = 1;
        int tempDosagem = 0;
        int tempUnidadeMedida = 0;
        int tempAdicionarSubstancia = 0;
        int tempIndex;
        int tempPorcentagemLucro;
        int tempProcuraCpf;
        int tempCadastroUsuario = 0;
        int tempcadastroClienteBairro = 0;
        int tempcadastroClienteRua = 0;
        int tempcadastroClienteNumero=0;
        String cpfClinte = "";
        String numeroRuaCliente = "";
        String nomeCliente = "";
        String bairroCliente = "";
        String ruaCliente = "";
        String cliente = "";

        double custoTotal = 0;
        double valorLucro = 0;
        double lucroSubstancia = 0;
        double quantidadeTotalMcg;
        double estoqueMcg;
        double precoMinimo;
        double quantidadeEstoque;
        double dosagemMcg;
        double custoSubstancia;
        double valorFinal;


        cadastroSubstanciaNome.addAll(Arrays.asList("Paracetamol", "Dipirona", "Dexametasona", "Loratadina", "Amoxicilina"));

        cadastroSubstanciaQuantidade.addAll(Arrays.asList(1000.0, 500.0, 200.0, 300.0, 400.0));

        cadastroSubstanciaPrecoMin.addAll(Arrays.asList(0.0000004, 0.0000003, 0.00005, 0.00005, 0.000004));

        cadastroSubstanciaPorcentagemLucro.addAll(Arrays.asList(200, 200, 200, 200, 200));

        cadastroClienteCpf.addAll(Arrays.asList("12345678911"));
        cadastroClienteNome.addAll(Arrays.asList("John Rocha"));
        cadastroClienteBairro.addAll(Arrays.asList("Mata Verde"));
        cadastroClienteRua.addAll(Arrays.asList("Rua das Flores"));
        cadastroClienteNumero.addAll(Arrays.asList("234"));

        /*
        --------------------------------------------------
        Calcular preço
        --------------------------------------------------
        */
        
        // Quantidade de cápsulas

        System.out.println("__________________________________________________");

        System.out.println("Digite a quantidade de cápsulas que deseja cotar: ");
        tempQuantidadeCapsulas = sc.nextInt();

        System.out.println("__________________________________________________");


        // Ciclo de repetição - Adicionar Substâncias e Dosagens

        do {

            // Listar todas as substâncias cadastradas

            tempListar = 1;
            for (String i : cadastroSubstanciaNome) {
                System.out.println("[" + tempListar + "] " + i);
                tempListar++;
            }

            System.out.println("Escolha a Substância: ");
            tempEscolhaSubstancia = sc.nextInt();

            // Perguntar unidade de medida

            System.out.println("__________________________________________________");

            System.out.println("Digite a unidade de medida:");
            System.out.println("[1] G");
            System.out.println("[2] MG");
            System.out.println("[3] MCG");
            tempUnidadeMedida = sc.nextInt();

            // Perguntar dosagem

            System.out.println("__________________________________________________");
            System.out.println("Digite a dosagem:");
            tempDosagem = sc.nextInt();

            // Calcular preço - Pegar dados necessários

            tempIndex = tempEscolhaSubstancia - 1;
            precoMinimo = cadastroSubstanciaPrecoMin.get(tempIndex);
            tempPorcentagemLucro = cadastroSubstanciaPorcentagemLucro.get(tempIndex);
            quantidadeEstoque = cadastroSubstanciaQuantidade.get(tempIndex);
            dosagemMcg = tempDosagem;

            // Calcular preço - Corrigir unidade de medida

            if (tempUnidadeMedida == 1) {
                dosagemMcg = tempDosagem * 1000000;
            } else if (tempUnidadeMedida == 2) {
                dosagemMcg = tempDosagem * 1000;
            }

            // Calcular preço - Calcular quantidade necessária

            quantidadeTotalMcg = dosagemMcg * tempQuantidadeCapsulas;
            estoqueMcg = quantidadeEstoque * 1000000;

            // Calcular preço - Testar se tem quantidade o suficiente

            if (quantidadeTotalMcg > estoqueMcg) {
                System.out.println("Estoque insuficiente para essa substância!");
            } else {

                // Calcular preço - Calcular preço e salvar
                
                custoSubstancia = quantidadeTotalMcg * precoMinimo;

                custoTotal += custoSubstancia;
                lucroSubstancia = custoSubstancia * tempPorcentagemLucro / 100.0;

                valorLucro += lucroSubstancia;
            }

            // Perguntar se o usuário deseja adicionar outra substância

            System.out.println("__________________________________________________");

            System.out.println("Deseja adicionar outra substância?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            tempAdicionarSubstancia = sc.nextInt();
        } while (tempAdicionarSubstancia == 1);

        /*
        --------------------------------------------------
        Procurar Cliente
        --------------------------------------------------
        */

        // Perguntar se o usuário deseja procurar um cliente no banco de dados

        System.out.println("__________________________________________________");

        System.out.println("Deseja procurar o CPF no banco de dados?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        tempProcuraCpf = sc.nextInt();

        if (tempProcuraCpf == 1) {
            // Procurar cpf no banco de dados

            System.out.println("---~> Digite o CPF do cliente: <~---");
            cpfClinte = sc.next();

            for (String cpf : cadastroClienteCpf)

                if (cpf.equals(cpfClinte)) {

                    System.out.println("CPF encontrado!");

                    System.out.println("Nome:" + cadastroClienteNome);
                    System.out.println("Bairro:" + cadastroClienteBairro);
                    System.out.println("Nome da rua:" + cadastroClienteRua);
                    System.out.println("Número da rua" + cadastroClienteNumero);

                } else {
                    System.out.println("CPF não encontrado!");
                }
        }
        else if (tempProcuraCpf == 2) {
            // Cadastrar cpf no banco de dados

            System.out.println("__________________________________________________");
            System.out.println("---~> Cadastro do cliente:  <~---");
            System.out.println("__________________________________________________");

            System.out.println("Insira o nome do cliente:");
            cliente = sc.nextLine();
            cadastroClienteNome.add(cliente);
            sc.nextLine();
            System.out.println("Insira o bairro do cliente:");
            bairroCliente = sc.next();
            cadastroClienteBairro.add(bairroCliente);

            System.out.println("Insira a rua do cliente:");
            ruaCliente = sc.next();
            cadastroClienteRua.add(ruaCliente);

            System.out.println("Insira o número do cliente:");
            numeroRuaCliente = sc.next();
            cadastroClienteNumero.add(numeroRuaCliente);

            System.out.println("Insira o CPF do cliente:");
            cpfClinte = sc.next();
            cadastroClienteCpf.add(cpfClinte);
        }

        valorFinal = custoTotal + valorLucro;

        // Print final

        System.out.println("__________________________________________________");
        System.out.println("RESUMO DO ORÇAMENTO");
        System.out.println("Custo total: R$ " + custoTotal);
        System.out.println("Lucro total: R$ " + valorLucro);
        System.out.println("Valor final do pedido: R$ " + valorFinal);
        System.out.println("Nome do cliente: " + cliente );
        System.out.println("Bairro do cliente: " + bairroCliente );
        System.out.println("Rua do cliente: " + ruaCliente );
        System.out.println("Número do cliente: " + numeroRuaCliente );

        System.out.println("__________________________________________________");

    }
}