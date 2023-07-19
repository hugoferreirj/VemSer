public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial = 200.00d;

    public ContaCorrente(Cliente cliente, String numeroConta, Integer agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }


    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial() {
        return (this.getSaldo() + this.chequeEspecial);

    }

    @Override
    public boolean sacar(double valor) {
        if (valor > this.retornarSaldoComChequeEspecial()) {
            System.out.println("O valor é maior do que o seu saldo somado ao cheque especial. Falha no saque!");
            return false;
        } else if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            Double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
            System.out.println("Saque realizado com sucesso!");
            return true;
        }
    }

    @Override
    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("Número conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Cheque especial: " + this.chequeEspecial);
    }
}
