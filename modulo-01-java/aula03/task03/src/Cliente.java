public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];;
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos() {
        for (Contato contato : this.contatos) {
            if(contato != null){
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : this.enderecos) {
            if(endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }


}
