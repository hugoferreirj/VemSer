public class Exemplo1 {
    public static void main(String[] args) {
        int[] valores = {10, 5, 4};
        float media, soma;
        soma = valores[0] + valores[1] + valores[2];
        media = soma / 3;
        System.out.printf("Média: %.1f\n", media);
        System.out.println("Média: " + media);
    }
}