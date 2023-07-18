public class Main {
    public static void main(String[] args) {
        Contato hugoContato1 = new Contato();
        hugoContato1.setDescricao("Emergência");
        hugoContato1.setTelefone("14998565714");
        hugoContato1.setTipo(2);
        Contato hugoContato2 = new Contato();
        hugoContato2.setDescricao("Regular");
        hugoContato2.setTelefone("17998559714");
        hugoContato2.setTipo(1);
        Contato mariaContato1 = new Contato();
        mariaContato1.setDescricao("Emergência");
        mariaContato1.setTelefone("89198565714");
        mariaContato1.setTipo(2);
        Contato mariaContato2 = new Contato();
        mariaContato2.setDescricao("Regular");
        mariaContato2.setTelefone("73298565714");
        mariaContato2.setTipo(1);
        Endereco hugoEndereco1 = new Endereco();
        hugoEndereco1.setTipo(1);
        hugoEndereco1.setLogradouro("Rua Marcos");
        hugoEndereco1.setNumero(116);
        hugoEndereco1.setComplemento("Apto 134");
        hugoEndereco1.setCep("1236573");
        hugoEndereco1.setCidade("Bauru");
        hugoEndereco1.setEstado("SP");
        hugoEndereco1.setPais("Brasil");
        Endereco mariaEndereco1 = new Endereco();
        mariaEndereco1.setTipo(1);
        mariaEndereco1.setLogradouro("Alameda Java");
        mariaEndereco1.setNumero(436);
        mariaEndereco1.setComplemento("Apto 12");
        mariaEndereco1.setCep("1293823");
        mariaEndereco1.setCidade("Bauru");
        mariaEndereco1.setEstado("SP");
        mariaEndereco1.setPais("Brasil");
        Cliente hugo = new Cliente();
        Endereco[] enderecosHugo = {hugoEndereco1};
        hugo.setEnderecos(enderecosHugo);
        Contato[] contatosHugo = {hugoContato1, hugoContato2};
        hugo.setContatos(contatosHugo);
        hugo.setNome("Hugo Ferreira Gabriel Vieira");
        hugo.setCpf("4392818274");
        Cliente maria = new Cliente();
        Endereco[] enderecosMaria = {mariaEndereco1};
        maria.setEnderecos(enderecosMaria);
        Contato[] contatosMaria = {mariaContato1, mariaContato2};
        maria.setContatos(contatosMaria);
        maria.setNome("Maria José");
        maria.setCpf("1287612712");
        ContaCorrente contaHugo = new ContaCorrente();
        contaHugo.setCliente(hugo);
        contaHugo.setSaldo(1000.00);
        contaHugo.setNumeroConta("1");
        contaHugo.setAgencia(123);
        ContaPoupanca contaMaria = new ContaPoupanca();
        contaMaria.setCliente(maria);
        contaMaria.setSaldo(5000.00);
        contaMaria.setNumeroConta("2");
        contaMaria.setAgencia(123);
        contaMaria.creditarTaxa();

        //Testes
        contaHugo.transferir(contaMaria, 10000.00);
        contaMaria.transferir(contaHugo, 100.00);
        contaHugo.imprimir();
        contaMaria.imprimir();
    }
}