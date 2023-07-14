import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nItens = 10, nMercados = 3;
        float[][] itens = new float[nItens][nMercados];
        float[] precoTotal = new float[nMercados];
        float menorPreco;
        int mercadoMaisBarato = 0;
        for (int j = 0; j < nMercados; j++) {
            precoTotal[j] = 0;
            System.out.println("===============================");
            System.out.println("MERCADO " + j);
            for (int i = 0; i < nItens; i++) {
                System.out.print("Digite o preço do produto[" + i + "]: ");
                itens[i][j] = scanner.nextFloat();
                precoTotal[j] += itens[i][j];
            }
        }
        menorPreco = precoTotal[0];
        for (int i = 1; i < nMercados; i++) {
            if (precoTotal[i] < menorPreco) {
                menorPreco = precoTotal[i];
                mercadoMaisBarato = i;
            }
        }
        System.out.println("O mercado mais barato é o " + mercadoMaisBarato);
    }
}
