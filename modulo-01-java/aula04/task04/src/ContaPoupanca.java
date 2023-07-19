public class ContaPoupanca extends Conta implements Impressao {
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, Integer agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        double novoSaldo = this.getSaldo() * JUROS_MENSAL;
        this.setSaldo(novoSaldo);
    }

    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("Número conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
