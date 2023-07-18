public class Contato {
    public String descricao;
    public String telefone;
    public Integer tipo;

    public void imprimirContato() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Telefone: " + this.telefone);
        if (this.tipo == 1) {
            System.out.println("Tipo: Residencial");
        }
        if (this.tipo == 2) {
            System.out.println("Tipo: Comercial");
        }
    }
}

