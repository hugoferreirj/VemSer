public class Main {
    public static void main(String[] args) {
        Contato hugoContato1 = new Contato("Emergência", "14998565714", 2);
        Contato hugoContato2 = new Contato("Regular", "17998559714", 1);
        Contato mariaContato1 = new Contato("Emergência", "89198565714", 2);
        Contato mariaContato2 = new Contato("Regular", "73298565714", 1);
        Endereco hugoEndereco1 = new Endereco(1, "Rua Marcos", 116, "Apto 134", "1236573", "Bauru", "SP", "Brasil");
        Endereco mariaEndereco1 = new Endereco(1, "Alameda Java", 436, "Apto 12", "1233421", "Bauru", "SP", "Brasil");
        Endereco[] enderecosHugo = {hugoEndereco1};
        Contato[] contatosHugo = {hugoContato1, hugoContato2};
        Cliente hugo = new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274", contatosHugo, enderecosHugo);
        Endereco[] enderecosMaria = {mariaEndereco1};
        Contato[] contatosMaria = {mariaContato1, mariaContato2};
        Cliente maria = new Cliente("Maria José", "1287612712", contatosMaria, enderecosMaria);
        ContaCorrente contaHugo = new ContaCorrente(hugo, "1", 123, 1000.0);
        ContaPoupanca contaMaria = new ContaPoupanca(maria, "2", 123, 5000.00 );
        contaMaria.creditarTaxa();

        //Testes
        contaHugo.transferir(contaMaria, 10000.00);
        contaMaria.transferir(contaHugo, 100.00);
        contaHugo.imprimir();
        contaMaria.imprimir();
    }
}