public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private String numeroDoWhatsapp;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Pessoa(String nome, String sobrenome, int idade, String numeroDoWhatsapp) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.numeroDoWhatsapp = numeroDoWhatsapp;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumeroDoWhatsapp() {
        return numeroDoWhatsapp;
    }

    public void setNumeroDoWhatsapp(String numeroDoWhatsapp) {
        this.numeroDoWhatsapp = numeroDoWhatsapp;
    }

    public void conversar(Pessoa pessoa) {
        System.out.println(this.nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    public boolean ehMaiorDeIdade() {
        if (this.idade >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem) {
        System.out.println(this.nome + " enviou: mensagem para " + pessoa.nome);
    }
}
