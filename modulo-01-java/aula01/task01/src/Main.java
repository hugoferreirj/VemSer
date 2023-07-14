import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Lista 01*/
        /*Ex 01*/
        String nome, cidade, estado;
        int idade;
        System.out.println("Exercício 1");
        System.out.println("Digite seu nome:");
        nome = scanner.nextLine();
        System.out.println("Digite sua idade:");
        idade = scanner.nextInt();
        scanner.nextLine(); /*Limpa o buffer*/
        System.out.println("Digite sua cidade:");
        cidade = scanner.nextLine();
        System.out.println("Digite seu estado:");
        estado = scanner.nextLine();
        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + ".");

        /*Ex 02*/

        String estadoEscolhido;
        String cidadeEscolhida;
        System.out.println("Exercício 2");
        System.out.println("Você pode conferir informações sobre os seguintes estados: Bahia, Pernambuco e Alagoas");
        System.out.println("O nome deve ser digitado exatamente da mesma forma que está escrito acima");
        System.out.println("Digite o nome do estado que deseja pesquisar:");
        estadoEscolhido = scanner.nextLine();
        switch (estadoEscolhido) {
            case "Bahia":
                System.out.println("Você pode conferir informações sobre as seguintes cidades: Itabuna ou Jacobina");
                System.out.println("O nome deve ser digitado exatamente da mesma forma que está escrito acima");
                System.out.println("Digite o nome da cidade que deseja pesquisar:");
                cidadeEscolhida = scanner.nextLine();
                switch (cidadeEscolhida) {
                    case "Itabuna":
                        System.out.println("população: 185.500 habitantes");
                        System.out.println("principal festa: Ita Pedro");
                        System.out.println("IDH: 0,712");
                        break;
                    case "Jacobina":
                        System.out.println("população: 82.590 habitantes");
                        System.out.println("principal festa: Festa Junina");
                        System.out.println("IDH: 0,649");
                        break;
                    default:
                        System.out.println("Nome de cidade inválido, programa encerrado.");
                        System.exit(0);
                        break;
                }
                break;
            case "Pernambuco":
                System.out.println("Você pode conferir informações sobre as seguintes cidades: Recife ou Caruaru");
                System.out.println("O nome deve ser digitado exatamente da mesma forma que está escrito acima");
                System.out.println("Digite o nome da cidade que deseja pesquisar:");
                cidadeEscolhida = scanner.nextLine();
                switch (cidadeEscolhida) {
                    case "Recife":
                        System.out.println("população: 1.653.461 habitantes");
                        System.out.println("principal festa: Carnaval");
                        System.out.println("IDH: 0,772");
                        break;
                    case "Caruaru":
                        System.out.println("população: 365.278 habitantes");
                        System.out.println("principal festa: São João de Caruaru");
                        System.out.println("IDH: 0,677");
                        break;
                    default:
                        System.out.println("Nome de cidade inválido, programa encerrado.");
                        System.exit(0);
                        break;
                }
                break;
            case "Alagoas":
                System.out.println("Você pode conferir informações sobre as seguintes cidades: Murici ou Pilar");
                System.out.println("O nome deve ser digitado exatamente da mesma forma que está escrito acima");
                System.out.println("Digite o nome da cidade que deseja pesquisar:");
                cidadeEscolhida = scanner.nextLine();
                switch (cidadeEscolhida) {
                    case "Murici":
                        System.out.println("população: 28.333 habitantes");
                        System.out.println("principal festa: Festa de Nossa Senhora da Graça");
                        System.out.println("IDH: 0,58");
                        break;
                    case "Pilar":
                        System.out.println("população: 35.370 habitantes");
                        System.out.println("principal festa: Festa de Nossa Senhora do Pilar");
                        System.out.println("IDH: 0,610");
                        break;
                    default:
                        System.out.println("Nome de cidade inválido, programa encerrado.");
                        System.exit(0);
                        break;
                }
                break;
            default:
                System.out.println("Nome de estado inválido, programa encerrado.");
                System.exit(0);
                break;
        }

        /*Ex 03*/
        String palavraParaTraduzir;
        System.out.println("Exercício 3");
        System.out.println("Digite a palavra que deseja traduzir: ");
        palavraParaTraduzir = scanner.nextLine();
        switch (palavraParaTraduzir) {
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            case "Triste":
                System.out.println("Sad");
                break;
            case "Sad":
                System.out.println("Triste");
                break;
            case "Deveria":
                System.out.println("Should");
                break;
            case "Should":
                System.out.println("Deveria");
                break;
            case "Poderia":
                System.out.println("Could");
                break;
            case "Could":
                System.out.println("Poderia");
                break;
            default:
                System.out.println("Essa palavra não é válida.");
        }

        /*Ex 04*/
        int a = 10;
        int b = 20;
        int aux;
        aux = a;
        a = b;
        b = aux;
        System.out.println("Exercício 4");
        System.out.println("A = " + String.valueOf(a));
        System.out.println("B = " + String.valueOf(b));

        /*Ex 05*/
        float base, altura, area;
        System.out.println("Exercício 5");
        System.out.println("Digite o valor da base do retângulo:");
        base = scanner.nextFloat();
        System.out.println("Digite o valor da altura do retângulo:");
        altura = scanner.nextFloat();
        area = base * altura;
        System.out.println("A área do retângulo é " + String.valueOf(area));

        /*Ex 06*/
        System.out.println("Exercício 6");
        int eleitores, votosBrancos, votosNulos, votosValidos;
        float pVotosBrancos, pVotosNulos, pVotosValidos;
        System.out.println("Digite o número total de eleitores:");
        eleitores = scanner.nextInt();
        System.out.println("Digite o número de votos brancos:");
        votosBrancos = scanner.nextInt();
        System.out.println("Digite o número de votos nulos:");
        votosNulos = scanner.nextInt();
        System.out.println("Digite o número de votos válidos:");
        votosValidos = scanner.nextInt();
        scanner.nextLine(); /*Limpa o buffer*/
        pVotosBrancos = (Float.valueOf(votosBrancos) * 100) / Float.valueOf(eleitores);
        pVotosNulos = (Float.valueOf(votosNulos) * 100) / Float.valueOf(eleitores);
        pVotosValidos = (Float.valueOf(votosValidos) * 100) / Float.valueOf(eleitores);
        System.out.println("Percentuais:");
        System.out.println("Votos Brancos: " + String.valueOf(pVotosBrancos));
        System.out.println("Votos Nulos: " + String.valueOf(pVotosNulos));
        System.out.println("Votos Válidos: " + String.valueOf(pVotosValidos));


        /*Ex 07*/
        System.out.println("Exercício 7");
        String codigo;
        int quantidade;
        float valorTotal;
        System.out.println("Digite a quantidade do produto que deseja comprar:");
        quantidade = scanner.nextInt();
        scanner.nextLine(); /*Limpa o buffer*/
        System.out.println("Digite o código do produto:");
        codigo = scanner.nextLine();

        switch (codigo) {
            case "ABCD":
                valorTotal = Float.valueOf(quantidade) * 5.3f;
                System.out.println("Preço total: " + String.valueOf(valorTotal));
                break;
            case "XYPK":
                valorTotal = Float.valueOf(quantidade) * 6f;
                System.out.println("Preço total: " + String.valueOf(valorTotal));
                break;
            case "KLMP":
                valorTotal = Float.valueOf(quantidade) * 3.2f;
                System.out.println("Preço total: " + String.valueOf(valorTotal));
                break;
            case "QRST":
                valorTotal = Float.valueOf(quantidade) * 2.5f;
                System.out.println("Preço total: " + String.valueOf(valorTotal));
                break;
            default:
                System.out.println("Código inválido!");
                break;
        }

        /*Ex 08*/
        System.out.println("Exercício 8");
        String cargo;
        Float salario, novoSalario, diferenca;
        System.out.println("Digite o cargo do funcionário:");
        cargo = scanner.nextLine();
        System.out.println("Digite o salário do funcionário:");
        salario = scanner.nextFloat();
        switch (cargo) {
            case "Gerente":
                novoSalario = 1.1f * salario;
                break;
            case "Engenheiro":
                novoSalario = 1.2f * salario;
                break;
            case "Técnico":
                novoSalario = 1.3f * salario;
                break;
            default:
                novoSalario = 1.4f * salario;
                break;
        }
        diferenca = novoSalario - salario;
        System.out.println("Salário antigo: " + String.valueOf(salario));
        System.out.println("Salário novo: " + String.valueOf(novoSalario));
        System.out.println("Diferença: " + String.valueOf(diferenca));

        /*Ex 09*/
        System.out.println("Exercício 9");
        int hInicio, mInicio, hFim, mFim, totalHoras, totalMinutos;
        System.out.println("Digite a hora em que o o jogo começou:");
        hInicio = scanner.nextInt();
        System.out.println("Digite os minutos em que o o jogo começou:");
        mInicio = scanner.nextInt();
        System.out.println("Digite a hora em que o o jogo terminou:");
        hFim = scanner.nextInt();
        System.out.println("Digite os minutos em que o o jogo terminou:");
        mFim = scanner.nextInt();
        scanner.nextLine(); /*Limpa o buffer*/

        if (hFim < hInicio) {
            hFim += 24;
        }
        if (mFim < mInicio) {
            mFim += 60;
        }
        totalHoras = hFim - hInicio;
        totalMinutos = mFim - mInicio;
        System.out.println("A duração do jogo foi de " + String.valueOf(totalHoras) + " horas e " + String.valueOf(totalMinutos) + " minutos.");

        /*Ex 10*/
        System.out.println("Exercício 10");
        int id;
        float verificacao1, verificacao2, verificacao3, mExercicios, mAproveitamento;
        System.out.println("Digite o seu número de identificação:");
        id = scanner.nextInt();
        scanner.nextLine(); /*Limpa buffer*/
        System.out.println("Digite a nota da primeira verificação:");
        verificacao1 = scanner.nextFloat();
        System.out.println("Digite a nota da segunda verificação:");
        verificacao2 = scanner.nextFloat();
        System.out.println("Digite a nota da terceira verificação:");
        verificacao3 = scanner.nextFloat();
        System.out.println("Digite a média dos exercícios:");
        mExercicios = scanner.nextFloat();
        mAproveitamento = (verificacao1 + (verificacao2 * 2) + (verificacao3 * 3) + mExercicios) / 7;
        System.out.println("Número de identificação: " + String.valueOf(id));
        System.out.println("Nota verificação 1: " + String.valueOf(verificacao1));
        System.out.println("Nota verificação 2: " + String.valueOf(verificacao2));
        System.out.println("Nota verificação 3: " + String.valueOf(verificacao3));
        System.out.println("Média dos exercícios: " + String.valueOf(mExercicios));
        System.out.println("Média Aproveitamento: " + String.valueOf(mAproveitamento));
        if (mAproveitamento >= 6f) {
            if (mAproveitamento < 7.5f) {
                System.out.println("Conceito: C");
            } else if (mAproveitamento < 9.0f) {
                System.out.println("Conceito: B");
            } else {
                System.out.println("Conceito: A");
            }
            System.out.println("Aprovado");
        } else {
            if (mAproveitamento >= 4f) {
                System.out.println("Conceito: D");
            } else {
                System.out.println("Conceito: E");
            }
            System.out.println("Reprovado");
        }
        scanner.close();
    }
}