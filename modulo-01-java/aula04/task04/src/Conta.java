public class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private Integer agencia;
    private Double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            this.saldo += valor;
            return true;
        }

    }

    public boolean transferir(Conta conta, double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            if (this.sacar(valor)) {
                conta.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("O valor é maior do que o seu saldo. Falha no saque!");
            return false;
        } else if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }
}
