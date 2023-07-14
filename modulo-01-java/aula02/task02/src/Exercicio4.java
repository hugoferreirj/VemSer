import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        // Acredito que houve um engano ao solicitar que a matriz fosse do tipo int.
        // Para prencheer as notas faz mais sentido utilizar o float, por isso fiz essa substituição
        Scanner scanner = new Scanner(System.in);
        int qntAlunos = 5;
        float[][] alunos = new float[qntAlunos][4];
        float matriculaMaiorNota = -1f, maiorNotaFinal = -1f, somaNotasFinais = 0f, mediaNotasFinais;
        for (int i = 0; i < qntAlunos; i++) {
            System.out.println("Aluno " + i);
            System.out.print("Digite o número da matrícula:");
            alunos[i][0] = scanner.nextFloat();
            System.out.print("Digite a média das provas:");
            alunos[i][1] = scanner.nextFloat();
            System.out.print("Digite a média dos trabalhos:");
            alunos[i][2] = scanner.nextFloat();
            alunos[i][3] = (alunos[i][1] * 0.6f) + (alunos[i][2] * 0.4f); //Cálculo da nota final
            somaNotasFinais += alunos[i][3];
            if (alunos[i][3] > maiorNotaFinal) {
                maiorNotaFinal = alunos[i][3];
                matriculaMaiorNota = alunos[i][0];
            }
        }
        System.out.println("==================================");
        System.out.printf("Matrícula que obteve a maior nota: %.0f\n", matriculaMaiorNota);
        mediaNotasFinais = somaNotasFinais / qntAlunos;
        System.out.printf("Média notas finais: %.2f", mediaNotasFinais);


    }
}
