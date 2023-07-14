import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NUMERO_SECRETO = 73;
        int palpite;
        do {
            System.out.print("Digite seu palpite: ");
            palpite = scanner.nextInt();
            if (palpite < NUMERO_SECRETO) {
                System.out.println("O número a ser encontrado é maior do que o que você digitou");
            } else if (palpite > NUMERO_SECRETO) {
                System.out.println("O número a ser encontrado é menor do que o que você digitou");
            } else {
                System.out.println("Parabéns! Você acertou");
            }
        } while (palpite != NUMERO_SECRETO);
    }
}
