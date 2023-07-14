import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[3];
        float media, soma = 0;
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("Digite o elemento %d: ", i);
            valores[i] = scanner.nextInt();
            soma += valores[i];
        }
        media = soma / 3;
        System.out.printf("Média: %.1f\n", media);
        System.out.println("Média: " + media);
    }
}