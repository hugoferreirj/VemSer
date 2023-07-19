public class ContaPagamento extends Conta implements Impressao {

    private static final float TAXA_SAQUE = 4.25f;

    public ContaPagamento(Cliente cliente, String numeroConta, Integer agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("Número conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
    }

    @Override
    public boolean sacar(double valor) {
        if ((valor + this.TAXA_SAQUE) > this.getSaldo()) {
            System.out.println("O valor é maior do que o seu saldo somado a taxa de saque. Falha no saque!");
            return false;
        } else if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            Double novoSaldo = this.getSaldo() - valor - this.TAXA_SAQUE;
            this.setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso!");
            return true;
        }
    }
}
