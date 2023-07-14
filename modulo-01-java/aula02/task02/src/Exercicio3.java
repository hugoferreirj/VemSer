import java.util.Objects;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float altura, peso, somaAlturas = 0f, maiorPeso = 0f, maiorAltura = 0f, mediaAlturas;
        int maiorIdade = 0, idade, qtdJogadores = 0;
        String nome = "", jogadorMaisVelho = "", jogadorMaisPesado = "";
        while (!Objects.equals(nome, "SAIR")) {
            System.out.print("Digite o nome do jogador: ");
            nome = scanner.nextLine();
            if (Objects.equals(nome, "SAIR")) {
                break;
            }
            System.out.print("Digite a altura do jogador: ");
            altura = scanner.nextFloat();
            if (altura > maiorAltura) {
                maiorAltura = altura;
            }
            somaAlturas += altura;
            System.out.print("Digite a idade do jogador: ");
            idade = scanner.nextInt();
            if (idade > maiorIdade) {
                maiorIdade = idade;
                jogadorMaisVelho = nome;
            }
            System.out.print("Digite o peso do jogador: ");
            peso = scanner.nextFloat();
            scanner.nextLine();
            if (peso > maiorPeso) {
                maiorPeso = peso;
                jogadorMaisPesado = nome;
            }
            qtdJogadores++;
        }
        if (qtdJogadores == 0) {
            System.out.println("Nenhum jogador foi cadastrado!");
        } else {
            mediaAlturas = somaAlturas / qtdJogadores;
            System.out.println("=================================");
            System.out.println("Quantidade de jogadores cadastrados: " + qtdJogadores);
            System.out.println("Altura do maior jogador: " + maiorAltura);
            System.out.println("Jogador mais velho: " + jogadorMaisVelho);
            System.out.println("Jogador mais pesado: " + jogadorMaisPesado);
            System.out.printf("Média das alturas dos jogadores: %.2f", mediaAlturas);

        }
    }
}
