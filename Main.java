import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Função que encontra o número mínimo de moedas necessárias para um determinado valor
    public static List<Integer> coinChange(int[] coins, double amount) {
        List<Integer> result = new ArrayList<>();
        int convertedAmount = (int) (amount * 100);

        // Ordena as moedas em ordem decrescente (estratégia gulosa: usar a maior moeda possível)
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            // Enquanto o valor da moeda atual for menor ou igual ao valor restante
            while (convertedAmount >= coins[i]) {
                convertedAmount -= coins[i]; // Subtrai o valor da moeda do montante
                result.add(coins[i]); // Adiciona a moeda à lista de resultado
            }
        }

        // Retorna a lista de moedas usadas
        return result;
    }

    public static void main(String[] args) {
        // Moedas disponíveis
        int[] coins = {100, 25, 10, 5, 1};
        // Valor que queremos alcançar
        double amount = 2.89;

        // Obtendo a lista de moedas usadas para alcançar o valor
        List<Integer> result = coinChange(coins, amount);

        // Imprime o resultado
        System.out.println("Moedas usadas para compor " + amount + " centavos: " + result);
        System.out.println("Número total de moedas: " + result.size());
    }
}
