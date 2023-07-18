public class Main {
    public static void main(String[] args) {
        Pessoa hugo = new Pessoa();
        Pessoa mayra = new Pessoa();
        hugo.setNome("Hugo");
        hugo.setIdade(21);
        hugo.setSobrenome("Ferreira");
        hugo.setNumeroDoWhatsapp("123");
        mayra.setNome("Mayra");
        mayra.setIdade(23);
        mayra.setSobrenome("Silva");
        mayra.setNumeroDoWhatsapp("456");
        hugo.conversar(mayra);
        System.out.println(hugo.retornarNomeCompleto());
        System.out.println(mayra.ehMaiorDeIdade());
        mayra.mandarWhatsapp(hugo, "oiee");
        Pessoa rafael = new Pessoa("Rafael", "Lazzari");
        System.out.println(rafael.retornarNomeCompleto());

        Animal mila = new Animal();
        System.out.println(mila.caminha());
        Cachorro nick = new Cachorro("Nick");
        System.out.println(nick.late());
        System.out.println(nick.caminha());
        Gato tobby = new Gato("Tobby");
        System.out.println(tobby.mia());
        System.out.println(tobby.caminha());


    }
}