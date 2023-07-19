import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public void imprimirContatos() {
        System.out.println("Contatos:");
        for (Contato contato : this.contatos) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        System.out.println("Endereços:");
        for (Endereco endereco : this.enderecos) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("----------------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }
}
