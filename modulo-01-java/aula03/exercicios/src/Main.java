public class Main {
    public static void main(String[] args) {
        Pessoa hugo = new Pessoa();
        Pessoa mayra = new Pessoa();
        hugo.nome = "Hugo";
        hugo.idade = 21;
        hugo.sobrenome = "Ferreira";
        hugo.numeroDoWhatsapp = "123";
        mayra.nome = "Mayra";
        mayra.idade = 23;
        mayra.sobrenome = "Silva";
        mayra.numeroDoWhatsapp = "456";
        hugo.conversar(mayra);
        System.out.println(hugo.retornarNomeCompleto());
        System.out.println(mayra.ehMaiorDeIdade());
        mayra.mandarWhatsapp(hugo, "oiee");
    }
}