public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public Integer agencia;
    public Double saldo;
    public Double chequeEspecial = 200.00d;

    public void imprimirContaCorrente() {
        this.cliente.imprimirCliente();
        System.out.println("Número conta: " + this.numeroConta);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Cheque especial: " + this.chequeEspecial);
    }

    public boolean sacar(double valor) {
        if (valor > this.retornarSaldoComChequeEspecial()) {
            System.out.println("O valor é maior do que o seu saldo somado ao cheque especial. Falha no saque.");
            return false;
        } else if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            return true;
        }
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            return true;
        }

    }

    public Double retornarSaldoComChequeEspecial() {
        return (this.saldo + this.chequeEspecial);

    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            if (this.sacar(valor)) {
                contaCorrente.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
                return true;
            } else {
                return false;
            }
        }
    }
}
