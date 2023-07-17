public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String numeroDoWhatsapp;

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
