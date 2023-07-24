package br.com.dbc.vemser;

public class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private Integer agencia;
    private Double saldo;

    public Conta(Cliente cliente, String numeroConta, Integer agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            return true;
        }

    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            if (valor <= this.saldo) {
                this.saldo -= valor;
                conta.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("O valor é maior do que o seu saldo. Falha no saque!");
            return false;
        } else if (valor < 0) {
            System.out.println("O valor deve ser positivo!");
            return false;
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            return true;
        }
    }

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
}

