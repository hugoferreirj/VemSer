public class Main {

    public static void main(String[] args) {
        Calculo soma = new Calculo() {
            @Override
            public int calcular(int n1, int n2) {
                return n1 + n2;
            }
        };

        Calculo multiplicacao = new Calculo() {
            @Override
            public int calcular(int n1, int n2) {
                return n1 * n2;
            }
        };
        int resultadoSoma = soma.calcular(10, 2);
        int resultadoMultiplicacao = multiplicacao.calcular(10, 2);
        System.out.println(resultadoSoma);
        System.out.println(resultadoMultiplicacao);
    }
}