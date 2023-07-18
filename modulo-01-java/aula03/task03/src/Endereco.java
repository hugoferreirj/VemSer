public class Endereco {
    public Integer tipo;
    public String logradouro;
    public Integer numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco() {
        if (this.tipo == 1) {
            System.out.println("Tipo: Residencial");
        }
        if (this.tipo == 2) {
            System.out.println("Tipo: Comercial");
        }
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Número: " + this.numero);
        System.out.println("Complemento: " + this.complemento);
        System.out.println("CEP: " + this.cep);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
        System.out.println("País: " + this.pais);
    }
}


