public class Exemplo2 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2}, {3, 4}};
        int somaTotal, somaPrimeiraLinha, somaSegundaLinha, subtracao;
        somaPrimeiraLinha = matriz[0][0] + matriz[0][1];
        somaSegundaLinha = matriz[1][0] + matriz[1][1];
        somaTotal = somaPrimeiraLinha + somaSegundaLinha;
        subtracao = somaPrimeiraLinha - somaSegundaLinha;
        System.out.println("Soma primeira linha: " + somaPrimeiraLinha);
        System.out.println("Soma segunda linha: " + somaSegundaLinha);
        System.out.println("Soma total: " + somaTotal);
        System.out.println("Valor da primeira linha menos a segunda linha: " + subtracao);
    }
}
