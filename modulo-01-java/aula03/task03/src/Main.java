public class Main {
    public static void main(String[] args) {
        Contato hugoContato1 = new Contato();
        hugoContato1.descricao = "Emergência";
        hugoContato1.telefone = "14998565714";
        hugoContato1.tipo = 2;
        Contato hugoContato2 = new Contato();
        hugoContato2.descricao = "Regular";
        hugoContato2.telefone = "17998559714";
        hugoContato2.tipo = 1;
        Contato mariaContato1 = new Contato();
        mariaContato1.descricao = "Emergência";
        mariaContato1.telefone = "89198565714";
        mariaContato1.tipo = 2;
        Contato mariaContato2 = new Contato();
        mariaContato2.descricao = "Regular";
        mariaContato2.telefone = "73298565714";
        mariaContato2.tipo = 1;
        Endereco hugoEndereco1 = new Endereco();
        hugoEndereco1.tipo = 1;
        hugoEndereco1.logradouro = "Rua Marcos";
        hugoEndereco1.numero = 116;
        hugoEndereco1.complemento = "Apto 134";
        hugoEndereco1.cep = "1236573";
        hugoEndereco1.cidade = "Bauru";
        hugoEndereco1.estado = "SP";
        hugoEndereco1.pais = "Brasil";
        Endereco mariaEndereco1 = new Endereco();
        mariaEndereco1.tipo = 1;
        mariaEndereco1.logradouro = "Alameda Java";
        mariaEndereco1.numero = 436;
        mariaEndereco1.complemento = "Apto 12";
        mariaEndereco1.cep = "1293823";
        mariaEndereco1.cidade = "Bauru";
        mariaEndereco1.estado = "SP";
        mariaEndereco1.pais = "Brasil";
        Cliente hugo = new Cliente();
        hugo.enderecos[0] = hugoEndereco1;
        hugo.contatos[0] = hugoContato1;
        hugo.contatos[1] = hugoContato2;
        hugo.nome = "Hugo Ferreira Gabriel Vieira";
        hugo.cpf = "4392818274";
        Cliente maria = new Cliente();
        maria.enderecos[0] = mariaEndereco1;
        maria.contatos[0] = mariaContato1;
        maria.contatos[1] = mariaContato2;
        maria.nome = "Maria José";
        maria.cpf = "1287612712";
        ContaCorrente contaHugo = new ContaCorrente();
        contaHugo.cliente = hugo;
        contaHugo.saldo = 1000.00;
        contaHugo.numeroConta = "1";
        contaHugo.agencia = 123;
        ContaCorrente contaMaria = new ContaCorrente();
        contaMaria.cliente = maria;
        contaMaria.saldo = 5000.00;
        contaMaria.numeroConta = "2";
        contaMaria.agencia = 123;

        //Testes
        contaHugo.transferir(contaMaria, 10000.00);
        contaMaria.transferir(contaHugo, 100.00);
        contaHugo.imprimirContaCorrente();
        contaMaria.imprimirContaCorrente();
    }
}