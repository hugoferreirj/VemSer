import java.util.Scanner;

public class Exemplo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qntd, soma = 0;
        float media;
        System.out.print("Digite a quantidade de elementos que você deseja colocar no vetor: ");
        qntd = scanner.nextInt();
        scanner.nextLine();
        int[] valores = new int[qntd];
        for (int i = 0; i < qntd; i++) {
            System.out.printf("Digite o elemento %d: ", i);
            valores[i] = scanner.nextInt();
            scanner.nextLine();
            soma += valores[i];
        }
        media = Float.valueOf(soma) / Float.valueOf(qntd);
        System.out.printf("A média dos valores foi %.2f", media);

    }
}
