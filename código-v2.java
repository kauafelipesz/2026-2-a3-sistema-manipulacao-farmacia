import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> cadastrosSubstanciaNome = new ArrayList<>();
        ArrayList<Double> cadastroSubstanciaQuantidade = new ArrayList<>();
        ArrayList<Double> cadastroSubstanciaPrecoMin = new ArrayList<>();
        ArrayList<Integer> cadastroSubstanciaPorcentagemLucro = new ArrayList<>();

        int tempQuantidadecapsulas = 0;
        int tempEscolhaSubstancia = 0;
        int tempContador = 1;
        int tempConta = 0;
        int tempUnidadeMedida = 0;
        int tempDosagem = 0;


        cadastrosSubstanciaNome.addAll(Arrays.asList("Paracetamol", "Dipirona", "Dexametasona", "Ibuprofeno", "Amoxicilina"));

        cadastroSubstanciaQuantidade.addAll(Arrays.asList(1000.0, 500.0, 200.0, 300.0, 400.0 ));

        cadastroSubstanciaPrecoMin.addAll(Arrays.asList(10.0, 15.0, 20.0, 25.0, 30.0 ));

        cadastroSubstanciaPorcentagemLucro.addAll(Arrays.asList(400, 300, 200, 100, 50));

        System.out.println("Digite a quantidade de capsulas que deseja cotar: ");
        tempQuantidadecapsulas = sc.nextInt();

        // Calculando o valor

        System.out.println("________________________");


        for (String i : cadastrosSubstanciaNome) {
            System.out.println("[" + tempContador + "] " + i);
            tempContador++;
        }

        System.out.println("Escolha a Substância: ");
        tempEscolhaSubstancia = sc.nextInt();

        System.out.println("________________________");

        System.out.println("[1] G");
        System.out.println("[2] MG");
        System.out.println("[3] MCG");
        System.out.println("Escolha a unidade de medida: ");
        tempUnidadeMedida = sc.nextInt();

        System.out.println("________________________");
         System.out.println("Digite a dosagem: ");
         tempDosagem = sc.nextInt();


       System.out.println ((tempQuantidadecapsulas * cadastroSubstanciaPrecoMin * tempDosagem));
    }
}