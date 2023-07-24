package br.com.dbc.vemser;

public class Main {
    public static void main(String[] args) {
        Contato hugoContato1 = new Contato("Emergência", "14998565714", 2);
        Contato hugoContato2 = new Contato("Regular", "17998559714", 1);
        Contato mariaContato1 = new Contato("Emergência", "89198565714", 2);
        Contato mariaContato2 = new Contato("Regular", "73298565714", 1);
        Endereco hugoEndereco1 = new Endereco(1, "Rua Marcos", 116, "Apto 134", "1236573", "Bauru", "SP", "Brasil");
        Endereco mariaEndereco1 = new Endereco(1, "Alameda Java", 436, "Apto 12", "1233421", "Bauru", "SP", "Brasil");
        Cliente hugo = new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274");
        hugo.addContato(hugoContato1);
        hugo.addContato(hugoContato2);
        hugo.addEndereco(hugoEndereco1);
        Cliente maria = new Cliente("Maria José", "1287612712");
        maria.addContato(mariaContato1);
        maria.addContato(mariaContato2);
        maria.addEndereco(mariaEndereco1);
        ContaCorrente contaCorrenteHugo = new ContaCorrente(hugo, "1", 123, 1000.00);
        ContaPagamento contaPagamentoHugo = new ContaPagamento(hugo, "3", 123, 700.00);
        ContaPoupanca contaMaria = new ContaPoupanca(maria, "2", 123, 5000.00);
        contaMaria.creditarTaxa();

        //Testes
        contaCorrenteHugo.sacar(50);
        contaPagamentoHugo.depositar(250);
        contaMaria.sacar(1000000);
        contaCorrenteHugo.sacar(-200);
        contaCorrenteHugo.depositar(-900);
        contaCorrenteHugo.transferir(contaMaria, 10000.00);
        contaMaria.transferir(contaCorrenteHugo, 100.00);
        contaPagamentoHugo.imprimir();
        contaCorrenteHugo.imprimir();
        contaMaria.imprimir();
    }
}