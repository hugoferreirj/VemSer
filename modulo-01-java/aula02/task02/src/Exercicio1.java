import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        Float preco, precoComDesconto, precoTotal;
        System.out.print("Digite o nome do produto: ");
        nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        preco = scanner.nextFloat();
        System.out.println("Promoção " + nome);
        System.out.println("-------------------------------");
        for (int i = 1; i <= 10; i++) //i representa a quantidade de produtos
        {
            precoComDesconto = preco * (1 - i * 0.05f);
            precoTotal = i * precoComDesconto;
            System.out.printf("%d x R$%.2f = R$%.2f\n", i, precoComDesconto, precoTotal);
        }


    }
}