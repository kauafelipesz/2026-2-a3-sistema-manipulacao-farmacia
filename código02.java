//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);

    ArrayList<String> cadastrosSubstanciaNome = new ArrayList<>();
    ArrayList<Double> cadastroSubstanciaQuantidade = new ArrayList<>();
    ArrayList<Double> cadastroSubstanciaPrecoMin = new ArrayList<>();
    ArrayList<Integer> cadastroSubstanciaPorcentagemLucro = new ArrayList<>();

    int tempQuantidadecapsulas = 0;
    int tempEscolhaSubstancia = 0;
    int tempContador = 1;
    int tempConta = 0;
    int tempDosagem = 0;
    int tempUnidadeMedida = 0;
    int adicionarSubstancia = 0;
    double custoTotal=0;
    double valorLucro = 0;
    double lucroSubstancia = 0;

    cadastrosSubstanciaNome.addAll(Arrays.asList("Paracetamol", "Dipirona", "Dexametasona", "Ibuprofeno", "Amoxicilina"));

    cadastroSubstanciaQuantidade.addAll(Arrays.asList(1000.0, 500.0, 200.0, 300.0, 400.0));

    cadastroSubstanciaPrecoMin.addAll(Arrays.asList(0.00002, 0.00003, 0.00010, 0.00004, 0.00005));

    cadastroSubstanciaPorcentagemLucro.addAll(Arrays.asList(400, 300, 200, 100, 50));

    System.out.println("Digite a quantidade de capsulas que deseja cotar: ");
    tempQuantidadecapsulas = sc.nextInt();

    System.out.println("_______________________");


    do {
        tempContador = 1;
        for (String i : cadastrosSubstanciaNome) {
            System.out.println("[" + tempContador + "] " + i);
            tempContador++;
        }
        System.out.println("Escolha a Substância: ");

        tempEscolhaSubstancia = sc.nextInt();

        System.out.println("_______________________");

        System.out.println("Digite a unidade de medida:");
        System.out.println("[1] G");
        System.out.println("[2] MG");
        System.out.println("[3] MCG");
        tempUnidadeMedida = sc.nextInt();

        System.out.println("_______________________");
        System.out.println("Digite a dosagem:");
        tempDosagem = sc.nextInt();


        int indice = tempEscolhaSubstancia - 1;
        double precoMinimo = cadastroSubstanciaPrecoMin.get(indice);
        int porcentagemLucro = cadastroSubstanciaPorcentagemLucro.get(indice);
        double quantidadeEstoque = cadastroSubstanciaQuantidade.get(indice);
        double dosagemMcg = tempDosagem;

        if (tempUnidadeMedida == 1) {
            dosagemMcg = tempDosagem * 1000000;
        } else if (tempUnidadeMedida == 2) {
            dosagemMcg = tempDosagem * 1000;
        }

        double quantidadeTotalMcg = dosagemMcg * tempQuantidadecapsulas;
        double estoqueMcg = quantidadeEstoque * 1000000;

        if (quantidadeTotalMcg > estoqueMcg) {
            System.out.println("Estoque insuficiente para essa substância!");
        } else {
            double custoSubstancia = quantidadeTotalMcg * precoMinimo;

            custoTotal += custoSubstancia;
             lucroSubstancia = custoSubstancia * porcentagemLucro / 100.0;

            valorLucro += lucroSubstancia;
        }

        System.out.println("Deseja adicionar outra substância?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        adicionarSubstancia = sc.nextInt();
    } while (adicionarSubstancia == 1);

    double valorFinal = custoTotal + valorLucro;

    System.out.println("_______________________");
    System.out.println("RESUMO DO ORÇAMENTO");
    System.out.println("Custo total: R$ " + custoTotal);
    System.out.println("Lucro total: R$ " + valorLucro);
    System.out.println("Valor final do pedido: R$ " + valorFinal);


}






