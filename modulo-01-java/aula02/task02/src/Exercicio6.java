import java.util.Scanner;

public class Exercicio6 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = {6, 6, 7, 9, 34, 76, 1, 8, 10, 2};
        int numero, repeticoes = 0, menores = 0, maiores = 0;
        System.out.print("Digite um número: ");
        numero = scanner.nextInt();
        for (int valor : vetor) {
            if (valor == numero) {
                repeticoes++;
            }
            if (valor < numero) {
                menores++;
            }
            if (valor > numero) {
                maiores++;
            }
        }
        System.out.println("vetor = {6, 6, 7, 9, 34, 76, 1, 8, 10, 2}");
        System.out.println("Quantidade de vezes que o número aparece no vetor: " + repeticoes);
        System.out.println("Quantidade de vezes que numeros menores aparecem no vetor: " + menores);
        System.out.println("Quantidade de vezes que numeros maiores aparecem no vetor: " + maiores);
    }
}
