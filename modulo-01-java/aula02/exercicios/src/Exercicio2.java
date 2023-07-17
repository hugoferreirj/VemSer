import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[2][2];
        int somaTotal = 0, somaPrimeiraLinha, somaSegundaLinha, subtracao;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++){
                System.out.printf("Digite o elemento [%d][%d]: ", i,j);
                matriz[i][j] = scanner.nextInt();
                somaTotal += matriz[i][j];
            }
        }
        somaPrimeiraLinha = matriz[0][0] + matriz[0][1];
        somaSegundaLinha = matriz[1][0] + matriz[1][1];
        subtracao = somaPrimeiraLinha - somaSegundaLinha;
        System.out.println("Soma primeira linha: " + somaPrimeiraLinha);
        System.out.println("Soma segunda linha: " + somaSegundaLinha);
        System.out.println("Soma total: " + somaTotal);
        System.out.println("Valor da primeira linha menos a segunda linha: " + subtracao);
    }
}
