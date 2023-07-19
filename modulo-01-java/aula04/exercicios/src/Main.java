public class Main {
    public static void main(String[] args) {
        Pessoa hugo = new Pessoa("Hugo", "Ferreira", 21, "123");
        Pessoa mayra = new Pessoa("Mayra", "Silva", 23, "456");
        hugo.conversar(mayra);
        System.out.println(hugo.retornarNomeCompleto());
        System.out.println(mayra.ehMaiorDeIdade());
        mayra.mandarWhatsapp(hugo, "oiee");
        Pessoa rafael = new Pessoa("Rafael", "Lazzari");
        System.out.println(rafael.retornarNomeCompleto());

        Animal mila = new Animal();
        System.out.println(mila.caminha());
        Cachorro nick = new Cachorro("Nick");
        nick.setRaca("shitzu");
        System.out.println(nick.late());
        System.out.println(nick.caminha());
        Gato tobby = new Gato("Tobby");
        tobby.setRaca("siames");
        System.out.println(tobby.mia());
        System.out.println(tobby.caminha());


    }
}